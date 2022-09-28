package ar.com.meli.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import ar.com.meli.service.ShortenUrlService;
import io.quarkus.arc.Priority;

@Logged
@Priority(2020)
@Interceptor
public class LoggingInterceptor {

	@Inject
	ShortenUrlService shortenUrlService;

	@AroundInvoke
	Object logInvocation(InvocationContext context) throws Exception {

		Object ret = context.proceed();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				shortenUrlService.log((String) context.getParameters()[0]);
			}
		});
		t1.start();

		return ret;
	}
}

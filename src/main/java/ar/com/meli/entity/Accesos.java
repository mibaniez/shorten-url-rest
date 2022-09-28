package ar.com.meli.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ACCESOS")
public class Accesos {

	@Id
	@Column(name = "ACCESOS_ID")
	@SequenceGenerator(name = "seq_accesos", sequenceName = "seq_accesos", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "seq_accesos")
	private long accesosId;
	
	@JoinColumn(name = "SHORT_URL_ID")
	@OneToOne(fetch = FetchType.EAGER)
	private ShortenedUrl shortenedUrl;
	
	@Column(name = "FECHA_HORA")
	private Date fechaHora;	

	public long getAccesosId() {
		return accesosId;
	}

	public void setAccesosId(long accesosId) {
		this.accesosId = accesosId;
	}

	public ShortenedUrl getShortenedUrl() {
		return shortenedUrl;
	}

	public void setShortenedUrl(ShortenedUrl shortenedUrl) {
		this.shortenedUrl = shortenedUrl;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

}

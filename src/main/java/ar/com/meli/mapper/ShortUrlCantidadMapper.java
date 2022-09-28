package ar.com.meli.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ar.com.meli.dto.ShortUrlCantidadDTO;
import ar.com.meli.entity.ShortUrlCantidad;

@Mapper
public interface ShortUrlCantidadMapper {
//    @Mapping(target = "shortUrl", source = "shortUrl")	
	
	ShortUrlCantidadMapper INSTANCE = Mappers.getMapper( ShortUrlCantidadMapper.class );
	
	@Mapping(target = "shortUrl", source = "shortUrl")
    @Mapping(target = "cantidad", source = "cantidad")
	ShortUrlCantidadDTO map(ShortUrlCantidad entity);
	
	List<ShortUrlCantidadDTO> map(List<ShortUrlCantidad> person);
}

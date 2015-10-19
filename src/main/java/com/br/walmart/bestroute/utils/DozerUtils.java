package com.br.walmart.bestroute.utils;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.br.walmart.bestroute.objects.dto.CitiesMapDTO;
import com.br.walmart.bestroute.objects.dto.PathDTO;
import com.br.walmart.bestroute.objects.hibernate.CitiesMap;
import com.br.walmart.bestroute.objects.hibernate.Path;
import com.br.walmart.bestroute.objects.interfaces.PathInterface;

/**
 * Classe Utils com métodos referentes ao framework dozer
 * 
 * @author davidson.sestaro
 */
@Service
public class DozerUtils {
	
	/**
	 * Método de copia entre a entidade CitiesMap do hibernate para a sua forma DTO, é feito também a conversão
	 * dos objetos Path para PathDTO.
	 * 
	 * @param map		- Mapa a ser convertido
	 * 
	 * @return			- DTO para a serialização
	 */
	public static CitiesMapDTO convert2DTO(CitiesMap map) {
		Mapper mapper = new DozerBeanMapper();
		
		CitiesMapDTO mapDTO = new CitiesMapDTO();
		
		//TODO substituir por uma implementação customizada de um mapper do dozer
		mapDTO.setName(map.getName());
		
		for(int i = 0; i < map.getPaths().size(); i++) {
			Path path = (Path) map.getPaths().get(i);
			
			mapDTO.addPath(mapper.map(path, PathDTO.class));
		}

		return mapDTO;
	}
	
	public static CitiesMap convertFromDTO (CitiesMapDTO mapDTO) {
		Mapper mapper = new DozerBeanMapper();
		
		CitiesMap map = new CitiesMap();
		
		//TODO substituir por uma implementação customizada de um mapper do dozer
		map.setName(mapDTO.getName());
		
		for(PathInterface pathDTO : mapDTO.getPaths()) {
			Path path = mapper.map(pathDTO, Path.class);
			
			path.setMap(map);
			map.addPath(path);
		}
		
		return map;
	}
 }

package finalProject.mapper;

import org.springframework.stereotype.Repository;

import finalProject.domain.SpotDTO;

@Repository("finalProject.mapper.SpotMapper")
public interface SpotMapper {
	public void insertSpot(SpotDTO dto);

}

package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.SpotInfoDTO;
import finalProject.domain.StartEndPageDTO;

@Repository("finalProject.mapper.SpotInfoMapper")
public interface SpotInfoMapper {
	public void insertSpot(SpotInfoDTO dto);
	public List<SpotInfoDTO> getSpotList(StartEndPageDTO dto);
	public void updateSpot(SpotInfoDTO dto);
	public void deleteSpot(StartEndPageDTO dto);

}

package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.RentScoreDTO;
import finalProject.domain.StartEndPageDTO;

@Repository("finalProject.mapper.RentScoreMapper")
public interface RentScoreMapper {
	public void insertRentScore(RentScoreDTO dto);
	public List<RentScoreDTO> getScore(StartEndPageDTO dto);

}

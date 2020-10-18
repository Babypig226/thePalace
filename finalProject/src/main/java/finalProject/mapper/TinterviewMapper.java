package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TinterviewDTO;

@Repository("finalProject.mapper.TinterviewMapper")
public interface TinterviewMapper {
	public void insertTinterview(TinterviewDTO tinterviewDTO);
	public List<TinterviewDTO> getTinterviewList(StartEndPageDTO sdto);
	public void updateTinterview(TinterviewDTO tinterviewDTO);

}

package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TnoticeDTO;

@Repository("finalProject.mapper.TnoticeMapper")
public interface TnoticeMapper {
	public void insertTnotice(TnoticeDTO tnoticeDTO);
	public List<TnoticeDTO> getTnoticeList(StartEndPageDTO startEndPageDTO);
	public void updateTnotice(TnoticeDTO tnoticeDTO);
}

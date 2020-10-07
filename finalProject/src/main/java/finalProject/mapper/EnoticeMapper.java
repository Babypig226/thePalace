package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.EnoticeDTO;
import finalProject.domain.StartEndPageDTO;

@Repository("finalProject.mapper.EnoticeMapper")
public interface EnoticeMapper {
	public void insertEnotice(EnoticeDTO dto);
	public List<EnoticeDTO> getEnoticeList(StartEndPageDTO dto);
	public void updateEnotice(EnoticeDTO dto);
}

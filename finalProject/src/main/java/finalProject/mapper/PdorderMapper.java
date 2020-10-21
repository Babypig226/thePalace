package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.PdorderDTO;

@Component
@Repository("finalProject.mapper.PdorderMapper")
public interface PdorderMapper {

	public void pdorderInsert(PdorderDTO pordto);
	public List<PdorderDTO> pdorderList(String orderNo);
	public void pdorderUpdate(PdorderDTO pdodto);
	public void pdorderDel(String orderNo);

}

package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.PdoneDTO;

@Component
@Repository("finalProject.mapper.PdoneMapper")
public interface PdoneMapper {
	public void pdoneInsert(PdoneDTO podto);
	public List<PdoneDTO> poList(String glibNo);
	public void poneUpdate(PdoneDTO podto);
	public void pdoneDel(String glibNo);

}

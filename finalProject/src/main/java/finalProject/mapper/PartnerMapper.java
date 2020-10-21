package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.PartnerDTO;

@Component
@Repository("finalProject.mapper.PartnerMapper")
public interface PartnerMapper {
	public void ptInsert(PartnerDTO ptdto);
	public List<PartnerDTO>ptlist(String gcompanyNo);
	public void ptmodify(PartnerDTO ptdto);
	public void ptdel(String gcompanyNo);
	
	
}

package finalProject.mapper;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.ShopDTO;

@Component
@Repository("finalProject.mapper.ShopMapper")
public interface ShopMapper {
	public void spInsert(ShopDTO spdto);
	public List<ShopDTO> spList(String shopNo);
	public void spModify(ShopDTO sdto);
	
	

}

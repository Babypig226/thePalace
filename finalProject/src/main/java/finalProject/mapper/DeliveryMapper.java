package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.DeliveryDTO;

@Component
@Repository("finalProject.mapper.DeliveryMapper")
public interface DeliveryMapper {
	public void deliveryInsert(DeliveryDTO dvdto);
	public List<DeliveryDTO> deliveryList(String deliveryNo);

}

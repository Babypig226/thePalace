package finalProject.service.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.DeliveryDTO;
import finalProject.mapper.DeliveryMapper;

@Service
public class DeliveryListService {
 
	@Autowired
	DeliveryMapper deliveryMapper;
	
	public void deliveryList(Model model) {
		// TODO Auto-generated method stub
		List<DeliveryDTO> dvlists = deliveryMapper.deliveryList(null);
		model.addAttribute("dvlists",dvlists);
		
	}
	

}

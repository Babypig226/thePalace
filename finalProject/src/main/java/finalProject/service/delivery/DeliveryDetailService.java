package finalProject.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.DeliveryDTO;
import finalProject.mapper.DeliveryMapper;

@Service
public class DeliveryDetailService {
  @Autowired
  DeliveryMapper deliveryMapper;
  
	public void deliveryDetail(String deliveryNo, Model model) {
		// TODO Auto-generated method stub
		DeliveryDTO dvdto = deliveryMapper.deliveryList(deliveryNo).get(0);
		model.addAttribute("dvdto",dvdto);
		
	}

}

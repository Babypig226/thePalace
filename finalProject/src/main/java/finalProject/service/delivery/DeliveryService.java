package finalProject.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.command.DeliveryCommand;
import finalProject.domain.DeliveryDTO;
import finalProject.mapper.DeliveryMapper;

@Service
public class DeliveryService {
	@Autowired
	DeliveryMapper deliveryMapper;

	public void orderdeliberyPro(DeliveryCommand deliveryCommand) {
		// TODO Auto-generated method stub
		DeliveryDTO dvdto = new DeliveryDTO();
		
		dvdto.setDeliveryAddr(deliveryCommand.getDeliveryAddr());
		dvdto.setDeliveryNote(deliveryCommand.getDeliveryNote());
		dvdto.setReceiverName(deliveryCommand.getReceiverName());
		deliveryMapper.deliveryInsert(dvdto);
		
		
	}
	

}

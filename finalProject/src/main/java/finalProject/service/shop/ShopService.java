package finalProject.service.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.command.ShopCommand;
import finalProject.domain.ShopDTO;
import finalProject.mapper.ShopMapper;

@Service
public class ShopService {
	
	@Autowired
	ShopMapper shopMapper;

	public void spFormPro(ShopCommand shopCommand) {
		// TODO Auto-generated method stub
		ShopDTO spdto = new ShopDTO();
		spdto.setShopAddr(shopCommand.getShopAddr());
		spdto.setShopName(shopCommand.getShopName());
		spdto.setShopNo(shopCommand.getShopNo());
		spdto.setShopPh(shopCommand.getShopPh());
		
		//Command에 값 담은거가 dto에게 넘겨주고 이제 db에게 넘기기 위해 mapper에게 넘겨준당
		shopMapper.spInsert(spdto);
		
		
	}
	

}

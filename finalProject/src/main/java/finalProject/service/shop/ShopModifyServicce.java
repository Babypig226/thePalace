package finalProject.service.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.command.ShopCommand;
import finalProject.domain.ShopDTO;
import finalProject.mapper.ShopMapper;

@Service
public class ShopModifyServicce {

	@Autowired
	ShopMapper shopMapper;
	
	public void spModifyPro(ShopCommand shopCommand) {
		// TODO Auto-generated method stub
		
		ShopDTO sdto = new ShopDTO();
		sdto.setShopNo(shopCommand.getShopNo());
		sdto.setShopPh(shopCommand.getShopPh());
		sdto.setShopAddr(shopCommand.getShopAddr());
		
		shopMapper.spModify(sdto);
		
	
		
	}

}

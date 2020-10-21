package finalProject.service.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.ShopDTO;
import finalProject.mapper.ShopMapper;

@Service
public class ShopDetailService {

	@Autowired
	ShopMapper shopMapper;
	
	public void spDetail(String shopNo, Model model) {
		// TODO Auto-generated method stub
		ShopDTO sdto = shopMapper.spList(shopNo).get(0);
		model.addAttribute("sdto",sdto);
		
	}

}

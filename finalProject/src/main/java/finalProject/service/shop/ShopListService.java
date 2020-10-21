package finalProject.service.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.ShopDTO;
import finalProject.mapper.ShopMapper;

@Service
public class ShopListService {
	
	@Autowired
	ShopMapper shopMapper;
	
	public void stList(Model model) {
		// TODO Auto-generated method stub
		List<ShopDTO> slist = shopMapper.spList(null);
		model.addAttribute("slist", slist);
		
	}

	

}

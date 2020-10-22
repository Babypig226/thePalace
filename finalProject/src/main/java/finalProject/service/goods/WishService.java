package finalProject.service.goods;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.GoodsDTO;
import finalProject.domain.PdWishDTO;
import finalProject.mapper.GoodsCartMapper;
import finalProject.mapper.GoodsMapper;

@Service
public class WishService {
	@Autowired
	GoodsMapper goodsMapper;
	
	@Autowired
	GoodsCartMapper goodsCartMapper;
	
	public void wishadd(String goodsNo, Model model, HttpSession session) {
		// TODO Auto-generated method stub
		
		GoodsDTO gdto = goodsMapper.gdList(goodsNo).get(0);
		
		PdWishDTO wsdto = new PdWishDTO();
		
		wsdto.setGoodsNo(gdto.getGoodsNo());
		wsdto.setUserId("2222");
		
		goodsCartMapper.gdwishInsert(wsdto);
		
		
		
	}

	public void wishList(Model model) {
		// TODO Auto-generated method stub
		
		List<PdWishDTO> pwishLists = goodsCartMapper.pdwishList();
		model.addAttribute("pwishLists",pwishLists);
		
		
	}
	

}

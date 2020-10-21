package finalProject.controller.pdgoods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.service.goods.GoodsCartService;

@Controller
@RequestMapping("pdcart")
public class GoodsCartController {
	@Autowired
	GoodsCartService goodsCartService;
	
	@RequestMapping("pdcartadd")
	public String pdcartadd(@RequestParam(value = "goodsNo")String goodsNo,Model model,HttpSession session) {
		goodsCartService.pdcartadd(goodsNo,model,session);
		return "thymeleaf/goods/goodsSuccess";
	}		
	//근데 저거 success는 장바구니에 담겠습니까? 그페이지인데 insert한거 안보이지 않을까? 부모키가 없뎅 
}

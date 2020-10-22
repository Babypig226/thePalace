package finalProject.controller.pdgoods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.service.goods.GoodsCartListService;
import finalProject.service.goods.GoodsCartService;

@Controller
@RequestMapping("pdcart")
public class GoodsCartController {
	@Autowired
	GoodsCartService goodsCartService;
	@Autowired
	GoodsCartListService goodsCartListService;
	
	@RequestMapping("pdcartadd")
	public String pdcartadd(@RequestParam(value = "goodsNo")String goodsNo,Model model,HttpSession session) {
		goodsCartService.pdcartadd(goodsNo,model,session);
		return "thymeleaf/goods/goodsSuccess";
	}
	
	@RequestMapping("pdcartList")
	public String pdcartList(Model model) {
		goodsCartListService.pdcartList(model);
		return "thymeleaf/userorder/cart";
	}
	
	
}

package finalProject.controller.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.ShopCommand;
import finalProject.service.shop.ShopDetailService;
import finalProject.service.shop.ShopListService;
import finalProject.service.shop.ShopModifyServicce;
import finalProject.service.shop.ShopService;

@Controller
@RequestMapping("shop")
public class ShopController {
	
	@Autowired
	ShopService shopService;
	@Autowired
	ShopListService shopListService;
	@Autowired
	ShopDetailService shopDetailService;
	@Autowired
	ShopModifyServicce shopModifyService;
	
	
	//th:objcet 폼에서 적은거 서버단으로 값을 넘길 때 object에 지정한 객체에 값을 담아 넘겨줄수 있다.
	@ModelAttribute
	ShopCommand setShopCommand() {
		return new ShopCommand();
	}

	//service에 있는 값을 다시 넘겨주기 누가? model!!
	@RequestMapping("shopList")
	public String spList(Model model) {
		shopListService.stList(model);
		return "thymeleaf/shop/shopList";
	}
	
	@RequestMapping(value = "shopForm", method = RequestMethod.GET)
	public String spForm() {
		return "thymeleaf/shop/shopForm";
	}
	
	
	@RequestMapping(value = "shopFrom", method = RequestMethod.POST)
	public String spFormPro(ShopCommand shopCommand) {
	    shopService.spFormPro(shopCommand);
		return "redirect:/shop/shopList";
	}
	
	@RequestMapping(value = "shopDetail")
	public String spDetail(@RequestParam (value = "shopNo")String shopNo, Model model) {
		shopDetailService.spDetail(shopNo, model);
		return "thymeleaf/shop/shopDetail";
	}
	
	//service에 있는 값 model
	@RequestMapping(value = "shopModify")
	public String spModify(@RequestParam (value = "shopNo")String shopNo, Model model) {
		shopDetailService.spDetail(shopNo, model);
		return"thymeleaf/shop/shopModify";
	}
	
	//받아온값 다시 입력해서 값 넘겨줘야 하니까 command 뿅!
	@RequestMapping(value = "shopModifyPro", method = RequestMethod.POST)
	public String spModifyPro(ShopCommand shopCommand) {
		shopModifyService.spModifyPro(shopCommand);
		return "redirect:/shop/shopDetail?shopNo=" + shopCommand.getShopNo();
		
	}
	
	@RequestMapping("shopDel")
	public String spDel(@RequestParam(value = "shopNo")String shopNo, Model model) {
		model.addAttribute("shopNo", shopNo);
		return "thymeleaf/shop/shopDelete";
	}
	
	

}

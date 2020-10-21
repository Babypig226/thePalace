package finalProject.controller.pdgoods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.GoodsCommand;
import finalProject.service.goods.GoodsDeleteService;
import finalProject.service.goods.GoodsDetailService;
import finalProject.service.goods.GoodsListService;
import finalProject.service.goods.GoodsModifyService;
import finalProject.service.goods.GoodsService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsService goodsService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsModifyService goodsModifyService;
	@Autowired
	GoodsDeleteService goodsDeleteService;
	
	@ModelAttribute
	GoodsCommand setGoodsCommand() {
		return new GoodsCommand();
	}
	
	@RequestMapping("goodsList")
	public String gdList(Model model) {
		goodsListService.gdList(model);
		return "thymeleaf/goods/goodsList";
	}
	
	@RequestMapping(value= "goodsForm", method = RequestMethod.GET)
	public String gdForm() {
		return "thymeleaf/goods/goodsForm";
	}
	
	@RequestMapping(value = "goodsForm", method = RequestMethod.POST)
	public String gdFormPro(GoodsCommand goodsCommand, HttpSession session) {
		goodsService.gdWritePro(goodsCommand,session);
		return "redirect:/goods/goodsList";
	}
	
	//detail list에서 하나 가져와서 하는거잖오
	@RequestMapping(value = "goodsDetail")
	public String gdDetail(@RequestParam(value = "goodsNo")String goodsNo,Model model) {
		goodsDetailService.gdDetail(goodsNo,model);
		return "thymeleaf/goods/admingoodsDetail";
	}
	
	@RequestMapping("goodsModify")
	public String gdModify(@RequestParam(value = "goodsNo")String goodsNo,Model model) {
		goodsDetailService.gdDetail(goodsNo,model);
		return "thymeleaf/goods/goodsModify";
	}
	
	@RequestMapping(value = "goodsModifyPro", method = RequestMethod.POST)
	public String gdmodifyPro(GoodsCommand goodsCommand) {
		goodsModifyService.gdModifyPro(goodsCommand);
		return "redirect:/goods/goodsDetail?goodsNo=" + goodsCommand.getGoodsNo();
	}
	
	@RequestMapping(value = "goodsDel")
	public String goodsDel(@RequestParam(value = "goodsNo")String goodsNo,Model model) {
		model.addAttribute("goodsNo",goodsNo);
		return"thymeleaf/goods/goodsDelete";
	}
	
	@RequestMapping(value = "goodsDelPro")
	public String goodsDelPro(@RequestParam(value = "goodsNo")String goodsNo,Model model) {
		goodsDeleteService.gdDelPro(goodsNo, model);
		return"redirect:/goods/goodsList";
	}
	
	@RequestMapping(value = "goodsuserDetail")
	public String usergoodDetail(@RequestParam(value = "goodsNo")String goodsNo,Model model) {
		goodsDetailService.gdDetail(goodsNo,model);
		return "thymeleaf/goods/goodsDetail";
	}
	
	
	
	
	 
	
}

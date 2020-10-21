package finalProject.controller.adminorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.PdorderCommand;
import finalProject.service.pdorder.PdorderDelService;
import finalProject.service.pdorder.PdorderDetailService;
import finalProject.service.pdorder.PdorderListService;
import finalProject.service.pdorder.PdorderModifyService;
import finalProject.service.pdorder.PdorderService;

@Controller
@RequestMapping("pdorder")
public class ProductOrderController {
	@Autowired
	PdorderService pdorderService;
	@Autowired
	PdorderListService pdorderListService;
	@Autowired
	PdorderDetailService pdorderDetailService;
	@Autowired
	PdorderModifyService pdorderModifyService;
	@Autowired
	PdorderDelService pdorderDelService;
	
	@ModelAttribute
	PdorderCommand setPdorderCommand() {
		return new PdorderCommand();
	}
	
	@RequestMapping("pdorderList") 
		public String pdorderList(Model model) {
		pdorderListService.pdorderList(model);
		return "thymeleaf/productorder/pdOrderList";
	}
	
	@RequestMapping(value = "pdorderForm", method = RequestMethod.GET)
	 public String pdorderWrite() {
		return "thymeleaf/productorder/pdOrderForm";
	}
	
	@RequestMapping(value = "pdorderFormPro", method = RequestMethod.POST)
	public String pdorderFormPro(PdorderCommand pdorderCommand) {
		pdorderService.pdorderFormPro(pdorderCommand);
		return "redirect:/pdorder/pdorderList";
	}
	
	@RequestMapping(value = "pdorderDetail")
	public String pdorderDetail(@RequestParam (value = "orderNo")String orderNo, Model model) {
		pdorderDetailService.pdorderDetail(orderNo,model);
		return "thymeleaf/productorder/pdOrderView";
	}
	
	@RequestMapping(value = "pdorderModify")
	public String pdorderModify(@RequestParam (value = "orderNo")String orderNo, Model model) {
		pdorderDetailService.pdorderDetail(orderNo,model);
		return "thymeleaf/productorder/pdOrderModify";
	}
	
	@RequestMapping(value = "pdorderModifyPro", method = RequestMethod.POST)
	public String pdorderModifyPro(PdorderCommand pdorderCommand) {
		pdorderModifyService.pdorderModifyPro(pdorderCommand);
		return "redirect:/pdorder/pdorderDetail?orderNo=" + pdorderCommand.getOrderNo();
	}
	
	@RequestMapping(value = "pdorderDel")
	public String pdorderDel(@RequestParam (value = "orderNo")String orderNo, Model model) {
		model.addAttribute("orderNo",orderNo);
		return "thymeleaf/productorder/pdOrderDelete";
	}
	
	@RequestMapping("pdorderDelPro")
	public String pdorderDelPro(@RequestParam (value = "orderNo")String orderNo, Model model) {
		pdorderDelService.pdorderDelPro(orderNo,model);
		return "redirect:/pdorder/pdorderList";
	}

}

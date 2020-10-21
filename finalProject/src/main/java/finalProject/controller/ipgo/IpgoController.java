package finalProject.controller.ipgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.IpgoCommand;
import finalProject.service.ipgo.IpgoDelService;
import finalProject.service.ipgo.IpgoListService;
import finalProject.service.ipgo.IpgoModifyService;
import finalProject.service.ipgo.IpgoService;
import finalProject.service.ipgo.IpgoViewService;

@Controller
@RequestMapping("ipgo")
public class IpgoController {
	@Autowired
	IpgoService ipgoService;
	@Autowired
	IpgoListService ipgoListService;
	@Autowired
	IpgoViewService ipgoViewService;
	@Autowired
	IpgoModifyService ipgoModifyService;
	@Autowired
	IpgoDelService ipgoDelService;
	
	@ModelAttribute
	IpgoCommand setIpgoCommand() {
		return new IpgoCommand();
	}
	
	@RequestMapping("ipgoList")
	public String ipgoList(Model model) {
		ipgoListService.ipgoList(model);
		return "thymeleaf/ipgo/ipgoList";
	}
	
	@RequestMapping(value = "ipgoForm", method = RequestMethod.GET)
	public String ipgoForm() {
		return "thymeleaf/ipgo/ipgoForm";
	}
	
	@RequestMapping(value= "ipgoFormPro", method = RequestMethod.POST)
	public String ipgoFormPro(IpgoCommand ipgoCommand) {
		ipgoService.ipgoFormPro(ipgoCommand);
		return "redirect:/ipgo/ipgoList";
	}
	
	@RequestMapping(value = "ipgoView")
	public String ipgoView(@RequestParam (value = "ipgoNo")String ipgoNo,Model model) {
		ipgoViewService.ipgoView(ipgoNo,model);
		return "thymeleaf/ipgo/ipgoView";
	}
	
	@RequestMapping("ipgoModify")
	public String ipgoModify(@RequestParam (value = "ipgoNo")String ipgoNo,Model model) {
		ipgoViewService.ipgoView(ipgoNo,model);
		return "thymeleaf/ipgo/ipgoModify";
	}
	
	@RequestMapping(value = "ipgoModifyPro", method = RequestMethod.POST)
	public String ipgoModifyPro(IpgoCommand ipgoCommand) {
		ipgoModifyService.ipgomodifyPro(ipgoCommand);
		return "redirect:/ipgo/ipgoView?ipgoNo=" + ipgoCommand.getIpgoNo();
	}
	
	@RequestMapping("ipgoDel")
	public String ipgoDel(@RequestParam (value = "ipgoNo")String ipgoNo,Model model) {
		model.addAttribute("ipgoNo",ipgoNo);
		return "thymeleaf/ipgo/ipgoDelete";
	}
	
	@RequestMapping("ipgoDelPro")
	public String ipgoDelPro(@RequestParam (value = "ipgoNo")String ipgoNo,Model model) {
       ipgoDelService.ipgoDel(ipgoNo,model);
 		return "redirect:/ipgo/ipgoList";
	}
	

	

}

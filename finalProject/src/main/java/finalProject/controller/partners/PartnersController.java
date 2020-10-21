package finalProject.controller.partners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.PartnerCommand;
import finalProject.service.partners.PartnersDeleteService;
import finalProject.service.partners.PartnersDetailService;
import finalProject.service.partners.PartnersListService;
import finalProject.service.partners.PartnersModifyService;
import finalProject.service.partners.PartnersService;

@Controller
@RequestMapping("partners")

public class PartnersController {
	
	@Autowired
	PartnersService partnersService;
	@Autowired
	PartnersListService partnersListService;
	@Autowired
	PartnersDetailService partnersDetailService;
	@Autowired
	PartnersModifyService partnersModifyService;
	@Autowired
	PartnersDeleteService partnersDeleteService;
	
	@ModelAttribute
	PartnerCommand setPartnerCommad() {
		return new PartnerCommand();
	}
	
	@RequestMapping("partnersList")
	public String ptList(Model model) {
		partnersListService.ptList(model);
		return "thymeleaf/partners/partnersList";
	}
	
	@RequestMapping(value = "partnersWrite", method = RequestMethod.GET)
	public String ptWrite() {
		return "thymeleaf/partners/partnersWrite";
	}
	
	//작성한거 command가 넘겨주기
	@RequestMapping(value = "partnersWrite", method = RequestMethod.POST)
	public String ptWritePro(PartnerCommand partnerCommand) {
		partnersService.ptwritePro(partnerCommand);
		return "redirect:/partners/partnersList";
	}
	
	@RequestMapping("partnersDetail")
	public String ptDetail(@RequestParam(value = "gcompanyNo")String gcompanyNo,Model model) {
		partnersDetailService.ptdetail(gcompanyNo,model);
		return  "thymeleaf/partners/partnersDetail";
	}
	
	//수정할려면 service값을 가져와야지 그치
	
	@RequestMapping("partnersModify")
	public String ptModify(@RequestParam(value = "gcompanyNo")String gcompanyNo,Model model) throws Exception{
		partnersDetailService.ptdetail(gcompanyNo,model);
		return "thymeleaf/partners/partnersModify";
	}
	
	@RequestMapping(value = "partnersModifyPro", method = RequestMethod.POST)
	public String ptModifyPro(PartnerCommand partnerCommand) {
		partnersModifyService.ptModifyPro(partnerCommand);
		return"redirect:/partners/partnersDetail?gcompanyNo="+partnerCommand.getGcompanyNo();
	}
	
	@RequestMapping("partnerDelete")
	public String ptDelete(@RequestParam(value = "gcompanyNo")String gcompanyNo,Model model) {
		model.addAttribute("gcompanyNo",gcompanyNo);
		return "thymeleaf/partners/partnersDelete";
	}
	
	@RequestMapping("partnerDelPro")
	public String ptDeletePro(@RequestParam(value = "gcompanyNo")String gcompanyNo,Model model) {
		partnersDeleteService.ptdelPro(gcompanyNo, model);
		return "redirect:/partners/partnersList";
	}
	
	
	

	
	
	

}

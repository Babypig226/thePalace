package finalProject.controller.admin.etraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.EtrainingCommand;
import finalProject.service.admin.etraining.EtrainingDeleteService;
import finalProject.service.admin.etraining.EtrainingDetailService;
import finalProject.service.admin.etraining.EtrainingListService;
import finalProject.service.admin.etraining.EtrainingModifyService;
import finalProject.service.admin.etraining.EtrainingRegistService;

@Controller
@RequestMapping("etrn")
public class EtrainingController {
	@Autowired
	EtrainingRegistService etrainingRegistService;
	@Autowired
	EtrainingListService etrainingListService;
	@Autowired
	EtrainingDetailService etrainingDetailService;
	@Autowired
	EtrainingModifyService etrainingModifyService;
	@Autowired
	EtrainingDeleteService etrainingDeleteService;
	
	@RequestMapping("list")
	public String etrainingList(Model model, @RequestParam(value = "page", defaultValue = "1")String page) {
		etrainingListService.getEtrainingList(model, page);
		return "v-admin-etrn/admin-etraining-list";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String etrainingRegist() {
		return "thymeleaf/admin-etraining/admin-etraining-regist";
	}
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String etrainingRegistPro(EtrainingCommand etrainingCommand) {
		etrainingRegistService.insertEtraining(etrainingCommand);
		return "redirect:/etrn/list";
	}
	
	@RequestMapping("detail")
	public String etrainingDetail(Model model, @RequestParam(value = "etrnNo")String trainingNo) {
		etrainingDetailService.getEtrainingDetail(model, trainingNo);
		return "thymeleaf/admin-etraining/admin-etraining-detail";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String etrainingModify(@RequestParam(value = "etrnNo")String trainingNo, Model model) {
		etrainingDetailService.getEtrainingDetail(model, trainingNo);
		return "thymeleaf/admin-etraining/admin-etraining-modify";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String etrainingModifyPro(EtrainingCommand etrainingCommand) {
		etrainingModifyService.updateEtraining(etrainingCommand);
		return "redirect:/etrn/list";
	}
	
	@RequestMapping(value = "delete")
	public String etrainingDelete(@RequestParam(value = "etrnNo")String trainingNo) {
		etrainingDeleteService.deleteEtraining(trainingNo);
		return "redirect:/etrn/list";
	}

}

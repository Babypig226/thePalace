package finalProject.controller.admin.tch;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.TeacherCommand;
import finalProject.service.admin.tch.TeacherDetService;
import finalProject.service.admin.tch.TeacherDetailService;
import finalProject.service.admin.tch.TeacherListService;
import finalProject.service.admin.tch.TeacherModService;
import finalProject.service.admin.tch.TeacherRegistService;

@Controller
@RequestMapping("tch")
public class TeacherController {
	@Autowired
	TeacherRegistService teacherRegistService;
	@Autowired
	TeacherListService teacherListService;
	@Autowired
	TeacherDetailService teacherDetailService;
	@Autowired
	TeacherModService teacherModService;
	@Autowired
	TeacherDetService teacherDelService;
	
	
	@ModelAttribute
	TeacherCommand setTeacherCommand() {
		return new TeacherCommand();
	}
	
	@RequestMapping("list")
	public String teacherList(@RequestParam(value = "page", defaultValue = "1")Integer page, Model model) {
		teacherListService.getTeacherList(model, page);
		return "/v-admin-tch/admin-tch-list";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String teacherRegist() {
		return "thymeleaf/admin-tch/admin-tch-regform";
	}
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String teacherRegistPro(TeacherCommand teacherCommand, HttpSession session) {
		teacherRegistService.registTeacher(teacherCommand, session);
		return "redirect:/tch/list";
	}
	
	@RequestMapping("view")
	public String teacherView(@RequestParam(value = "tchNo")String teacherNo, Model model) {
		teacherDetailService.getTeacherDetail(teacherNo, model);
		return "thymeleaf/admin-tch/admin-tch-detail";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String teacherModify(@RequestParam(value = "tchNo")String teacherNo, Model model) {
		teacherDetailService.getTeacherDetail(teacherNo, model);
		return "thymeleaf/admin-tch/admin-tch-modify";
	}
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String teacherModifyPro(TeacherCommand teacherCommand) {
		teacherModService.modifyTeacher(teacherCommand);
		return "redirect:/tch/list";
	}
	
	@RequestMapping("delete")
	public String teacherDelete(@RequestParam(value = "tchNo")String teacherNo) {
		teacherDelService.deleteTeacher(teacherNo);
		return "redirect:/tch/list";
	}

}

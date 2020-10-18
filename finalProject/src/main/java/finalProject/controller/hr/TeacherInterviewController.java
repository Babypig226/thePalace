package finalProject.controller.hr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.TinterviewCommand;
import finalProject.service.hr.teacherInterview.TinterviewDetailService;
import finalProject.service.hr.teacherInterview.TinterviewRegistService;
import finalProject.service.hr.teacherInterview.TinterviewUpdateService;

@Controller
@RequestMapping("titv")
public class TeacherInterviewController {
	@Autowired
	TinterviewRegistService tinterviewRegistService;
	@Autowired
	TinterviewDetailService tinterviewDetailService;
	@Autowired
	TinterviewUpdateService tinterviewUpdateService;
	
	@RequestMapping("view")
	public String teacherInterviewRegist(@RequestParam(value = "regNo")String regNo, Model model, HttpSession session) {
		return tinterviewDetailService.getTinterviewDetail(regNo, model, session);
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String teacherInterviewRegistPro(TinterviewCommand tinterviewCommand, HttpSession session) {
		tinterviewRegistService.insertTinterview(tinterviewCommand, session);
		String num = tinterviewCommand.getRegNo().split("-")[0];
		return "redirect:/tregist/list?tnoticeNo="+num;
	}
	
	@RequestMapping("modify")
	public String teacherInterviewUpdate(TinterviewCommand tinterviewCommand){
		tinterviewUpdateService.updateTinterview(tinterviewCommand);
		return "redirect:/tregist/list?tnoticeNo="+tinterviewCommand.getRegNo().split("-")[0];
		
	}
}

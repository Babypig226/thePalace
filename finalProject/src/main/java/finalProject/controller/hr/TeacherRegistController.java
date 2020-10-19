package finalProject.controller.hr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.TchRegistCommand;
import finalProject.service.file.FileDown;
import finalProject.service.hr.teacherRegist.TchRegistListService;
import finalProject.service.hr.teacherRegist.TchRegistWriteService;

@Controller
@RequestMapping("tregist")
public class TeacherRegistController {
	@Autowired
	TchRegistWriteService tchRegistWriteService;
	@Autowired
	TchRegistListService tchRegistListService;
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String teacherRegistWrite(@RequestParam(value = "tnoticeNo")String tnoticeNo, Model model) {
		model.addAttribute("tnoticeNo", tnoticeNo);
		return "thymeleaf/hr/teacher-regist/teacher-regist-write";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String teacherRegistWritePro(TchRegistCommand tchRegistCommand, HttpServletRequest request) {
		tchRegistWriteService.insertTchRegist(tchRegistCommand, request);
		return "redirect:/tnotice/Detail?tnoticeNo="+tchRegistCommand.getTnoticeNo();
	}
	
	@RequestMapping("list")
	public String teacherRegistList(@RequestParam(value = "tnoticeNo")String tnoticeNo, Model model, @RequestParam(value = "page", defaultValue = "1")Integer page) {
		tchRegistListService.getTchRegistDetail(tnoticeNo, model, page);
		return "/v-hr-recruit/hr-tregist-list";
		
	}
	
	@Autowired
	FileDown fileDown;
	@RequestMapping("fileDown")
	public void FileDown(@RequestParam(value = "file")String fileName, HttpServletRequest request, HttpServletResponse response) {
		String path = "/static/teacher-regist/upload";
		fileDown.singleFileDown(path, fileName, response, request);
	}

}

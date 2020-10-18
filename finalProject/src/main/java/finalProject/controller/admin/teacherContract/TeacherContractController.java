package finalProject.controller.admin.teacherContract;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.TchContractCommand;
import finalProject.service.admin.tch.TeacherDetailService;
import finalProject.service.admin.teacherContract.TchContractDetailService;
import finalProject.service.admin.teacherContract.TchContractListService;
import finalProject.service.admin.teacherContract.TchContractRegistService;
import finalProject.service.file.FileDown;

@Controller
@RequestMapping("tctrt")
public class TeacherContractController {
	@Autowired
	TeacherDetailService teacherDetailService;
	@Autowired
	TchContractRegistService tchContractRegistService;
	@Autowired
	TchContractListService tchContractListService;
	@Autowired
	TchContractDetailService tchContractDetailService;
	@Autowired
	FileDown fileDown;
	
	@RequestMapping("list")
	public String teachreContractList(@RequestParam(value = "tchNo")String teacherNo, Model model, @RequestParam(value = "page", defaultValue = "1")Integer page) {
		teacherDetailService.getTeacherDetail(teacherNo, model);
		tchContractListService.getTctrtLists(teacherNo, model, page);
		return "/v-admin-tctrt/admin-tctrt-list";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String teacherContractRegist(@RequestParam(value = "tchNo")String teacherNo, Model model) {
		teacherDetailService.getTeacherDetail(teacherNo, model);
		return "thymeleaf/hr/teacher-contract/teacher-contract-regform";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String teacherContractRegistPro(TchContractCommand tchContractCommand, HttpServletRequest request) {
		tchContractRegistService.registTctrt(tchContractCommand, request);
		return "redirect:/tctrt/list?tchNo="+tchContractCommand.getTeacherNo();
	}
	
	@RequestMapping("view")
	public String teacherContractDetail(@RequestParam(value = "tctrtNo")String tcontractNo, Model model) {
		tchContractDetailService.tctrtDetail(tcontractNo, model);
		return "thymeleaf/hr/teacher-contract/teacher-contract-detail";
	}
	@RequestMapping("fileDown")
	public void idCardDown(@RequestParam(value = "file")String fileName, HttpServletResponse response, HttpServletRequest request) {
		String path = "/static/teacherContract/upload";
		fileDown.singleFileDown(path, fileName, response, request);
	}

}

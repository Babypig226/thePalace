package finalProject.controller.admin.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.EmployeeCommand;
import finalProject.service.admin.emp.EmployeeDeleteService;
import finalProject.service.admin.emp.EmployeeDetailService;
import finalProject.service.admin.emp.EmployeeListService;
import finalProject.service.admin.emp.EmployeeModifyService;
import finalProject.service.admin.emp.EmployeeRegistService;
import finalProject.service.file.FileDown;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	EmployeeRegistService employeeRegistService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeDetailService employeeDetailService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@Autowired
	EmployeeModifyService employeeModifyService;
	@Autowired
	FileDown fileDown;
	@ModelAttribute
	EmployeeCommand setEmployeeCommand() {
		return new EmployeeCommand();
	}
	@RequestMapping("list")
	public String empList(Model model) {
		employeeListService.getEmpList(model);
		return "v-admin-emp/admin-emp-list";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String empRegist() {
		return "thymeleaf/admin-emp/admin-emp-regform";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String empRegistPro(EmployeeCommand employeeCommand, HttpServletRequest request) {
		employeeRegistService.registEmp(employeeCommand, request);
		return "redirect:/emp/list";
	}
	
	@RequestMapping("view")
	public String empDetail(@RequestParam(value = "empNo")String employeeNo, Model model) {
		employeeDetailService.empDetail(employeeNo, model);
		return "thymeleaf/admin-emp/admin-emp-detail";
	}
	
	@RequestMapping("fileDown")
	public void idCardDown(@RequestParam(value = "file")String fileName, HttpServletResponse response, HttpServletRequest request) {
		String path = "/static/employee/upload";
		fileDown.singleFileDown(path, fileName, response, request);
	}
	
	@RequestMapping("delete")
	public String deleteEmp(@RequestParam(value = "empNo")String employeeNo) {
		employeeDeleteService.deleteEmployee(employeeNo);
		return "redirect:/emp/list";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String empModify(@RequestParam(value = "empNo")String employeeNo, Model model) {
		employeeDetailService.empDetail(employeeNo, model);
		return "thymeleaf/admin-emp/admin-emp-modify";
	}
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String empModifyPro(EmployeeCommand employeeCommand) {
		employeeModifyService.empModify(employeeCommand);
		return "redirect:/emp/list";
	}

}
package finalProject.controller.program;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.FileName;
import finalProject.command.ProgramLibCommand;
import finalProject.command.ProgramLibReplyCommand;
import finalProject.service.file.FileDelService;
import finalProject.service.program.PlibReplyService;
import finalProject.service.program.ProLibDetailService;
import finalProject.service.program.ProLibModifyService;
import finalProject.service.program.ProgramLibService;
import finalProject.service.program.ProlibListService;

@Controller
@RequestMapping("pgmypage")
public class PgMypageController {
	@Autowired
	ProgramLibService programLibService;
	@Autowired
	ProlibListService prolibListService;
	@Autowired
	ProLibDetailService proLibDetailService;
	@Autowired
	ProLibModifyService proLibModifyService;
	@Autowired
	FileDelService fileDelService;
	@Autowired
	PlibReplyService plibReplyService;

	@RequestMapping("programMypage")
	public String myPage() {
		return "thymeleaf/program/programMypage";
	}

	@RequestMapping("programLib")
	public String programLib(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model)
			throws Exception {
		prolibListService.prolibList(model, page);
		return "thymeleaf/programLib/one_to_one";
	}

	@RequestMapping(value = "programLibWrite", method = RequestMethod.GET)
	public String programLibWrite() {
		return "thymeleaf/programLib/one_to_one_write";
	}

	@RequestMapping(value = "programLibWrite", method = RequestMethod.POST)
	public String programLibPro(@Validated ProgramLibCommand programLibCommand, BindingResult result,
			HttpServletRequest request) throws Exception {
		if (result.hasErrors()) {
			System.out.println("programLibWrite 오류");
			return "thymeleaf/programLib/one_to_one_write";
		}

		String location = programLibService.writePro(programLibCommand, request);
		return location;
	}

	@RequestMapping("libDetail")
	public String libDetail(@RequestParam(value = "plibNo") String plibNo, Model model) throws Exception {
		proLibDetailService.prolibDetail(plibNo, model);
		return "thymeleaf/programLib/prolibDetail";
	}

	@RequestMapping("prolibModify")
	public String prolibModify(@RequestParam("plibNo") String plibNo, Model model, HttpSession session)
			throws Exception {
		proLibDetailService.prolibDetail(plibNo, model);
		return "thymeleaf/programLib/prolibModify";
	}

	@RequestMapping("fileDel")
	public String fileDel(FileName fileName, HttpSession session, Model model) {
		fileDelService.fileSessionAdd(fileName, session, model);
		return "thymeleaf/programLib/delPage";
	}

	@RequestMapping(value = "proLibModifyPro", method = RequestMethod.POST)
	public String proLibModifyPro(ProgramLibCommand programLibCommand, HttpSession session, Model model)
			throws Exception {
		String path = proLibModifyService.prolibModify(programLibCommand, model, session);
		return path;
	}

	@RequestMapping(value = "replyInsert", method = RequestMethod.POST)
	public String replyInsert(@RequestParam("plibNo") String plibNo, ProgramLibReplyCommand programLibReplyCommand,
			Model model, HttpSession session) throws Exception {
		plibReplyService.replyInsert(plibNo, programLibReplyCommand, model, session);
		return "redirect:/pgmypage/libDetail?plibNo=" + plibNo;
	}
}

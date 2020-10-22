package finalProject.controller.house.roomMake;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.house.roomMake.RoomMakeCommand;
import finalProject.service.house.roomMake.RoomMakeDeleteService;
import finalProject.service.house.roomMake.RoomMakeListService;
import finalProject.service.house.roomMake.RoomMakeModifyService;
import finalProject.service.house.roomMake.RoomMakeService;
import finalProject.service.house.roomMake.RoomMakeViewService;

@Controller
@RequestMapping("roomMake")
public class roomMakeController {
	
	@ModelAttribute
	RoomMakeCommand setRoomMakeCommand() {
		return new RoomMakeCommand();
	}

	@Autowired
	RoomMakeService roomMakeService;

	@Autowired
	RoomMakeListService roomMakeListService;
	
	@Autowired
	RoomMakeViewService roomMakeViewService;
	
	@Autowired
	RoomMakeModifyService roomMakeModifyService;
	
	@Autowired
	RoomMakeDeleteService roomMakeDeleteService;
	
	@RequestMapping(value = "roomList") // 객실등록 리스트
	public String roomList(Model model) throws Exception{
		roomMakeListService.RoomMakeList(model);
		return "thymeleaf/roomMake/roomList";
	}

	@RequestMapping(value = "roomInsert") // 객실등록 페이지
	public String roomInsert() {
		return "thymeleaf/roomMake/roomInsert";
	}

	@RequestMapping(value = "roomInsertPro", method = RequestMethod.POST) // 객실등록 인서트
	public String roomInsertPro(RoomMakeCommand roomMakeCommand, HttpSession session) throws Exception {

		 roomMakeService.roomInsertPro(roomMakeCommand, session);

		 return "redirect:/roomMake/roomList";
	}
	
	@RequestMapping(value = "roomView") // 객실 상세보기  
	public String roomView(@RequestParam(value = "roomNo") String roomNo, Model model) throws Exception {
		
		roomMakeViewService.RoomMakeView(roomNo, model);
		
		return "thymeleaf/roomMake/roomView";
	}
	
	@RequestMapping(value = "roomModify", method = RequestMethod.GET) // 객실 수정하기
	public String roomModify(@RequestParam(value = "roomNo") String roomNo, Model model) throws Exception {
		
		roomMakeViewService.RoomMakeView(roomNo, model);
		
		return "thymeleaf/roomMake/roomModify";
	} 
	
	@RequestMapping(value = "roomModifyPro", method = RequestMethod.POST) // 객실 수정완료 
	public String roomModifyPro(RoomMakeCommand roomMakeCommand, Model model) throws Exception {
		
		roomMakeModifyService.roomMakeModify(roomMakeCommand, model);
		
		return "redirect:/roomMake/roomList";
	} 
	
	@RequestMapping(value = "roomDelete", method = RequestMethod.GET) // 객실 삭제 
	public String roomDelete(@RequestParam(value = "roomNo") String roomNo, Model model) throws Exception {
		
		model.addAttribute("roomNo", roomNo);
		
		return "thymeleaf/roomMake/roomDelete";
	}
	
	@RequestMapping(value = "roomDeletePro", method = RequestMethod.POST) // 객실 삭제 완료 
	public String roomDeletePro(@RequestParam(value = "roomNo") String roomNo, Model model) throws Exception {
		
		roomMakeDeleteService.roomDeletePro(roomNo, model);
		
		return "redirect:/roomMake/roomList";
	}
	
	
	
	
	
	
	
 }

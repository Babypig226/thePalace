package finalProject.controller.house.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.house.fixtures.FixturesCommand;
import finalProject.command.house.roomMake.RoomMakeCommand;
import finalProject.service.house.fixtures.FixturesDeleteSerivce;
import finalProject.service.house.fixtures.FixturesListService;
import finalProject.service.house.fixtures.FixturesService;
import finalProject.service.house.fixtures.FixturesViewService;
import finalProject.service.house.fixtures.FixturesModifyService;
import finalProject.service.house.roomMake.RoomMakeListService;

//import finalProject.service.house.fixtures.FixturesService;

@Controller
@RequestMapping("houseFixtures")
public class HouseFixturesController {
 
	@ModelAttribute
	FixturesCommand fixturesCommand() {
		return new FixturesCommand();
	}
	
	
	@Autowired
	FixturesService fixturesService;
	
	@Autowired
	FixturesListService fixturesListService;
	
	@Autowired
	RoomMakeListService roomMakeListService;
	
	@Autowired
	FixturesViewService fixturesViewService;
	
	@Autowired
	FixturesModifyService fixturesModifyService;
	
	@Autowired
	FixturesDeleteSerivce fixturesDeleteSerivce;
	
	@RequestMapping(value = "fixturesList") 
	public String fixturesList(Model model) throws Exception {
		fixturesListService.FixturesList(model);
		return "thymeleaf/fixtures/fixturesList";
	}
	
	@RequestMapping(value = "fixturesInsert") 
	public String fixturesInsert(Model model) throws Exception {
		roomMakeListService.RoomMakeList(model);
		return "thymeleaf/fixtures/fixturesInsert";
	}
	
	@RequestMapping(value = "fixturesInsertPro", method = RequestMethod.POST) 
	public String fixturesInsertPro(FixturesCommand fixturesCommand) throws Exception {
		fixturesService.fixturesInsertPro(fixturesCommand);
		
		return "redirect:/houseFixtures/fixturesList";
	}
	
	@RequestMapping(value = "fixturesView") 
	public String fixturesView(@RequestParam(value = "equipNo") String equipNo, Model model) throws Exception {
		
		fixturesViewService.fixturesView(equipNo, model);
		
		return "thymeleaf/fixtures/fixturesView";
	}
	
	@RequestMapping(value = "fixturesModify", method = RequestMethod.GET) 
	public String fixturesModify(@RequestParam(value = "equipNo") String equipNo, Model model) throws Exception {
		
		fixturesViewService.fixturesView(equipNo, model);
		
		return "thymeleaf/fixtures/fixturesModify";
	}
	
	@RequestMapping(value = "fixturesModifyPro", method = RequestMethod.POST) 
	public String fixturesModifyPro(FixturesCommand fixturesCommand, Model model) throws Exception {
		
		fixturesModifyService.fixturesModify(fixturesCommand, model);
		
		return "redirect:/houseFixtures/fixturesList";
	}
	
	@RequestMapping(value = "fixturesDelete", method = RequestMethod.GET) 
	public String fixturesDelete(@RequestParam(value = "equipNo") String equipNo, Model model) throws Exception {
		
		model.addAttribute("equipNo", equipNo);
		
		return "thymeleaf/fixtures/fixturesDelete";
	}
	
	@RequestMapping(value = "fixturesDeletePro", method = RequestMethod.POST) 
	public String fixturesDeletePro(@RequestParam(value = "equipNo") String equipNo, Model model) throws Exception {
		
		fixturesDeleteSerivce.fixturesDeletePro(equipNo, model);
		
		return "redirect:/houseFixtures/fixturesList";
	}
	
}

package finalProject.controller.pdgoods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import finalProject.service.productlist.BoxService;
import finalProject.service.productlist.CardService;
import finalProject.service.productlist.CupService;
import finalProject.service.productlist.DailySuppliesService;
import finalProject.service.productlist.DishService;
import finalProject.service.productlist.FrameSerivce;
import finalProject.service.productlist.InteriorSuppliesServce;
import finalProject.service.productlist.KitchenWareService;
import finalProject.service.productlist.LightingService;
import finalProject.service.productlist.MirrorService;
import finalProject.service.productlist.NoteService;
import finalProject.service.productlist.OfficeSuppliesService;
import finalProject.service.productlist.PenService;
import finalProject.service.productlist.SpoonService;

@Controller
@RequestMapping("product")
public class GoodsListController {
	
	@Autowired
	OfficeSuppliesService officeSuppliesService;
	@Autowired
	KitchenWareService kitchenWareService;
	@Autowired
	InteriorSuppliesServce interiorSuppliesServce; 
	@Autowired
	DailySuppliesService dailySuppliesService;
	
	@RequestMapping("officeSupplies") // 문구/사무용품
	public String officeSupplies(Model model) {
		officeSuppliesService.offsList(model);
		return "thymeleaf/office_supplies";
	}
	
	@RequestMapping("kitchenWare") // 주방용품
	public String kitchenWare(Model model) {
		kitchenWareService.kitList(model);
		return "thymeleaf/Kitchen_ware";
	}
	
	@RequestMapping("interiorSupplies") //인테리어용품
	public String interiorSupplies(Model model) {
		interiorSuppliesServce.inteList(model);
		return "thymeleaf/interior_supplies";
	}
	
	@RequestMapping("dailySupplies") //일상용품
	public String dailySupplies(Model model) {
		dailySuppliesService.dayList(model);
		return "thymeleaf/daily_supplies";
	}
	
	// --------------------------------------------------------- 카테고리
	
	@Autowired
	CardService cardService;
	@Autowired
	NoteService noteService;
	@Autowired
	PenService penService;
	
	@RequestMapping("card")
	public String card(Model model) {
		cardService.cardList(model);
		return "thymeleaf/office_supplies";
	}
	
	@RequestMapping("note")
	public String note(Model model) {
		noteService.noteList(model);
		return "thymeleaf/office_supplies";
	}
	
	@RequestMapping("pen")
	public String pen(Model model) {
		penService.penList(model);
		return "thymeleaf/office_supplies";
	}
	
	// --------------------------------------------------------- 문구/사무용품
	
	@Autowired
	DishService dishService;
	@Autowired
	CupService cupService;
	@Autowired
	SpoonService spoonService;
	@RequestMapping("dish")
	public String dish(Model model) {
		dishService.dishList(model);
		return "thymeleaf/Kitchen_ware";
	}
	
	@RequestMapping("cup")
	public String cup(Model model) {
		cupService.cupList(model);
		return "thymeleaf/Kitchen_ware";
	}
	
	@RequestMapping("spoon")
	public String spoon(Model model) {
		spoonService.spoonList(model);
		return "thymeleaf/Kitchen_ware";
	}
	// --------------------------------------------------------- 주방용품
    @Autowired
    FrameSerivce frameService;
	@Autowired
	LightingService lightingService;
	
	@RequestMapping("frame")
    public String frame(Model model) {
    	frameService.frameList(model);
    	return "thymeleaf/interior_supplies";
    }
	
	@RequestMapping("lighting")
	public String lighting(Model model) {
		lightingService.lightingList(model);
		return "thymeleaf/interior_supplies";
	}
	// --------------------------------------------------------- 인테리어용품
	@Autowired
	MirrorService mirrorService;
	@Autowired
	BoxService boxService;
	
	@RequestMapping("mirror")
	public String mirror(Model model) {
		mirrorService.mirrorList(model);
		return "thymeleaf/daily_supplies";
	}
	
	@RequestMapping("box")
	public String box(Model model) {
		boxService.boxList(model);
		return "thymeleaf/daily_supplies";
	}
	
	

}

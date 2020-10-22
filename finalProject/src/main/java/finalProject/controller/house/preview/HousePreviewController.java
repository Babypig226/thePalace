package finalProject.controller.house.preview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("preview")
public class HousePreviewController {
	
	@RequestMapping(value = "houseDetailInfo")
	public String houseDetailInfo() {
		return "thymeleaf/room/reservationSupport";
	}
	
	@RequestMapping(value = "slide1")
	public String houseSlide1() {
		return "thymeleaf/roomReservation/roomSlide1";
	}

	
	
}

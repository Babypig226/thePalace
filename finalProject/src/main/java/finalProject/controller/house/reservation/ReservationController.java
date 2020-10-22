package finalProject.controller.house.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.house.reservation.ReservationCommand;
import finalProject.service.house.reservation.ReservationInsertService;
import finalProject.service.house.reservation.ReservationViewService;
import finalProject.service.house.roomMake.RoomMakeListService;
import finalProject.service.house.roomMake.RoomMakeViewService;

@Controller
@RequestMapping("reservation")
public class ReservationController {

	@Autowired
	RoomMakeListService roomMakeListService;

	@Autowired
	RoomMakeViewService roomMakeViewService;

	@Autowired
	ReservationInsertService reservationInsertService;

	@Autowired
	ReservationViewService reservationViewService;

	@RequestMapping(value = "reservation")
	public String reservation() {
		return "thymeleaf/room/houseReservation";
	}

	@RequestMapping(value = "guide") // 예약안내
	public String guide() {
		return "thymeleaf/room/guide";
	}

	@RequestMapping(value = "structure") // 객실배치도
	public String structure() {
		return "thymeleaf/room/structure";
	}

	@RequestMapping(value = "reservationGuide") // 실시간 예약
	public String reservationGuide(Model model) throws Exception {

		roomMakeListService.RoomMakeList(model);

		return "thymeleaf/room/reservationGuide";
	}

	@RequestMapping(value = "reservationInfo") // 실시간 예약 정보 입력
	public String reservationInfo(@RequestParam(value = "roomNo") String roomNo, Model model) throws Exception {

		roomMakeViewService.RoomMakeView(roomNo, model);

		return "thymeleaf/room/reservationInfo";
	}

	@RequestMapping(value = "reservationInfoPro") // 실시간 예약 정보 입력
	public String reservationInfoPro(ReservationCommand reservationCommand, Model model) throws Exception {

		reservationInsertService.ReservationInsert(reservationCommand, model);

		reservationViewService.reservationView(reservationCommand, model);

		return "thymeleaf/room/reservationPayment";
	}

	@RequestMapping(value = "reservationPayment")
	public String reservationPayment(Model model) throws Exception {

		return "redirect:/";
	}

}

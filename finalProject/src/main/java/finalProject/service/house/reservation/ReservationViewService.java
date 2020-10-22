package finalProject.service.house.reservation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.house.reservation.ReservationCommand;
import finalProject.domain.house.ReservationDTO;
import finalProject.mapper.house.reservation.ReservationMapper;

@Component
@Service
public class ReservationViewService {

	@Autowired
	ReservationMapper reservationMapper;
	
	public void reservationView(ReservationCommand reservationCommand, Model model) {
		//user Id& using date 조건 select
		ReservationDTO rdto = new ReservationDTO();
		rdto.setUserId(reservationCommand.getUserId());
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String usingDate = dt.format(reservationCommand.getUsingDate());
		Timestamp date = Timestamp.valueOf(usingDate);
		rdto.setUsingDate(date);
		
		ReservationDTO newdto = reservationMapper.getReservationView(rdto);
		System.out.println("view Service new dto : using date"+newdto.getUsingDate());
		System.out.println("view Service new dto : reservation content"+newdto.getRsContent());
		model.addAttribute("dto", newdto);		
	}

	
	
}

package finalProject.service.house.reservation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.house.reservation.ReservationCommand;
import finalProject.domain.house.ReservationDTO;
import finalProject.domain.house.RoomMakeDTO;
import finalProject.mapper.house.reservation.ReservationMapper;
import finalProject.mapper.house.roomMake.RoomMakeMapper;

@Component
@Service
public class ReservationInsertService {

	@Autowired
	ReservationMapper reservationMapper;
	
	@Autowired
	RoomMakeMapper roomMakeMapper;
	
	
	public void ReservationInsert(ReservationCommand reservationCommand, Model model) throws Exception {
		
		ReservationDTO dto = new ReservationDTO();
		
		dto.setRsContent(reservationCommand.getRsContent());
		dto.setUserId(reservationCommand.getUserId());
		dto.setRsPh(reservationCommand.getRsPh());
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String usingDate = dt.format(reservationCommand.getUsingDate());
		
		
		Timestamp date = Timestamp.valueOf(usingDate);
		dto.setUsingDate(date);
		
		RoomMakeDTO dto1 = roomMakeMapper.getListView(reservationCommand.getRoomNo());
	
		dto.setReservationCount(Integer.parseInt(dto1.getRMaxCount()));
		System.out.println("reservation service :"+reservationCommand.getRsContent());
		System.out.println("reservation service :"+reservationCommand.getUserId());
		System.out.println("reservation service :"+reservationCommand.getRsPh());
		System.out.println("reservation service :"+reservationCommand.getUsingDate());
		System.out.println("reservation service :"+Integer.parseInt(dto1.getRMaxCount()));
		model.addAttribute("roomPrice", dto1.getRoomPrice());
		model.addAttribute("roomName", dto1.getRoomName());
		reservationMapper.reserverationInsert(dto);
		
	}
	
}

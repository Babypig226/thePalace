package finalProject.mapper.house.reservation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.house.ReservationDTO;

@Component
@Repository("finalProject.mapper.house.reservation.ReservationMapper")
public interface ReservationMapper {

	public void reserverationInsert(ReservationDTO dto);

	public ReservationDTO getReservationView(ReservationDTO rdto);
	
}

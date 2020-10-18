package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.RentDocDTO;
import finalProject.domain.StartEndPageDTO;

@Repository("finalProject.mapper.RentDocMapper")
public interface RentDocMapper {
	public void insertRentDoc(RentDocDTO dto);
	public List<RentDocDTO> getRentDocList(StartEndPageDTO dto);

}

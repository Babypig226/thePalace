package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.RentContractDTO;
import finalProject.domain.StartEndPageDTO;

@Repository("finalProject.mapper.RentContractMapper")
public interface RentContractMapper {
	public void insertRentContract(RentContractDTO dto);
	public List<RentContractDTO> getRentContractList(StartEndPageDTO sdto);

}

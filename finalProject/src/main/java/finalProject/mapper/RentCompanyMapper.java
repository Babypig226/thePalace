package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.RentCompanyDTO;
import finalProject.domain.StartEndPageDTO;

@Repository("finalProject.mapper.RentCompanyMapper")
public interface RentCompanyMapper {
	public void insertRentCompany(RentCompanyDTO dto);
	public List<RentCompanyDTO> getRentCompanyList(StartEndPageDTO dto);

}

package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TchContractDTO;

@Repository("finalProject.mapper.TeacherContractMapper")
public interface TeacherContractMapper {
	public void insertTctrt(TchContractDTO tctrtdto);
	public List<TchContractDTO> getTcontractsList(StartEndPageDTO dto);
	public TchContractDTO getContractDetail(StartEndPageDTO dto);
}

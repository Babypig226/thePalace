package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.ApplicantDTO;
import finalProject.domain.StartEndPageDTO;

@Repository("finalProject.mapper.ApplicantMapper")
public interface ApplicantMapper {
   public void registApplicant(ApplicantDTO applicantDTO);
   public List<ApplicantDTO> getApplicantsList(StartEndPageDTO startEndPageDTO);
   public List<ApplicantDTO> getFinalists();
}
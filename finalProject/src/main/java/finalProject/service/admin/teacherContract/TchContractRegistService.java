package finalProject.service.admin.teacherContract;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.TchContractCommand;
import finalProject.domain.TchContractDTO;
import finalProject.mapper.TeacherContractMapper;
import finalProject.service.file.FileUploadService;

@Component
@Service
public class TchContractRegistService {
	
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	TeacherContractMapper teacherContractMapper;
	
	public void registTctrt(TchContractCommand tchContractCommand, HttpServletRequest request) {
		TchContractDTO dto = new TchContractDTO();
		dto.setTeacherNo(tchContractCommand.getTeacherNo());
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMddHHmmss");
		String num = dateForm.format(new Date());
		dto.setTcontractNo(tchContractCommand.getTeacherNo()+"-"+num);
		dto.setTcontractTerm(tchContractCommand.getTcontractTerm());
		dto.setTcontractType(tchContractCommand.getTcontractType());
		dto.setTeacherSal(tchContractCommand.getTeacherSal());
		dto.setTeacherAccount(tchContractCommand.getTeacherAccount());
		dto.setCheckSafe(tchContractCommand.getCheckSafe());
		dto.setEmpNo("1");
		String path = "/static/teacherContract/upload";
		String filePath = request.getServletContext().getRealPath(path);
		dto.setTcopyBankbook(fileUploadService.fileUpload(tchContractCommand.getTcopyBankbook(), filePath));
		dto.setTidentitiCard(fileUploadService.fileUpload(tchContractCommand.getTidentitiCard(), filePath));
		teacherContractMapper.insertTctrt(dto);
	}

}

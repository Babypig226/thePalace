package finalProject.service.hr.teacherRegist;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.TchRegistCommand;
import finalProject.domain.TchRegistDTO;
import finalProject.mapper.TeacherRegistMapper;
import finalProject.service.file.FileUploadService;

@Component
@Service
public class TchRegistWriteService {
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	TeacherRegistMapper teacherRegistMapper;
	
	public void insertTchRegist(TchRegistCommand tchRegistCommand, HttpServletRequest request) {
		TchRegistDTO dto = new TchRegistDTO();
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMddHHmmss");
		String num = fm.format(new Date());
		dto.setRegisterNo(tchRegistCommand.getTnoticeNo()+"-"+num);
		dto.setTeacherLevel(tchRegistCommand.getTeacherLevel());
		String path = "/static/teacher-regist/upload";
		String realPath = request.getServletContext().getRealPath(path);
		dto.setProgramRegist(fileUploadService.fileUpload(tchRegistCommand.getProgramRegist(), realPath));
		dto.setRegisterContent(fileUploadService.fileUpload(tchRegistCommand.getRegisterContent(), realPath));
		dto.setTeacherLicense(fileUploadService.fileUpload(tchRegistCommand.getTeacherLicense(), realPath));
		teacherRegistMapper.insertTchRegist(dto);
		
	}
	

}

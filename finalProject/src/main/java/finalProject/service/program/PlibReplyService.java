package finalProject.service.program;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import finalProject.command.ProgramLibReplyCommand;
import finalProject.domain.PlibReplyDTO;
import finalProject.domain.ProgramLibDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramLibMapper;

@Component
@Service
@Transactional
public class PlibReplyService {
	@Autowired
	ProgramLibMapper programLibMapper;

	public void replyInsert(String plibNo, ProgramLibReplyCommand programLibReplyCommand, 
						Model model, HttpSession session) throws Exception{
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, "1111", plibNo);
		ProgramLibDTO dto = programLibMapper.getproLibList(startEndPageDTO).get(0);
		PlibReplyDTO predto = new PlibReplyDTO();
		
		predto.setEmployeeNo("1");
		System.out.println(dto.getPlibNo());
		predto.setPlibNo(dto.getPlibNo());
		predto.setPreplyContent(programLibReplyCommand.getPreplyContent());
		
		programLibMapper.replyInsert(predto);

	}

}

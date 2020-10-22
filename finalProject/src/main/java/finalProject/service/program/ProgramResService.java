package finalProject.service.program;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.AuthInfo;
import finalProject.command.ProResCommand;
import finalProject.domain.PgbasketDTO;
import finalProject.domain.ProResDTO;
import finalProject.domain.ProgramDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProResMapper;
import finalProject.mapper.ProgramMapper;

@Component
@Service
public class ProgramResService {
	@Autowired
	ProResMapper proResMapper;
	@Autowired
	ProgramMapper programMapper;

	public void resInfoInsert(ProResCommand proResCommand,
								Model model, HttpSession session) throws Exception{
		System.out.println("programResService");

		ProResDTO prdto = new ProResDTO();
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		prdto.setUserId(userId);
		prdto.setRsContent(proResCommand.getRsContent());
		prdto.setRsPh(proResCommand.getRsPh());
		prdto.setReservationCount(proResCommand.getReservationCount());
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String musingDate = fm.format(proResCommand.getUsingDate());
		Timestamp usingDate = Timestamp.valueOf(musingDate);
		prdto.setUsingDate(usingDate);
		
		Integer i = proResMapper.resInfoInsert(prdto);
		model.addAttribute("num", i);
	}

	public void resInfoList(Model model) throws Exception{
		System.out.println("resInfoListService");
		List<ProResDTO> rslist = proResMapper.resInfoList();
		
		model.addAttribute("rslist", rslist);
	}

}

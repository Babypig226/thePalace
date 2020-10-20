package finalProject.service.program;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.ProResCommand;
import finalProject.domain.PgbasketDTO;
import finalProject.domain.ProResDTO;
import finalProject.mapper.ProResMapper;

@Component
@Service
public class ProgramResService {
	@Autowired
	ProResMapper proResMapper;

	public void resInfoInsert(ProResCommand proResCommand,
								Model model, HttpSession session) throws Exception{
		System.out.println("programResService");
		PgbasketDTO cart = new PgbasketDTO();
		ProResDTO prdto = new ProResDTO();
		prdto.setRsContent(proResCommand.getRsContent());
		prdto.setRsPh(proResCommand.getRsPh());
		prdto.setReservationCount(proResCommand.getReservationCount());
		prdto.setUserId("1111");
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
		
	}

}

package finalProject.service.program;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.ProgramPayCommand;
import finalProject.domain.PgbasketDTO;
import finalProject.domain.ProPayDTO;
import finalProject.mapper.ProPayMapper;
import finalProject.mapper.ProgramBasketMapper;

@Component
@Service
public class ProgramPayService {
	@Autowired
	ProPayMapper proPayMapper;
	@Autowired
	ProgramBasketMapper programBasketMapper;

	public void payInfoInsert(ProgramPayCommand programPayCommand,
							Model model, HttpSession session) throws Exception{
		System.out.println("ProgramPayService");
		List<PgbasketDTO> pglist = programBasketMapper.pgbasketlist();
		ProPayDTO ppdto = new ProPayDTO();
		ppdto.setPayOption(programPayCommand.getPayOption());
		ppdto.setCouponNo(null);
		int totPrice = 0;
		for (PgbasketDTO pg : pglist) {
			totPrice += pg.getAmount() * pg.getPro().get(0).getProgramPrice();
		}
		ppdto.setTotalPay(totPrice);
		
		Integer i = proPayMapper.payInfoInsert(ppdto);
		model.addAttribute("num", i);
	}

	public void payInfoList(Model model) throws Exception{
		System.out.println("payInfoListService");
		List<ProPayDTO> paylist = proPayMapper.payInfolist();
		
		model.addAttribute("paylist", paylist);
	}

}

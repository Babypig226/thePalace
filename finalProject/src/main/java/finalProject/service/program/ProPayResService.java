package finalProject.service.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.PgbasketDTO;
import finalProject.domain.ProPayDTO;
import finalProject.domain.ProPayResDTO;
import finalProject.domain.ProResDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProPayMapper;
import finalProject.mapper.ProPayResMapper;
import finalProject.mapper.ProResMapper;
import finalProject.mapper.ProgramBasketMapper;

@Component
@Service
public class ProPayResService {
	@Autowired
	ProgramBasketMapper programBasketMapper;
	@Autowired
	ProPayMapper proPayMapper;
	@Autowired
	ProResMapper proResMapper;
	@Autowired
	ProPayResMapper proPayResMapper;

	public void payresInsert() throws Exception{
		System.out.println("proresInsertService");
		ProPayResDTO pprdto = new ProPayResDTO();
		List<PgbasketDTO> pglist = programBasketMapper.pgbasketlist();
		List<ProPayDTO> paylist = proPayMapper.payInfolist();
		List<ProResDTO> reslist = proResMapper.resInfoList();
		
		String programNo = "";
		for (PgbasketDTO pg : pglist) {
			programNo = pg.getProgramNo();
		}
		System.out.println(programNo);
		pprdto.setProgramNo(programNo);
		
		String payNo = "";
		for (ProPayDTO pay : paylist) {
			payNo = pay.getPayNo();
		}
		System.out.println(payNo);
		pprdto.setPayNo(payNo);
		
		String rsNo = "";
		for (ProResDTO res : reslist) {
			rsNo = res.getReservationNo();
		}
		System.out.println(rsNo);
		pprdto.setRsNo(rsNo);
		
		proPayResMapper.payresInsert(pprdto);
	}

}

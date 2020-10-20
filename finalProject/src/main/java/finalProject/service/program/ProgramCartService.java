package finalProject.service.program;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.PgbasketCommand;
import finalProject.domain.PgbasketDTO;
import finalProject.domain.ProgramDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramBasketMapper;
import finalProject.mapper.ProgramMapper;

@Component
@Service
public class ProgramCartService {
	@Autowired
	ProgramMapper programMapper;	
	@Autowired
	ProgramBasketMapper programBasketMapper;

	public void programCartAdd(String programNo, PgbasketCommand pgbasketCommand, 
			Model model, HttpSession session) throws Exception{
		System.out.println("programCartAddService");
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, "1111", programNo);
		ProgramDTO prodto = programMapper.getProgramList(startEndPageDTO).get(0);
		PgbasketDTO pgdto = new PgbasketDTO();
		
		pgdto.setUserId("1111");
		pgdto.setProgramNo(prodto.getProgramNo());
		pgdto.setAmount(pgbasketCommand.getAmount());
		System.out.println("caraddService : "+pgbasketCommand.getAmount());
		pgdto.setCheckOp(pgbasketCommand.getCheckOp());
		System.out.println("caraddService : "+pgbasketCommand.getCheckOp());
		
		Integer i = programBasketMapper.cartInsert(pgdto);
		
		model.addAttribute("num", i);
	}


	public void programCartList(Model model) throws Exception{	
		System.out.println("programCartListService");
		List<PgbasketDTO> pglist = programBasketMapper.pgbasketlist();
		
			int totPrice = 0;
			for (PgbasketDTO pg : pglist) {
				System.out.println("programNo"+pg.getProgramNo());
				System.out.println("amount" + pg.getAmount());
				System.out.println("checkOp"+pg.getCheckOp());
				System.out.println("price"+pg.getAmount() * pg.getPro().get(0).getProgramPrice());
				totPrice += pg.getAmount() * pg.getPro().get(0).getProgramPrice();
			}	
			System.out.println("totPrice "+totPrice);
			model.addAttribute("totPrice", totPrice);
			
		model.addAttribute("pglist", pglist);
	}
}

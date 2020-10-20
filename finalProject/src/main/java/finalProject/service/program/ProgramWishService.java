package finalProject.service.program;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.PrWishDTO;
import finalProject.domain.ProgramDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramMapper;
import finalProject.mapper.ProgramWishMapper;

@Component
@Service
public class ProgramWishService {
	@Autowired
	ProgramMapper programMapper;
	@Autowired
	ProgramWishMapper programWishMapper;
	
	public void programWishAdd(String programNo,
							Model model, HttpSession session) throws Exception{
		System.out.println("programWishAdd");
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, "1111", programNo);
		ProgramDTO prodto = programMapper.getProgramList(startEndPageDTO).get(0);
		PrWishDTO wishdto = new PrWishDTO();
		
		wishdto.setUserId("1111");
		wishdto.setProgramNo(prodto.getProgramNo());
		System.out.println(prodto.getProgramNo());
		Integer i = programWishMapper.wishInsert(wishdto);
		model.addAttribute("num", i);		
	}

	public void programWishList(Model model) throws Exception{
		System.out.println("programWishList");
		List<PrWishDTO> prwish = programWishMapper.getwishlist();
		model.addAttribute("prwish", prwish);
	}

}

package finalProject.service.hr.tnotice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TnoticeDTO;
import finalProject.mapper.TnoticeMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class TnoticeListService {
	@Autowired
	AddressService addressService;
	@Autowired
	TnoticeMapper tnoticeMapper;
	public void getTnoticeList(Model model, Integer page) {
		int limit = 10;
		int limitPage = 10;
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, null);
		List<TnoticeDTO> lists = tnoticeMapper.getTnoticeList(dto);
		model.addAttribute("list", lists);
	}

}

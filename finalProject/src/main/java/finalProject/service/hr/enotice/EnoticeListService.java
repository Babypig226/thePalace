package finalProject.service.hr.enotice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.EnoticeDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.EnoticeMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class EnoticeListService {
	@Autowired
	EnoticeMapper enoticeMapper;
	@Autowired
	AddressService addressService;
	public void getEnoticeList(Model model, Integer page) {
		int limit = 10;
		int limitPage = 10;
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO pdto = new StartEndPageDTO(startRow, endRow, null, null);
		List<EnoticeDTO> lists = enoticeMapper.getEnoticeList(pdto);
		model.addAttribute("list", lists);
		
	}
	

}

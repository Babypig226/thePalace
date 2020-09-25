package finalProject.service.dep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.DepDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.DepMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class DepListService {
	
	@Autowired
	DepMapper depMapper;
	@Autowired
	AddressService addressService;
	public void getDepList(Model model, Integer page) {
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		
		StartEndPageDTO dto = 
				new StartEndPageDTO(startRow, endRow, null, null);
		
		List<DepDTO> list = depMapper.getDepList(dto);
		for (int i = 0; i < list.size(); i++) {
			String departmentAddr = addressService.rebuildAddress(list.get(i).getDepartmentAddr());
			list.get(i).setDepartmentAddr(departmentAddr);
		}
		model.addAttribute("list", list);
		
	}
	
}

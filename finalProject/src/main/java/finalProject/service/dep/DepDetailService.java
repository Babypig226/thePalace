package finalProject.service.dep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.AddressDTO;
import finalProject.domain.DepDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.DepMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class DepDetailService {
	@Autowired
	DepMapper depMapper;
	@Autowired
	AddressService addressService;
	public void depDetail(String depNo, Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, depNo);
		List<DepDTO> list = depMapper.getDepList(dto);
		AddressDTO addr = addressService.devideAddress(list.get(0).getDepartmentAddr());
		model.addAttribute("detail", list.get(0));
		model.addAttribute("addr", addr);
	}
	

}

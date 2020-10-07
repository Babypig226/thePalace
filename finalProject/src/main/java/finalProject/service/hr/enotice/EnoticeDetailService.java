package finalProject.service.hr.enotice;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.AddressDTO;
import finalProject.domain.EnoticeDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.EnoticeMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class EnoticeDetailService {
	@Autowired
	EnoticeMapper enoticeMapper;
	@Autowired
	AddressService addressService;
	public void getEnoticeDetail(String enoticeNo, Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, enoticeNo);
		EnoticeDTO endto = enoticeMapper.getEnoticeList(dto).get(0);
		AddressDTO addr = addressService.devideAddress(endto.getInterviewAddr());
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd"); 
		String fpassDate=fmt.format(endto.getFpassDate()); 
		String joinDate=fmt.format(endto.getJoinDate()); 
		String deadline=fmt.format(endto.getDeadline()); 
		String interviewDate=fmt.format(endto.getInterviewDate()); 
		endto.setInterviewAddr(addressService.rebuildAddress(endto.getInterviewAddr()));
		model.addAttribute("fpassDate", fpassDate);
		model.addAttribute("joinDate", joinDate);
		model.addAttribute("deadline", deadline);
		model.addAttribute("interviewDate", interviewDate);
		model.addAttribute("list", endto);
		model.addAttribute("addr", addr);
		
	}
	

}

package finalProject.service.hr.tnotice;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.AddressDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TnoticeDTO;
import finalProject.mapper.TnoticeMapper;
import finalProject.service.addr.AddressService;
import finalProject.service.dateFormat.DateFormatService;

@Component
@Service
public class TnoticeDetailService {
	@Autowired
	TnoticeMapper tnoticeMapper;
	@Autowired
	AddressService addressService;
	@Autowired
	DateFormatService dateFormatService;
	public void getTnoticeDetail(String tnoticeNo, Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, tnoticeNo); 
		TnoticeDTO tdto = tnoticeMapper.getTnoticeList(dto).get(0);
		AddressDTO addr = addressService.devideAddress(tdto.getTinterviewAddr());
		tdto.setTinterviewAddr(addressService.rebuildAddress(tdto.getTinterviewAddr()));
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd"); 
		String tpassDate=fmt.format(tdto.getTpassDate()); 
		String tnoticeDeadline=fmt.format(tdto.getTnoticeDeadline()); 
		String tinterviewDate=fmt.format(tdto.getTinterviewDate()); 
		model.addAttribute("list", tdto);
		model.addAttribute("addr", addr);
		model.addAttribute("tpassDate", tpassDate);
		model.addAttribute("tnoticeDeadline", tnoticeDeadline);
		model.addAttribute("tinterviewDate", tinterviewDate);
	}
	

}

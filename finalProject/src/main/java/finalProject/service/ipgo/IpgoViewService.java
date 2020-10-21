package finalProject.service.ipgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.IpgoDTO;
import finalProject.mapper.IpgoMapper;

@Service
public class IpgoViewService {
	@Autowired
	IpgoMapper ipgoMapper;

	public void ipgoView(String ipgoNo, Model model) {
		// TODO Auto-generated method stub
		
		IpgoDTO ipdto = ipgoMapper.ipgoList(ipgoNo).get(0);
		model.addAttribute("ipdto",ipdto);

	}

}

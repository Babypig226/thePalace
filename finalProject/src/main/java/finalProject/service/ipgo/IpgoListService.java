package finalProject.service.ipgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.IpgoDTO;
import finalProject.mapper.IpgoMapper;

@Service
public class IpgoListService {
    @Autowired
    IpgoMapper ipgoMapper;
    
	public void ipgoList(Model model) {
		// TODO Auto-generated method stub
		List<IpgoDTO> iplists = ipgoMapper.ipgoList(null);
		model.addAttribute("iplists", iplists);
		
	}

}

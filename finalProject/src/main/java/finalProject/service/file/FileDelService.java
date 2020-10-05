package finalProject.service.file;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.ImageName;

@Component
@Service
public class FileDelService {

	public void fileSessionAdd(ImageName imageName, HttpSession session, Model model) {
		List<ImageName> list = (List<ImageName>)session.getAttribute("imglist");
		if(list == null) {
			list = new ArrayList<ImageName>();
		}
		
		int num = 0;
		
		Boolean newImg = true;
		for (int i = 0; i < list.size(); i++) {
			ImageName in = list.get(i);
			if(in.getProgramImage().equals(imageName.getProgramImage())) {
				list.remove(i);
				newImg = false;
				num = 0;
			}
		}
		
		if(newImg) {
			list.add(imageName);
			num = 1;
		}
		
		model.addAttribute("val", num);
		session.setAttribute("imgList", list);
		
	}

}

package finalProject.service.program;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.ImageName;
import finalProject.Option;
import finalProject.domain.ProgramDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramMapper;

@Component
@Service
public class ProgramDetailService {
	@Autowired
	ProgramMapper programMapper;

	public void programDetail(String programNo, HttpSession session, Model model) throws Exception{
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, "1111", programNo);
		
		ProgramDTO prodto = programMapper.getProgramList(startEndPageDTO).get(0);
		String [] img = prodto.getProgramImage().split("`");
		String [] options = prodto.getPOption().split("`");
		
		ArrayList<String> list = new ArrayList<String>();
		String op = null;
		for(int i = 0; i < options.length; i++) {
			op = options[i];
			System.out.println(op);
			list.add(op);
			System.out.println(list);
			model.addAttribute("list", list);
		}
		
		/*
		List<Option> oplist = new ArrayList<Option>();
		int i = 0;
		for (String pop : options) {
			System.out.println("optionlist "+ pop);
			Option option = new Option(pop);
			oplist.add(option);
			i++;
		}
		model.addAttribute("oplist", oplist);
		*/
		List<ImageName> imglist = new ArrayList<ImageName>();
		int j = 0;
		for (String file : img) {
			System.out.println("imgfile "+ file);
			ImageName imageName = new ImageName(file);
			imglist.add(imageName);
			j++;
		}
		model.addAttribute("imglist", imglist);
		//model.addAttribute("option", op);
		//model.addAttribute("image", img[0]);
		model.addAttribute("prodto", prodto);	
	}

}

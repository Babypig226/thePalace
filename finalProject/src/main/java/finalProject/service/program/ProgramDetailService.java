package finalProject.service.program;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.Option;
import finalProject.command.FileName;
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
			model.addAttribute("checkOp", list);
		}
		System.out.println(prodto.getProgramName());
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
		
		List<FileName> filelist = new ArrayList<FileName>();
		int j = 0;
		for (String file : img) {
			System.out.println("imgfile "+ file);
			FileName imageName = new FileName(file, null, null);
			filelist.add(imageName);
			j++;
		}
		
		ArrayList<Integer> countlist = new ArrayList<Integer>();
		int count = 0;
		for (count = 1; count <= prodto.getMaxCount(); count++) {
			System.out.println(count);
			countlist.add(count);
			System.out.println(countlist);
			model.addAttribute("amount", countlist);
		}
		model.addAttribute("imglist", filelist);
		//model.addAttribute("option", op);
		//model.addAttribute("image", img[0]);
		model.addAttribute("prodto", prodto);	
	}

}

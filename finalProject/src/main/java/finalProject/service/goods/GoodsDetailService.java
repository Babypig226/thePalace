package finalProject.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.GoodsDTO;
import finalProject.mapper.GoodsMapper;

@Service
public class GoodsDetailService {

	@Autowired
	GoodsMapper goodsMapper;
	
	public void gdDetail(String goodsNo, Model model){
		// TODO Auto-generated method stub
		GoodsDTO gdto = goodsMapper.gdList(goodsNo).get(0);
		model.addAttribute("gdto", gdto);
		//조회수
		
		goodsMapper.updateReadCount(goodsNo);
		
	}

}

package finalProject.service.productlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.GoodsDTO;
import finalProject.mapper.GoodsMapper;

@Service
public class InteriorSuppliesServce {
	@Autowired
	GoodsMapper goodsMapper;

	public void inteList(Model model) {
		// TODO Auto-generated method stub
		List<GoodsDTO> glists = goodsMapper.interiorsupplies();

		model.addAttribute("glists", glists);

	}

}

package finalProject.service.productlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.GoodsDTO;
import finalProject.mapper.GoodsMapper;

@Component
@Service
public class PenService {

	@Autowired
	GoodsMapper goodsMapper;
	public void penList(Model model) {
		// TODO Auto-generated method stub
		List<GoodsDTO> glists = goodsMapper.pen();
		model.addAttribute("glists", glists);
	}

}

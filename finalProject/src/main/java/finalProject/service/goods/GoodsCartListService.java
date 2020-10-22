package finalProject.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.PdCartDTO;
import finalProject.mapper.GoodsCartMapper;

@Service
public class GoodsCartListService {
    @Autowired
    GoodsCartMapper goodsCartMapper;
    
	public void pdcartList(Model model) {
		// TODO Auto-generated method stub
		List<PdCartDTO> pdcartlists = goodsCartMapper.pdcartList();
		model.addAttribute("pdcartlists",pdcartlists);
	}
	
	

}

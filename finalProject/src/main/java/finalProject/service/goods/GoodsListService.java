package finalProject.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import finalProject.domain.GoodsDTO;
import finalProject.mapper.GoodsMapper;

@Service
public class GoodsListService {
  @Autowired
  GoodsMapper goodsMapper;
  
	public void gdList(Model model) {
		// TODO Auto-generated method stub
//		int limit = 10;
//		int limitPage = 10;
//		
//		Long startRow = ((long)page -1 ) * 10 +1;
//		Long endRow = startRow + limit -1;
//		
//		StartEndPageDTO dto = 
//				new StartEndPageDTO(startRow, endRow, null, null);
		
	  List<GoodsDTO> glists = goodsMapper.gdList(null);
	  model.addAttribute("glists", glists);
	  
//	  PageAction pageAction = new PageAction();
//	  pageAction.page(model, count, limit, limitPage, page, "library?");
		
	}

}

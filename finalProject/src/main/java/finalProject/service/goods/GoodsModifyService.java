package finalProject.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.command.GoodsCommand;
import finalProject.domain.GoodsDTO;
import finalProject.mapper.GoodsMapper;

@Service
public class GoodsModifyService {
	
	@Autowired
	GoodsMapper goodsMapper;

	public void gdModifyPro(GoodsCommand goodsCommand) {
		// TODO Auto-generated method stub
		
		GoodsDTO gdto = new GoodsDTO();
		gdto.setGoodsType(goodsCommand.getGoodsType());
		gdto.setGoodsCategory(goodsCommand.getGoodsCategory());
		gdto.setGoodsPrice(goodsCommand.getGoodsPrice());
		gdto.setGoodsContent(goodsCommand.getGoodsContent());
		gdto.setGoodsQty(goodsCommand.getGoodsQty());
		gdto.setGoodsNo(goodsCommand.getGoodsNo());
		
		goodsMapper.gdModify(gdto);
		
		
		
	}

}

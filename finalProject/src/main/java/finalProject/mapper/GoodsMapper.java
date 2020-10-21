package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.GoodsDTO;
import finalProject.domain.PdCartDTO;

@Component
@Repository("finalProject.mapper.GoodsMapper")
public interface GoodsMapper {
	public void gdInsert(GoodsDTO gdto);
	public List<GoodsDTO> gdList(String goodsNo);
	public List<GoodsDTO> gdpopular();
	public void gdModify(GoodsDTO gdto);
	public void gdDel(String goodsNo);
	public void updateReadCount(String goodsNo);
	//------------------------------------상품등록
	public List<GoodsDTO> officesupplies();
	public List<GoodsDTO> kitchenware();
	public List<GoodsDTO> interiorsupplies();
	public List<GoodsDTO> dailysupplies();
	//------------------------------------카테고리
	public List<GoodsDTO> card();
	public List<GoodsDTO> note();
	public List<GoodsDTO> pen();
	//------------------------------------ office
	public List<GoodsDTO> dish();
	public List<GoodsDTO> cup();
	public List<GoodsDTO> spoon();
	//------------------------------------ kitchenware
	public List<GoodsDTO> frame();
	public List<GoodsDTO> lighting();
	//------------------------------------ interior
	public List<GoodsDTO> mirror();
	public List<GoodsDTO> box();
	//------------------------------------ daily
	
	
	
	
	
}

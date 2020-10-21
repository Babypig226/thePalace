package finalProject.service.goods;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import finalProject.command.GoodsCommand;
import finalProject.domain.GoodsDTO;
import finalProject.mapper.GoodsMapper;

@Service
public class GoodsService {
	@Autowired
	GoodsMapper goodsMapper;

	public void gdWritePro(GoodsCommand goodsCommand, HttpSession session){
		// TODO Auto-generated method stub
		//session 가져오는 이유 경로 찾을려고
		
		GoodsDTO gdto = new GoodsDTO();
		gdto.setGoodsCategory(goodsCommand.getGoodsCategory());
		gdto.setGoodsContent(goodsCommand.getGoodsContent());
		gdto.setGoodsName(goodsCommand.getGoodsName());
		gdto.setGoodsNo(goodsCommand.getGoodsNo());
		gdto.setGoodsPrice(goodsCommand.getGoodsPrice());
		gdto.setGoodsQty(goodsCommand.getGoodsQty());
		gdto.setGoodsType(goodsCommand.getGoodsType());
		//null이 아니라면 조건 
		//if(goodsCommand.getGoodsImage() != null){}		
		try {
			String PATH  = "/static/goods/upload";
			//위에 경로 가져오는거
			//String filePath = session.getServletContext().getRealPath(PATH);
			String filePath = "C:/Users/연다인/workspace24/test5/src/main/resources"+PATH;
			MultipartFile mf = goodsCommand.getGoodsImage();
			String original = mf.getOriginalFilename();
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "") + originalFileExtension;
			gdto.setGoodsImage(store);
			//파일 저장하기 위해서 파일 객체 생성
			File file = new File(filePath + "/" + store);
			//파일저장
			mf.transferTo(file);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			goodsMapper.gdInsert(gdto);
		}
	}

}

package finalProject.service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.GoodsDTO;
import finalProject.domain.PdCartDTO;
import finalProject.mapper.GoodsCartMapper;
import finalProject.mapper.GoodsMapper;

@Service
public class GoodsCartService {
  @Autowired
  GoodsMapper goodsMapper;// 여기 이 메퍼는 상품list정보를 불러오기 위한 메퍼
  @Autowired
  GoodsCartMapper goodsCartMapper; // 장바구니 관련 메퍼
  
	public void pdcartadd(String goodsNo, Model model,HttpSession session) {
		System.out.println("goodscartservice");
		
		// 상품정보를 끌어와야함
		GoodsDTO gdto = goodsMapper.gdList(goodsNo).get(0);
		// 상품정보를 cartdto에 담아야지
		PdCartDTO cartdto = new PdCartDTO();
		cartdto.setGoodsNo(gdto.getGoodsNo());
		System.out.println(cartdto.getGoodsNo());
		cartdto.setUserId("2222"); // 이런식으로 장바구니에 상품정보를 담아야지용 아항
		System.out.println(cartdto.getUserId());
		// 이제 mapper에 니가 장바구니에 담음 값들을 insert해줘야 하지 않을까여??아하
		
		goodsCartMapper.gdcartInsert(cartdto); // 정답~~
	}

}

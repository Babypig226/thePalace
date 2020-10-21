package finalProject.controller.pdmain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import finalProject.service.goods.GoodsListService;
import finalProject.service.productlist.GoodspopularListService;

@Controller
public class PdMainController {
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodspopularListService goodspopularListService; //service.productlist에 있음 
	

	@RequestMapping("product") //souvenior shop 메인 페이지 및 상품리스트 띄우기 
	public String product(Model model) {
		goodsListService.gdList(model);
		return "thymeleaf/productMain";
	}
	
	@RequestMapping("Mypage") //sovenior shop 마이페이지 가기
	public String mypage() {
		return "thymeleaf/Mypage";
	}
	
	@RequestMapping("pdAdmin") //관리자 마이페이지 가기
	public String pdAdmin() {
		return "thymeleaf/pdAdminMypage";
	}
	
	@RequestMapping("Information_guide") //이용안내
		public String infor() {
		return "thymeleaf/support/Information_guide";
	}
	
	@RequestMapping("Support") //고객센터
	public String support() {
		return "thymeleaf/support/Support";
	}
	
	@RequestMapping("Way_to_Come") //오시는길
	public String waytocome() {
		return"thymeleaf/support/Way_to_Come";
	}
	
	@RequestMapping("productnew") //신상품
	public String productnew(Model model) {
		goodsListService.gdList(model);
		return "thymeleaf/productnew";
	}
	
	@RequestMapping("productpopular") //인기상품
	public String productpopular(Model model) {
		goodspopularListService.popular(model);
		return "thymeleaf/productpopular";
	}
	
	@RequestMapping("coupon")
	public String coupon() {
		return "thymeleaf/coupon";
	}
	 
}

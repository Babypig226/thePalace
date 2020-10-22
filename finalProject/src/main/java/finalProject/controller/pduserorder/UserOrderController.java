package finalProject.controller.pduserorder;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.DeliveryCommand;
import finalProject.command.PaymentCommand;
import finalProject.service.delivery.DeliveryDetailService;
import finalProject.service.delivery.DeliveryListService;
import finalProject.service.delivery.DeliveryService;
import finalProject.service.goods.GoodsDetailService;
import finalProject.service.goods.GoodsListService;
import finalProject.service.goods.WishService;
import finalProject.service.payment.PaymentService;

@Controller
@RequestMapping("userorder")
public class UserOrderController {
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	DeliveryService deliveryService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	DeliveryDetailService deliveryDetailService;
	@Autowired
	DeliveryListService deliveryListService;
	@Autowired
	WishService wishService;
	
	
	@ModelAttribute
	DeliveryCommand setDeliveryCommand() {
		return new DeliveryCommand();
	}
	@ModelAttribute
	PaymentCommand setPaymentCommand() {
		return new PaymentCommand();
	}
	
	@RequestMapping("wishList")
	public String wishList(@RequestParam(value = "goodsNo")String goodsNo, Model model, HttpSession session) {
		wishService.wishadd(goodsNo,model,session);
		return "thymeleaf/userorder/wishok";
	}
	
	@RequestMapping("wishListPro")
	public String wishListPro(Model model) {
		wishService.wishList(model);
		return "thymeleaf/userorder/wishList";
	}
	
	@RequestMapping(value = "orderForm", method  = RequestMethod.GET) //배송지정보 창 띄우기
	public String orderForm(Model model) {
		goodsListService.gdList(model);
		return "thymeleaf/userorder/orderdelibery";
		
	}
	
	@RequestMapping(value = "orderdeliberyPro", method = RequestMethod.POST) //배송지 정보 등록
	public String orderdeliberyPro(DeliveryCommand deliveryCommand) {
		deliveryService.orderdeliberyPro(deliveryCommand);
		return "thymeleaf/userorder/PaymentForm";
		
	}
	
	@RequestMapping(value = "orderPaymentPro", method = RequestMethod.POST)  //결제수단 등록
	public String orderpaymentPro(PaymentCommand paymentCommand) {
		paymentService.orderpaymentPro(paymentCommand);
		return "thymeleaf/userorder/orderquestion";
	}
	
	@RequestMapping("deliveryList") //배송조회
	public String deliveryList(Model model) {
		deliveryListService.deliveryList(model);
		return "thymeleaf/userorder/deliveryList";
	}
	
	@RequestMapping("deliveryDetail") //배송디테일
	public String deliveryDetail(@RequestParam (value = "deliveryNo")String deliveryNo,Model model) {
		deliveryDetailService.deliveryDetail(deliveryNo,model);
		return "thymeleaf/userorder/orderPayment";
	}
	
	
//	@RequestMapping(value = "deliveryOk")
//	public String deliveryDetail(@RequestParam (value = "deliveryNo")String deliveryNo,Model model ) {
//		deliveryDetailService.deliveryOk(deliveryNo,model);
//		return "thymeleaf/userorder/orderPayment";
//	}
//	
	
	/*@RequestMapping("paymentForm")
	public String paymentForm(Model model) {
		goodsListService.gdList(model);
		return "thymeleaf/userorder/paymentForm";
	} */
	

}

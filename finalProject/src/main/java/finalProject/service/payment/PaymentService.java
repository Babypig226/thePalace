package finalProject.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.command.PaymentCommand;
import finalProject.domain.PaymentDTO;
import finalProject.mapper.PaymentMapper;

@Service
public class PaymentService {
   @Autowired
   PaymentMapper paymentMapper;
	public void orderpaymentPro(PaymentCommand paymentCommand) {
		// TODO Auto-generated method stub
		PaymentDTO pydto = new PaymentDTO();
		pydto.setCouponNo(paymentCommand.getCouponNo());
		pydto.setPayOption(paymentCommand.getPayOption());
		
		paymentMapper.paymentInsert(pydto);
		
		
		
		
	}

}

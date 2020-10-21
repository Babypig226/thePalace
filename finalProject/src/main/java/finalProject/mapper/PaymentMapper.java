package finalProject.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.PaymentDTO;

@Component
@Repository("finalProject.mapper.PaymentMapper")
public interface PaymentMapper {
	
	public void paymentInsert(PaymentDTO pydto);
	

}

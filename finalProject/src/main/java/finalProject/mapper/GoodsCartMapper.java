package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.PdCartDTO;
import finalProject.domain.PdWishDTO;

@Component
@Repository("finalProject.mapper.GoodsCartMapper")
public interface GoodsCartMapper {
	public void gdcartInsert(PdCartDTO cartdto); 
	public void gdwishInsert(PdWishDTO wsdto);
	public List<PdCartDTO>pdcartList();
	public List<PdWishDTO>pdwishList();
}

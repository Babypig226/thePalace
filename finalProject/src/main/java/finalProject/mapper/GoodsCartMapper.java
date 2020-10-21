package finalProject.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.PdCartDTO;

@Component
@Repository("finalProject.mapper.GoodsCartMapper")
public interface GoodsCartMapper {
	public void gdcartInsert(PdCartDTO cartdto);//  그 다음은??

}

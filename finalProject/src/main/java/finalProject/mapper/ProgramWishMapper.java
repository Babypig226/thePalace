package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.PrWishDTO;

@Component
@Repository(value = "finalProject.mapper.ProgramWishMapper")
public interface ProgramWishMapper {

	public Integer wishInsert(PrWishDTO wishdto) throws Exception;
	public List<PrWishDTO> getwishlist() throws Exception;

}

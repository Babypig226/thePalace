package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.CartDTO;
import finalProject.domain.PgbasketDTO;
import finalProject.domain.StartEndPageDTO;

@Component
@Repository(value = "finalProject.mapper.ProgramBasketMapper")
public interface ProgramBasketMapper {
	//public void cartInsert(StartEndPageDTO startEndPageDTO) throws Exception;
	public List<PgbasketDTO> pgbasketlist() throws Exception;
	public void cartUpdate() throws Exception;
	public Integer cartInsert(PgbasketDTO pgdto) throws Exception;
}

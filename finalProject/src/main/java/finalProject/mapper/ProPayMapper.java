package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.ProPayDTO;

@Component
@Repository(value = "finalProject.mapper.ProPayMapper")
public interface ProPayMapper {

	public Integer payInfoInsert(ProPayDTO ppdto) throws Exception;
	public List<ProPayDTO> payInfolist() throws Exception;

}

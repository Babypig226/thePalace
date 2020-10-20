package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.ProResDTO;

@Component
@Repository(value = "finalProject.mapper.ProResMapper")
public interface ProResMapper {

	public Integer resInfoInsert(ProResDTO prdto) throws Exception;
	public List<ProResDTO> resInfoList() throws Exception;

}

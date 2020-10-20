package finalProject.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.ProPayResDTO;

@Component
@Repository(value = "finalProject.mapper.ProPayResMapper")
public interface ProPayResMapper {

	public void payresInsert(ProPayResDTO pprdto) throws Exception;

}

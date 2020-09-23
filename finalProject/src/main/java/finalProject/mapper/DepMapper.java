package finalProject.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.DepDTO;

@Component
@Repository("finalProject.mapper.DepMapper")
public interface DepMapper {

	public void depInsert(DepDTO dto);

}

package finalProject.mapper.house.fixtures;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.house.FixturesDTO;

@Component
@Repository("finalProject.mapper.house.fixtures.FixturesMapper")
public interface FixturesMapper {

	public void fixturesInsert(FixturesDTO fixturesDTO) throws Exception;

	public List<FixturesDTO> getFixturesList() throws Exception;

	public FixturesDTO getFixturesView(String equipNo) throws Exception;

	public void fixturesUpdate(FixturesDTO dto) throws Exception;

	public void fixturesDelete(String equipNo) throws Exception;

}

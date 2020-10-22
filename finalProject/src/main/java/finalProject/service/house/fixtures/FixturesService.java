package finalProject.service.house.fixtures;




import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.house.fixtures.FixturesCommand;
import finalProject.domain.house.FixturesDTO;
import finalProject.mapper.house.fixtures.FixturesMapper;

@Component
@Service
public class FixturesService {
	
	@Autowired
	FixturesMapper fixturesMapper;
	
	public void fixturesInsertPro(FixturesCommand fixturesCommand) throws Exception {
		
		FixturesDTO fixturesDTO = new FixturesDTO();
		System.out.println("sjbfsbvsvbsv" + fixturesCommand.getEOrderDate());
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		
		
		

		date = dt.parse(fixturesCommand.getEOrderDate());
		
		Timestamp eOrderDate = new Timestamp(date.getTime());
		
		
		fixturesDTO.setEquipNo(fixturesCommand.getEquipNo());
		fixturesDTO.setRoomNo(fixturesCommand.getRoomNo());
		fixturesDTO.setEquipName(fixturesCommand.getEquipName());
		fixturesDTO.setEquipQty(fixturesCommand.getEquipQty());
		fixturesDTO.setEOrderDate(eOrderDate);
		fixturesDTO.setEOrderQry(fixturesCommand.getEOrderQry());
		
		fixturesMapper.fixturesInsert(fixturesDTO);
	}
	
}

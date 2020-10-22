package finalProject.service.house.fixtures;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import finalProject.command.house.fixtures.FixturesCommand;
import finalProject.domain.house.FixturesDTO;
import finalProject.mapper.house.fixtures.FixturesMapper;

@Component
@Service
@Transactional
public class FixturesModifyService {

	@Autowired
	FixturesMapper fixturesMapper;
	
	public void fixturesModify(FixturesCommand fixturesCommand, Model model) throws Exception{
		

		FixturesDTO dto = new FixturesDTO();
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;

		date = dt.parse(fixturesCommand.getEOrderDate());
		
		Timestamp eOrderDate = new Timestamp(date.getTime());
		
	
		dto.setEquipNo(fixturesCommand.getEquipNo());
		dto.setRoomNo(fixturesCommand.getRoomNo());
			System.out.println(2 + fixturesCommand.getRoomNo());
		dto.setEquipName(fixturesCommand.getEquipName());
			System.out.println(3 + fixturesCommand.getEquipName());
		dto.setEquipQty(fixturesCommand.getEquipQty());
			System.out.println("모야야 " + fixturesCommand.getEquipQty());
		dto.setEOrderDate(eOrderDate);
			System.out.println("날짜 " + date.getTime());
		dto.setEOrderQry(fixturesCommand.getEOrderQry());
			System.out.println("6번 " + fixturesCommand.getEOrderQry());
		
			fixturesMapper.fixturesUpdate(dto);
		
		
	}

}

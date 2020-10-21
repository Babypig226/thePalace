package finalProject.service.ipgo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.IpgoCommand;
import finalProject.domain.IpgoDTO;
import finalProject.mapper.IpgoMapper;

@Service
public class IpgoModifyService {
	@Autowired
	IpgoMapper ipgoMapper;

	public void ipgomodifyPro(IpgoCommand ipgoCommand) {
		// TODO Auto-generated method stub
		
		IpgoDTO ipdto = new IpgoDTO();
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String modifiedDate = fm.format(ipgoCommand.getCheckDate());
		Timestamp checkDate = Timestamp.valueOf(modifiedDate);
		ipdto.setCheckDate(checkDate);
		ipdto.setGoodsNo(ipgoCommand.getGoodsNo());
		ipdto.setIpgoQty(ipgoCommand.getIpgoQty());
		ipdto.setIpgoNo(ipgoCommand.getIpgoNo());
		
		ipgoMapper.ipgoUpdate(ipdto);
		
		
	}

}

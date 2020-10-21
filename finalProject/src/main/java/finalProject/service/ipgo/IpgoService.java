package finalProject.service.ipgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import finalProject.command.IpgoCommand;
import finalProject.domain.IpgoDTO;
import finalProject.mapper.IpgoMapper;

@Service
public class IpgoService {
   @Autowired
   IpgoMapper ipgoMapper;
	public void ipgoFormPro(IpgoCommand ipgoCommand) {
		// TODO Auto-generated method stub
		IpgoDTO ipdto = new IpgoDTO();
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String modifiedDate = fm.format(ipgoCommand.getCheckDate());
		Timestamp checkDate = Timestamp.valueOf(modifiedDate);
		ipdto.setCheckDate(checkDate);
		ipdto.setCheckOk(ipgoCommand.getCheckOk());
		ipdto.setGoodsNo(ipgoCommand.getGoodsNo());
		ipdto.setIpgoNo(ipgoCommand.getIpgoNo());
		ipdto.setIpgoQty(ipgoCommand.getIpgoQty());
		ipdto.setShopNo(ipgoCommand.getShopNo());
		
		ipgoMapper.ipgoInsert(ipdto);
		
		
	}

}

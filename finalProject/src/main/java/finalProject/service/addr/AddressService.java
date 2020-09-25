package finalProject.service.addr;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.domain.AddressDTO;

@Component
@Service
public class AddressService {
	public String rebuildAddress(String fullAddress) {
		String reAddr = "";
		String[] fullAddr = fullAddress.split("`");
		for (String string : fullAddr) {
			if (string.equals("/")) {
				string="";
			}
			reAddr += string+" ";
		}
		return reAddr;
	}
	
	public AddressDTO devideAddress(String fullAddress) {
		String[] fullAddr = fullAddress.split("`");
		AddressDTO addr = new AddressDTO();
		addr.setPostcode(fullAddr[0]);
		addr.setRoadAddress(fullAddr[1]);
		addr.setDetailAddress(fullAddr[2]);
		if(fullAddr[3].equals("/")) {
			addr.setExtraAddress("");
		}else {
			addr.setExtraAddress(fullAddr[3]);
		}
		return addr;
	}
	
	public String updateAddress(String[] addrSet) {
		String addr = "";
		for (int i = 0; i < addrSet.length; i++) {
			if(addrSet[i].equals("")) {
				addr += "/";
			}
			addr += addrSet[i]+"`";
		}
		return addr;
	} 

}

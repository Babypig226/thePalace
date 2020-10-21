package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.IpgoDTO;

@Component
@Repository("finalProject.mapper.IpgoMapper")
public interface IpgoMapper {
	public void ipgoInsert(IpgoDTO ipdto);
	public List<IpgoDTO> ipgoList(String ipgoNo);
    public void ipgoUpdate(IpgoDTO ipdto);
    public void ipgoDel(String ipgoNo);	

}

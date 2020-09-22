package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.MemberDTO;

@Component
@Repository(value = "finalProject.mapper")
public interface MemberMapper {
	public Integer insertMember(MemberDTO dto) throws Exception;
	public List<MemberDTO> selectByMember(MemberDTO member) throws Exception;
	public Integer joinOkUpdate(MemberDTO memberDTO) ;
}

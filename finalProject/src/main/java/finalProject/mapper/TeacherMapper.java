package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TeacherDTO;

@Repository("finalProject.mapper.TeacherMapper")
public interface TeacherMapper {
	public void registTeacher(TeacherDTO dto);
	public List<TeacherDTO> getTeacherList(StartEndPageDTO dto);
	public void updateTeacher(TeacherDTO dto);
	public void deleteTeacher(String teacherNo);
}

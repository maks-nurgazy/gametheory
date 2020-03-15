package diplom.gametheory.project.service;

import java.util.List;

import diplom.gametheory.project.entity.Course;

public interface CourseService {

	public List<Course> findAll();
	
	public Course findById(int theId);
	
	public void save(Course theEmployee);
	
	public void deleteById(int theId);
	
}

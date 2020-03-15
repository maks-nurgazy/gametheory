package diplom.gametheory.project.service;

import java.util.List;
import java.util.Optional;

import diplom.gametheory.project.entity.Course;
import diplom.gametheory.project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository thecourseRepository) {
		courseRepository = thecourseRepository;
	}
	
	@Override
	public List<Course> findAll() {
		return courseRepository.findAllByOrderByTopicAsc();
	}

	@Override
	public Course findById(int theId) {
		Optional<Course> result = courseRepository.findById(theId);
		
		Course theCourse = null;
		
		if (result.isPresent()) {
			theCourse = result.get();
		}
		else {
			// we didn't find the Course
			throw new RuntimeException("Did not find Course id - " + theId);
		}
		
		return theCourse;
	}

	@Override
	public void save(Course theCourse) {
		courseRepository.save(theCourse);
	}

	@Override
	public void deleteById(int theId) {
		courseRepository.deleteById(theId);
	}

}







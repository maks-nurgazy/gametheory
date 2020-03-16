package diplom.gametheory.project.service;

import diplom.gametheory.project.entity.Course;
import diplom.gametheory.project.entity.Quiz;
import diplom.gametheory.project.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuizServiceImpl implements QuizService {

	private QuizRepository quizRepository;
	private CourseService courseService;

	@Autowired
	public QuizServiceImpl(QuizRepository thequizRepository,CourseService courseService) {
		quizRepository = thequizRepository;
		this.courseService = courseService;
	}
	
	@Override
	public List<Quiz> findAll() {
		return quizRepository.findAll();
	}

	@Override
	public Quiz findById(int theId) {
		Optional<Quiz> result = quizRepository.findById(theId);
		
		Quiz theQuiz = null;
		
		if (result.isPresent()) {
			theQuiz = result.get();
		}
		else {
			// we didn't find the Quiz
			throw new RuntimeException("Did not find Quiz id - " + theId);
		}
		
		return theQuiz;
	}

	@Override
	public void save(int id, Quiz theQuiz) {
		Course course = courseService.findById(id);
		theQuiz.setCourse(course);
		course.addQuiz(theQuiz);
		quizRepository.save(theQuiz);
	}

	@Override
	public void deleteById(int theId) {
		quizRepository.deleteById(theId);
	}

}







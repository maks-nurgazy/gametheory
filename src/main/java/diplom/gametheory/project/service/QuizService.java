package diplom.gametheory.project.service;

import diplom.gametheory.project.entity.Course;
import diplom.gametheory.project.entity.Quiz;

import java.util.List;

public interface QuizService {

	public List<Quiz> findAll();
	
	public Quiz findById(int theId);
	
	public void save(int id,Quiz theQuiz);
	
	public void deleteById(int theId);
	
}

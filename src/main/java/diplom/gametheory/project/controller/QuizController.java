package diplom.gametheory.project.controller;

import diplom.gametheory.project.entity.Course;
import diplom.gametheory.project.entity.Quiz;
import diplom.gametheory.project.service.CourseService;
import diplom.gametheory.project.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/quizzes")
public class QuizController {

	private QuizService quizService;
	private CourseService courseService;
	private int id;

	public QuizController(QuizService theQuizService,CourseService courseService) {
		quizService = theQuizService;
		this.courseService = courseService;
	}

	@GetMapping("/list/{id}")
	public String listQuizzes(@PathVariable Integer id, Model theModel) {

		this.id = id;

		// get employees from db
		List<Quiz> theQuizzes = courseService.findById(this.id).getQuizzes();
		
		// add to the spring model
		theModel.addAttribute("quizzes", theQuizzes);
		
		return "list-quizzes";
	}


	@GetMapping("/list")
	public String listQuizzes(Model theModel) {

		// get employees from db
		List<Quiz> theQuizzes = courseService.findById(this.id).getQuizzes();

		// add to the spring model
		theModel.addAttribute("quizzes", theQuizzes);

		return "list-quizzes";
	}

	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Quiz theQuiz = new Quiz();
		
		theModel.addAttribute("quiz", theQuiz);
		
		return "quiz-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("quizId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Quiz theQuiz = quizService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("quiz", theQuiz);
		
		// send over to our form
		return "quiz-form";
	}
	
	
	@PostMapping("/save")
	public String saveQuiz(@ModelAttribute("quiz") Quiz theQuiz) {
		
		// save the employee
		quizService.save(this.id,theQuiz);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/quizzes/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("quizId") int theId) {
		
		// delete the employee
		quizService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/quizzes/list";
		
	}
}



















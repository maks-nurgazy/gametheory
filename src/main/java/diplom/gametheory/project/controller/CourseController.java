package diplom.gametheory.project.controller;

import java.util.List;

import diplom.gametheory.project.entity.Course;
import diplom.gametheory.project.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/courses")
public class CourseController {

	private CourseService courseService;
	
	public CourseController(CourseService theCourseService) {
		courseService = theCourseService;
	}


	@GetMapping("/list")
	public String listCourses(Model theModel) {
		
		// get employees from db
		List<Course> theCourses = courseService.findAll();
		
		// add to the spring model
		theModel.addAttribute("courses", theCourses);
		
		return "list-courses";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Course theCourse = new Course();
		
		theModel.addAttribute("course", theCourse);
		
		return "course-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Course theCourse = courseService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("course", theCourse);
		
		// send over to our form
		return "course-form";
	}
	
	
	@PostMapping("/save")
	public String saveCourse(@ModelAttribute("course") Course theCourse) {
		
		// save the employee
		courseService.save(theCourse);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/courses/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("courseId") int theId) {
		
		// delete the employee
		courseService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/courses/list";
		
	}
}



















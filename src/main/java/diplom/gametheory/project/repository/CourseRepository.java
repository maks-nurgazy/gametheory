package diplom.gametheory.project.repository;

import diplom.gametheory.project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findAllByOrderByTopicAsc();

}

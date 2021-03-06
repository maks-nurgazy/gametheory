package diplom.gametheory.project.repository;

import diplom.gametheory.project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findAllByOrderByTopicAsc();

}

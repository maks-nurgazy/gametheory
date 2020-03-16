package diplom.gametheory.project.repository;

import diplom.gametheory.project.entity.Course;
import diplom.gametheory.project.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {

}

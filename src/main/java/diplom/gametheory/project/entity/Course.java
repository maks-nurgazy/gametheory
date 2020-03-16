package diplom.gametheory.project.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String topic;
    private String book;
    private String link;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Quiz> quizzes;

    public void addQuiz(Quiz quiz){
        if(quizzes==null){
            quizzes = new ArrayList<>();
        }
        quizzes.add(quiz);
        quiz.setCourse(this);
    }

}

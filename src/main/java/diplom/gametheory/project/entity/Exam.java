package diplom.gametheory.project.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    private String question;

    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


}


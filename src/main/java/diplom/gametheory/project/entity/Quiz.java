package diplom.gametheory.project.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String question;

    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

    @ManyToOne(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "course_id")
    private Course course;


}


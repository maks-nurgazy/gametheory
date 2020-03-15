package diplom.gametheory.project.entity;

import lombok.Data;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "course")
    private List<Exam> exams;

}

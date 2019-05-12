package lesson3_hw;

import lesson2.entites.Student;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class CourseHibernate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentHibernate> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        String allStudent = "";
        for (StudentHibernate o : students) {
            allStudent += o.getTitle() + ", ";
        }
        return "Course name: " + title + "; have student: " + allStudent;
    }
}

package lesson3_hw;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentHibernate {

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
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<CourseHibernate> courses;

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
        String allCourse = "";
        for (CourseHibernate o : courses) {
            allCourse += o.getTitle() + ", ";
        }
        return "Student name: " + title + " ; have courses: " + allCourse;
    }
}

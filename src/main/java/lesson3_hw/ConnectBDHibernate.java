package lesson3_hw;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ConnectBDHibernate {

    private SessionFactory factory;
    private Session session = null;

    public ConnectBDHibernate() {
        factory = new Configuration()
                .configure("/lesson3_hw/hibernate.cfg.xml")
                .addAnnotatedClass(StudentHibernate.class)
                .addAnnotatedClass(CourseHibernate.class)
                .buildSessionFactory();
    }

    public void getStudent(int studentId) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        StudentHibernate student = session.get(StudentHibernate.class, studentId);
        System.out.println(student);
        session.getTransaction().commit();
    }

    public void getCourse(int courseId){
        session = factory.getCurrentSession();
        session.beginTransaction();
        CourseHibernate course = session.get(CourseHibernate.class, courseId);
        System.out.println(course);
        session.getTransaction().commit();
    }

    public void getAllStudent() {
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<StudentHibernate> allStudent = session.createQuery("from StudentHibernate").getResultList();
        System.out.println(allStudent);
        session.getTransaction().commit();
    }

    public void deleteStudentInTable(int num) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        StudentHibernate student = session.get(StudentHibernate.class, num);
        session.delete(student);
        session.getTransaction().commit();
    }

    public void deleteCourseInTable(int num) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        CourseHibernate course = session.get(CourseHibernate.class, num);
        session.delete(course);
        session.getTransaction().commit();
    }

}

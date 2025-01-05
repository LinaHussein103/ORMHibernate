package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class StudentDAO {
    private SessionFactory factory;

    public StudentDAO() {
       factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    public void addStudent(String name, int age) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Student student = new Student();
            student.setName(name);
            student.setAge(age);
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Student added successfully");
        } finally {
            session.close();
        }
    }

    public List<Student> getStudents() {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").getResultList();
            session.getTransaction().commit();
            return students;
        } finally {
            session.close();
        }
    }

    public void updateStudent(int id, String name, int age) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                student.setName(name);
                student.setAge(age);
                session.update(student);
            }
            session.getTransaction().commit();
            System.out.println("Student updated successfully");
        } finally {
            session.close();
        }
    }

    public void deleteStudent(int id) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
            }
            session.getTransaction().commit();
            System.out.println("Student deleted successfully");
        } finally {
            session.close();
        }
    }

}

package cb8.individualproject;

import java.util.ArrayList;

public class StudentsPerCourse {

    private ArrayList <Student> students;
    private Course course;

    @Override
    public String toString() {
        return "\nStudentsPerCourse{" + "students=" + students + "\ncourse=" + course.getTitle() + '}';
    }
       
    public StudentsPerCourse() {
    }

    public StudentsPerCourse(ArrayList<Student> students, Course course) {
        this.students = students;
        this.course = course;
    }


    public ArrayList<Student> getStudents() {
        if(students==null){
            students = new ArrayList();
        }
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
}

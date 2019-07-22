package cb8.individualproject;

import java.util.ArrayList;

public class StudentsToManyCourses {

    private ArrayList <Student> students;
    private ArrayList <Course>  course;

    @Override
    public String toString() {
        return "\nStudentsPerCourse{" + "students=" + students + "\ncourse=" + course + '}';
    }
       
    public StudentsToManyCourses() {
    }

    public StudentsToManyCourses(ArrayList<Student> students,ArrayList<Course> course) {
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

    public ArrayList<Course> getCourse() {
        if (course == null){
            course = new ArrayList();
        }
        return course;
    }

    public void setCourse(ArrayList<Course> course) {
        this.course = course;
    }
    
}

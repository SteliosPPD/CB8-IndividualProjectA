package cb8.individualproject;

import java.util.ArrayList;

public class AssignmentsPerCourse {

    private ArrayList <Assignment> assignments;
    private Course course;

    @Override
    public String toString() {
        return "\nAssignmentsPerCourse{" + "assignments=" + assignments + "\ncourse=" + course.getTitle() + '}';
    }
       
    public AssignmentsPerCourse() {
    }

    public AssignmentsPerCourse(ArrayList<Assignment> assignments, Course course) {
        this.assignments = assignments;
        this.course = course;
    }

    public ArrayList<Assignment> getAssignments() {
        if(assignments==null){
            assignments = new ArrayList();
        }
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }   
    
}

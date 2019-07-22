package cb8.individualproject;

import java.util.ArrayList;

public class AssignmentsPerStudent {

    private ArrayList <Assignment> assignments;
    private Student student;

    @Override
    public String toString() {
        return "\nAssignmentsPerStudent{" + "assignments=" + assignments + "\nstudent=" + student.getFirstName() + " " + student.getLastName() + '}';
    }
       
    public AssignmentsPerStudent() {
    }

    public AssignmentsPerStudent(ArrayList<Assignment> assignments, Student student) {
        this.assignments = assignments;
        this.student = student;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }   
    
}

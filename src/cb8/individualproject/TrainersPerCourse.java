package cb8.individualproject;

import java.util.ArrayList;

public class TrainersPerCourse {

    private ArrayList <Trainer> trainers;
    private Course course;

    @Override
    public String toString() {
        return "\nTrainersPerCourse{" + "trainers=" + trainers + "\ncourse=" + course.getTitle() + '}';
    }
       
    public TrainersPerCourse() {
    }

    public TrainersPerCourse(ArrayList<Trainer> trainers, Course course) {
        this.trainers = trainers;
        this.course = course;
    }

    public ArrayList<Trainer> getTrainers() {
        if(trainers==null){
            trainers = new ArrayList();
        }
        return trainers;
    }

    public void setTrainers(ArrayList<Trainer> trainers) {
        this.trainers = trainers;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }   
    
}

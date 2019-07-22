package cb8.individualproject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Stylianos Papadopoulos
 */
public class CB8IndividualProject {
    
        static ArrayList<Student> arrayStudents = new ArrayList();
        static ArrayList<Trainer> arrayTrainers = new ArrayList();
        static ArrayList<Course> arrayCourses = new ArrayList();
        static ArrayList<Assignment> arrayAssignments = new ArrayList();
        static ArrayList<StudentsPerCourse> studentsCourse = new ArrayList();
        static ArrayList<TrainersPerCourse> trainersCourse = new ArrayList();
        static ArrayList<AssignmentsPerCourse> assignmentsCourse = new ArrayList();
        static ArrayList<AssignmentsPerStudent> assignmentsStudent = new ArrayList();
        static ArrayList<StudentsToManyCourses> studentsToCourses = new ArrayList();

    public static void main(String[] args) {
        

        String answer = welcome();
        menu(answer);

    }

    public static void menu(String answer) {

        Scanner input = new Scanner(System.in);

        if (answer.equals("N")) {
            
            arrayStudents = createStudentList(arrayStudents);
            arrayTrainers = createTrainerList(arrayTrainers);
            arrayAssignments = createAssignmentList(arrayAssignments);
            arrayCourses = createCourseList(arrayCourses);
            
            System.out.println("1.List of all the students");
            System.out.println("2.List of all the trainers");
            System.out.println("3.List of all the assignments");
            System.out.println("4.List of all the courses");
            System.out.println("5.More options");
            System.out.println("9.Exit app");
            String menuOptions = input.nextLine();
            
            while (!"1".equals(menuOptions) && !"2".equals(menuOptions) && !"3".equals(menuOptions)
                       && !"4".equals(menuOptions) && !"5".equals(menuOptions) && !"9".equals(menuOptions)){
                System.out.println("Your input is not valid, please try again!");
                menuOptions = input.nextLine();
            }
            
            switch (menuOptions){
                case "1":
                    for (Student students : arrayStudents){
                        System.out.println(students);
                    }
                    backToMenu(answer);
                    break;
                case "2":
                    for (Trainer trainers : arrayTrainers){
                        System.out.println(trainers);
                    }
                    backToMenu(answer);
                    break;
                case "3":
                    for (Assignment assignments : arrayAssignments){
                        System.out.println(assignments);
                    }
                    backToMenu(answer);
                    break;
                case "4":
                    for (Course courses : arrayCourses){
                       System.out.println(courses);
                    }
                    backToMenu(answer);
                    break;
                    
                case "5":
                    System.out.println("1.List of all the students per course");
                    System.out.println("2.List of all the trainers per course");
                    System.out.println("3.List of all the assignments per course");
                    System.out.println("4.List of all the assignments per student");
                    System.out.println("5.List of students that belong to more than one courses");
                    System.out.println("9.Exit app");
                    String moreInformation = input.nextLine();
                    while (!"1".equals(moreInformation) && !"2".equals(moreInformation) && !"3".equals(moreInformation)
                       && !"4".equals(moreInformation) && !"5".equals(moreInformation) && !"9".equals(moreInformation)){
                        System.out.println("Your input is not valid, please try again!");
                        moreInformation = input.nextLine();
                    }
                    switch (moreInformation){
                        case "1":
                            studentsCourse = createStudentsPerCourseList(studentsCourse, arrayStudents, arrayCourses);
                            for (StudentsPerCourse students : studentsCourse){
                                System.out.println(students);
                            }
                            backToMenu(answer);
                            break;
                        case "2":
                            trainersCourse = createTrainersPerCourseList( trainersCourse, arrayTrainers, arrayCourses);
                            for (TrainersPerCourse trainers : trainersCourse){
                                System.out.println(trainers);
                            }
                            backToMenu(answer);
                            break;
                        case "3":
                            assignmentsCourse = createAssignmentsPerCourseList(assignmentsCourse, arrayAssignments, arrayCourses);
                            for (AssignmentsPerCourse assignments : assignmentsCourse){
                                System.out.println(assignments);
                            }
                            backToMenu(answer);
                            break;
                        case "4":
                            assignmentsStudent = createAssignmentsPerStudentList(assignmentsStudent, arrayAssignments, arrayStudents);
                            for (AssignmentsPerStudent assignments : assignmentsStudent){
                                System.out.println(assignments);
                            }
                            backToMenu(answer);
                            break;
                        case "5":
                            studentsToCourses =  createStudentsToManyCoursesList(studentsToCourses, arrayStudents, arrayCourses);
                            for (StudentsToManyCourses student : studentsToCourses){
                                System.out.println(student);
                            }
                            backToMenu(answer);
                            break;
                        case "9": 
                            System.exit(0);
                    }
                case "9":
                    System.exit(0);
            
            }
            

        }
        if (answer.equals("Y")){
            
            System.out.println("1.Add students to a list");
            System.out.println("2.Add trainers to a list");
            System.out.println("3.Add assignments to a list");
            System.out.println("4.Add courses to a list");
            System.out.println("5.More options");
            System.out.println("6.See your lists");
            System.out.println("9.Exit app");
            String menuOptions = input.nextLine();
            
            while (!"1".equals(menuOptions) && !"2".equals(menuOptions) && !"3".equals(menuOptions)
                       && !"4".equals(menuOptions) && !"5".equals(menuOptions) && !"6".equals(menuOptions) 
                         && !"9".equals(menuOptions)){
                System.out.println("Your input is not valid, please try again!");
                menuOptions = input.nextLine();
            }
            
            switch (menuOptions){
                
                case "1":
                    arrayStudents = addStudentToList(arrayStudents);
                    backToMenu(answer);
                    break;
                case "2":
                    arrayTrainers = addTrainerToList(arrayTrainers);
                    backToMenu(answer);
                    break;
                case "3":
                    arrayAssignments = addAssignmentToList(arrayAssignments);
                    backToMenu(answer);
                    break;
                case "4":
                    arrayCourses = addCourseToList(arrayCourses);
                    backToMenu(answer);
                    break;
                case "5":
                    System.out.println("1.Add students to a course");
                    System.out.println("2.Add trainers to a course");
                    System.out.println("3.Add assignments to a course");
                    System.out.println("4.Add assignment to a student");
                    System.out.println("5.Add students to more than one courses");
                    System.out.println("9.Exit app");
                    String moreInformation = input.nextLine();
                    while (!"1".equals(moreInformation) && !"2".equals(moreInformation) && !"3".equals(moreInformation)
                       && !"4".equals(moreInformation) && !"5".equals(moreInformation) && !"9".equals(moreInformation)){
                        System.out.println("Your input is not valid, please try again!");
                        moreInformation = input.nextLine();
                    }
                    switch (moreInformation){
                        case "1":
                            createStudentsPerCourse(answer);
                        case "2":
                            createTrainersPerCourse(answer);
                        case "3":
                            createAssignmentsPerCourse(answer);
                        case "4":
                            createAssignmentsPerStudent(answer);
                        case "5":
                            createStudentsToCourses(answer);
                        case "9": 
                            System.exit(0);
                    }
                break;
                case "6":
                    System.out.println("1.List of added students");
                    System.out.println("2.List of added trainers");
                    System.out.println("3.List of added assignments");
                    System.out.println("4.List of added courses");
                    System.out.println("5.More options");
                    System.out.println("9.Exit app");
                    String menuOptions1 = input.nextLine();
            
                    while (!"1".equals(menuOptions1) && !"2".equals(menuOptions1) && !"3".equals(menuOptions1)
                             && !"4".equals(menuOptions1) && !"5".equals(menuOptions1) && !"9".equals(menuOptions1)){
                        System.out.println("Your input is not valid, please try again!");
                        menuOptions1 = input.nextLine();
                    }
                    switch (menuOptions1){
                
                        case "1":
                            for (Student students : arrayStudents){
                                System.out.println(students);
                            }
                            backToMenu(answer);
                            break;
                        case "2":
                            for (Trainer trainers : arrayTrainers){
                                System.out.println(trainers);
                            }
                            backToMenu(answer);
                            break;
                        case "3":
                            for (Assignment assignments : arrayAssignments){
                                System.out.println(assignments);
                            }
                            backToMenu(answer);
                            break;
                        case "4":
                            for (Course courses : arrayCourses){
                            System.out.println(courses);
                            }
                            backToMenu(answer);
                            case "5":
                            System.out.println("1.List of added students per course");
                            System.out.println("2.List of added trainers per course");
                            System.out.println("3.List of added assignments per course");
                            System.out.println("4.List of added assignments per student");
                            System.out.println("5.List of added students that belong to more than one courses");
                            System.out.println("9.Exit app");
                            String menuOptions2 = input.nextLine();
            
                    while (!"1".equals(menuOptions1) && !"2".equals(menuOptions1) && !"3".equals(menuOptions1)
                             && !"4".equals(menuOptions1) && !"5".equals(menuOptions1) && !"9".equals(menuOptions1)){
                        System.out.println("Your input is not valid, please try again!");
                        menuOptions1 = input.nextLine();
                    }
                    switch (menuOptions2){
                        case "1":
                            for (StudentsPerCourse sc : studentsCourse){
                                System.out.println(sc);
                            }
                            backToMenu(answer);
                            break;
                        case "2":
                            for (TrainersPerCourse sc : trainersCourse){
                                System.out.println(sc);
                            }
                            backToMenu(answer);
                            break;
                        case "3":
                            for (AssignmentsPerCourse sc : assignmentsCourse){
                                System.out.println(sc);
                            }
                            backToMenu(answer);
                            break;
                        case "4":
                            for (AssignmentsPerStudent sc : assignmentsStudent){
                            System.out.println(sc);
                            }
                            backToMenu(answer);
                            break;
                        case "5":
                            for (StudentsPerCourse sc : studentsCourse){
                                System.out.println(sc);
                            }
                            backToMenu(answer);
                            break;
                        case "9":
                            System.exit(0);       
                    }
                            
                    }
                case "9":
                    System.exit(0);
                    
            }
            
        }
        input.close();

    }
    
        public static ArrayList<Course> createCourseList(ArrayList<Course> arrayCourses){
        
        arrayCourses.add(new Course("CB6", "Full-Time", "Java", "01/01/2019", "31/3/2019"));
        arrayCourses.add(new Course("CB8", "Part-Time", "Java", "01/01/2019", "31/6/2019"));
        arrayCourses.add(new Course("CB7", "Full-Time", "C#", "01/01/2019", "31/3/2019"));
        arrayCourses.add(new Course("CB9", "Part-Time", "C#", "01/01/2019", "31/6/2019"));
        
        return arrayCourses;
 
    }
        
        public static ArrayList<Trainer> createTrainerList(ArrayList<Trainer> arrayTrainers){
            
        arrayTrainers.add(new Trainer("Konstantinos", "Katakouzinos", "Java Developer"));
        arrayTrainers.add(new Trainer("Giorgos", "Papadopoulos", "Java Developer"));
        arrayTrainers.add(new Trainer("Stylianos", "Papadeas", "C# Developer"));
        arrayTrainers.add(new Trainer("Giorgos", "Gkotsis", "C# Developer"));
            
            return arrayTrainers;
        }
        
        public static ArrayList<Student> createStudentList(ArrayList<Student> arrayStudents){
            
            arrayStudents.add(new Student("Stylianos","Papadoulos","12/10/1994","2500$"));
            arrayStudents.add(new Student("Jason","Gkotsis","02/09/1994","2500$"));
            arrayStudents.add(new Student("Nick","Petropoulos","06/06/1994","2500$"));
            arrayStudents.add(new Student("Dimitrios","Tsopelas","09/07/1987","2500$"));
            arrayStudents.add(new Student("Giorgos","Diamantopoulos","07/05/1991","2500$"));
            arrayStudents.add(new Student("Dimitrios","Diamantidis","06/02/1990","2500$"));
            arrayStudents.add(new Student("Dimitrios","Bafas","09/04/1989","2500$"));
            arrayStudents.add(new Student("Asimakis","Konstantopoulos","27/04/1986","2500$"));
            arrayStudents.add(new Student("Nikolaos","Katsimadakis","13/01/1993","2500$"));
            arrayStudents.add(new Student("Aggelos","Pigadiotis","16/06/1991","2500$"));
            
            return arrayStudents;
        }
        
        public static ArrayList<Assignment> createAssignmentList(ArrayList<Assignment> arrayAssignments){
            
            arrayAssignments.add(new Assignment("Individual ProjectFT","PART A","01/02/2019",67.2,78.9));
            arrayAssignments.add(new Assignment("Individual ProjectFT","PART B","25/03/2019",78.2,79.0));
            arrayAssignments.add(new Assignment("Individual ProjectPT","PART A","25/04/2019",85.2,94.6));
            arrayAssignments.add(new Assignment("Individual ProjectPT","PART B","25/06/2019",97.2,98.1));
            
            return arrayAssignments;
            
        }
        
        public static ArrayList<Course> addCourseToList(ArrayList<Course> arrayCourses){
            
            Scanner input = new Scanner(System.in);
            
            int number= 0;
            System.out.println("How many Courses you want to add? (from 1 to 4)");
            String epilogi = input.nextLine();
            
            while (!"1".equals(epilogi) && !"2".equals(epilogi) && !"3".equals(epilogi) && !"4".equals(epilogi)){
                System.out.println("Your input is not valid, please try again! Give a nymber from 1 to 4.");
                epilogi = input.nextLine();
            }
            
            if (null == epilogi){
                number = 4;
            } else switch (epilogi) {
            case "1":
                number = 1;
                break;
            case "2":
                number = 2;
                break;
            case "3":
                number = 3;
                break;
            default:
                number = 4;
                break;
        }
            for (int i = 0; i < number ; i++){
                System.out.print("Write the title of the course: ");
                String title = input.nextLine();
                System.out.print("Write the stream of the course: ");
                String stream = input.nextLine();
                System.out.print("Write the type of the course: ");
                String type = input.nextLine();
                System.out.print("Write the start date of the course: ");
                String start_date = input.nextLine();
                checkDate(start_date);
                System.out.print("Write the end date of the course: ");
                String end_date = input.nextLine();
                checkDate(end_date);
                Course cr = (new Course(title, stream, type, start_date, end_date));
                arrayCourses.add(cr);  
                System.out.println("Course added!");
            }
            
            return arrayCourses;
        }
        
        public static ArrayList<Trainer> addTrainerToList(ArrayList<Trainer> arrayTrainers){
            
            Scanner input = new Scanner (System.in);
            int number= 0;
            System.out.println("How many Trainers you want to add? (from 1 to 4)");
            String epilogi = input.nextLine();
            
            while (!"1".equals(epilogi) && !"2".equals(epilogi) && !"3".equals(epilogi) && !"4".equals(epilogi)){
                System.out.println("Your input is not valid, please try again! Give a nymber from 1 to 4.");
                epilogi = input.nextLine();
            }
            
                if (null == epilogi){
                number = 4;
            } else switch (epilogi) {
            case "1":
                number = 1;
                break;
            case "2":
                number = 2;
                break;
            case "3":
                number = 3;
                break;
            default:
                number = 4;
                break;
        }
                for (int i = 0; i < number ; i++){
                    
                    System.out.print("Write the first name of the trainer: ");
                    String firstName = input.nextLine();
                    System.out.print("Write the last name of the trainer: ");
                    String lastName = input.nextLine();
                    System.out.print("Write the subject of the trainer: ");
                    String subject = input.nextLine();
                    Trainer tr = (new Trainer(firstName, lastName, subject));
                    arrayTrainers.add(tr);  
                    System.out.println("Trainer added!");
                }
                return arrayTrainers;
        }
        
        public static ArrayList <Student> addStudentToList(ArrayList<Student> arrayStudents){
            
            Scanner input = new Scanner (System.in);
            int number= 0;
            System.out.println("How many Students you want to add? (from 1 to 8)");
            String epilogi = input.nextLine();
            
            while (!"1".equals(epilogi) && !"2".equals(epilogi) && !"3".equals(epilogi)
                       && !"4".equals(epilogi) && !"5".equals(epilogi) && !"6".equals(epilogi) &&
                    !"7".equals(epilogi) && !"8".equals(epilogi)){      

                System.out.println("Your input is not valid, please try again! Give a number from 1 to 8.");
                epilogi = input.nextLine();
    }
                
                if (null == epilogi){
                number = 8;
            } else switch (epilogi) {
            case "1":
                number = 1;
                break;
            case "2":
                number = 2;
                break;
            case "3":
                number = 3;
                break;
            case "4":
                number = 4;
                break;
            case "5":
                number = 5;
                break;
            case "6":
                number = 6;
                break;
            case "7":
                number = 7;
                break;
            default:
                number = 8;
                break;
        }
                for (int i = 0; i < number ; i++){
                    System.out.print("Write the first name of the student: ");
                    String firstName = input.nextLine();
                    System.out.print("Write the last name of the student: ");
                    String lastName = input.nextLine();
                    System.out.print("Write the date of birth of the student: ");
                    String dateOfBirth = input.nextLine();
                    checkDate(dateOfBirth);
                    System.out.print("Write the tiution fee of the student: ");
                    String tuitiOnFees = input.nextLine();
                    Student st = (new Student(firstName, lastName, dateOfBirth, tuitiOnFees));
                    arrayStudents.add(st);  
                    System.out.println("Student added!");
                }
            return arrayStudents;
        }
        
        public static ArrayList<Assignment> addAssignmentToList(ArrayList<Assignment> arrayAssignments){
            
            Scanner input = new Scanner (System.in);
            int number= 0;
            System.out.println("How many Assignments you want to add? (from 1 to 4)");
            String epilogi = input.nextLine();
            
            while (!"1".equals(epilogi) && !"2".equals(epilogi) && !"3".equals(epilogi) && !"4".equals(epilogi)){      
                System.out.println("Your input is not valid, please try again! Give a nymber from 1 to 4.");
                epilogi = input.nextLine();
            } 
                if (null == epilogi){
                number = 4;
            } else switch (epilogi) {
            case "1":
                number = 1;
                break;
            case "2":
                number = 2;
                break;
            case "3":
                number = 3;
                break;
            default:
                number = 4;
                break;
        }
                
                for (int i = 0; i < number ; i++){
                    System.out.print("Write the title of the assignment: ");
                    String title = input.nextLine();
                    System.out.print("Write the description of the assignment: ");
                    String description = input.nextLine();
                    System.out.print("Write the sub date time of the assignment: ");
                    String subDateTime = input.nextLine();
                    checkDate(subDateTime);
                    System.out.print("Write the oral mark of the assignment: ");
                    double oralMark = input.nextDouble();
                    System.out.print("Write the total mark of the assignment: ");
                    double totalMark = input.nextDouble();
                    Assignment ass = (new Assignment(title, description, subDateTime, oralMark, totalMark));
                    arrayAssignments.add(ass);  
                    System.out.println("Assignment added!");
            }
            
            return arrayAssignments;
        }
              
        public static String welcome(){
            
        Scanner input = new Scanner(System.in);
        
        System.out.println("+------------------------------------+");
        System.out.println("+    WELCOME TO OUR PRIVATE SCHOOL   +");
        System.out.println("+------------------------------------+");
        System.out.println("\nYou want to type data now or not?");
        System.out.println("Press 'Y' for YES or 'N' for NO");
        String answer = input.nextLine();
        while (!"Y".equals(answer) && !"N".equals(answer)) {
            System.out.println("Your answer is not valid! Please press 'Y' or 'N'.");
            answer = input.nextLine();
        }
            return answer;
        }
        
        public static String option(){
            
            Scanner input = new Scanner (System.in);
            System.out.println("--------------------------------------");
            System.out.println("If you want to go to the menu PRESS 'M'");
            System.out.println("If you want to exit from app PRESS 'E'");
            String option = input.nextLine();
            while (!"M".equals(option) && !"E".equals(option)){
                option = input.nextLine();
            }
            return option;
            
            }
        
        public static void backToMenu(String answer){
            String option = option();
                    if ("M".equals(option)){
                        menu( answer);
                    } else {
                        System.exit(0);
                    }
        }

        public static void createStudentsPerCourse(String answer){
                
                    Student stud = new Student();
                    Course cr = new Course();
                    Scanner input = new Scanner(System.in);
                    StudentsPerCourse spc = new StudentsPerCourse();
                    int ind = 0;

                    for (Student students : arrayStudents){
                        System.out.println(students.getFirstName() + " " + students.getLastName()); 
                    }
                    System.out.println("Choose a student=press a number (1 for first student, 2 for second student etc..");
                    int y = input.nextInt() - 1;
                    stud = arrayStudents.get(y);
                    
                    for (Course courses : arrayCourses){
                        System.out.println(courses.getTitle());                 
                    }
                    System.out.println("Choose a course-press a number (1 for first course, 2 for second course etc..");
                    int x = input.nextInt() - 1;
                    cr = arrayCourses.get(x);
                    
                    if (studentsCourse.isEmpty()){
                        spc.setCourse(cr);
                        spc.getStudents().add(stud);
                        studentsCourse.add(spc);
                        System.out.println("Student " + stud.getFirstName() + " " + stud.getLastName() + " added to course: " + cr.getTitle());
                        backToMenu(answer);
                    } else{
                       for (StudentsPerCourse sc : studentsCourse){
                           if(sc.getCourse().equals(cr)){
                               ind = studentsCourse.indexOf(sc);
                               System.out.println(ind);   
                           }
                       }
                        if (ind == -1){
                            spc.setCourse(cr);
                            spc.getStudents().add(stud);
                            studentsCourse.add(spc);
                            System.out.println("Student " + stud.getFirstName() + " " + stud.getLastName() + " added to course: " + cr.getTitle());
                            backToMenu(answer);
                        } else {
                            if(studentsCourse.get(ind).getStudents().contains(stud)){
                                System.out.println("Student is already exists in this course");
                                backToMenu(answer);
                            } else {
                                studentsCourse.get(ind).getStudents().add(stud);
                                System.out.println("Student " + stud.getFirstName() + " " + stud.getLastName() + " added to course: " + cr.getTitle());
                                backToMenu(answer);
                            }
                        }
                        
                    }
        }

        public static void createTrainersPerCourse(String answer){
                
                    Trainer tr = new Trainer();
                    Course cr = new Course();
                    Scanner input = new Scanner(System.in);
                    TrainersPerCourse tpc = new TrainersPerCourse();
                    int ind = 0;

                    for (Trainer trainers : arrayTrainers){
                        System.out.println(trainers.getFirstName() + " " + trainers.getLastName()); 
                    }
                    System.out.println("Choose a trainer=press a number (1 for first trainer, 2 for second trainer etc..");
                    int y = input.nextInt() - 1;
                    tr = arrayTrainers.get(y);
                    
                    for (Course courses : arrayCourses){
                        System.out.println(courses.getTitle());                 
                    }
                    System.out.println("Choose a course-press a number (1 for first course, 2 for second course etc..");
                    int x = input.nextInt() - 1;
                    cr = arrayCourses.get(x);
                    
                    if (trainersCourse.isEmpty()){
                        tpc.setCourse(cr);
                        tpc.getTrainers().add(tr);
                        trainersCourse.add(tpc);
                        System.out.println("Trainer " + tr.getFirstName() + " " + tr.getLastName() + " added to course: " + cr.getTitle());
                        backToMenu(answer);
                    } else{
                       for (TrainersPerCourse sc : trainersCourse){
                           if(sc.getCourse().equals(cr)){
                               ind = trainersCourse.indexOf(sc);
                               System.out.println(ind);   
                           }
                       }
                        if (ind == -1){
                            tpc.setCourse(cr);
                            tpc.getTrainers().add(tr);
                            trainersCourse.add(tpc);
                            System.out.println("Trainer " + tr.getFirstName() + " " + tr.getLastName() + " added to course: " + cr.getTitle());
                            backToMenu(answer);
                        } else {
                            if(trainersCourse.get(ind).getTrainers().contains(tr)){
                                System.out.println("Trainer is already exists in this course");
                                backToMenu(answer);
                            } else {
                                trainersCourse.get(ind).getTrainers().add(tr);
                                System.out.println("Trainer " + tr.getFirstName() + " " + tr.getLastName() + " added to course: " + cr.getTitle());
                                backToMenu(answer);
                            }
                        }
                        
                    }
        }
        
        
         public static void createAssignmentsPerCourse(String answer){
                
                    Assignment ass = new Assignment();
                    Course cr = new Course();
                    Scanner input = new Scanner(System.in);
                    AssignmentsPerCourse apc = new AssignmentsPerCourse();
                    int ind = 0;

                    for (Assignment assignments : arrayAssignments){
                        System.out.println(assignments.getTitle()); 
                    }
                    System.out.println("Choose an assignment=press a number (1 for first assignment, 2 for second assignment etc..");
                    int y = input.nextInt() - 1;
                    ass = arrayAssignments.get(y);
                    
                    for (Course courses : arrayCourses){
                        System.out.println(courses.getTitle());                 
                    }
                    System.out.println("Choose a course-press a number (1 for first course, 2 for second course etc..");
                    int x = input.nextInt() - 1;
                    cr = arrayCourses.get(x);
                    
                    if (assignmentsCourse.isEmpty()){
                        apc.setCourse(cr);
                        apc.getAssignments().add(ass);
                        assignmentsCourse.add(apc);
                        System.out.println("Assignment " + ass.getTitle() + " added to course: " + cr.getTitle());
                        backToMenu(answer);
                    } else{
                       for (AssignmentsPerCourse sc : assignmentsCourse){
                           if(apc.getCourse().equals(cr)){
                               ind = assignmentsCourse.indexOf(sc);
                               System.out.println(ind);   
                           }
                       }
                        if (ind == -1){
                            apc.setCourse(cr);
                            apc.getAssignments().add(ass);
                            assignmentsCourse.add(apc);
                            System.out.println("Assignment " + ass.getTitle() + " added to course: " + cr.getTitle());
                            backToMenu(answer);
                        } else {
                            if(assignmentsCourse.get(ind).getAssignments().contains(ass)){
                                System.out.println("Assignment is already exists in this course");
                                backToMenu(answer);
                            } else {
                                assignmentsCourse.get(ind).getAssignments().add(ass);
                                System.out.println("Assignment " + ass.getTitle() + " added to course: " + cr.getTitle());
                                backToMenu(answer);
                            }
                        }
                        
                    }
        }
         
         
         public static void createAssignmentsPerStudent(String answer){
                
                    Assignment ass = new Assignment();
                    Student st = new Student();
                    Scanner input = new Scanner(System.in);
                    AssignmentsPerStudent aps = new AssignmentsPerStudent();
                    int ind = 0;

                    for (Assignment assignments : arrayAssignments){
                        System.out.println(assignments.getTitle()); 
                    }
                    System.out.println("Choose an assignment=press a number (1 for first assignment, 2 for second assignment etc..");
                    int y = input.nextInt() - 1;
                    ass = arrayAssignments.get(y);
                    
                    for (Student students : arrayStudents){
                        System.out.println(students.getFirstName() + " " + students.getLastName());                 
                    }
                    System.out.println("Choose a student-press a number (1 for first course, 2 for second course etc..");
                    int x = input.nextInt() - 1;
                    st = arrayStudents.get(x);
                    
                    if (assignmentsCourse.isEmpty()){
                        aps.setStudent(st);
                        aps.getAssignments().add(ass);
                        assignmentsStudent.add(aps);
                        System.out.println("Assignment " + ass.getTitle() + " added to student: " + st.getFirstName() +" "+ st.getLastName());
                        backToMenu(answer);
                    } else{
                       for (AssignmentsPerStudent sc : assignmentsStudent){
                           if(sc.getStudent().equals(st)){
                               ind = assignmentsStudent.indexOf(st);
                               System.out.println(ind);   
                           }
                       }
                        if (ind == -1){
                            aps.setStudent(st);
                            aps.getAssignments().add(ass);
                            assignmentsStudent.add(aps);
                             System.out.println("Assignment " + ass.getTitle() + " added to student: " + st.getFirstName() +" "+ st.getLastName());
                             backToMenu(answer);
                        } else {
                            if(assignmentsCourse.get(ind).getAssignments().contains(ass)){
                                System.out.println("Assignment is already exists on this student");
                                backToMenu(answer);
                            } else {
                                assignmentsCourse.get(ind).getAssignments().add(ass);
                                 System.out.println("Assignment " + ass.getTitle() + " added to student: " + st.getFirstName() +" "+ st.getLastName());
                                 backToMenu(answer);
                            }
                        }
                        
                    }
         }
           
         public static void createStudentsToCourses(String answer){
                
                    Student stud = new Student();
                    Course cr = new Course();
                    Scanner input = new Scanner(System.in);
                    StudentsToManyCourses stc = new StudentsToManyCourses();
                    int ind = 0;

                    for (Student students : arrayStudents){
                        System.out.println(students.getFirstName() + " " + students.getLastName()); 
                    }
                    System.out.println("Choose a student=press a number (1 for first student, 2 for second student etc..");
                    int y = input.nextInt() - 1;
                    stud = arrayStudents.get(y);
                    
                    for (Course courses : arrayCourses){
                        System.out.println(courses.getTitle());                 
                    }
                    System.out.println("Choose a course-press a number (1 for first course, 2 for second course etc..");
                    int x = input.nextInt() - 1;
                    cr = arrayCourses.get(x);
                    
                    if (studentsCourse.isEmpty()){
                        stc.getCourse().add(cr);
                        stc.getStudents().add(stud);
                        studentsToCourses.add(stc);
                        System.out.println("Course " + cr.getTitle() + " added to student: " + stud.getFirstName()+ " " + stud.getLastName() );
                        backToMenu(answer);
                    } else{
                       for (StudentsPerCourse sc : studentsCourse){
                           if(sc.getCourse().equals(cr)){
                               ind = studentsCourse.indexOf(sc);
                               System.out.println(ind);   
                           }
                       }
                        if (ind == -1){
                            stc.getCourse().add(cr);
                            stc.getStudents().add(stud);
                            studentsToCourses.add(stc);
                            System.out.println("Course " + cr.getTitle() + " added to student: " + stud.getFirstName()+ " " + stud.getLastName() );
                            backToMenu(answer);
                        } else {
                            if(studentsCourse.get(ind).getStudents().contains(stud)){
                                System.out.println("Student is already exists in this course");
                                backToMenu(answer);
                            } else {
                                studentsCourse.get(ind).getStudents().add(stud);
                                 System.out.println("Course " + cr.getTitle() + " added to student: " + stud.getFirstName()+ " " + stud.getLastName() );
                                 backToMenu(answer);
                            }
                        }
                        
                    }
        }


        public static ArrayList<StudentsPerCourse> createStudentsPerCourseList(ArrayList<StudentsPerCourse> studentsCourse, ArrayList<Student> arrayStudents, ArrayList<Course> arrayCourses){
        
            ArrayList <Student> s1 = new ArrayList<>();
            ArrayList <Student> s2 = new ArrayList<>();
            ArrayList <Student> s3 = new ArrayList<>();
            ArrayList <Student> s4 = new ArrayList<>();
            s1.add(arrayStudents.get(0));
            s1.add(arrayStudents.get(1));
            s1.add(arrayStudents.get(2));
            s2.add(arrayStudents.get(3));
            s2.add(arrayStudents.get(4));
            s3.add(arrayStudents.get(5));
            s3.add(arrayStudents.get(6));
            s4.add(arrayStudents.get(7));
            s4.add(arrayStudents.get(8));
            s4.add(arrayStudents.get(9));
            
            int x = 0;
            for (Course course : arrayCourses){
                switch (x) {
                    case 0:
                        studentsCourse.add(new StudentsPerCourse(s1, course));
                        x+=1;
                        break;
                    case 1:
                        studentsCourse.add(new StudentsPerCourse(s2, course));
                        x+=1;
                        break;
                    case 2:
                        studentsCourse.add(new StudentsPerCourse(s3, course));
                        x+=1;
                        break;
                    default:
                        studentsCourse.add(new StudentsPerCourse(s4, course));
                        x+=1;
                        break;
                }
            }
        return studentsCourse;
    } 
        
        public static ArrayList<TrainersPerCourse> createTrainersPerCourseList(ArrayList<TrainersPerCourse> trainersCourse, ArrayList<Trainer> arrayTrainers, ArrayList<Course> arrayCourses){
        
            ArrayList <Trainer> t1 = new ArrayList<>();
            ArrayList <Trainer> t2 = new ArrayList<>();
            ArrayList <Trainer> t3 = new ArrayList<>();
            ArrayList <Trainer> t4 = new ArrayList<>();
            t1.add(arrayTrainers.get(0));
            t2.add(arrayTrainers.get(1));
            t3.add(arrayTrainers.get(2));
            t4.add(arrayTrainers.get(3));
            
            int x = 0;
            for (Course course : arrayCourses){
                switch (x) {
                    case 0:
                        trainersCourse.add(new TrainersPerCourse(t1, course));
                        x+=1;
                        break;
                    case 1:
                        trainersCourse.add(new TrainersPerCourse(t2, course));
                        x+=1;
                        break;
                    case 2:
                        trainersCourse.add(new TrainersPerCourse(t3, course));
                        x+=1;
                        break;
                    default:
                        trainersCourse.add(new TrainersPerCourse(t4, course));
                        x+=1;
                        break;
                }
            }
        return trainersCourse;
    } 
        
        public static ArrayList<AssignmentsPerCourse> createAssignmentsPerCourseList(ArrayList<AssignmentsPerCourse> assignmentsCourse, ArrayList<Assignment> arrayAssignments, ArrayList<Course> arrayCourses){
        
            ArrayList <Assignment> a1 = new ArrayList<>();
            ArrayList <Assignment> a2 = new ArrayList<>();
            ArrayList <Assignment> a3 = new ArrayList<>();
            ArrayList <Assignment> a4 = new ArrayList<>();
            a1.add(arrayAssignments.get(0));
            a2.add(arrayAssignments.get(1));
            a3.add(arrayAssignments.get(2));
            a4.add(arrayAssignments.get(3));
            
            int x = 0;
            for (Course course : arrayCourses){
                switch (x) {
                    case 0:
                        assignmentsCourse.add(new AssignmentsPerCourse(a1, course));
                        x+=1;
                        break;
                    case 1:
                        assignmentsCourse.add(new AssignmentsPerCourse(a2, course));
                        x+=1;
                        break;
                    case 2:
                        assignmentsCourse.add(new AssignmentsPerCourse(a3, course));
                        x+=1;
                        break;
                    default:
                        assignmentsCourse.add(new AssignmentsPerCourse(a4, course));
                        x+=1;
                        break;
                }
            }
        return assignmentsCourse;
    } 
        
        
        public static ArrayList<AssignmentsPerStudent> createAssignmentsPerStudentList(ArrayList<AssignmentsPerStudent> assignmentsStudent, ArrayList<Assignment> arrayAssignments, ArrayList<Student> arrayStudents){
        
            ArrayList <Assignment> a1 = new ArrayList<>();
            ArrayList <Assignment> a2 = new ArrayList<>();
            ArrayList <Assignment> a3 = new ArrayList<>();
            ArrayList <Assignment> a4 = new ArrayList<>();
            a1.add(arrayAssignments.get(0));
            a2.add(arrayAssignments.get(1));
            a3.add(arrayAssignments.get(2));
            a4.add(arrayAssignments.get(3));
            
            int x = 0;
            for (Student student : arrayStudents){
                switch (x) {
                    case 0:
                        assignmentsStudent.add(new AssignmentsPerStudent(a1, student));
                        x+=1;
                        break;
                    case 1:
                        assignmentsStudent.add(new AssignmentsPerStudent(a1, student));
                        x+=1;
                        break;
                    case 2:
                        assignmentsStudent.add(new AssignmentsPerStudent(a1, student));
                        x+=1;
                        break;
                    case 3:
                        assignmentsStudent.add(new AssignmentsPerStudent(a1, student));
                        x+=1;
                        break;
                    case 4:
                        assignmentsStudent.add(new AssignmentsPerStudent(a2, student));
                        x+=1;
                        break;
                    case 5:
                        assignmentsStudent.add(new AssignmentsPerStudent(a2, student));
                        x+=1;
                        break;
                    case 6:
                        assignmentsStudent.add(new AssignmentsPerStudent(a3, student));
                        x+=1;
                        break;
                    case 7:
                        assignmentsStudent.add(new AssignmentsPerStudent(a4, student));
                        x+=1;
                        break;
                    case 8:
                        assignmentsStudent.add(new AssignmentsPerStudent(a4, student));
                        x+=1;
                        break;
                    default:
                        assignmentsStudent.add(new AssignmentsPerStudent(a4, student));
                        x+=1;
                        break;

            }
        }
         return assignmentsStudent;
    }
        
        public static ArrayList<StudentsToManyCourses> createStudentsToManyCoursesList(ArrayList<StudentsToManyCourses> studentsToCourses, ArrayList<Student> arrayStudents, ArrayList<Course> arrayCourses){
        
            ArrayList <Student> s1 = new ArrayList<>();
            ArrayList <Student> s2 = new ArrayList<>();
            ArrayList <Student> s3 = new ArrayList<>();
            ArrayList <Student> s4 = new ArrayList<>();
            s1.add(arrayStudents.get(0));
            s1.add(arrayStudents.get(1));
            s1.add(arrayStudents.get(2));
            s2.add(arrayStudents.get(3));
            s2.add(arrayStudents.get(4));
            s3.add(arrayStudents.get(5));
            s3.add(arrayStudents.get(6));
            s4.add(arrayStudents.get(7));
            s4.add(arrayStudents.get(8));
            s4.add(arrayStudents.get(9));
            
            ArrayList <Course> c1 = new ArrayList<>();
            ArrayList <Course> c2 = new ArrayList<>();
            ArrayList <Course> c3 = new ArrayList<>();
            ArrayList <Course> c4 = new ArrayList<>();
            c4.add(arrayCourses.get(0));
            c4.add(arrayCourses.get(1));
            c1.add(arrayCourses.get(0));
            c1.add(arrayCourses.get(2));
            c2.add(arrayCourses.get(3));
            c2.add(arrayCourses.get(1));
            c3.add(arrayCourses.get(0));
            c3.add(arrayCourses.get(2));
            
            studentsToCourses.add(new StudentsToManyCourses(s1, c1));
            studentsToCourses.add(new StudentsToManyCourses(s2, c2));
            studentsToCourses.add(new StudentsToManyCourses(s3, c3));
            studentsToCourses.add(new StudentsToManyCourses(s4, c4));

         return studentsToCourses;
    }

        public static String checkDate(String date) {
            
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

         try {
            LocalDate.parse(date, formatter);
         } catch (Exception e) {
        System.out.println("Invalid input. Date pattern must be: dd/MM/yyyy. Try again");
        date = input.nextLine();
        checkDate(date);
    }
    return date;
}
}

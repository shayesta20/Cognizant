class Student {
    private String id;
    private String name;
    private String grade;

    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Student Details:");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Grade: " + student.getGrade());
    }
}

class StudentController {
    private final Student student;
    private final StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public void setStudentGrade(String grade) {
        student.setGrade(grade);
    }

    public void updateView() {
        view.displayStudentDetails(student);
    }
}

public class MVCTest {
    public static void main(String[] args) {
        Student model = new Student("S1001", "Ayesha", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}

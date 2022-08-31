package main;

public class Student extends AbstractPerson {
    private String classCode;

    public Student(String name, String phoneNumber, String classCode) {
        super(name, phoneNumber);
        this.classCode = classCode;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }
    
}

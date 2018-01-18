/**
 * Class which creates students and their associated student numbers, names and GPAs.
 * Created by Brandon on 2017-03-29. Student I.D: 201238730
 */
public class Student {
    private String studentNum;
    private String name;
    private double gpa;

    /**
     * Constructs a student object.
     * @param studentNum - a unique student number identifying the student.
     * @param name - the name of the student.
     * @param gpa - the cumulative grade point average.
     */
    public Student(String studentNum, String name, double gpa) {
        this.studentNum = studentNum;
        this.name = name;
        this.gpa = gpa;
    }

    /**
     * Gets the student number.
     * @return a string representing a student's number.
     */
    public String getStudentNum() {
        return studentNum;
    }

    /**
     * Sets the number of a student to a new value.
     * @param studentNum - the new value to be set.
     */
    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    /**
     * Gets the name of the student.
     * @return a string representing the name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student to a new value.
     * @param name - the name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the GPA for the student.
     * @return a double representing the gpa.
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Sets the GPA of the student to a new value.
     * @param gpa - the value to be set.
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}

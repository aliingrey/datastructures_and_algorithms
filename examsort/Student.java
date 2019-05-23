public class Student {
    public String first;     // first name
    public String last;      // last name
    public int uniYear;      // year in uni
    public int studentID;      // section number
    public String program;
    

    public Student(int studentID, String first, String last, int uniYear, String program) { 
        this.studentID = studentID;
        this.first = first;
        this.last = last;
        this.uniYear = uniYear;
        this.program = program;
    }
    public int getId() {
        return studentID;
    }
    public String toString() {
        return studentID + " " + first + " " + last + " " + " " + uniYear + " " + program;
    }
    public int compareTo(Student student) {
        if (this.getId() > student.getId() ) {
            return 1;
        } else {
            return -1;
        }
    }
}
package Pages;

import Pages.Questions.Students;

import java.util.ArrayList;

public class Classroom {








    static void main() {
        Students studentOne = new Students("Piyush", 23);
        Students studentTwo = new Students("Rajkumar", 45);
        ArrayList<Students> students = new ArrayList<>();
        students.add(studentOne);
        students.add(studentTwo);




        for(Students student: students) {
            System.out.println(student.getStudentName());
            System.out.println(student.getStudentAge());

        }




    }
}

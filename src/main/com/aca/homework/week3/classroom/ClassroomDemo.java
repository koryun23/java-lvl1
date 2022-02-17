package com.aca.homework.week3.classroom;

public class ClassroomDemo {
    public static void main(String[] args) {
        AcaClass acaClass = new AcaClass();
        acaClass.name = "java level 1";
        acaClass.startMillis = 1640980800000L; // milliseconds for 1st January 2022
        acaClass.endMillis = 1651348800000L; // milliseconds for 1st May 2022
        acaClass.fee = 500_000;

        // took the students names and surnames from our slack workspace
        acaClass.students = new Student[]{
                getStudent("Anahit", "Tumanyan"),
                getStudent("Arman", ""),
                getStudent("Artyom", "Ghazaryan"),
                getStudent("Avetis", "Khachatryan"),
                getStudent("Koryun", "Grigoryan"),
                getStudent("Liana", "Simonian"),
                getStudent("Lily", "L"),
                getStudent("Sargis", "Eghoyan"),
                getStudent("Vahan", "Grigoryan"),
                getStudent("Vov", "Gasparyan")
        };
    }
    public static Student getStudent(String name, String surname){
        Student student = new Student();
        student.name = name;
        student.surname = surname;
        return student;
    }


}

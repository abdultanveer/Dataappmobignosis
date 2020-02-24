package com.spot.dataapp.classroom;

public class HarshaManager {

    public static void main(String[] args) {
        Teacher abdul = new Teacher("python");
        Student[]  students = new Student[4];
        abdul.teach(students);
        abdul.testKnowledge(students);
    }
}

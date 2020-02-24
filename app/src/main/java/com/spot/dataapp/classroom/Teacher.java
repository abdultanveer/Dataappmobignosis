package com.spot.dataapp.classroom;

public class Teacher {
    //partitions of box
    String teachersKnowledge = "complete android knowledge";


    public Teacher(){}

    public Teacher(String knowledge){
        teachersKnowledge = knowledge;
    }



    public void teach(Student[] students) {
        for(Student student:students){
            student.androidKnowledge = teachersKnowledge;
        }
    }

    public void testKnowledge(Student[] students) {
        for(Student student : students){
            System.out.println(student.androidKnowledge);
        }
    }
}

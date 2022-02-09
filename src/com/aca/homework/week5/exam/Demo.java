package com.aca.homework.week5.exam;

public class Demo {
    public static void main(String[] args) {
        ExamTest failedExam = new FailedExamTest("username");
        ExamTest passedExam = new PassedExamTest("smart-username");
        ExamTest[] examTests = {failedExam, passedExam};
        for(ExamTest examTest: examTests) {
            System.out.println(examTest);
            System.out.println("---------------");
        }
    }
}

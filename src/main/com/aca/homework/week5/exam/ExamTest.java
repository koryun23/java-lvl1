package com.aca.homework.week5.exam;

public class ExamTest {
    private String username;
    private boolean passed;

    public ExamTest(String username, boolean passed){
        this.username = username;
        this.passed = passed;
    }

    public String getUsername(){
        return username;
    }

    public boolean isPassedExam(){
        return passed;
    }
    @Override
    public String toString(){
        String examStatus = isPassedExam() ? "passed" : "failed";
        return String.format("%s: %s\n%s: %s",
                "username", getUsername(), "exam status", examStatus);

    }
}

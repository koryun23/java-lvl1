package com.aca.homework.week2.projectuptime;

import java.util.Scanner;

public class ProjectTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Project[] projects = new Project[3];
        for(int i = 0; i < 3; i++){
            Project project = createProject(startTime);
            projects[i] = project;
        }
        printProjects(projects);
    }
    public static void printProjects(Project[] projects){
        for(Project project : projects){
            System.out.println(project.name + " " + project.creationSeconds);
        }
    }
    public static Project createProject(long startTime){
        Scanner scanner = new Scanner(System.in);
        Project project = new Project();
        System.out.println("Enter a name for your project");
        String projectName = scanner.nextLine();
        long projectUpTime = (System.currentTimeMillis()-startTime) / 1000;
        project.name = projectName;
        project.creationSeconds = projectUpTime;
        return project;
    }
}

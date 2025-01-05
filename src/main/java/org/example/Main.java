package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            
            int choice = scanner.nextInt();
            
            switch(choice) {
                case 1 -> {
                    System.out.println("Enter Student Name: ");
                    String name = scanner.next();
                    System.out.println("Enter Student Age: ");
                    int age = scanner.nextInt();
                    dao.addStudent(name, age);
                    }
                case 2 -> {
                    System.out.println("Students:");
                    dao.getStudents().forEach(student -> System.out.println("Id: " + student.getId() + "\nName:  " +student.getName() + "\nAge: " + student.getAge() +"\n-----------------------------------------------\n"));
                }
                case 3 -> {
                    System.out.println("Enter student ID to update: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter new name: ");
                    String newName = scanner.next();
                    System.out.println("Enter new age: ");
                    int newAge = scanner.nextInt();
                    dao.updateStudent(id, newName, newAge);
                }
                case 4 -> {
                    System.out.println("Enter student ID to delete: ");
                    int id = scanner.nextInt();
                    dao.deleteStudent(id);
                }
                case 5->
                {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, Please try again");
            }
        }
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
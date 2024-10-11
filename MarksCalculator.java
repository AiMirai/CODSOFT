import java.util.Scanner;

public class MarksCalculator {

    // Method to calculate grade based on percentage
    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input the number of subjects with validation
        int numSubjects = 0;
        while (true) {
            System.out.print("Enter the number of subjects: ");
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) {
                    break; // valid positive number, exit loop
                } else {
                    System.out.println("Please enter a positive integer for the number of subjects.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // clear invalid input
            }
        }

        // Step 2: Input marks for each subject with validation
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            int subjectMarks;
            // Validation loop for each subject's marks
            while (true) {
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
                if (scanner.hasNextInt()) {
                    subjectMarks = scanner.nextInt();
                    // Check if the marks are valid (between 0 and 100)
                    if (subjectMarks >= 0 && subjectMarks <= 100) {
                        marks[i] = subjectMarks;
                        totalMarks += subjectMarks; // Update total marks
                        System.out.println("Marks accepted.");
                        break; // valid marks, exit loop
                    } else {
                        System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // clear invalid input
                }
            }
        }

        // Step 3: Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Step 4: Calculate grade
        String grade = calculateGrade(averagePercentage);

        // Step 5: Display results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

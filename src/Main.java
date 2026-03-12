import java.util.Scanner;
import service.*;

public class Main {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        AppointmentService appointmentService = new AppointmentService();
        IssueService issueService = new IssueService();
        ActionHistoryService actionService = new ActionHistoryService();

        studentService.initializeStudents();
        studentService.removeLowGPA();
        studentService.insertAtIndex();

        appointmentService.initializeAppointments();
        appointmentService.cancelLast();

        issueService.initializeIssues();
        issueService.resolveIssues();

        actionService.initializeActions();
        actionService.undoLastAction();
        actionService.addRequestedTranscript();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== 🎓 Smart University Service System =====");
            System.out.println("1. Show Students");
            System.out.println("2. Show Appointments");
            System.out.println("3. Show Emergency Issues");
            System.out.println("4. Show Action History");
            System.out.println("5. Add New Issue");
            System.out.println("6. Undo Action");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentService.printStudents();
                    studentService.findHighestGPA();
                    break;
                case 2:
                    appointmentService.showFirstAndLast();
                    appointmentService.printAppointments();
                    break;
                case 3:
                    issueService.showMostUrgent();
                    issueService.printRemainingIssues();
                    break;
                case 4:
                    actionService.showFirstAndLast();
                    actionService.printHistory();
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("Enter issue description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter urgency level (1 = most urgent): ");
                    int urgency;
                    while (!scanner.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        scanner.next();
                    }
                    urgency = scanner.nextInt();
                    issueService.addNewIssue(description, urgency);
                    issueService.showMostUrgent();
                    break;
                case 6:
                    actionService.undoLastAction();
                    actionService.showFirstAndLast();
                    break;
                case 7:
                    System.out.println("Exiting... 👋");
                    break;
                default:
                    System.out.println("Invalid option ❌");
            }

        } while (choice != 7);

        scanner.close();
    }
}

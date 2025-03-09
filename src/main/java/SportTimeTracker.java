import java.util.ArrayList;
import java.util.Scanner;

public class SportTimeTracker {
    static class Activity {
        String name;
        int duration; // in minutes

        Activity(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }
    }

    private static final ArrayList<Activity> activities = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSports Activity Logger");
            System.out.println("1. Log an activity");
            System.out.println("2. View activities");
            System.out.println("3. Calculate total time spent");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> logActivity();
                case 2 -> viewActivities();
                case 3 -> calculateTotalTime();
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void logActivity() {
        System.out.print("Enter activity name: ");
        String name = scanner.nextLine();
        System.out.print("Enter duration in minutes: ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        activities.add(new Activity(name, duration));
        System.out.println("Activity logged successfully.");
    }

    private static void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged yet.");
            return;
        }

        System.out.println("\nLogged Activities:");
        for (int i = 0; i < activities.size(); i++) {
            Activity act = activities.get(i);
            System.out.println((i + 1) + ". " + act.name + " - " + act.duration + " minutes");
        }
    }

    private static void calculateTotalTime() {
        int totalTime = activities.stream().mapToInt(a -> a.duration).sum();
        System.out.println("Total time spent on sports this week: " + totalTime + " minutes");
    }
}

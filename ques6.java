import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class CurrentDateTime {
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        // Get the current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);

        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);
    }
}

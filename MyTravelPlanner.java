import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MyTravelPlanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();


        System.out.println("What is the weather prediction today? (Rainy/Sunny/Snowy/Cloudy)");
        String weatherPrediction = scanner.nextLine();

        String plan = getTravelPlan(currentDate, currentTime, weatherPrediction);


        System.out.println("Recommended Travel Plan:");
        System.out.println(plan);

        scanner.close();
    }

    public static String getTravelPlan(LocalDate date, LocalTime currentTime, String weatherPrediction) {
        if (shouldCancelAppointments(weatherPrediction)) {
            return "Please cancel or reschedule your appointments on " + date.toString();
        } else {
            if (shouldTakeTrain(weatherPrediction, currentTime)) {
                return "Please take the train to go to the city, and take the train back home on " + date.toString();
            } else {
                LocalTime departureTime = calculateDepartureTime();
                return "Please drive on " + date.toString() + ", and leave the house at " + departureTime.toString();
            }
        }
    }

    public static boolean shouldCancelAppointments(String weatherPrediction) {
        return weatherPrediction.equalsIgnoreCase("Rainy") || weatherPrediction.equalsIgnoreCase("Snowy");
    }

    public static boolean shouldTakeTrain(String weatherPrediction, LocalTime currentTime) {
        return !shouldCancelAppointments(weatherPrediction) && isTrainPractical(currentTime);
    }

    public static boolean isTrainPractical(LocalTime currentTime) {
        int hour = currentTime.getHour();
        return (currentTime.getDayOfWeek().getValue() < 6 && hour >= 6 && hour <= 22) || // Weekday train hours
               (currentTime.getDayOfWeek().getValue() >= 6 && hour >= 10 && hour <= 22); // Weekend train hours
    }

    public static LocalTime calculateDepartureTime() {
        LocalTime appointmentStartTime = LocalTime.of(9, 0); // Example: Appointment starts at 9:00 AM
        return appointmentStartTime.minusHours(1); // Depart 1 hour before appointment start time
    }
}

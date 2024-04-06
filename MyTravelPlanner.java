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

        String plan = getPlan(currentDate, weatherPrediction);

        System.out.println("Recommended Travel Plan:");
        System.out.println(plan);

        scanner.close(); 
    }

    public static String getPlan(LocalDate date, String weatherPrediction) {
        if (shouldCancelAppointments(weatherPrediction)) {
            return "Please cancel or reschedule your appointments on " + date.toString();
        } else {
            return "Please take the train to go to the city, and train to get back home on " + date.toString();
        }
    }

    public static boolean shouldCancelAppointments(String weatherPrediction) {
        return weatherPrediction.equalsIgnoreCase("Rainy") || weatherPrediction.equalsIgnoreCase("Snowy");
    }
}

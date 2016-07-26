import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class dateDiff {

	// counter that keeps track of which date we are collecting
	static int counter = 1;

	public dateDiff() {

		System.out.println("This program calculates the time between two dates.\n");

		LocalDate dateOne = collectDate();
		LocalDate dateTwo = collectDate();

		this.timeBetween(dateOne, dateTwo);
	}

	public LocalDate collectDate() {

		// defining date format
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		while (true) {
			try {
				System.out.print("Please enter Date #" + counter + " in the format MM/DD/YYYY: ");
				Scanner sc = new Scanner(System.in);
				String input = sc.next();

				// parsing user input to get date in correct format
				LocalDate date = LocalDate.parse(input, dateFormat);

				counter++;
				return date;

			} catch (Exception e) {
				// this will catch errors and let user retry
				System.out.println("That is not a valid date. Please try again.\n");
				continue;
			}
		}
	}

	public void timeBetween(LocalDate first, LocalDate second) {

		// the 'between' method below creates a period with a length equal to
		// the time between the two date parameters
		Period period;

		// this block ensures earlier date is first date in period
		if (first.isBefore(second)) {
			period = Period.between(first, second);
		} else {
			period = Period.between(second, first);
		}

		// getting years/months/days between two dates
		int yearDiff = period.getYears();
		int monthDiff = period.getMonths();
		int dayDiff = period.getDays();

		// having fun with printing the results
		System.out.println("\n---------------------------------------------------------\nRESULT\n");
		System.out.println("Date 1: " + first + "\tDate 2: " + second);
		System.out.println("\nTime between dates:");
		System.out.println(yearDiff + " year(s)\n" + monthDiff + " month(s)\n" + dayDiff + " day(s)");
		System.out.println("---------------------------------------------------------");
	}

}

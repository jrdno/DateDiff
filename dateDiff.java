import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateDiff {
	// counter that keeps track of which date we are collecting
	private int counter = 1;
	private Scanner sc;

	public DateDiff() {
		System.out.println("This program calculates the time between two dates.\n");
		sc = new Scanner(System.in);

		LocalDate dateOne = collectDate();
		LocalDate dateTwo = collectDate();
		sc.close();
		
		this.timeBetween(dateOne, dateTwo);
	}

	private LocalDate collectDate() {
		LocalDate date = null;
		
		// defining date format
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.print("Please enter Date #" + counter + " in the format MM/DD/YYYY: ");

		while (sc.hasNext()) {
			try {
				String input = sc.next();

				// parsing user input to get date in correct format
				date = LocalDate.parse(input, dateFormat);
				counter++;
				break;
			} catch (Exception e) {
				// this will catch errors and let user retry
				System.out.println("That is not a valid date. Please try again.\n");
				System.out.print("Please enter Date #" + counter + " in the format MM/DD/YYYY: ");
				continue;
			}
		}
		return date;
	}
	
	private void timeBetween(LocalDate first, LocalDate second) {
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

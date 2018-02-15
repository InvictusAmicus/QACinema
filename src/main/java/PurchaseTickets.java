import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class PurchaseTickets
{

    Scanner scan = new Scanner(System.in);

    public void addTicket()
    {
        System.out.println("What kind of ticket would you like to purchase?");

        if(LocalDate.now().getDayOfWeek().equals(DayOfWeek.WEDNESDAY))
        {
            System.out.println("Wednesday Deals! Every ticket £2 off!");
            System.out.println("Enter 1 for a Standard ticket - £6");
            System.out.println("Enter 2 for a OAP ticket - £4");
            System.out.println("Enter 3 for a Student ticket - £4");
            System.out.println("Enter 4 for a Child ticket - £2");
        }
        else
        {
            System.out.println("Enter 1 for a Standard ticket - £8");
            System.out.println("Enter 2 for a OAP ticket - £6");
            System.out.println("Enter 3 for a Student ticket - £6");
            System.out.println("Enter 4 for a Child ticket - £4");
        }
        int ticketType = scan.nextInt();

        if(ticketType > 1 && ticketType > 4)
        {
            System.out.println("Sorry, that ticket type doesn't exist.");
        }
        else
        {
            System.out.println("How many of these tickets would you like?");
            int ticketAmount = scan.nextInt();

            Ticket ticket = new Ticket(ticketType, ticketAmount);
            Order o = Order.getInstance();
            o.addTickets(ticket);
        }
    }

}

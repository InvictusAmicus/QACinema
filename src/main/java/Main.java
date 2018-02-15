import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to QA Cinemas");
        PurchaseTickets pt = new PurchaseTickets();
        pt.addTicket();

        boolean finishedBuying = false;
        while (!finishedBuying)
        {
            System.out.println("Would you like to buy any more tickets?\n Enter either Y or N to respond.");
            String response = scan.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
                pt.addTicket();
            }
            else if(response.equalsIgnoreCase("N"))
            {
                finishedBuying = true;
            }
            else
            {
                System.out.println("Sorry, that was an invalid option. Please try again.");
            }
        }
        Order o = Order.getInstance();
        System.out.println("The total cost of tickets for this movie is: " + o.calculatePriceOfOrder());

        scan.close();


    }
}

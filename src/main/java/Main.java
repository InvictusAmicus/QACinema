import java.util.Scanner;

public class Main
{
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {

        System.out.println("Welcome to QA Cinemas");

        System.out.println("Would you like to use our User Interface? Enter Y to confirm.");
        if(scan.nextLine().equalsIgnoreCase("Y"))
        {
            UserInterface ui = new UserInterface();
            ui.createScreen();
        }
        else {
            PurchaseTickets pt = new PurchaseTickets();
            pt.addTicket();

            boolean finishedBuying = false;
            while (!finishedBuying) {
                System.out.println("Would you like to buy any more tickets?\n Enter either Y or N to respond.");
                String response = scan.nextLine();
                if (response.equalsIgnoreCase("Y")) {
                    pt.addTicket();
                } else if (response.equalsIgnoreCase("N")) {
                    finishedBuying = true;
                } else {
                    System.out.println("Sorry, that was an invalid option. Please try again.");
                }
            }
            Order o = Order.getInstance();
            System.out.println("The total cost of tickets for this movie is: " + o.calculatePriceOfOrder());
        }

        scan.close();


    }
}

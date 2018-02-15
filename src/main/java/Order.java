import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order
{
    private static Order instance = null;
    private static List<Ticket> cart;

    private Order()
    {
        cart = new ArrayList<Ticket>();
    }

    public static Order getInstance()
    {
        if(instance == null)
        {
            instance = new Order();
        }
        return instance;
    }

    public void addTickets(Ticket t)
    {
        cart.add(t);
    }

    public int calculatePriceOfOrder()
    {
        int price = 0;
        for(int i = 0; i < cart.size(); i++)
        {
            if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.WEDNESDAY))
            {
                if (cart.get(i).ticketType == Ticket.Type.STANDARD)
                {
                    price += (6 * cart.get(i).amountOfTickets);
                }
                else if (cart.get(i).ticketType == Ticket.Type.OAP)
                {
                    price += (4 * cart.get(i).amountOfTickets);
                }
                else if (cart.get(i).ticketType == Ticket.Type.STUDENT)
                {
                    price += (4 * cart.get(i).amountOfTickets);
                }
                else if (cart.get(i).ticketType == Ticket.Type.CHILD)
                {
                    price += (2 * cart.get(i).amountOfTickets);
                }
            }
            else
            {
                if (cart.get(i).ticketType == Ticket.Type.STANDARD)
                {
                    price += (8 * cart.get(i).amountOfTickets);
                }
                else if (cart.get(i).ticketType == Ticket.Type.OAP)
                {
                    price += (6 * cart.get(i).amountOfTickets);
                }
                else if (cart.get(i).ticketType == Ticket.Type.STUDENT)
                {
                    price += (6 * cart.get(i).amountOfTickets);
                }
                else if (cart.get(i).ticketType == Ticket.Type.CHILD)
                {
                    price += (4 * cart.get(i).amountOfTickets);
                }
            }
        }
        return price;
    }

}

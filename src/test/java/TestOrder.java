import org.junit.Test;
import org.junit.Assert;

public class TestOrder
{
    @Test
    public void testPurchase()
    {
        Ticket twoStandardTickets = new Ticket(1, 2);
        Ticket oneChildTicket = new Ticket(4, 1);

        Order o = Order.getInstance();
        o.addTickets(twoStandardTickets);
        o.addTickets(oneChildTicket);

        Assert.assertEquals("Price does not add up", 20, o.calculatePriceOfOrder());
    }

    @Test
    public void testWednesdayPurchase()
    {
        Ticket twoStandardTickets = new Ticket(1, 2);
        Ticket oneChildTicket = new Ticket(4, 1);

        Order o = Order.getInstance();
        o.addTickets(twoStandardTickets);
        o.addTickets(oneChildTicket);

        Assert.assertEquals("Price does not add up", 14, o.calculatePriceOfOrder());
    }
}
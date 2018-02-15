public class Ticket
{

    enum Type
    {
        STANDARD,
        OAP,
        STUDENT,
        CHILD
    }
    public int amountOfTickets;
    public Type ticketType;

    Ticket(int type, int amountOfTickets)
    {
        if(type == 1)
        {
            ticketType = Type.STANDARD;
        }
        else if(type == 2)
        {
            ticketType = Type.OAP;
        }
        else if(type == 3)
        {
            ticketType = Type.STUDENT;
        }
        else if(type == 4)
        {
            ticketType = Type.CHILD;
        }

        this.amountOfTickets = amountOfTickets;
    }

}

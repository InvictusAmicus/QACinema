import javax.swing.*;
import java.awt.event.*;

public class UserInterface extends WindowAdapter
{
    JFrame frame = new JFrame("QA Cinema");

    JRadioButton standard = new JRadioButton("Standard", true);
    JRadioButton oap = new JRadioButton("OAP");
    JRadioButton student = new JRadioButton("Student");
    JRadioButton child = new JRadioButton("Child");
    ButtonGroup ticket = new ButtonGroup();

    public void createScreen()
    {
        frame.addWindowListener(new WindowAdapter()
        {
           public void windowClosing(WindowEvent e)
           {
               frame.dispose();
               System.exit(0);
           }
        });
        JPanel panel = new JPanel();
        JLabel greetingsLabel = new JLabel("Welcome to QA Cinemas");
        JLabel ticketType = new JLabel("Ticket Type: ");

        ticket.add(standard);
        ticket.add(oap);
        ticket.add(student);
        ticket.add(child);
        final JTextField amountOfTickets = new JTextField(5);

        JButton addTickets = new JButton("Add");
        addTickets.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Ticket t;
                if(Integer.parseInt(amountOfTickets.getText()) < 0)
                {
                    amountOfTickets.setText("0");
                }
                if (ticket.isSelected(standard.getModel()))
                {
                     t = new Ticket(1, Integer.parseInt(amountOfTickets.getText()));
                }
                else if (ticket.isSelected(oap.getModel()))
                {
                     t = new Ticket(2, Integer.parseInt(amountOfTickets.getText()));
                }
                else if (ticket.isSelected(student.getModel()))
                {
                     t = new Ticket(3, Integer.parseInt(amountOfTickets.getText()));
                }
                else
                {
                     t = new Ticket(4, Integer.parseInt(amountOfTickets.getText()));
                }
                Order o = Order.getInstance();
                o.addTickets(t);
                amountOfTickets.setText("");
            }
        });

        JButton confirmCost = new JButton("Pay");
        confirmCost.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Order o = Order.getInstance();
                int price = o.calculatePriceOfOrder();
                JOptionPane.showMessageDialog(frame, "Total price is: £" + price);
                o.clearCart();
            }
        });

        panel.add(greetingsLabel);
        panel.add(ticketType);
        panel.add(standard);
        panel.add(oap);
        panel.add(student);
        panel.add(child);
        panel.add(amountOfTickets);
        panel.add(addTickets);
        panel.add(confirmCost);
        frame.add(panel);

        frame.setSize(400,400);
        frame.setVisible(true);

    }
}

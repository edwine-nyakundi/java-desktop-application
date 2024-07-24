import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerManagementSystem extends JFrame {
    private ArrayList<Customer> customers;
    private JButton registerButton, orderButton, viewCustomersButton;

    public CustomerManagementSystem() {
        customers = new ArrayList<>();

        setTitle("Customer Management System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        registerButton = new JButton("Register Customer");
        orderButton = new JButton("Place Order");
        viewCustomersButton = new JButton("View Customers");

        panel.add(registerButton);
        panel.add(orderButton);
        panel.add(viewCustomersButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationForm(CustomerManagementSystem.this);
            }
        });

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerEmail = JOptionPane.showInputDialog("Enter Customer Email:");
                Customer customer = findCustomerByEmail(customerEmail);
                if (customer != null) {
                    new OrderForm(customer);
                } else {
                    JOptionPane.showMessageDialog(null, "Customer not found");
                }
            }
        });

        viewCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder customerList = new StringBuilder();
                for (Customer customer : customers) {
                    customerList.append(customer).append("\n");
                }
                JOptionPane.showMessageDialog(null, customerList.toString());
            }
        });

        add(panel);
        setVisible(true);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    private Customer findCustomerByEmail(String email) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }
}

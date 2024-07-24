import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderForm extends JFrame {
    private JTextField productField, quantityField;
    private JButton orderButton;

    public OrderForm(Customer customer) {
        setTitle("New Order");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        productField = new JTextField(15);
        quantityField = new JTextField(15);
        orderButton = new JButton("Place Order");

        panel.add(new JLabel("Product:"));
        panel.add(productField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);
        panel.add(orderButton);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String product = productField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                Order order = new Order(product, quantity);
                customer.addOrder(order);
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }
}


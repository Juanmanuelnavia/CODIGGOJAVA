import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Veterinaria {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel productPanel;

    public Veterinaria() {
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("Veterinaria - Página de Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(2, 3, 10, 10)); 

        String[][] products = {
                {"Bolsas de Comida", "comida"},
                {"Juguetería", "jugueteria"},
                {"Medicamentos", "medicamentos"},
                {"Productos de Limpieza", "limpieza"},
                {"Ropa para Mascotas", "ropa"},
                {"Collares", "collares"}
        };
        
        for (String[] product : products) {
            JPanel productCard = createProductCard(product[0]);
            productPanel.add(productCard);
        }
        mainPanel.add(productPanel, BorderLayout.CENTER);
        frame.setContentPane(mainPanel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
    
    private JPanel createProductCard(String productName) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel nameLabel = new JLabel(productName, JLabel.CENTER);
        JButton detailsButton = new JButton("Ver detalles");
        
        detailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showProductDetails(productName);
            }
        });

        card.add(nameLabel, BorderLayout.NORTH);
        card.add(detailsButton, BorderLayout.SOUTH);

        return card;
    }
    
    private void showProductDetails(String productName) {
        JFrame detailsFrame = new JFrame("Detalles del Producto");
        detailsFrame.setSize(400, 300);
        detailsFrame.setLayout(new BorderLayout());

        JLabel detailsLabel = new JLabel("Detalles de " + productName, JLabel.CENTER);
        detailsFrame.add(detailsLabel, BorderLayout.CENTER);

        JButton backButton = new JButton("Volver");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detailsFrame.dispose();
            }
        });

        detailsFrame.add(backButton, BorderLayout.SOUTH);
        detailsFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Veterinaria());
    }
}
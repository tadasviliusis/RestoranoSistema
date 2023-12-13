package presentation;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import model.modules.FoodOrder;
import model.modules.Menu;
import model.services.FoodOrderServices;

/**
 *
 * @author maxim
 */
public class MenuPage extends javax.swing.JFrame {
    List<FoodOrder> orders = new ArrayList<>();
    Map<String, Object> userInfo = new HashMap();
    int restaurantID;
    String restaurantName;
    
    double totalCost = 0;
    /**
     * Creates new form RestaurantsPage
     */
    public MenuPage(){
        Color col = new Color(204,204,204);
        getContentPane().setBackground(col);
        
    }

    public MenuPage(Map<String, Object> userInfo, int restaurantID, String restaurantName){
        try {
            generateOrderList(restaurantID, restaurantName);
        } catch (SQLException ex) {
            Logger.getLogger(MenuPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.userInfo = userInfo;
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        setLocationRelativeTo(null);
        this.setTitle("Menu Page");
        costLabel.setName("costLabel");
    }
 
    
    
    private int AddButton(int foodID,String foodname, double foodCost){
        
        for(FoodOrder order : orders){
            if(order.foodID() == foodID)
            {
                //System.out.println(foodCost);
                this.totalCost = this.totalCost + foodCost;
                //costLabel.setText(this.);
                order.setAmount(order.amount() + 1);
                order.setCost(order.cost() + foodCost);
                return 0;
            }
        }
        //System.out.println(totalCost);
        this.totalCost = this.totalCost + foodCost;
        //System.out.println(totalCost);
        orders.add(new FoodOrder(foodID, foodname, 1, foodCost));
        return 1;
    }
   
    
    private int SubtractButton(int foodID, double foodCost){
        int index = 0;
        boolean temp = false;
        for(FoodOrder order : orders){
            if(order.foodID() == foodID)
            {
                if(order.amount() > 1)
                {
                    //System.out.println(foodCost);
                    this.totalCost = this.totalCost - foodCost;
                    order.setAmount(order.amount() - 1);
                    return 0;
                }
                else
                {
                    index = orders.indexOf(order);
                    temp = true;
                    this.totalCost = this.totalCost - foodCost;
                }
            }
        }
        if(temp)
            orders.remove(index);
        return 1;
    }
    
    
    
    private void generateOrderList(int restaurantID, String restaurantName) throws SQLException{
        List<Menu> menu = FoodOrderServices.getRestaurantMenu(restaurantID);
        
        
        //
        setLayout(new BorderLayout()); // Set layout for the JFrame

        // Create a JPanel with a vertical BoxLayout to contain each item and its button
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));

        // Scroll Pane in case of many items
        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Panel to hold the scroll pane
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.add(scrollPane, BorderLayout.CENTER);
        containerPanel.setPreferredSize(new Dimension(375, 300)); // Set preferred size

        for (Menu dish : menu) {
            addItem(dish.ID(), dish.cost(), dish.name(), itemsPanel);
        }

        // Additional components
        JLabel header = new JLabel(restaurantName + " meniu", SwingConstants.CENTER);
        JButton checkoutButton = new JButton("Pirkti");
        checkoutButton.setName("proceedButton");
        JButton returnButton = new JButton("Atgal");
        returnButton.setName("backButton");
        
        returnButton.addActionListener(e -> {
            try {
                returnPress();
            } catch (SQLException ex) {
                Logger.getLogger(MenuPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        checkoutButton.addActionListener(e -> {
            checkoutPress();
        });
        
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        //bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Align to the right

        this.costLabel = new JLabel("Suma: " + new Formatter().format("%.2f", this.totalCost).toString());
        
        JLabel textLabel = new JLabel("Suma:");
        bottomPanel.add(returnButton, BorderLayout.WEST);
        bottomPanel.add(costLabel, BorderLayout.CENTER);
        //bottomPanel.add(costLabel, BorderLayout.CENTER); // Add to the left of the button
        bottomPanel.add(checkoutButton, BorderLayout.EAST);

        // Add the panels to the JFrame
        add(header, BorderLayout.NORTH);
        add(containerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        //add(checkoutButton, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        
    }
    
    private void checkoutPress(){
        if(orders.size() != 0)
        {
            int option = JOptionPane.showConfirmDialog(null, "Ar norite pristatymą į namus?", "Pristatymas", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                new DeliveryPage(userInfo, restaurantID, orders, restaurantName).setVisible(true);
                this.setVisible(false);
            } else {
                new CheckoutPage(userInfo, restaurantID, orders, restaurantName).setVisible(true);
                this.setVisible(false);
            }

        }
        else
            JOptionPane.showMessageDialog(null, "Jūsų užsakymas yra tusčias!");
    }
    
    private String newAmountAdd(int id,String foodname, double cost, String amount){
        AddButton(id, foodname, cost);
        this.costLabel.setText("Suma: " + new Formatter().format("%.2f", this.totalCost).toString());
        int temp = Integer.parseInt(amount);
        String newAmount = Integer.toString( temp + 1);
        return newAmount;
    }
    
    
    private String newAmountSubtract(int id, double cost, String amount){
        SubtractButton(id, cost);
        this.costLabel.setText(new Formatter().format("%.2f", this.totalCost).toString());
        if(costLabel.getText().charAt(0) == '-')
            this.costLabel.setText(costLabel.getText().substring(1));
        //System.out.println(totalCost);
        this.costLabel.setText("Suma: " + costLabel.getText());
        int temp = Integer.parseInt(amount);
        if(temp == 0)
            return Integer.toString( temp);
        else
            return Integer.toString( temp - 1);
    }

    
    private void returnPress() throws SQLException{
        new RestaurantsPage(userInfo).setVisible(true);
        this.setVisible(false);
    }
    
    private void addItem(int id, double cost,  String item, JPanel itemsPanel) {
        JPanel itemPanel = new JPanel(new BorderLayout());

    JLabel idLabel = new JLabel(Integer.toString( id));
    //idLabel.setVisible(false);
    
    Formatter formatter = new Formatter();
    formatter.format("%.2f", cost);
    
    JLabel itemLabel = new JLabel(item + " " + formatter.toString() + " Eur");
    itemLabel.setVerticalAlignment(SwingConstants.TOP);
    itemPanel.add(itemLabel, BorderLayout.WEST);

    // Create a new panel for the buttons
    JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton buyButton = new JButton("+");
    JLabel amountLabel = new JLabel("0");
    amountLabel.setName(item + "amountLabel");
    JButton subtractButton = new JButton("-");
    buyButton.setName(item + "+");
    subtractButton.setName(item + "-");
    buyButton.addActionListener(e -> amountLabel.setText(newAmountAdd(id, item, cost, amountLabel.getText())));
    subtractButton.addActionListener(e -> amountLabel.setText(newAmountSubtract(id, cost, amountLabel.getText())));

    buttonsPanel.add(subtractButton);
    buttonsPanel.add(amountLabel);
    buttonsPanel.add(buyButton);

    // Add the buttons panel to the right of the item panel
    itemPanel.add(buttonsPanel, BorderLayout.EAST);

    itemsPanel.add(itemPanel);
        
        
        
    }
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }
private javax.swing.JLabel costLabel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

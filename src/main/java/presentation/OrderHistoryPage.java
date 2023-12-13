/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
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

import model.modules.ClientOrder;
import model.modules.FoodOrder;
import model.services.FoodOrderServices;

/**
 *
 * @author viliu
 */
public class OrderHistoryPage extends javax.swing.JFrame {
    Map<String, Object> userInfo = new HashMap();
    List<ClientOrder> orders = new ArrayList<>();
    List<FoodOrder> ordersFood = new ArrayList<>();
    /**
     * Creates new form OrderHistoryPage
     */
    public OrderHistoryPage() {
        initComponents();
        Color col = new Color(204,204,204);
        getContentPane().setBackground(col);
        
    }
    
    public OrderHistoryPage(Map<String, Object> userInfo) throws SQLException {
        //initComponents();
        this.userInfo = userInfo;
        fillOrders();
        generateOrdersList();
        setLocationRelativeTo(null);
        this.setTitle("Order History Page");
    }

    
    private void fillOrders() throws SQLException{
        this.orders = FoodOrderServices.getOrders((int)userInfo.get("ID"));
    }
    
    
    
    
    private void openOrder(ClientOrder order){
        try {
            double totalCost = 0;
            ordersFood = FoodOrderServices.getFoodOrder((int)order.ID());
            
            String fullOrder = "Uzsakymas:\n"
                    + "Laikas: " + order.time().toString() + "\n"
                    + "Data: " + order.date().toString() + "\n"
                    + "Būsena: " + order.state().toString() + "\n";
                    fullOrder += " \n";
            
            fullOrder += "Patiekalai: \n";
            
            for(FoodOrder food : ordersFood){
                fullOrder += food.foodname() + "\n";
                fullOrder += "Kiekis: " + food.amount() + "\n";
                fullOrder += "Kaina: " + food.cost() + "\n";
                totalCost += food.cost();
                fullOrder += " \n";
            }
            
            if(order.deliveryID() != 0)
            {
                fullOrder += "Pristatymas į namus. \n";
                fullOrder += "Kaina: " + 2 + "\n";
                fullOrder += " \n";
                totalCost += 2;
            }
            
            
            fullOrder += "Suma: " + totalCost + "\n";
            
            
            
            
            
            if(order.state().equals("Vykdoma"))
            {
                
                Object[] options = { "Atšaukti", "OK" };
                int choice = JOptionPane.showOptionDialog(
                null,
                fullOrder,
                "Užsakymas",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

                if (choice == 0) {
                    FoodOrderServices.cancelOrder((int)order.ID());
                    order.setState("Atsauktas");
                    JOptionPane.showMessageDialog(null, "Užsakymas atšauktas.");

                } else if (choice == 1) {

                }  
            }
            else
                JOptionPane.showMessageDialog(null, fullOrder);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NOT SUCCESS");
        }
    }
    
    
    
        private void generateOrdersList() throws SQLException{
     
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

        for (ClientOrder order : orders) {
            addItem(order, itemsPanel);
        }

        // Additional components
        JLabel header = new JLabel("Uzsakymu istorija.", SwingConstants.CENTER);
        JButton returnButton = new JButton("Atgal");
        returnButton.addActionListener(e -> {
            try {
                returnPress();
            } catch (SQLException ex) {
                Logger.getLogger(RestaurantsPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
        
        //--------
        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(returnButton, BorderLayout.WEST);
        
        add(header, BorderLayout.NORTH);
        add(containerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        
    }
    
    
    private void addItem(ClientOrder order, JPanel itemsPanel) {
    JPanel itemPanel = new JPanel(new BorderLayout());

    JLabel itemLabel = new JLabel("Uzsakymas #" + order.ID());
    itemLabel.setVerticalAlignment(SwingConstants.TOP);
    itemPanel.add(itemLabel, BorderLayout.WEST);

    // Create a new panel for the buttons
    JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton orderButton = new JButton("Perziureti");
    
    
    
    orderButton.addActionListener(e -> {
        openOrder(order);
    });

    buttonsPanel.add(orderButton);

    // Add the buttons panel to the right of the item panel
    itemPanel.add(buttonsPanel, BorderLayout.EAST);

    itemsPanel.add(itemPanel);
        
        
        
    }
    
    
    private void returnPress() throws SQLException{
        new MainPage(userInfo).setVisible(true);
        this.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Užsakymai");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(264, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(OrderHistoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderHistoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderHistoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderHistoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderHistoryPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

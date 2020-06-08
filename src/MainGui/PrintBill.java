package MainGui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import Shops.OnlineStore;
import Shops.Outlet;
import Shops.Store;
import Payments.Card;
import Payments.Cash;
import Payments.OnlinePayment;
import Payments.Payment;
import com.company.*;

import Orders.OrderDetails;

import javax.swing.JTextPane;

public class PrintBill extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintBill frame = new PrintBill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrintBill() {
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane, BorderLayout.CENTER);
		
		
		String format = "%1$10s %2$-50s %3$-20s";

		textPane.setText("****************************************************Fee Recipt\n");
		//String s = "%-20s %-20s\n", "Total Quantity", "Total Price";
		String s = "Something has to be done";
		//textPane.setText(textPane.getText()+s);
		
		String someLine;
		someLine = String.format("%-20s %-20s\n", "Total Quantity", "Total Price");
		textPane.setText(textPane.getText()+someLine + "\n");
		
		/*textPane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});*/
		
		//OrderDetails order, Online on, ShoppingCart sCart, String paymode, Customer customer
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*System.out.println("****************************************************");
        System.out.printf("%30s\n%30s\n", storeVisited.getName(), storeVisited.getAddress());
        System.out.println("****************************************************");
        if (storeVisited instanceof Outlet) {
            Outlet outlet = (Outlet) storeVisited;
            System.out.printf("%38s\n", "Cashier Name: " + outlet.getCashierName());
        }
        System.out.printf("%30s","Date: "+order.getReceiveDate().toLocalDate());
        System.out.println("\n****************************************************");
        System.out.printf("%-20s %-10s %-10s %-10s\n", "Items", "Quantity", "Price", "Amount");
        System.out.println("****************************************************");

        HashMap<Item, OrderDetails> details = order.getDetails();
        int count = 0;
        for(Item item : details.keySet()) {
            System.out.printf("%-20s %-10s %-10s %-10s\n", item.getName(), details.get(item).getQuantity(),
                    item.getPrice(), details.get(item).getQuantity() * item.getPrice());
            count += details.get(item).getQuantity();
        }
        System.out.println("\n****************************************************");
        System.out.printf("%-20s %-20s\n", "Total Quantity", "Total Price");
        System.out.printf("%-20d %-20.2f\n", count, order.getTotalPrice());
        System.out.println(payment.getPaymentDetails());
        System.out.println("****************************************************");
        System.out.printf("%30s %s\n","Thanks for Shopping with", storeVisited.getName());
    
*/
		/*
					JFrame frame = new JFrame();
					frame.setBounds(30, 30, 500, 700);
					JLabel l1 = new JLabel("************************************************************************************************");
					JLabel l2 = new JLabel(Store.getName());
					l2.setFont(new Font(GuiClass.customer.storeVisited.getName(), Font.BOLD,30));
					JLabel l3 = new JLabel(GuiClass.customer.storeVisited.getAddress());
					JLabel l4 = new JLabel("Islamabad");
					JLabel l5 = new JLabel("Phn: +92-051-32557274");
					JLabel l6 = new JLabel("Retail invoice");
					JLabel l7 = new JLabel("************************************************************************************************");
					//JLabel l8 = new JLabel("Cashier ID: "+customer.address);
					//JLabel l9 = new JLabel("Order Date: "+order.orderDate);
					JLabel l91 = new JLabel("Cashier name: "+GuiClass.outlet.getCashierName()+"\n"+order.getReceiveDate().toLocalDate());
					JLabel l92 = new JLabel("Counter number: "+customer.phone);
					JLabel l10 = new JLabel("------------------------------------------------------------------------------------------------------------------------");
					JLabel l11 = new JLabel("S.No");
					JLabel l12 = new JLabel("Product");
					JLabel l13 = new JLabel("Qty");
					JLabel l14 = new JLabel("Rate");
					JLabel l15 = new JLabel("Amount");
					JLabel l21 = new JLabel("------------------------------------------------------------------------------------------------------------------------");
					JLabel l22 = new JLabel("Total:");
					JLabel l223 = new JLabel("Rs. "+order.total);
					JLabel l23 = new JLabel("Payment mode: "+paymode);
					JLabel l24 = new JLabel("------------------------------------------------------------------------------------------------------------------------");
					JLabel l25 = new JLabel("Thanks for shopping");
					JLabel l26 = new JLabel("Looking to see you again");
					
					l1.setBounds(0, 10, 500, 10);
					l2.setBounds(100, 20, 300, 40);
					l3.setBounds(185, 60, 80, 20);
					l4.setBounds(190, 85, 80, 20);
					l5.setBounds(160, 110, 150, 20);
					l6.setBounds(185, 135, 80, 20);
					l7.setBounds(0, 160, 500, 10);
					l8.setBounds(5, 170, 130, 20);
					l9.setBounds(270, 170, 200, 20);
					l91.setBounds(5, 195, 200, 20);
					l92.setBounds(270, 195, 200, 20);
					l10.setBounds(0, 220, 500, 10);
					l11.setBounds(5, 230, 40, 20);
					l12.setBounds(90, 230, 80, 20);
					l13.setBounds(210, 230, 40, 20);
					l14.setBounds(290, 230, 50, 20);
					l15.setBounds(380, 230, 50, 20);
					l21.setBounds(0, sCart.cart.size()*20 +263, 500, 10);
					l22.setBounds(5, sCart.cart.size()*20 +275, 110, 20);
					l223.setBounds(365, sCart.cart.size()*20 +275, 110, 20);
					l23.setBounds(5, sCart.cart.size()*20 +300, 180, 20);
					l24.setBounds(0, sCart.cart.size()*20 +325, 500, 10);
					l25.setBounds(170, sCart.cart.size()*20 +340, 130, 20);
					l26.setBounds(160, sCart.cart.size()*20 +365, 180, 20);
					
					
					for(int i=1;i<=sCart.cart.size();i++) {
						JLabel l16 = new JLabel(Integer.toString(i));
						JLabel l17 = new JLabel(sCart.cart.get(i-1));
						JLabel l18 = new JLabel(Integer.toString(sCart.qty.get(i-1)));
						JLabel l19 = new JLabel(Integer.toString(sCart.itemsCost.get(sCart.cart.get(i-1))));
						JLabel l20 = new JLabel(Integer.toString((sCart.qty.get(i-1)*sCart.itemsCost.get(sCart.cart.get(i-1)))));
						
						l16.setBounds(5, 250 + (i*20), 40, 20);
						l17.setBounds(90, 250 + (i*20), 80, 20);
						l18.setBounds(210, 250 + (i*20), 40, 20);
						l19.setBounds(290, 250 + (i*20), 40, 20);
						l20.setBounds(380, 250 + (i*20), 40, 20);
						
						 frame.add(l16);
						 frame.add(l17);
						 frame.add(l18);
						 frame.add(l19);
						 frame.add(l20);
					}
					
					 frame.setBackground(Color.WHITE);
					 frame.setLayout(null);
					 frame.setVisible(true);
					 frame.add(l1);
					 frame.add(l2);
					 frame.add(l3);
					 frame.add(l4);
					 frame.add(l5);
					 frame.add(l6);
					 frame.add(l7);
					 frame.add(l8);
					 frame.add(l9);
					 frame.add(l10);
					 frame.add(l11);
					 frame.add(l12);
					 frame.add(l13);
					 frame.add(l14);
					 frame.add(l15);
					 frame.add(l21);
					 frame.add(l22);
					 frame.add(l23);
					 frame.add(l24);
					 frame.add(l25);
					 frame.add(l26);
					 frame.add(l91);
					 frame.add(l92);
					 frame.add(l223);
					 
				   	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				   	 frame.setDefaultLookAndFeelDecorated(true);
				
			*/
			
			
		    
		    

	}
}





	
	
	

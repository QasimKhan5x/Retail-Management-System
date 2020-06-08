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


import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//5th Class
public class Options extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
	public void askDetails() {
		Item product = null;
		boolean found = false;
		String name = null;
	    double price = 0;
	    int quantity = 0;
		String tempname =
				JOptionPane.showInputDialog( "Enter Name of Item" );
		String tempquantity =
				JOptionPane.showInputDialog( "Enter Quantity of Item" );
		quantity= Integer.parseInt(tempquantity);
		
		for(Item item : Store.getInventory().keySet()) {
            if (item.getName().equals(tempname)) {
            	found = true;
                price = item.getPrice();
                product = item;
                break;
            }
        }
		 if (!found) {
             //System.out.println("The store doesn't have that item.");
             JOptionPane.showMessageDialog(null, "The store doesn't have that item." );
		 }
		 else if (quantity > Store.getInventory().get(product)) {
             //System.out.println("The store doesn't have that quantity.");
             JOptionPane.showMessageDialog(null, "The store doesn't have that quantity." );
		 }
		 else{
			 GuiClass.customer.addToCart(product, quantity);
			 JOptionPane.showMessageDialog(null, "Successfully added " + product);
		 }
     }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options frame = new Options();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Options() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("View Inventory");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowInventory showinventory = new ShowInventory();
				showinventory.setVisible(true);
		        dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(136, 47, 140, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Place your Order");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				askDetails();
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2_1.setBounds(136, 113, 140, 37);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Confirm Order");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChoosePaymentType choosepayment = new ChoosePaymentType();
				choosepayment.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2_2.setBounds(136, 180, 140, 37);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_2_1 = new JButton("BACK");
		btnNewButton_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPaymentMethod registerpayment = new RegisterPaymentMethod();
			}
		});
		btnNewButton_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2_2_1.setBounds(136, 257, 140, 37);
		contentPane.add(btnNewButton_2_2_1);
		
		
	}

}

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

//3rd class
class CreatingCustumer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private int index;

	
	public CreatingCustumer() {
		String []options = {"Outlet","Online"};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to "+Store.getName());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(114, 25, 297, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblYourName = new JLabel("Your Name");
		lblYourName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYourName.setBounds(34, 75, 151, 39);
		contentPane.add(lblYourName);
		
		JLabel lblHowWouldYou = new JLabel("Shopping Source");
		lblHowWouldYou.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHowWouldYou.setBounds(34, 125, 151, 39);
		contentPane.add(lblHowWouldYou);
		
		JComboBox comboBox = new JComboBox(options);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setBounds(195, 125, 166, 39);
		contentPane.add(comboBox);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.addItemListener(
						new ItemListener(){
							public void itemStateChanged(ItemEvent event){
								if(event.getStateChange() == ItemEvent.SELECTED){
									//System.out.println(" before Changed : "+index);
									index =comboBox.getSelectedIndex();
									//lblAmount_1.setText("Index: "+Integer.toString(index));
									//System.out.println("Index Changed : "+index);
								
								}
							}	//end method
						}
						);}
		});
		
		
		textField = new JTextField();
		textField.setBounds(195, 75, 166, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAlreadyRegisteredWallet = new JLabel("Register your payment account to proceed");
		lblAlreadyRegisteredWallet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlreadyRegisteredWallet.setBounds(34, 175, 356, 39);
		contentPane.add(lblAlreadyRegisteredWallet);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String choice= comboBox.getSelectedItem().toString();
				switch (choice){
				
				case "Outlet": {
					//System.out.println("Customer class created outlet");
					GuiClass.customer = new Customer(textField.getText(), "04532094", GuiClass.outlet);
					JOptionPane.showMessageDialog(null, "Outlet customer created. Now add payment method");
				}
					break;
				
				case "Online": {
					//System.out.println("Customer class created onlinestore");
					GuiClass.customer = new Customer(textField.getText(), "04532094", GuiClass.onlineStore);
					JOptionPane.showMessageDialog(null, "OnlineStore customer created. Now add payment method");
				    break;
                }
				default: {
					break;
				}
			}//end switch
				RegisterPaymentMethod registerpaymentmethod = new RegisterPaymentMethod();
				registerpaymentmethod.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(157, 225, 99, 39);
		contentPane.add(btnNewButton);
		
	
	}
}

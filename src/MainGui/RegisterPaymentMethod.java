package MainGui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Payments.Card;
import Payments.Cash;
import Payments.OnlinePayment;
import com.company.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

//4rth class
public class RegisterPaymentMethod extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	int index;

	ArrayList<String> methods = new ArrayList<>();

	
	public RegisterPaymentMethod() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddPaymentMethod = new JLabel("Add Payment Method Account");
		lblAddPaymentMethod.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddPaymentMethod.setBounds(89, 23, 261, 40);
		contentPane.add(lblAddPaymentMethod);
		
		JLabel lblAvailableOptions = new JLabel("Available Options");
		lblAvailableOptions.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAvailableOptions.setBounds(26, 70, 159, 40);
		contentPane.add(lblAvailableOptions);
		
		JComboBox comboBox = new JComboBox();
		
		
		/*
		comboBox.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						index =comboBox.getSelectedIndex();
						System.out.println(comboBox.getSelectedIndex());
					}	
				});
				
			*/
		
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Card", "Online"}));
		comboBox.setBounds(205, 74, 145, 32);
		contentPane.add(comboBox);
		
		
		
	
		
		
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmount.setBounds(50, 138, 109, 32);
		contentPane.add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(190, 140, 131, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setEnabled(false);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(50, 181, 109, 32);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(190, 183, 131, 32);
		contentPane.add(textField_1);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setEnabled(false);
 		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
 		lblPassword.setBounds(50, 224, 109, 32);
 		contentPane.add(lblPassword);
 		
 		textField_2 = new JTextField();
 		textField_2.setEnabled(false);
 		textField_2.setColumns(10);
 		textField_2.setBounds(190, 226, 131, 32);
 		contentPane.add(textField_2);
	
 		
 		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.addItemListener(
						new ItemListener(){
							public void itemStateChanged(ItemEvent event){
								if(event.getStateChange() == ItemEvent.SELECTED){
									index =comboBox.getSelectedIndex();
									if (index == 0 || index == 1) {
										lblEmail.setEnabled(false);
										textField_1.setEnabled(false);
										lblPassword.setEnabled(false);
										textField_2.setEnabled(false);
									}
									else {
										lblEmail.setEnabled(true);
										textField_1.setEnabled(true);
										lblPassword.setEnabled(true);
										textField_2.setEnabled(true);
										
									}
								}
							}	//end method
						}
						);}
		});
 		
 		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (methods.size() < 3) {
					String choice= comboBox.getSelectedItem().toString();
					//System.out.println(choice);
					if (methods.contains(choice)) {
						JOptionPane.showMessageDialog(null, "Warning: you have already added that method");
		                //System.out.println("You have already added that method");
		                choice = "";
		            }
					double amount;
					switch (choice){
						case "Cash": {
	                        methods.add(choice);
	                        amount = Double.parseDouble(textField.getText());
	                        GuiClass.customer.addPaymentMethod(new Cash(amount));
	                        JOptionPane.showMessageDialog(null, "Successfully created your wallet to your payment methods");
	                        //System.out.println("Successfully created your wallet");
	                        break;
	                    }
						case "Card": {
							methods.add(choice);
							amount = Double.parseDouble(textField.getText());
	                        GuiClass.customer.addPaymentMethod(new Card(amount, GuiClass.customer));
	                        JOptionPane.showMessageDialog(null, "Successfully added a card to your payment methods");
	                        //System.out.println("Successfully added a card to your payment methods");
	                        break;
						}
						case "Online": {
	                        methods.add(choice);
	                        amount = Double.parseDouble(textField.getText());
	                        String email = textField_1.getText();
	                        String password = textField_2.getText();
	                        GuiClass.customer.addPaymentMethod(new OnlinePayment(amount, email, password));
	                        JOptionPane.showMessageDialog(null, "Successfully added your online account to your payment methods");
	                        //System.out.println("Successfully created your online account");
	                        break;
	                    }
						default: {
							break;
						}
					
					}//end switch statement
				}//end if statement
				else {
					JOptionPane.showMessageDialog(null, "Already Added this account");					
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(89, 284, 89, 32);
		contentPane.add(btnAdd);
		
		JButton btnDone = new JButton("FINISH");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Options options = new Options();
				options.setVisible(true);
		        dispose();
			}
		});
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDone.setBounds(261, 284, 89, 32);
		contentPane.add(btnDone);
	
	
	}

}

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

//1st class
public class GuiClass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public static Customer customer;
    public static OnlineStore onlineStore;
    public static Outlet outlet;
	/*
	   Launch the application.
	 */
	
	
	public static void main(String[] args) {
		
		
		// seeting up round buttons and backgroud color
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				//JFrame.setDefaultLookAndFeelDecorated(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiClass frame = new GuiClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	   Create the frame.
	 */
	public GuiClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Store.setName(textField.getText());
		        String address = textField_1.getText();
		        String url = textField_2.getText();
		        String cashier = textField_3.getText();
		        Store.setRegister(Double.parseDouble(textField_4.getText()));
		        
		        
		        JOptionPane.showMessageDialog(null, "Store Successfully Added");
		        
		        AddInventory inventory = new AddInventory();
		        inventory.setVisible(true);
		        dispose();
		        
		        onlineStore = new OnlineStore(url);
		        outlet = new Outlet(address, cashier);
		        
			}
		});
		btnNewButton.setBounds(182, 375, 97, 42);
		contentPane.add(btnNewButton);
		
		
		JLabel lblHelloTherePlease = new JLabel("Hello There, Please Set Up An Outlet");
		lblHelloTherePlease.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHelloTherePlease.setBounds(51, 11, 385, 62);
		contentPane.add(lblHelloTherePlease);
		
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.set
			}
		});
		textField.setBounds(238, 98, 211, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Name of your Shop");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(27, 98, 173, 43);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		JLabel lblEnterAdressOf = new JLabel("Enter address of your Shop");
		lblEnterAdressOf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterAdressOf.setBounds(27, 152, 173, 43);
		contentPane.add(lblEnterAdressOf);
		
		textField_1 = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.setText(textField_1.getText());
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(238, 152, 211, 36);
		contentPane.add(textField_1);
		
		
		
		JLabel lblEnterUrlOf = new JLabel("Enter URL of your Shop");
		lblEnterUrlOf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterUrlOf.setBounds(27, 209, 173, 43);
		contentPane.add(lblEnterUrlOf);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(238, 209, 211, 36);
		contentPane.add(textField_2);
		
		
		
		JLabel lblEnterNameOf = new JLabel("Enter name of cashier");
		lblEnterNameOf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterNameOf.setBounds(27, 263, 173, 43);
		contentPane.add(lblEnterNameOf);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(238, 263, 211, 36);
		contentPane.add(textField_3);
		
		
		
		JLabel lblEnterYourBalance = new JLabel("Enter your balance registered");
		lblEnterYourBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterYourBalance.setBounds(27, 317, 190, 43);
		contentPane.add(lblEnterYourBalance);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(238, 317, 211, 36);
		contentPane.add(textField_4);
	}
}







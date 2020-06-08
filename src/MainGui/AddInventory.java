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


//2nd class
public class AddInventory extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	//HashMap<Item, Integer> inventory = new HashMap<>();

	public AddInventory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSetUpInventory = new JLabel("Seting Up Inventory");
		lblSetUpInventory.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSetUpInventory.setBounds(142, 22, 180, 38);
		contentPane.add(lblSetUpInventory);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
                double price = Double.parseDouble(textField_1.getText());
                int quantity = Integer.parseInt(textField_2.getText());
                Item item = new Item(name, price);
                Store.inventory.put(item, quantity);
                JOptionPane.showMessageDialog(null, "Item Added Successfully");
                AddInventory inventory = new AddInventory();
                inventory.setVisible(true);
                dispose();
			}
		});
		btnNewButton.setBounds(110, 250, 89, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DONE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Store.setInventory(Store.inventory);
				//Store.showInventory();
				JOptionPane.showMessageDialog(null, "Inventory Successfully Saved");
				CreatingCustumer custumer = new CreatingCustumer();
				custumer.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(268, 250, 89, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblItemsName = new JLabel("Item's Name ");
		lblItemsName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblItemsName.setBounds(46, 84, 110, 32);
		contentPane.add(lblItemsName);
		
		textField = new JTextField();
		textField.setBounds(180, 84, 153, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 134, 153, 31);
		contentPane.add(textField_1);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(46, 134, 110, 32);
		contentPane.add(lblPrice);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(180, 187, 153, 31);
		contentPane.add(textField_2);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantity.setBounds(46, 187, 110, 32);
		contentPane.add(lblQuantity);
	}
}

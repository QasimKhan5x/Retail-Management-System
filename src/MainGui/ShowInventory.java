package MainGui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.Arrays;
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

//6th Class
public class ShowInventory extends JFrame {

	private JPanel contentPane;
	private JTable table;

	//String [] column = {"Sr.no","Item","Price","Quantity"};
	
	int i=0;
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowInventory frame = new ShowInventory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ShowInventory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DefaultTableModel model = new DefaultTableModel(new String[] {"Sr.no","Item","Price","Quantity"},0);
		
		//DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model);
		/*model.addColumn("Sr.no");
		model.addColumn("Item");
		model.addColumn("Price");
		model.addColumn("Quantity");
		*/
		for(Item item : Store.inventory.keySet()) {
			i++;
			String name = item.getName();
			double price = item.getPrice();
			int value = Store.inventory.get(item); 
			
			String temp[]={Integer.toString(i),name,Double.toString(price),Integer.toString(value)};
			//System.out.println(temp);
		
			Object[] objArr = {temp}; // Array of String Arrays
			for (Object obj : objArr) {
			    if (obj instanceof String[]) {
			        String[] strArray = (String[]) obj;
			        //System.out.println(Arrays.toString(strArray));
			        model.addRow(strArray);
			        //rows = temp;
			    }
			}
			
		}
		
		table.setBounds(33, 5, 529, 300);
		//JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		//contentPane.add(table);
		
		contentPane.setLayout(new BorderLayout());
		contentPane.add(table.getTableHeader(), BorderLayout.PAGE_START);
		contentPane.add(table, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options options = new Options();
				options.setVisible(true);
		        dispose();
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
	}
}

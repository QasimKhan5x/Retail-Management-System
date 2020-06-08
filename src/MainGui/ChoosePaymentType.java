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

//7th Classs
public class ChoosePaymentType extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoosePaymentType frame = new ChoosePaymentType();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ChoosePaymentType() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAvailablePaymentOptions = new JLabel("Available Payment Options");
		lblAvailablePaymentOptions.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAvailablePaymentOptions.setBounds(101, 11, 254, 44);
		contentPane.add(lblAvailablePaymentOptions);
		
		JButton btnCash = new JButton("Cash");
		btnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Payment payment : GuiClass.customer.getPaymentMethods()) {
                    if (payment instanceof Cash) {
                    	if (!GuiClass.customer.canMakePayment(payment)) {
                    		JOptionPane.showMessageDialog(null, "Insufficient Balance for this order.");
                    	}
                    	else {
                            GuiClass.customer.makePaymentGui(payment);
                            
                        }
                    }
				}
			}
		});
		btnCash.setEnabled(true);
		btnCash.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCash.setBounds(145, 66, 108, 32);
		contentPane.add(btnCash);
		
		JButton btnCard = new JButton("Card");
		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Payment payment : GuiClass.customer.getPaymentMethods()) {
                    if (payment instanceof Card) {
                    	if (!GuiClass.customer.canMakePayment(payment)) {
                    		JOptionPane.showMessageDialog(null, "Insufficient Balance for this order.");
                    	}
                    	else {
                            GuiClass.customer.makePaymentGui(payment);
                            
                        }
                    }
				}
				
			}
		});
		btnCard.setEnabled(true);
		btnCard.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCard.setBounds(145, 118, 108, 32);
		contentPane.add(btnCard);
		
		JButton btnOnline = new JButton("Online");
		btnOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Payment payment : GuiClass.customer.getPaymentMethods()) {
                    if (payment instanceof OnlinePayment) {
                    	if (!GuiClass.customer.canMakePayment(payment)) {
                    		JOptionPane.showMessageDialog(null, "Insufficient Balance for this order.");
                    	}
                    	else {
                            GuiClass.customer.makePaymentGui(payment);
                            
                        }
                    }
				}
			}
		});
		btnOnline.setEnabled(true);
		btnOnline.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOnline.setBounds(145, 172, 108, 32);
		contentPane.add(btnOnline);
		
		JButton btnCash_2_1 = new JButton("BACK");
		btnCash_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options options = new Options();
				options.setVisible(true);
		        dispose();
			}
		});
		btnCash_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCash_2_1.setBounds(145, 244, 108, 32);
		contentPane.add(btnCash_2_1);
		
		if (GuiClass.customer.getStoreVisited() instanceof Outlet) {
            //System.out.println("Available options \"card\" and \"cash\"");
            btnOnline.setEnabled(false);
        } else {
            //System.out.println("Available options \"card\" and \"online\"");
            btnCash.setEnabled(false);
        }
		
		
	}

}

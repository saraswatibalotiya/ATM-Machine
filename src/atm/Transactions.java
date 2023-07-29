package atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{

	int account_id;
	JButton deposit , withdrawl , fastcash,miniStatement ,pinChange ,balanceEnquiry ,exit;
	Transactions(int account_id){
		
		this.account_id = account_id;
		System.out.println("Account _ id from transaction page : "+account_id);

		setLayout(null);
		
		final ImageIcon i1 = new ImageIcon("D:\\JAVA Project\\ATM\\src\\icons\\atm.jpg");		
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel  image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel ("Please select your Transactions");
		text.setBounds(220, 300, 700, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("Cash Withdawal");
		withdrawl.setBounds(355, 415, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(355, 450, 150, 30);
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		pinChange = new JButton("Pin Change");
		pinChange.setBounds(170, 485, 150, 30);
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		balanceEnquiry = new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(355, 485, 150, 30);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(355, 520, 150, 30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
				
		setSize(900,900);
		setLocation(300,0);
//		setUndecorated(true);
		setVisible(true);//always write this in last
	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== exit) {
			System.exit(0);
		}
		else if(e.getSource() == deposit) {
			System.out.println("Account _ id : "+account_id);
			setVisible(false);
			new deposit(account_id).setVisible(true);
		}
		else if(e.getSource() == withdrawl) {
			setVisible(false);
			new Withdrawl(account_id).setVisible(true);
		}
		else if(e.getSource() == fastcash) {
			setVisible(false);
			new FirstCash(account_id).setVisible(true);
		}
		else if(e.getSource() == pinChange) {
			setVisible(false);
			new pinChange(account_id).setVisible(true);
		}
		else if(e.getSource() == balanceEnquiry) {
			setVisible(false);
			new BalanceEnquiry(account_id).setVisible(true);
		}
		else if(e.getSource() == miniStatement) {
			setVisible(false);
			new MiniStatement(account_id).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Transactions(0);

	}
	

}

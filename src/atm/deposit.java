package atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;

public class deposit extends JFrame implements ActionListener {

	int account_id;
	JTextField amount ;
	JButton deposit,back;
	deposit(int account_id){
		this.account_id = account_id;
		System.out.println("Account _ id from deposit page : "+account_id);

		
		setLayout(null);
		
		final ImageIcon i1 = new ImageIcon("D:\\JAVA Project\\ATM\\src\\icons\\atm.jpg");		
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel  image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
				
		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.white);
		text.setBounds(170, 300, 400, 20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("System",Font.BOLD,22));
		amount.setBounds(170, 350, 320, 25);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(355, 485, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
	
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == deposit) {
			int amt = 0;
			int bal = 0;
			String amtText = "";
			amtText = amount.getText();
			
    		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date(0);
			if(amtText.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the Amount","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else {
				amt = Integer.parseInt(amtText);
				try {
					Conn conn = new Conn();
					String query1 = "insert into transaction(account_id,transaction_type,transaction_amount) values('"+account_id+"','Deposit','"+amt+"')";
					conn.s.executeUpdate(query1);
					
					String query2 = "select balance from AccountDetails where account_id = '"+account_id+"'";
					ResultSet rs;
					rs = conn.s.executeQuery(query2);
					if(rs.next()) {
						bal = rs.getInt(1);
					}
					int tot = bal + amt;
					
					String query3 = " update AccountDetails set balance =  '"+tot+"' where account_id = '"+account_id+"' ";
					conn.s.executeUpdate(query3);
					
					
					amount.setText("");
					JOptionPane.showMessageDialog(null, "Rs ."+amt+" Successfully Deposited !",null, JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					new Transactions(account_id).setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			
		}else if(e.getSource() == back) {
			setVisible(false);
			new Transactions(account_id).setVisible(true);
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new deposit(0);
	}


}

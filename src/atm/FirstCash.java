package atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class FirstCash extends JFrame implements ActionListener{

	int account_id;
	JButton r100 , r500 , r1000 ,r2000 , r5000 ,r10000 ,back;
	FirstCash(int account_id){
		
		this.account_id = account_id;
		System.out.println("Account _ id from transaction page : "+account_id);

		setLayout(null);
		
		final ImageIcon i1 = new ImageIcon("D:\\JAVA Project\\ATM\\src\\icons\\atm.jpg");		
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel  image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel (" Select Withdrawal Amount ");
		text.setBounds(230, 310, 700, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		r100 = new JButton("Rs 100");
		r100.setBounds(170, 415, 150, 30);
		r100.addActionListener(this);
		image.add(r100);
		
		r500 = new JButton("Rs 500");
		r500.setBounds(355, 415, 150, 30);
		r500.addActionListener(this);
		image.add(r500);
		
		r1000 = new JButton("Rs 1000");
		r1000.setBounds(170, 450, 150, 30);
		r1000.addActionListener(this);
		image.add(r1000);
		
		r2000 = new JButton("Rs 2000");
		r2000.setBounds(355, 450, 150, 30);
		r2000.addActionListener(this);
		image.add(r2000);
		
		r5000 = new JButton("Rs 5000");
		r5000.setBounds(170, 485, 150, 30);
		r5000.addActionListener(this);
		image.add(r5000);
		
		r10000 = new JButton("RS 10000");
		r10000.setBounds(355, 485, 150, 30);
		r10000.addActionListener(this);
		image.add(r10000);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
					
		setSize(900,900);
		setLocation(300,0);
//		setUndecorated(true);
		setVisible(true);//always write this in last
	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== back) {
			System.exit(0);
		}
		else {
			int bal = 0;
			String amtText = ((JButton)e.getSource()).getText().substring(3);
			int amt = Integer.parseInt(amtText);
			try {
				Conn conn = new Conn();
				
				String query2 = "select balance from AccountDetails where account_id = '"+account_id+"'";
				ResultSet rs;
				rs = conn.s.executeQuery(query2);
				if(rs.next()) {
					bal = rs.getInt(1);
				}
				
				if(amt >= bal) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance ","Alert", JOptionPane.WARNING_MESSAGE);
					return;
					
				}
				else {
					String query1 = "insert into transaction(account_id,transaction_type,transaction_amount) values('"+account_id+"','Withdrawal','"+amt+"')";
					conn.s.executeUpdate(query1);
					
					
					int tot = bal - amt;
					
					String query3 = " update AccountDetails set balance =  '"+tot+"' where account_id = '"+account_id+"' ";
					conn.s.executeUpdate(query3);
					
					JOptionPane.showMessageDialog(null, "Rs ."+amt+" Debited Successfully !",null, JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					new Transactions(account_id).setVisible(true);
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FirstCash(0);

	}
	

}

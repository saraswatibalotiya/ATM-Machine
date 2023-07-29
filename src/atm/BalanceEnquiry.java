package atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class BalanceEnquiry extends JFrame implements ActionListener{

	int account_id;
	JButton back;
	BalanceEnquiry(int account_id){
		this.account_id = account_id;
		int balance = 0;
		
		setLayout(null);
		
		final ImageIcon i1 = new ImageIcon("D:\\JAVA Project\\ATM\\src\\icons\\atm.jpg");		
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel  image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		try {
			String query = "select balance from AccountDetails where account_id ='"+account_id+"'";
			
			Conn conn = new Conn();			
			ResultSet rs;
			rs = conn.s.executeQuery(query);
			while(rs.next()) {
				balance = rs.getInt(1);
			}
						
		}
		catch(Exception e) {
			System.out.println(e);
		}
				
		JLabel text = new JLabel(" Your Current Account Balance is Rs "+balance);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.white);
		text.setBounds(190, 340, 500, 25);
		image.add(text);
	
		
		
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
		if(e.getSource()==back) {
			setVisible(false);
			new Transactions(account_id).setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BalanceEnquiry(0);

	}

	

}

package atm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener{

	int account_id ;
	MiniStatement(int account_id){
		this.account_id = account_id;
		
		setTitle("Mini Statement");
		setLayout(null);
		
		JLabel text = new JLabel("Bank Name");
		text.setBounds(150,20,100,20);
		add(text);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel l1 = new JLabel();
        add(l1);
        
        JLabel l4 = new JLabel();
        l4.setBounds(20, 500, 300, 20);
        add(l4);
        
		try {
			Conn conn = new Conn();
			ResultSet rs;
			rs = conn.s.executeQuery("select * from carddetails where account_id =  '"+account_id+"'");
			while(rs.next()) {
				card.setText("Card Number : "+rs.getString("card_number").substring(0,4)+"XXXXXXXX"+rs.getString("card_number").substring(12,16));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		 try{
	            Conn c1  = new Conn();
	            //'"+account_id+"'
	            ResultSet rs1 = c1.s.executeQuery("SELECT * FROM transaction where account_id =  '"+account_id+"' order by transaction_date desc limit 10");
	            while(rs1.next()){
	                l1.setText(l1.getText() + "<html>"+rs1.getString("transaction_date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("transaction_type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("transaction_amount") + "<br><br><html>");
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		 try{
	            int balance = 0;
	            Conn c1  = new Conn();
	            //'"+account_id+"'
	            ResultSet rs = c1.s.executeQuery("SELECT balance FROM accountDetails where account_id = '"+account_id+"'");
	            while(rs.next()){
		            l4.setText("Your total Balance is Rs "+rs.getInt(1));
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		
		 l1.setBounds(20, 140, 400, 300);
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 this.setVisible(false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiniStatement(0);
	}

	

}

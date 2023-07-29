package atm;

import java.awt.*;

import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.text.*;

import javax.swing.*;
import javax.swing.text.PlainDocument;

import java.util.*;


public class accountDetails extends JFrame implements ActionListener{
	
	JPasswordField pinPasswordField;
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	int cid ;
	JButton submit , cancel;
	
	accountDetails(int cid){
		
		this.cid = cid;
		
		setLayout(null);
		
		
		JLabel l1 = new JLabel("Customer Id : "+cid);
		l1.setFont(new Font("Raleway",Font.BOLD,24));
		l1.setBounds(80, 10, 200, 30);
		add(l1);
		
		JLabel l2 = new JLabel("Page 3 : Account Details");
		l2.setFont(new Font("Raleway",Font.BOLD,24));
		l2.setBounds(280, 60, 400, 40);
		add(l2);
		
		JLabel type = new JLabel("Account Type : ");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100, 140, 200, 30);
		add(type);
		
		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBackground(Color.white);
		r1.setBounds(100, 180, 150, 30);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBackground(Color.white);
		r2.setBounds(350, 180, 300, 30);
		add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBackground(Color.white);
		r3.setBounds(100, 220, 250, 20);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBackground(Color.white);
		r4.setBounds(350, 220, 250, 30);
		add(r4);
		
		ButtonGroup accountGroup = new ButtonGroup();
		accountGroup.add(r1);
		accountGroup.add(r2);
		accountGroup.add(r3);
		accountGroup.add(r4);
		
		
		JLabel card = new JLabel("Card Number : ");
		card.setFont(new Font("Raileway",Font.BOLD,22));
		card.setBounds(100,300,200,30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
		number.setFont(new Font("Raileway",Font.BOLD,18));
		number.setBounds(330,300,250,30);
		add(number);
		
		JLabel card_detail = new JLabel("Your 16 Digit Card Number");
		card_detail.setFont(new Font("Raileway",Font.BOLD,12));
		card_detail.setBounds(100,330,200,20);
		add(card_detail);
		
		JLabel pin = new JLabel("PIN : ");
		pin.setFont(new Font("Raileway",Font.BOLD,22));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		JLabel pin_detail = new JLabel("Your 4 Digit Password");
		pin_detail.setFont(new Font("Raileway",Font.BOLD,12));
		pin_detail.setBounds(100,400,200,20);
		add(pin_detail);
		
		pinPasswordField = new JPasswordField(4);
		
		PlainDocument document = (PlainDocument) pinPasswordField.getDocument();
	      document.setDocumentFilter(new DocumentFilter() {
	         @Override
	         public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	            String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
	               if (string.length() <= 4) {
	                  super.replace(fb, offset, length, text, attrs);
	               }
	         }
	      });
	      
	      
	    pinPasswordField.setFont(new Font("Raleway",Font.BOLD,20));
	    pinPasswordField.setBounds(330,370,300,30);
		add(pinPasswordField);
		
		
		JLabel services = new JLabel("Services Required : ");
		services.setFont(new Font("Raileway",Font.BOLD,22));
		services.setBounds(100,450,400,30);
		add(services);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setBackground(Color.white);
		c1.setFont(new Font("Raileway",Font.BOLD,16));
		c1.setBounds(100, 500, 200, 30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setFont(new Font("Raileway",Font.BOLD,16));
		c2.setBounds(350, 500, 200, 30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setFont(new Font("Raileway",Font.BOLD,16));
		c3.setBounds(100, 550, 200, 30);
		add(c3);
		
		c4 = new JCheckBox("Email & SMS Alert");
		c4.setBackground(Color.white);
		c4.setFont(new Font("Raileway",Font.BOLD,16));
		c4.setBounds(350, 550, 200, 30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.white);
		c5.setFont(new Font("Raileway",Font.BOLD,16));
		c5.setBounds(100, 600, 200, 30);
		add(c5);
		
		c6 = new JCheckBox("E - Statement");
		c6.setBackground(Color.white);
		c6.setFont(new Font("Raileway",Font.BOLD,16));
		c6.setBounds(350, 600, 200, 30);
		add(c6);
		
		c7 = new JCheckBox("I hereby Declare that the above entered details are correct in best of my knowledge");
		c7.setBackground(Color.white);
		c7.setFont(new Font("Raileway",Font.BOLD,12));
		c7.setBounds(100, 670, 600, 30);
		add(c7);
		
		
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raileway",Font.BOLD,14));
		submit.setBounds(250, 720, 100, 35);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raileway",Font.BOLD,14));
		cancel.setBounds(420, 720, 100, 35);
		cancel.addActionListener(this);
		add(cancel);
		
		
		
		getContentPane().setBackground(Color.white);	
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
	}
	
	public String randomCardNo() {
		Random random = new Random();
		String cardNo = ""+Math.abs((random.nextLong() % 90000000L)) + 5040936000000000L;
		return cardNo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== submit) {
			String  account_type = null;
			if ( r1.isSelected()) {
				account_type = "Saving Account";
			}
			else if (r2.isSelected()) {
				account_type = "Fixed Deposit Account";
			}
			else if (r3.isSelected()) {
				account_type = "Current Account";
			}
			else if (r4.isSelected()) {
				account_type = "Reccuring Deposit Account";
			}
			else if (r2.isSelected()) {
				account_type = "Fixed Deposit Account";
			}
			else if (r2.isSelected()) {
				account_type = "Fixed Deposit Account";
			}
			
			Random random = new Random();
						
	        long first3 = (random.nextLong() % 9000L) + 1000L;
	        String pin = new String(pinPasswordField.getPassword());
	        
	        String facility = "";
	        if(c1.isSelected()){ 
	            facility = facility + " ATM Card , ";
	        }
	        if(c2.isSelected()){ 
	            facility = facility + " Internet Banking ,";
	        }
	        if(c3.isSelected()){ 
	            facility = facility + " Mobile Banking ,";
	        }
	        if(c4.isSelected()){ 
	            facility = facility + " EMAIL Alerts ,";
	        }
	        if(c5.isSelected()){ 
	            facility = facility + " Cheque Book ,";
	        }
	        if(c6.isSelected()){ 
	            facility = facility + " E-Statement";
	        }
	        
	        try {
	        	if(account_type.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is Required","Alert",JOptionPane.WARNING_MESSAGE);
	        	}
	        	else {
					String cardNumber = null;
	        		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	        		Date date = new Date();
	        		System.out.println(date);
	        		
	        		Conn c = new Conn();
					String query1 = "insert into AccountDetails(customer_id,account_type,facility,opening_date,balance) values('"+cid+"','"+account_type+"','"+facility+"',current_date(),0)";
					
					c.s.executeUpdate(query1);		
					
					String query2 = "select account_id from AccountDetails order by account_id desc limit 1";
					int acc_id = 0;
					PreparedStatement st = c.c.prepareStatement(query2);
					
					ResultSet rs = st.executeQuery();
					while(rs.next()) {
						acc_id = rs.getInt(1);
						System.out.println("acc_id : "+acc_id);	
					}
					
					if(acc_id != 0) {
						//int check = uniqueCardNo(cardNumber);
						boolean cn = false;
						while(cn == false) {
							cardNumber = randomCardNo();
							cn = uniqueCardNo(cardNumber);
						}
						System.out.println(cardNumber);
						String query4 = "insert into CardDetails(account_id,card_number,pin) values('"+acc_id+"','"+cardNumber+"','"+pin+"')";
						c.s.executeUpdate(query4);	
					}
					
					JOptionPane.showMessageDialog(null, "Card No : "+cardNumber+"\n Pin : "+pin,null,JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					new Transactions(acc_id).setVisible(true);
					
	        	}
	        }
	        catch(Exception ae) {
	        	System.out.println(ae);
	        }
		}
		else {
			setVisible(false);
			new Login().setVisible(true);
		}
		
	}
	
	public boolean uniqueCardNo(String cardNumber) {
		String check_id = "";
		try {
			String query3 = "select card_id from CardDetails where card_number ='"+cardNumber+"'";
			
			Conn c = new Conn();			
			PreparedStatement st1 = c.c.prepareStatement(query3);
			
			ResultSet rs1 = st1.executeQuery();
			while(rs1.next()) {
				check_id = rs1.getString(1);
				System.out.println("check_id : "+check_id);	
			}
			
						
		}
		catch(Exception e) {
			System.out.println(e);
		}
		if(check_id != "") {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new accountDetails(0);
		// TODO Auto-generated method stub

	}



	

}

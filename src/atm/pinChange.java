package atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class pinChange extends JFrame implements ActionListener{

	int account_id ;
	JPasswordField newPin,renewPin;
	JButton change , back;
	pinChange(int account_id){
		this.account_id = account_id;
		System.out.println("Account _ id from pinchange page : "+account_id);

		
		setLayout(null);
		
		final ImageIcon i1 = new ImageIcon("D:\\JAVA Project\\ATM\\src\\icons\\atm.jpg");		
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel  image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
				
		JLabel text = new JLabel("CHANGE YOUR PIN ");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.white);
		text.setBounds(250, 280, 500, 25);
		image.add(text);
		
		JLabel pintext = new JLabel("NEW PIN : ");
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setForeground(Color.white);
		pintext.setBounds(175, 320, 180, 25);
		image.add(pintext);
		
		newPin = new JPasswordField();
		
		PlainDocument document = (PlainDocument) newPin.getDocument();
	      document.setDocumentFilter(new DocumentFilter() {
	         @Override
	         public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	            String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
	               if (string.length() <= 4) {
	                  super.replace(fb, offset, length, text, attrs);
	               }
	         }
	      });
	      
	      
		newPin.setFont(new Font("System",Font.BOLD,25));
		newPin.setBounds(330, 320, 180, 25);
		image.add(newPin);
		
		
		JLabel repintext = new JLabel("Re-Enter New PIN : ");
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setForeground(Color.white);
		repintext.setBounds(175, 360, 180, 25);
		image.add(repintext);
		
		renewPin = new JPasswordField();
		
		PlainDocument document1 = (PlainDocument) renewPin.getDocument();
	      document1.setDocumentFilter(new DocumentFilter() {
	         @Override
	         public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	            String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
	               if (string.length() <= 4) {
	                  super.replace(fb, offset, length, text, attrs);
	               }
	         }
	      });
	      
	      
	    renewPin.setFont(new Font("System",Font.BOLD,25));
		renewPin.setBounds(330, 360, 180, 25);
		image.add(renewPin);
		
		
		
		change = new JButton("Change");
		change.setBounds(355, 485, 150, 30);
		change.addActionListener(this);
		image.add(change);
		
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
		//String newpin,renewpin;
		if(e.getSource()==change) {
			
			String newpin = new String(newPin.getPassword());
			String renewpin = new String (renewPin.getPassword());
			System.out.println("New Pin : "+newpin+" , Renew Pin : "+renewpin);
			
			if(newpin.equals("") || renewpin.equals("")) {
				JOptionPane.showMessageDialog(null, " Please Enter Pin . ","Alert", JOptionPane.WARNING_MESSAGE); 
				newPin.setText("");
				renewPin.setText("");
				return;
			}
			
			if(!(newpin.equals(renewpin))) {
				JOptionPane.showMessageDialog(null, " Pin do not match . ","Alert", JOptionPane.WARNING_MESSAGE); 
				newPin.setText("");
				renewPin.setText("");
				return;
			}
			else {
				try {
					Conn conn = new Conn();
					
					String query = " update cardDetails set pin ='"+renewpin+"' where account_id = '"+account_id+"' ";
					conn.s.executeUpdate(query);

					newPin.setText("");
					renewPin.setText("");
					JOptionPane.showMessageDialog(null, " Pin Changed Successfully ! ",null, JOptionPane.INFORMATION_MESSAGE); 

					setVisible(false);
					new Login().setVisible(true);
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		}
		else if(e.getSource() == back) {
			setVisible(false);
			new Transactions(account_id).setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new pinChange(0);
	}

	
}

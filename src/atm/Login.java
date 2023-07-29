package atm;
import java.awt.*;
import java.awt.event.*;//For action Listener
import java.sql.ResultSet;

import javax.swing.*; //all package of swing
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class Login extends JFrame implements ActionListener{
	
	//Globally defining button,textField to use them in different methods
	JButton loginBtn,signUpBtn,clearBtn,pinCreateBtn;
	JTextField cardnoTextField;
	JPasswordField pinTextField;
	Login(){
		
		setTitle("Automated Teller Machine");

		setLayout(null);//to change layout of image or text default layout need to be null
		
		final ImageIcon i1 = new ImageIcon("D:\\JAVA Project\\ATM\\src\\icons\\logo.jpg");		
		
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		//to place icon in frame we need to pass it in JLabel
		JLabel logoLabel = new JLabel(i3);
		logoLabel.setBounds(70,10,100,100);//Distance left , up , height , weight
		
		add(logoLabel);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200, 40, 400, 40);
		add(text);
		
		JLabel cardno = new JLabel("Card No : ");
		cardno.setFont(new Font("Raieway",Font.BOLD,28));
		cardno.setBounds(120, 150, 150, 30);
		add(cardno);
		
		cardnoTextField = new JTextField();
		cardnoTextField.setBounds(300,150,250,30);
		cardnoTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardnoTextField);
		
		JLabel pin = new JLabel("Pin : ");
		pin.setFont(new Font("Raieway",Font.BOLD,28));
		pin.setBounds(120, 220, 150, 40);
		add(pin);
		
		pinTextField = new JPasswordField();
		
		PlainDocument document = (PlainDocument) pinTextField.getDocument();
	      document.setDocumentFilter(new DocumentFilter() {
	         @Override
	         public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	            String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
	               if (string.length() <= 4) {
	                  super.replace(fb, offset, length, text, attrs);
	               }
	         }
	      });
	      
		pinTextField.setBounds(300,220,250,30);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		loginBtn = new JButton("SIGN IN");
		loginBtn.setBounds(300,300,100,30);
		loginBtn.setBackground(Color.black);
		loginBtn.setForeground(Color.white);
		loginBtn.addActionListener(this);
		add(loginBtn);
		
		clearBtn = new JButton("CLEAR");
		clearBtn.setBounds(450,300,100,30);
		clearBtn.setBackground(Color.black);
		clearBtn.setForeground(Color.white);
		clearBtn.addActionListener(this);
		add(clearBtn);
		
		signUpBtn = new JButton("SIGN UP");
		signUpBtn.setBounds(300,350,250,30);
		signUpBtn.setBackground(Color.black);
		signUpBtn.setForeground(Color.white);
		signUpBtn.addActionListener(this);
		add(signUpBtn);
		
		pinCreateBtn = new JButton("Generate PIN ");
		pinCreateBtn.setBounds(325,400,200,30);
		pinCreateBtn.setBackground(Color.black);
		pinCreateBtn.setForeground(Color.white);
		pinCreateBtn.addActionListener(this);
		add(pinCreateBtn);
		
		
		getContentPane().setBackground(Color.white);
		
		
		setSize(800,480);//dimension of frame
		setVisible(true);
		setLocation(350,200); //350 from left , 200 from up
		
	}
	//ActionPerformed is just declare in action listener which is abstract method so we need to override it .
	//ActionPerformed tell what to do if button clicked
	public void actionPerformed(ActionEvent ae) {
		
		if(pinTextField.getText()=="" && cardnoTextField.getText()=="") {
			JOptionPane.showMessageDialog(null, "Enter the Credentials","Alert",JOptionPane.WARNING_MESSAGE);
		}
		if(ae.getSource() == clearBtn) {
			pinTextField.setText("");
			cardnoTextField.setText("");
		}
		else if(ae.getSource()== loginBtn) {
			int account_id;
			try {
				Conn conn = new Conn();
				String cardnumber = cardnoTextField.getText();
				String pinNumber = pinTextField.getText();
				
				String query = "select account_id from cardDetails where card_number = '"+cardnumber+"' and pin =  '"+pinNumber+"' ";
				
				ResultSet rs = conn.s.executeQuery(query);
				if(rs.next()) {
					account_id = rs.getInt(1);
					System.out.println("Account _ id from login page : "+account_id);
					setVisible(false);
					new Transactions(account_id).setVisible(true);;
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Credentials","Alert",JOptionPane.WARNING_MESSAGE);
					pinTextField.setText("");
					cardnoTextField.setText("");
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			
			
		}
		else if(ae.getSource() == signUpBtn) {
			setVisible(false);
			new SignUpOne().setVisible(true);
		}
		else if(ae.getSource()==pinCreateBtn) {
			setVisible(false);
			new ask_CustId().setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		new Login();//object created it will run then constructor called
	}
	

}

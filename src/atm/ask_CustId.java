package atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ask_CustId  extends JFrame implements ActionListener {
	
	JTextField custidTextField;

	JButton submitBtn;
	
	
	ask_CustId(){
		
		setTitle("Automated Teller Machine");

		setLayout(null);//to change layout of image or text default layout need to be null
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200, 40, 400, 40);
		add(text);
		
		JLabel cardno = new JLabel("Enter Your Customer Id : ");
		cardno.setFont(new Font("Raieway",Font.BOLD,22));
		cardno.setBounds(100, 150, 300, 30);
		add(cardno);
		
		custidTextField = new JTextField();
		custidTextField.setBounds(400,150,250,30);
		custidTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(custidTextField);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(300,250,150,40);
		submitBtn.setBackground(Color.black);
		submitBtn.setForeground(Color.white);
		submitBtn.addActionListener(this);
		add(submitBtn);
		
		
		getContentPane().setBackground(Color.white);
		setSize(800,480);//dimension of frame
		setVisible(true);
		setLocation(350,200); //350 from left , 200 from up
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		int customer_id = 0;
		int custid = 0;
		custid = Integer.parseInt(custidTextField.getText()); //get values from field
		if(ae.getSource() == submitBtn) {
			try {
				if (custid == 0) {
					JOptionPane.showMessageDialog(null, "Customer Id is Required","Alert",JOptionPane.WARNING_MESSAGE);
				}
				else {
					Conn c = new Conn();
					String query = "Select customer_id from customer where customer_id='"+custid+"'";
					PreparedStatement st = c.c.prepareStatement(query);
					
					ResultSet rs = st.executeQuery();
					while(rs.next()) {
						customer_id = rs.getInt(1);
					}
					if(customer_id == 0) {
						JOptionPane.showMessageDialog(null, "Wrong Customer Id","Alert",JOptionPane.WARNING_MESSAGE);
						custidTextField.setText("");
					}
					else {
						setVisible(false);
						new accountDetails(customer_id).setVisible(true);
					}
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ask_CustId();

	}
	
}

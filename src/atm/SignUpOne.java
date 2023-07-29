package atm;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener{
	
	static int id;
	JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,stateTextField,cityTextField,pinCodeTextField;
	JRadioButton male , female , other , married,unmarried;
	JButton next;
	JDateChooser dateChooser;
	
	public static int userid()
    {
        return id;
    }
	
	SignUpOne(){
		
		setLayout(null);
		
		try {
			Conn c = new Conn();
			String query = "Select customer_id from customer order by customer_id DESC limit 1";
			PreparedStatement st = c.c.prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				id = rs.getInt(1)+1;
				System.out.println(id);	
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel formno = new JLabel("APPLICATION FORM NO. "+(id));
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1 : Personal Details ");
		personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		personalDetails.setBounds(290, 80, 400, 30);
		add(personalDetails);
		
		JLabel name = new JLabel("Name : ");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		
		JLabel fname = new JLabel("Father's Name : ");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway",Font.BOLD,20));
		fnameTextField.setBounds(300,190,400,30);
		add(fnameTextField);
		
		
		JLabel dob = new JLabel("Date Of Birth : ");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender : ");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100, 290, 100, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 290, 100, 30);
		male.setBackground(Color.white);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450,290,100,30);
		female.setBackground(Color.white);
		add(female);
		
		other = new JRadioButton("Other");
		other.setBounds(600,290,100,30);
		other.setBackground(Color.white);
		add(other);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		genderGroup.add(other);
		
		
		
		JLabel email = new JLabel("Email Address : ");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100, 340, 200, 30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
		emailTextField.setBounds(300,340,400,30);
		add(emailTextField);
		
		
		JLabel marital = new JLabel("Marital Status : ");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.white);
		add(married);
		
		unmarried = new JRadioButton("UnMarried");
		unmarried.setBounds(450,390,100,30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		
		
		JLabel address = new JLabel("Address : ");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100, 440, 100, 30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
		addressTextField.setBounds(300,440,400,30);
		add(addressTextField);
		
		JLabel city = new JLabel("City : ");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100, 490, 100, 30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
		cityTextField.setBounds(300,490,400,30);
		add(cityTextField);
		
		JLabel state = new JLabel("State : ");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100, 540, 100, 30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway",Font.BOLD,20));
		stateTextField.setBounds(300,540,400,30);
		add(stateTextField);
		
		JLabel pinCode = new JLabel("Pin Code : ");
		pinCode.setFont(new Font("Raleway",Font.BOLD,20));
		pinCode.setBounds(100, 590, 200, 30);
		add(pinCode);
		
		pinCodeTextField = new JTextField();
		pinCodeTextField.setFont(new Font("Raleway",Font.BOLD,20));
		pinCodeTextField.setBounds(300,590,400,30);
		add(pinCodeTextField);
		
		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String fromno = "",random; //long
		String name = nameTextField.getText(); //get values from field
		String father_name = fnameTextField.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}
		else if(female.isSelected()) {
			gender = "Female";
		}
		else if(other.isSelected()) {
			gender = "Other";
		}
		String email = emailTextField.getText();
		String marital_status = null;
		if(married.isSelected()) {
			marital_status = "Married";
		}
		else if(unmarried.isSelected()) {
			marital_status = "Unmarried";
		}
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pincode = pinCodeTextField.getText();
		
		try {
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(father_name.equals("")) {
				JOptionPane.showMessageDialog(null, "Father Name is Required","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(dob.equals("")) {
				JOptionPane.showMessageDialog(null, "Date of Birth is Required","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(gender.equals("")) {
				JOptionPane.showMessageDialog(null, "Gender is Required","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(email.equals("")) {
				JOptionPane.showMessageDialog(null, "Email is Required","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(marital_status.equals("")) {
				JOptionPane.showMessageDialog(null, "Marital Status is Required","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(address.equals("")) {
				JOptionPane.showMessageDialog(null, "Address is Required","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(city.equals("")) {
				JOptionPane.showMessageDialog(null, "City is Required","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(state.equals("")) {
				JOptionPane.showMessageDialog(null, "State is Required","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(pincode.equals("")) {
				JOptionPane.showMessageDialog(null, "Pin Code is Required","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else {
				Conn c = new Conn();
				String query = "insert into customer(customer_id,name,father_name,dob,gender,email,marital_status,address,city,pincode,state) values('"+id+"','"+name+"','"+father_name+"','"+dob+"','"+gender+"','"+email+"','"+marital_status+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignUpTwo(id).setVisible(true);
			}
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.print(name);
			System.out.print(father_name);
			System.out.print(dob);
			System.out.print(gender);
			System.out.print(email);
			System.out.print(marital_status);
			System.out.print(address);
			System.out.print(city);
			System.out.print(pincode);
			System.out.print(state);
		}
		
		
//		if (authenticateUser(username, password)) {
//            UserSession.getInstance().setCurrentUser(new User(username));
//            // Open the main application window or perform other actions
//        } else {
//            JOptionPane.showMessageDialog(LoginFrame.this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
//        }

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUpOne();

	}

}

package atm;

import java.awt.*;

import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener{
	
	JTextField panTextField,aadharTextField,seniorCitizenTextField,existing_accountTextField;
	JRadioButton syes , sno ,eyes ,eno ;
	JButton next;
	int cid;
	JComboBox religionCombo ,categoryCombo ,incomeCombo ,eduCombo ,occupationCombo;
	JDateChooser dateChooser;
	
	SignUpTwo(int id){
		setLayout(null);
		
		this.cid = id;
		
		JLabel formno = new JLabel("APPLICATION FORM NO. "+(id));
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);

		
		JLabel additionalDetails = new JLabel("Page 2 : Personal Details ");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		JLabel religion = new JLabel("Religion : ");
		religion.setFont(new Font("Raleway",Font.BOLD,20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);
		
		String valRegligion[] = {"Select Religion","Hindu","Muslim","Sikh","Christian","Other"};
		religionCombo = new JComboBox(valRegligion);
		religionCombo.setBackground(Color.white);
		religionCombo.setBounds(300, 140, 400, 30);
		add(religionCombo);
		
		JLabel category = new JLabel("Category : ");
		category.setFont(new Font("Raleway",Font.BOLD,20));
		category.setBounds(100,190,200,30);
		add(category);
		
		String valcategory[] = {"Select Category","General","OBC","SC","ST","Other"};
		categoryCombo = new JComboBox(valcategory);
		categoryCombo.setBackground(Color.white);
		categoryCombo.setBounds(300, 190, 400, 30);
		add(categoryCombo);
		
		JLabel income = new JLabel("Income : ");
		income.setFont(new Font("Raleway",Font.BOLD,20));
		income.setBounds(100,240,200,30);
		add(income);
		
		String valincome[] = {"Select Income","< 1,50,000","< 5,00,000","< 10,00,000"," > 10,00,000"};
		incomeCombo = new JComboBox(valincome);
		incomeCombo.setBackground(Color.white);
		incomeCombo.setBounds(300, 240, 400, 30);
		add(incomeCombo);
		
		
		JLabel education = new JLabel("Educational ");
		education.setFont(new Font("Raleway",Font.BOLD,20));
		education.setBounds(100, 290, 200, 30);
		add(education);
		
		JLabel qualification = new JLabel("Qualification : ");
		qualification.setFont(new Font("Raleway",Font.BOLD,20));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);
		
		String eduval[] = {"Select your Educational Qualification","Non-Graduate","Graduate","Post Graudate","Doctrate","Others"};
		eduCombo = new JComboBox(eduval);
		eduCombo.setBackground(Color.white);
		eduCombo.setBounds(300, 315, 400, 30);
		add(eduCombo);
		
		
		JLabel occupation = new JLabel("Occupation : ");
		occupation.setFont(new Font("Raleway",Font.BOLD,20));
		occupation.setBounds(100, 390, 200, 30);
		add(occupation);
		
	
		String occupationVal[] = {"Select your occupation","Salaried","Self - Employed ","Bussiness","Student","Salaried","Others"};
		occupationCombo = new JComboBox(occupationVal);
		occupationCombo.setBackground(Color.white);
		occupationCombo.setBounds(300, 390, 400, 30);
		add(occupationCombo);
		
		
		JLabel pan = new JLabel("Pan No : ");
		pan.setFont(new Font("Raleway",Font.BOLD,20));
		pan.setBounds(100, 440, 200, 30);
		add(pan);
		
		panTextField = new JTextField();
		panTextField.setFont(new Font("Raleway",Font.BOLD,20));
		panTextField.setBounds(300,440,400,30);
		add(panTextField);
		
		
		JLabel aadhar = new JLabel("Aadhar Number : ");
		aadhar.setFont(new Font("Raleway",Font.BOLD,20));
		aadhar.setBounds(100, 490, 200, 30);
		add(aadhar);
		
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Raleway",Font.BOLD,20));
		aadharTextField.setBounds(300,490,400,30);
		add(aadharTextField);
		
		JLabel seniorCitizen = new JLabel("Senior Citizen : ");
		seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
		seniorCitizen.setBounds(100, 540, 200, 30);
		add(seniorCitizen);
		
		syes = new JRadioButton("YES");
		syes.setBounds(300,540,100,30);
		syes.setBackground(Color.white);
		add(syes);
		
		sno = new JRadioButton("NO");
		sno.setBounds(450,540,100,30);
		sno.setBackground(Color.white);
		add(sno);
		
		ButtonGroup seniorGroup = new ButtonGroup();
		seniorGroup.add(syes);
		seniorGroup.add(sno);
		
		
		JLabel existing_account = new JLabel("Existing Account : ");
		existing_account.setFont(new Font("Raleway",Font.BOLD,20));
		existing_account.setBounds(100, 590, 200, 30);
		add(existing_account);
		
		eyes = new JRadioButton("YES");
		eyes.setBounds(300,590,100,30);
		eyes.setBackground(Color.white);
		add(eyes);
		
		eno = new JRadioButton("NO");
		eno.setBounds(450,590,100,30);
		eno.setBackground(Color.white);
		add(eno);
		
		ButtonGroup existGroup = new ButtonGroup();
		existGroup.add(eyes);
		existGroup.add(eno);
	
		
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

	@Override
	public void actionPerformed(ActionEvent e) {

		String religion = (String)religionCombo.getSelectedItem(); //get values from combo box
		String category = (String)categoryCombo.getSelectedItem();
		String income = (String)incomeCombo.getSelectedItem();
		String education = (String)eduCombo.getSelectedItem();
		String occupation = (String)occupationCombo.getSelectedItem();
	
		String pan = panTextField.getText();
		String aadhar = aadharTextField.getText();
		
		String senior_citizen = null;
		if(syes.isSelected()) {
			senior_citizen = "Yes";
		}
		else if(sno.isSelected()) {
			senior_citizen = "No";
		}
		
		String existing_account = null;
		if(eyes.isSelected()) {
			existing_account = "Yes";
		}
		else if(eno.isSelected()) {
			existing_account = "No";
		}

		try {
			if(pan.equals("")) {
				JOptionPane.showMessageDialog(null, "Pancard Number is Required","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(aadhar.equals("")) {
				JOptionPane.showMessageDialog(null, "Aadhar Number is Required","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else {
				Conn c = new Conn();
				String query = "insert into PersonalDetails values('"+cid+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior_citizen+"','"+existing_account+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new accountDetails(cid).setVisible(true);
			}
			
		}catch(Exception e1) {
			System.out.println(e1);
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUpTwo(0);

	}

	

}

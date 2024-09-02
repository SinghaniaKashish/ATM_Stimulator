package atm.stimulator;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nametf, fnametf, emailtf, addresstf, citytf, statetf, pincodetf;
    JButton next;
    JDateChooser datedob;
    JRadioButton others, male, female, married, unmarried;
    
    SignupOne(){
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+10000L);
        
        //application number
        JLabel formno = new JLabel("APPLICATION FORM No. "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 35));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1 : Personal Details ");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 25));
        personalDetails.setBounds(250,80,400,40);
        add(personalDetails);
        
        
        //name
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Raleway", Font.BOLD, 17));
        name.setBounds(200,150,100,30);
        add(name);
        
        nametf = new JTextField();
        nametf.setFont(new Font("Raleway", Font.BOLD, 15));
        nametf.setBounds(400, 150,250,30);
        add(nametf);
        
        
        //Fathers name
        JLabel fname = new JLabel("Father's Name");
        fname.setFont(new Font("Raleway",Font.BOLD, 17));
        fname.setBounds(200,190,200,30);
        add(fname);
        
        fnametf = new JTextField();
        fnametf.setFont(new Font("Raleway", Font.BOLD, 15));
        fnametf.setBounds(400, 190,250,30);
        add(fnametf);
        
        
        //date of birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Raleway",Font.BOLD, 17));
        dob.setBounds(200,230,200,30);
        add(dob);
        
        datedob = new JDateChooser();
        datedob.setBounds(400,230,250,30);
        add(datedob);
        
        
        //Gender
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD, 17));
        gender.setBounds(200,270,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(400,270,70,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(475,270,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        //email
        JLabel email = new JLabel("Email Address");
        email.setFont(new Font("Raleway",Font.BOLD, 17));
        email.setBounds(200,310,200,30);
        add(email);
        
        emailtf = new JTextField();
        emailtf.setFont(new Font("Raleway", Font.BOLD, 15));
        emailtf.setBounds(400, 310,250,30);
        add(emailtf);
        
        
        //marital sattus
        JLabel maritalstatus = new JLabel("Marital Status");
        maritalstatus.setFont(new Font("Raleway",Font.BOLD, 17));
        maritalstatus.setBounds(200,350,200,40);
        add(maritalstatus);
        
        married = new JRadioButton("Married");
        married.setBounds(400,350,70,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(475,350,90,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        others = new JRadioButton("Others");
        others.setBounds(580,350,100,30);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup maritalstatusgroup = new ButtonGroup();
        maritalstatusgroup.add(married);
        maritalstatusgroup.add(unmarried);
        maritalstatusgroup.add(others);
       
        
        //Address
        JLabel address = new JLabel("Address");
        address.setFont(new Font("Raleway",Font.BOLD, 17));
        address.setBounds(200,390,200,30);
        add(address);
        
        addresstf = new JTextField();
        addresstf.setFont(new Font("Raleway", Font.BOLD, 15));
        addresstf.setBounds(400, 390,250,30);
        add(addresstf);
        
        //city
        JLabel city = new JLabel("City");
        city.setFont(new Font("Raleway",Font.BOLD, 17));
        city.setBounds(200,430,200,30);
        add(city);
        
        citytf = new JTextField();
        citytf.setFont(new Font("Raleway", Font.BOLD, 15));
        citytf.setBounds(400, 430,250,30);
        add(citytf);
        
        //state
        JLabel state = new JLabel("State");
        state.setFont(new Font("Raleway",Font.BOLD, 17));
        state.setBounds(200,470,200,30);
        add(state);
        
        statetf = new JTextField();
        statetf.setFont(new Font("Raleway", Font.BOLD, 15));
        statetf.setBounds(400, 470,250,30);
        add(statetf);
        
        //pincode
        JLabel pincode = new JLabel("PINCODE");
        pincode.setFont(new Font("Raleway",Font.BOLD, 17));
        pincode.setBounds(200,510,200,30);
        add(pincode);
        
        pincodetf = new JTextField();
        pincodetf.setFont(new Font("Raleway", Font.BOLD, 15));
        pincodetf.setBounds(400, 510,250,30);
        add(pincodetf);
        
        
        //next
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(700,550,80,30);
        next.addActionListener(this);
        add(next); 
        
        
        //Basic setting
        getContentPane().setBackground(Color.WHITE);
        setSize(850,650);
        setLocation(350,10);
        setVisible(true);
    }
    
    //overriding funtion
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;//random long type
        String name = nametf.getText();
        String fname = fnametf.getText();
        String dob = ((JTextField)datedob.getDateEditor().getUiComponent()).getText();
        String email= emailtf.getText();
        String address = addresstf.getText();
        String city = citytf.getText();
        String state = statetf.getText();
        String pin = pincodetf.getText();
        
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }
        else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if(others.isSelected()){
            marital = "Other";
        }
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father name is Required");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            }
            else if(gender == null){
                JOptionPane.showMessageDialog(null, "Gender is Required");
            }
            else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Email Address is Required");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is Required");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City is Required");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State is Required");
            }
            else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "PINCODE is Required");
            }
            else{
                //connection establish
                Conn c = new Conn();
                String query = "insert into signup values( '"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    
    public static void main(String args[]){
        new SignupOne();
    }
}

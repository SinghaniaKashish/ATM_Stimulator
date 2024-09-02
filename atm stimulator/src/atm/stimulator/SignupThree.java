package atm.stimulator;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1,c2,c3,c4,c5,c6, c7;
    JButton submit, cancel;
    String formno;

    
    SignupThree(String formno){
        this.formno = formno;
        //basic
        setTitle("Application Form page 3");
        setLayout(null);
        setSize(850,650);
        setLocation(250,10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 24));
        l1.setBounds(230,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(100,110,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,150, 160, 30);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,150, 250, 30);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,185, 250, 25);
        add(r3);
         
        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,185, 250, 25);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100,240,300,30);
        add(card); 
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(350,240,400,30);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 digit card number");
        carddetail.setFont(new Font("Raleway", Font.PLAIN, 12));
        carddetail.setBounds(100,267,300,20);
        add(carddetail);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,300,100,30);
        add(pin); 
        
        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pinnumber.setBounds(350,300,100,30);
        add(pinnumber);
        JLabel pindetail = new JLabel("Your 4 digit password");
        pindetail.setFont(new Font("Raleway", Font.PLAIN, 12));
        pindetail.setBounds(100,327,300,20);
        add(pindetail);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100,370,300,30);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 15));
        c1.setBounds(100, 410,200, 30);
        add(c1);
        
        c2 = new JCheckBox("Online Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 15));
        c2.setBounds(350, 410,200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 15));
        c3.setBounds(100, 440,200, 30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 15));
        c4.setBounds(350, 440,200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 15));
        c5.setBounds(100, 470,200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 15));
        c6.setBounds(350, 470,200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above details are correct to best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 520,600, 30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBounds(200,565,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBounds(350,565,100,30);
        cancel.addActionListener(this);
        add(cancel);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String actype = null;
            if(r1.isSelected()){
                actype = "Saving Account";
            }
            else if(r2.isSelected()){
                actype = "Fixed Deposite Account";
            }
            else if(r3.isSelected()){
                actype = "Current Account";
            }
            else if(r4.isSelected()){
                actype = "Recurring Deposite Account";
            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 2907200300000000L);
            
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM Card";
            }
            else if(c2.isSelected()){
                facility = facility + " Internet Banking";
            }
            else if(c3.isSelected()){
                facility = facility + " Mobile Banking";
            }
            else if(c4.isSelected()){
                facility = facility + " EMAIL & SMS Alert";
            }
            else if(c5.isSelected()){
                facility = facility + " Cheque Book";
            }
            else if(c6.isSelected()){
                facility = facility + " E-Statement";
            }
            
            try{
               if(actype.equals("")){
                   JOptionPane.showMessageDialog(null,"Account Type is required");
               }
               else{
                   Conn conn = new Conn();
                   String query1 = "insert into signupthree values('"+formno+"','"+actype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                   String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                   
                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);
   
                   JOptionPane.showMessageDialog(null,"Card Number: " + cardnumber + "\n Pin: "+pinnumber);
               }
            }
            catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
}

package atm.stimulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back, withdraw, fastcash, ministmt, pinchng, balance, exit;
    String pinnum;
    
    BalanceEnquiry(String pinnum){
        this.pinnum = pinnum;
        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(550, 650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 5, 550, 650);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/black-check-box.png"));
        Image i5 = i4.getImage().getScaledInstance(300, 250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(155, 220, 240, 230);
        image2.setLayout(null);
        image.add(image2);
        
        back = new JButton("Back");
        back.setBounds(120, 170, 120, 30);
        back.addActionListener(this);
        image2.add(back);
        
        Conn conn = new Conn();
        int balance = 0;
        try{
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnum+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposite")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Account Balance = "+ balance);
        text.setFont(new Font("Raleway", Font.BOLD, 17));
        text.setBounds(20,50,300,30);
        text.setForeground(Color.WHITE);
        image2.add(text);
     
        //basic setting
        setLayout(null);
        setSize(600, 650);
        setLocation(300,30);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnum).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
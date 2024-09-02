package atm.stimulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton deposite, withdraw, fastcash, ministmt, pinchng, balance, exit;
    String pinnum;
    FastCash(String pinnum){
        this.pinnum = pinnum;
        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(550, 650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        //background color
        image.setBounds(0, 5, 550, 650);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/black-check-box.png"));
        Image i5 = i4.getImage().getScaledInstance(300, 250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(155, 220, 240, 230);
        image2.setLayout(null);
        image.add(image2);
        
        JLabel text = new JLabel("Select amount to withdraw");
        text.setBounds(5, 0, 225, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 15));
        text.setForeground(Color.WHITE);
        image2.add(text);//to show the text above image
        
        //buttons
        deposite = new JButton("100");
        deposite.setBounds(0, 35, 120, 30);
        deposite.addActionListener(this);
        image2.add(deposite);
        
        withdraw = new JButton("500");
        withdraw.setBounds(125, 35, 130, 30);
        withdraw.addActionListener(this);
        image2.add(withdraw);
        
        fastcash = new JButton("1000");
        fastcash.setBounds(0, 75, 120, 30);
        fastcash.addActionListener(this);
        image2.add(fastcash);
        
        ministmt = new JButton("2000");
        ministmt.setBounds(125, 75, 130, 30);
        ministmt.addActionListener(this);
        image2.add(ministmt);
        
        pinchng = new JButton("5000");
        pinchng.setBounds(0, 115, 120, 30);
        pinchng.addActionListener(this);
        image2.add(pinchng);
        
        balance = new JButton("10000");
        balance.setBounds(125, 115, 130, 30);
        balance.addActionListener(this);
        image2.add(balance);
        
        exit = new JButton("Back");
        exit.setBounds(75, 160, 100, 30);
        exit.addActionListener(this);
        image2.add(exit);
        
        //basic setting
        setLayout(null);
        setSize(600, 650);
        setLocation(300,30);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transaction(pinnum).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText();
            try{
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnum+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposite")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    
                    if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null," Insufficient Balance");
                        return;
                    }
                    Date date = new Date();
                    String query = "insert into bank values('"+pinnum+"', '"+date+"', 'Withdraw','"+amount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amount+" debited successfully");
                    setVisible(false);
                    new Transaction(pinnum).setVisible(true);
                }
            catch(Exception e){
                System.out.println(e);
            }   
        }   
    }
    
    public static void main(String args[]){
        new FastCash("");  
    }      
}


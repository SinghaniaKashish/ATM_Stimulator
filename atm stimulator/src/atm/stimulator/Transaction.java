package atm.stimulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    JButton deposite, withdraw, fastcash, ministmt, pinchng, balance, exit;
    String pinnum;
    Transaction(String pinnum){
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
        
        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(5, 0, 225, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 15));
        text.setForeground(Color.WHITE);
        image2.add(text);//to show the text above image
        
        //buttons
        deposite = new JButton("Deposite");
        deposite.setBounds(0, 35, 120, 30);
        deposite.addActionListener(this);
        image2.add(deposite);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(125, 35, 130, 30);
        withdraw.addActionListener(this);
        image2.add(withdraw);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(0, 75, 120, 30);
        fastcash.addActionListener(this);
        image2.add(fastcash);
        
        ministmt = new JButton("Mini Statement");
        ministmt.setBounds(125, 75, 130, 30);
        ministmt.addActionListener(this);
        image2.add(ministmt);
        
        pinchng = new JButton("Pin Change");
        pinchng.setBounds(0, 115, 120, 30);
        pinchng.addActionListener(this);
        image2.add(pinchng);
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(125, 115, 130, 30);
        balance.addActionListener(this);
        image2.add(balance);
        
        exit = new JButton("Exit");
        exit.setBounds(75, 160, 100, 30);
        exit.addActionListener(this);
        image2.add(exit);
        
        
        setLayout(null);
        setSize(600, 650);
        setLocation(300,30);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource()== deposite){
            setVisible(false);
            new Deposite(pinnum).setVisible(true);
        }
        else if(ae.getSource()== withdraw){
            setVisible(false);
            new Withdraw(pinnum).setVisible(true);
        }
        else if(ae.getSource()== fastcash){
            setVisible(false);
            new FastCash(pinnum).setVisible(true);
        }
        else if(ae.getSource()== pinchng){
            setVisible(false);
            new PinChange(pinnum).setVisible(true);
        }
        else if(ae.getSource()== balance){
            setVisible(false);
            new BalanceEnquiry(pinnum).setVisible(true);
        }
        else if(ae.getSource()== ministmt){
            setVisible(false);
            new MiniStatement(pinnum).setVisible(true);
        }
        
        
    }
    
    public static void main(String args[]){
        new Transaction("");
        
    }
         
    
}

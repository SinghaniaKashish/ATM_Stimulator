package atm.stimulator;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Deposite extends JFrame implements ActionListener {
    JTextField amounttf;
    JButton deposite, back;
    String pinnum;
    
    Deposite(String pinnum){
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
        
        JLabel text = new JLabel("Enter the amount to deposite");
        text.setBounds(20, 20, 310, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        text.setForeground(Color.WHITE);
        image2.add(text);
        
        amounttf = new JTextField();
        amounttf.setFont(new Font("Raleway", Font.BOLD, 22));
        amounttf.setBounds(20, 55,200,25);
        image2.add(amounttf);
        
        deposite = new JButton("Deposite");
        deposite.setForeground(Color.BLACK);
        deposite.setFont(new Font("Raleway", Font.BOLD, 16));
        deposite.setBounds(90,150,150,30);
        deposite.addActionListener(this);
        image2.add(deposite);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBounds(90,190,150,30);
        back.addActionListener(this);
        image2.add(back);
        
        setLayout(null);
        setSize(650,700);
        setLocation(250, 0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposite){
            String number = amounttf.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Enter valid Amount");
            }
            else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnum+"', '"+date+"', 'Deposite','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited successfully");
                    setVisible(false);
                    new Transaction(pinnum).setVisible(true);
                }
                catch(Exception e){
                  System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnum).setVisible(true);
        }
//        
//            
//        
    }
    public static void main(String args[]){
        new Deposite("");
    }
}

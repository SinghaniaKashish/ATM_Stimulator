package atm.stimulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JButton change, back; 
    String pinnum;
    JPasswordField repintf,pintf;
    PinChange(String pinnum){
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
        
        JLabel text = new JLabel("Change your PIN");
        text.setBounds(40, 20, 225, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 18));
        text.setForeground(Color.WHITE);
        image2.add(text);//to show the text above image
        
        JLabel pintext = new JLabel("New PIN");
        pintext.setBounds(20, 60, 100, 30);
        pintext.setFont(new Font("Raleway", Font.BOLD, 15));
        pintext.setForeground(Color.WHITE);
        image2.add(pintext);
        
        pintf = new JPasswordField();
        pintf.setFont(new Font("Raleway", Font.BOLD, 22));
        pintf.setBounds(130, 60,75,25);
        image2.add(pintf);
        
        JLabel repintext = new JLabel("Re-Enter PIN");
        repintext.setBounds(20, 100, 150, 30);
        repintext.setFont(new Font("Raleway", Font.BOLD, 15));
        repintext.setForeground(Color.WHITE);
        image2.add(repintext);
        
        repintf = new JPasswordField();
        repintf.setFont(new Font("Raleway", Font.BOLD, 22));
        repintf.setBounds(130, 100,75,25);
        image2.add(repintf);
        
        change = new JButton("Change");
        change.setBounds(130, 170, 100, 30);
        change.addActionListener(this);
        image2.add(change);
        
        back = new JButton("Back");
        back.setBounds(20, 170, 100, 30);
        back.addActionListener(this);
        image2.add(back);
        
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
        else {
            try{
                String npin = pintf.getText();
                String repin = repintf.getText();
                
                if(!npin.equals(repin)){
                    JOptionPane.showMessageDialog(null,"Entered pin does not match");
                    return;
                }
                else if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter PIN");
                    return;
                }
                else{
                    Conn conn = new Conn();
                    String query1 = "update bank set pinnumber = '"+repin+"' where pinnumber = '"+pinnum+"'";
                    String query2 = "update login set pinnumber = '"+repin+"' where pinnumber = '"+pinnum+"'";
                    String query3 = "update signupthree set pinnumber = '"+repin+"' where pinnumber = '"+pinnum+"'";
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                    
                    setVisible(false);
                    new Transaction(repin).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        new PinChange("");
        
    }
         
    
}

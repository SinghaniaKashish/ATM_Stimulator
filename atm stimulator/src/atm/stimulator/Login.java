package atm.stimulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton signin, signup, clear;
    JTextField cardtf;
    JPasswordField pintf;
    
    Login(){
        //title of frame
        setTitle("ATM Machine");
        
        //to use image
        setLayout(null);
            //bcuz by deafault boundry layout places the image in the center
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm-machine.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT );
            //need to import awt
        ImageIcon i3 = new ImageIcon(i2);
            //bcuz we can not place image in JLabel
        JLabel label = new JLabel(i3);
        label.setBounds(50, 170,200,200);
            //(distance from left, right, width, height)
        add(label);
        
        //heading
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(240,60,350,40);
        add(text);
        
        //card number
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(270,170,150,30);
        add(cardno);
            //text field
        cardtf = new JTextField();
        cardtf.setBounds(430, 170, 240, 30);
        cardtf.setFont(new Font("Arial",Font.BOLD, 14));
        add(cardtf);
        
        //PIN
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(270,240,150,30);
        add(pin);
            //password field
        pintf = new JPasswordField();
        pintf.setBounds(430, 240, 240, 30);
        pintf.setFont(new Font("Arial",Font.BOLD, 14));
        add(pintf);
        
       //Bottons
        //signin
       signin = new JButton("SIGN IN");
       signin.setBounds(430,310,100,30);
       signin.setBackground(Color.black);
       signin.setForeground(Color.white);
       signin.addActionListener(this);
       add(signin);
       
        //clear
       clear = new JButton("CLEAR");
       clear.setBounds(570,310,100,30);
       clear.setBackground(Color.black);
       clear.setForeground(Color.white);
       clear.addActionListener(this);
       add(clear);
       
        //signup
       signup  = new JButton("SIGN UP");
       signup.setBounds(430,360,240,30);
       signup.setBackground(Color.black);
       signup.setForeground(Color.white);
       signup.addActionListener(this);
       add(signup);
        
        //background color
        getContentPane().setBackground(Color.white);
        
        //width, height
        setSize(800,480);
        //to make the frame visible
        setVisible(true);
        //staring loc of frame
        setLocation(280,150);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        //click hone se ker na kya hai?
        if(ae.getSource() == clear){
            cardtf.setText("");
            pintf.setText("");
        }
        else if(ae.getSource() == signin){
            Conn conn = new Conn();
            String cardnum = cardtf.getText();
            String pinnum = pintf.getText();
            String query = "select * from login where cardnumber = '"+cardnum+"' and pinnumber = '"+pinnum+"'";
            try{
               ResultSet rs = conn.s.executeQuery(query);
               if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnum).setVisible(true);
               }
               else{
                   JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
               }
            }
            catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        } 
    }
    
    public static void main(String args[]){
        new Login();
        //login run ker te hi ye object call hoga n ye login constuctor ko call karega
        
    }
            
}

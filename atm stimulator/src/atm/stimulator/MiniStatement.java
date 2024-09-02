package atm.stimulator;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnum){
        
        JLabel text = new JLabel("Bank");
        text.setBounds(140,20,100,20);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        add(text);
        
        JLabel card = new JLabel();
        card.setBounds(20,60,250,20);
        add(card);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,100,400,350);
        add(mini);
        
        JLabel balancemini = new JLabel();
        balancemini.setBounds(20,450,150,50);
        add(balancemini);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '"+pinnum+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnum+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+ rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposite")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
 
            }
            balancemini.setText("Balance = "+bal);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}

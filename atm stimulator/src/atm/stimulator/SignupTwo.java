package atm.stimulator;
import javax.swing.*; //Frame
import java.awt.*;  //Color, Font
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField pantf, aadhartf;
    JButton next;
    JRadioButton syes, sno, eno, eyes;
    JComboBox categorytf, edutf, incometf, occupationtf;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        
        //basic setting
        setTitle("Application Form page 2");
        setLayout(null);
        setSize(850,600);
        setLocation(250,100);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,25));
        additionalDetails.setBounds(250,80,400,40);
        add(additionalDetails);
        

        //Category
        JLabel category = new JLabel("Category");
        category.setFont(new Font("Raleway",Font.BOLD, 17));
        category.setBounds(200,190,200,30);
        add(category);
            //dropdown
        String valCategory[] = {"GC", "OBC", "SC", "ST", "OTHER"};
        categorytf = new JComboBox(valCategory);
        categorytf.setBounds(400, 190,250,30);
        categorytf.setBackground(Color.WHITE);
        add(categorytf);
        
        
        //income
        JLabel income = new JLabel("Income");
        income.setFont(new Font("Raleway",Font.BOLD, 17));
        income.setBounds(200,230,200,30);
        add(income);
            //dropdown
        String valIncome[] = {"NULL", "<3,00,000", "< 5,00,000", "<7,00,000", "<10,00,000", "<15,00,000",">15,00,000"};
        incometf = new JComboBox(valIncome);
        incometf.setBounds(400, 230,250,30);
        incometf.setBackground(Color.WHITE);
        add(incometf);
       
        
        //Educational
        JLabel educational = new JLabel("Educational Qualification");
        educational.setFont(new Font("Raleway",Font.BOLD, 16));
        educational.setBounds(200,270,200,30);
        add(educational);
            //dropdown
        String valEdu[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctors", "Others"};
        edutf = new JComboBox(valEdu);
        edutf.setBounds(400, 270,250,30);
        edutf.setBackground(Color.WHITE);
        add(edutf);
        
        //occupation
        JLabel occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Raleway",Font.BOLD, 17));
        occupation.setBounds(200,310,200,40);
        add(occupation);
        
        String valOccupation[] = {"Bussiness", "self-Employed", "Salaried", "Student","Unemployed", "Others"};
        occupationtf = new JComboBox(valOccupation);
        occupationtf.setBounds(400, 310,250,30);
        occupationtf.setBackground(Color.WHITE);
        add(occupationtf);
        
        
        //pan
        JLabel pan = new JLabel("PAN Number");
        pan.setFont(new Font("Raleway",Font.BOLD, 17));
        pan.setBounds(200,350,200,30);
        add(pan);
        
        pantf = new JTextField();
        pantf.setFont(new Font("Raleway", Font.BOLD, 15));
        pantf.setBounds(400, 350,250,30);
        add(pantf);
        
        //aadhar
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setFont(new Font("Raleway",Font.BOLD, 17));
        aadhar.setBounds(200,390,200,30);
        add(aadhar);
        
        aadhartf = new JTextField();
        aadhartf.setFont(new Font("Raleway", Font.BOLD, 15));
        aadhartf.setBounds(400, 390,250,30);
        add(aadhartf);
        
        //senior
        JLabel senior = new JLabel("Senior Citizen");
        senior.setFont(new Font("Raleway",Font.BOLD, 17));
        senior.setBounds(200,430,200,30);
        add(senior);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(400,430,70,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(475,430,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
       
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        
        //existing account
        JLabel existingaccount = new JLabel("Existing Account");
        existingaccount.setFont(new Font("Raleway",Font.BOLD, 17));
        existingaccount.setBounds(200,470,200,30);
        add(existingaccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(400,470,70,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(475,470,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
        
        
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

        String category = (String) categorytf.getSelectedItem();
        String income = (String) incometf.getSelectedItem();
        String edu= (String) edutf.getSelectedItem();
        String occupation = (String) occupationtf.getSelectedItem();
        String pan = pantf.getText();
        String aadhar = aadhartf.getText();
        
        
        String senior = null;
        if(syes.isSelected()){
            senior = "yes";
        }else if(sno.isSelected()){
            senior = "no";
        }
        
        String existing = null;
        if(eyes.isSelected()){
            existing = "yes";
        }
        else if(eno.isSelected()){
            existing = "no";
        }
        
        try{
            if(category.equals("")){
                JOptionPane.showMessageDialog(null, "Category is Required");
            }
            else if(edu.equals("")){
                JOptionPane.showMessageDialog(null, "Educational Qualification is Required");
            }
            else if(income.equals("")){
                JOptionPane.showMessageDialog(null, "Income is Required");
            }
            else if(occupation.equals("")){
                JOptionPane.showMessageDialog(null, "Occupation is Required");
            }
            else if(senior == null){
                JOptionPane.showMessageDialog(null, "Gender is Required");
            }
            else if(existing == null){
                JOptionPane.showMessageDialog(null, "Gender is Required");
            }
            else if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "PAN Number is Required");
            }
            else if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Aaddhar is Required");
            }
            else{
                //connection establish
                Conn c = new Conn();
                String query = "insert into signuptwo values( '"+formno+"', '"+category+"', '"+income+"', '"+edu+"', '"+occupation+"', '"+senior+"', '"+existing+"', '"+pan+"', '"+aadhar+"')";
                c.s.executeUpdate(query);
                
                //signup3 obj
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}

import java.awt.Color;

import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Registration extends JFrame {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    JFrame frame = new JFrame();
    public JTextField username;
    public JPasswordField passwordField;
    public JButton btnNewButton;
    public JButton login; 
    private MongoClient mongoClient;
    private DB database;
    private JLabel lblNewUserRegister;
   
    public int CheckLogin(String username, String password) {
    	String name,pass;
    	try {
    	            mongoClient = new MongoClient("localhost", 27017);
    	        } catch (UnknownHostException ignored) {

    	        }
    	        database = mongoClient.getDB("DATABASE");
    	        DBCollection users = database.getCollection("users");
    	        List<DBObject> result = users.find().toArray();
    	        for (DBObject object : result) {
    	            name = (String) object.get("username");
    	            pass = (String) object.get("password");
    	            System.out.println(object);
    	            if(pass.equals(password) && name.equals(username))
    	            	return 1;
    	        }
    	
    	return 0;
    }

    public Registration() 
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 800, 600);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewUserRegister = new JLabel("Login Please");
        lblNewUserRegister.setFont(new Font("Arial", Font.PLAIN, 30));
        lblNewUserRegister.setBounds(300, 52, 325, 50);
        contentPane.add(lblNewUserRegister);
        
        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 20));
        username.setBounds(300, 151, 228, 50);
        username.setBackground(Color.lightGray);
        contentPane.add(username);
        username.setColumns(10); 
        
        JLabel lblUsername = new JLabel("USERNAME:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(180, 159, 150, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("PASSWORD:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(180, 245, 150, 25);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField.setBounds(300, 235, 228, 50);
        passwordField.setBackground(Color.lightGray);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(315, 447, 200, 70);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener(){  	     
        public void actionPerformed(ActionEvent e) {
        	SelectGamePage SelectGamePage;
        	
        	if(username.getText().length() < 1)
        		 lblNewUserRegister.setText("User can't be empty");
        	else if(passwordField.getText().length() < 1)
        		lblNewUserRegister.setText("Password can't be empty");
        	else if(CheckLogin(username.getText(),passwordField.getText())==1)
                SelectGamePage = new SelectGamePage();
             else
             {
            	 lblNewUserRegister.setText("Invalid Credentials");
                 //System.out.println("User doesn't exist in the Database");
             }
        }
    });
}
}
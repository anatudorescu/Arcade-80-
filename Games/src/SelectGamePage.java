import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectGamePage implements ActionListener 
	{
	    JLabel selectgamelabel = new JLabel("              CHOO$E.");
	    JButton Pong = new JButton("Pong");
	    JButton TicTacToe = new JButton("Tic-Tac-Toe");
	    SelectGamePage()
	    {
	    	
	        JFrame frame = new JFrame();
	        selectgamelabel.setBounds(75,20,500,40);
	        selectgamelabel.setFont(new Font(null, Font.BOLD, 20));
	        
	        Pong.setBounds(100,200,100,50);
	        Pong.setFocusable(false);
	        Pong.addActionListener(this);
	        
	        TicTacToe.setBounds(200,200,100,50);
	        TicTacToe.setFocusable(false);
	        TicTacToe.addActionListener(this);
	        
	        frame.add(Pong);
	        frame.add(TicTacToe);
	        frame.add(selectgamelabel);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(450,400);
	        frame.setLayout(null);
	        frame.setVisible(true);
	        
	    }
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if(e.getSource()==Pong)
	        {
	            GameFrame pong = new GameFrame();
	        }
	        else if(e.getSource()==TicTacToe)
	        {
	            TicTacToe tictactoe = new TicTacToe();
	        }    
	    }
	}
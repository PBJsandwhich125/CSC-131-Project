import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

class ButtonFrame extends JFrame
{
  JButton bChange ; // reference to the button object
  JButton cChange;
  JButton dChange;
  JButton eChange;
  JButton fChange;
  JButton Account1;
  JButton Account2;
  JButton Account3;
  JButton Movie1;
  JButton Movie2;
  JButton Movie3;
  JButton Movie4;
  JButton Movie5;
  JButton Movie6;
  JButton Movie7;
  JButton Movie8;
  JButton Movie9;

  // constructor for ButtonFrame
  ButtonFrame(String title) 
  {
    super( title );                     // invoke the JFrame constructor
    setLayout( new FlowLayout() );      // set the layout manager

    bChange = new JButton("Accounts!"); // construct a JButton
    cChange = new JButton("Movies");
    dChange = new JButton("Reviews");
    eChange = new JButton("Voting (Must be logged in)");
    fChange = new JButton("quit");
    bChange.addActionListener(new ActionListener(){
      @Override
         public void actionPerformed(ActionEvent e){
         JFrame frame = new JFrame("Accounts");
         frame.setLayout( new FlowLayout());
         Account1 = new JButton("Login");
         Account2 = new JButton("Create Account");
         Account3 = new JButton("Return to menu");
         
         frame.add( Account1);
         frame.add( Account2);
         frame.add( Account3);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
         frame.setSize( 500, 500);
         
         }
    
    ;
    });
    cChange.addActionListener(new ActionListener(){
      @Override
         public void actionPerformed(ActionEvent e){
         JFrame frame1 = new JFrame("Movies");
         frame1.setLayout( new FlowLayout());
         Movie1 = new JButton("Parasite");
         Movie2 = new JButton("1917");
         Movie3 = new JButton("Ford V Ferrari");
         Movie4 = new JButton("The Irishman");
         Movie5 = new JButton("Jojo Rabbit");
         Movie6 = new JButton("Joker");
         Movie7 = new JButton("Little Women");
         Movie8 = new JButton("Marriage Story");
         Movie9 = new JButton("Once Upon A Time...In Hollywood");
         
         frame1.add( Movie1);
         frame1.add( Movie2);
         frame1.add( Movie3);
         frame1.add( Movie4);
         frame1.add( Movie5);
         frame1.add( Movie6);
         frame1.add( Movie7);
         frame1.add( Movie8);
         frame1.add( Movie9);
         
         frame1.setLocationRelativeTo(null);
         frame1.setVisible(true);
         frame1.setSize( 500, 500);
         
         System.out.println("yello");
         }
    
    ;
    });
    dChange.addActionListener(new ActionListener(){
      @Override
         public void actionPerformed(ActionEvent e){
         JFrame frame2 = new JFrame("Reviews");
         frame2.setLayout( new FlowLayout());
         Movie1 = new JButton("Parasite");
         Movie2 = new JButton("1917");
         Movie3 = new JButton("Ford V Ferrari");
         Movie4 = new JButton("The Irishman");
         Movie5 = new JButton("Jojo Rabbit");
         Movie6 = new JButton("Joker");
         Movie7 = new JButton("Little Women");
         Movie8 = new JButton("Marriage Story");
         Movie9 = new JButton("Once Upon A Time...In Hollywood");
         
         frame2.add( Movie1);
         frame2.add( Movie2);
         frame2.add( Movie3);
         frame2.add( Movie4);
         frame2.add( Movie5);
         frame2.add( Movie6);
         frame2.add( Movie7);
         frame2.add( Movie8);
         frame2.add( Movie9);
         
         frame2.setLocationRelativeTo(null);
         frame2.setVisible(true);
         frame2.setSize( 500, 500);
         
         System.out.println("yello");
         }
    
    ;
    });
    eChange.addActionListener(new ActionListener(){
      @Override
         public void actionPerformed(ActionEvent e){
         JFrame frame2 = new JFrame("Reviews");
         frame2.setLayout( new FlowLayout());
         Movie1 = new JButton("Parasite");
         Movie2 = new JButton("1917");
         Movie3 = new JButton("Ford V Ferrari");
         Movie4 = new JButton("The Irishman");
         Movie5 = new JButton("Jojo Rabbit");
         Movie6 = new JButton("Joker");
         Movie7 = new JButton("Little Women");
         Movie8 = new JButton("Marriage Story");
         Movie9 = new JButton("Once Upon A Time...In Hollywood");
         
         frame2.add( Movie1);
         frame2.add( Movie2);
         frame2.add( Movie3);
         frame2.add( Movie4);
         frame2.add( Movie5);
         frame2.add( Movie6);
         frame2.add( Movie7);
         frame2.add( Movie8);
         frame2.add( Movie9);
         
         frame2.setLocationRelativeTo(null);
         frame2.setVisible(true);
         frame2.setSize( 500, 500);
         
         System.out.println("yello");
         }
    
    ;
    });
    fChange.addActionListener(new ActionListener(){
      @Override
         public void actionPerformed(ActionEvent e){
         System.exit(0);         
         }
    
    ;
    });
    add( bChange );    
    add( cChange);   
    add( dChange);
    add( eChange);  
    add( fChange);            // add the button to the JFrame
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
  }
}

public class MenuMockup
{
  public static void main ( String[] args )
  {
    ButtonFrame frm = new ButtonFrame("Button Demo");
    frm.setLocationRelativeTo(null);
    frm.setSize( 500, 500 );     
    frm.setVisible( true );   
  }
}
package v1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
//import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

 
public class CInterface extends JFrame implements ActionListener
{
   //Dialogs
    private JPanel pBasePane;
    private JPanel pMenue;
    private JPanel pBoard;
    private JPanel pOptions;
    
    
    //Menue dialog controls
    private JButton bSinglplayer; //opens singleplayer game
    private JButton bMultiplayer; //opens multiplayer game
    private JButton bOptions;     //opens option 
    private JButton bExit;        //exits the game
    
    
    
    //Game dialog controls
    private JButton bRestart;
    private JLabel  lGameInfo;
    
    private JButton bTopLeft;
    private JButton bTopMiddle;
    private JButton bTopRight;
    private JButton bMidLeft;
    private JButton bMidMid;
    private JButton bMidRight;
    private JButton bBotLeft;
    private JButton bBotMid;
    private JButton bBotRight;


    /**
     * Create the frame.
     */
    public CInterface()
    {
        
        //Frame settings
        this.setTitle("Tic-Tac-Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 450, 300);
        
        
        // create pane objects
        pBasePane = new JPanel();
        pMenue = new JPanel();
        pBoard = new JPanel();
        pOptions = new JPanel();
        
        
        create_basePane(pBasePane);
        create_Pane(pMenue);
        create_Pane(pBoard);
        create_Pane(pOptions);
        
        
        //create button objects
        bSinglplayer = create_button(20, 10, 100, 20, "Singleplayer");
        
        
        
        bSinglplayer.addActionListener(this);
      
        
        pMenue.add(bSinglplayer);
        
        
        
        
        setContentPane(pBasePane);
        
        
        pBasePane.add(pMenue, "Menue");
        pBasePane.add(pBoard, "Board");
        pBasePane.add(pOptions, "Options");
         
    }
    
    private JButton create_button(int x,int y,int w,int h,String name)
    {
        JButton tempButton = new JButton(name);
        tempButton.setBounds(x, y, w, h);
        
        return tempButton;
    }
    
    private void create_basePane(JPanel panel)
    {
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new CardLayout(0, 0));
    }
    
    
    private void create_Pane(JPanel panel)
    {
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(null);
        panel.setVisible(false);
    }
    
    
    //has to be public not able to change this
    public void actionPerformed (ActionEvent ae)
    {
        if(ae.getSource() ==this.bSinglplayer )
        {
            CardLayout cl = (CardLayout)(pBasePane.getLayout());
            cl.show(pBasePane, "Board");
        }
    }
}

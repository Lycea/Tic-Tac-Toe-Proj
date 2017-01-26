package v1;


import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.CardLayout;
//import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

 
public class CInterface extends JFrame implements ActionListener
{
    private ArrayList<JButton> buttons = new ArrayList<JButton>();
    
   //Dialogs
    private JPanel pBasePane;
    private JPanel pMenue;
    private JPanel pBoard;
    private JPanel pOptions;
    
    
    //Game dialog controls
    private JLabel  lGameInfo;
    
    
    //Options dialog controls
    //private JButton bBack;
    
    private JTextField txtNameP1;
    private JTextField txtNameP2;
    
    private JTextField txtSymbP1;
    private JTextField txtSymbP2;

    private JLabel lNameP1;
    private JLabel lNameP2;
    
    private JLabel lSymbP1;
    private JLabel lSymbP2;

    
    CSteuerung steuerung = new CSteuerung(this);
    /**
     * Create the frame.
     */
    public CInterface()
    {
        
        //Frame settings
        this.setTitle("Tic-Tac-Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 400, 300);
        this.setResizable(false);
        
        
        
        // create pane objects
        pBasePane = new JPanel();
        
        
        pOptions = new JPanel();
        
        
        createBasePane(pBasePane);
        
        
        createPane(pOptions);
        
        
        initMenue();
        initBoard();
        initOptions();
        
        
        setContentPane(pBasePane);
        
        
        pBasePane.add(pMenue, "Menue");
        pBasePane.add(pBoard, "Board");
        pBasePane.add(pOptions, "Options");
        
        for (JButton jButton : buttons)
        {
            jButton.addActionListener(this);
        }
        
         
    }
    
    private JButton createButton(int x,int y,int w,int h,String name)
    {
        JButton tempButton = new JButton(name);
        tempButton.setBounds(x, y, w, h);
        
        return tempButton;
    }
    
    private JLabel createLable(int x,int y,int w,int h,String name)
    {
        JLabel tempButton = new JLabel(name);
        tempButton.setBounds(x, y, w, h);
        
        return tempButton;
    }
    
    private void initMenue()
    {
        int x = 150;
        int y = 10;
        int width = 100;
        int height = 20;
        int space_between = 30;
        
        
        pMenue = new JPanel();
        createPane(pMenue);
        
        
        //create button objects
        
        buttons.add(createButton(x, y,      width, height, "Singleplayer")); 
        buttons.add(createButton(x, y+1*30, width, height, "Multiplayer"));
        buttons.add(createButton(x, y+2*30, width, height, "Options"));
        buttons.add(createButton(x, y+3*30, width, height, "Exit"));
        
        //Listener added
        
        //added Buttons to pane
        pMenue.add(buttons.get(0));
        pMenue.add(buttons.get(1));
        pMenue.add(buttons.get(2));
        pMenue.add(buttons.get(3));
        
    }
    
    
    private void initBoard()
    {
        
        int x = 100;
        int y = 40;
        int width  = 60;
        int height = 60;
        int space_between = 0;
        
        pBoard = new JPanel();
        createPane(pBoard);
        
        buttons.add(createButton(x, y,          width, height, ""));
        buttons.add(createButton(x+width, y,    width, height, ""));
        buttons.add(createButton(x+width*2, y,  width, height, ""));
        buttons.add(createButton(x, y+height,   width, height, ""));
        buttons.add(createButton(x+width, y+height,   width, height, ""));
        buttons.add(createButton(x+width*2, y+height,   width, height, ""));
        buttons.add(createButton(x, y+height*2, width, height, ""));
        buttons.add(createButton(x+width, y+height*2, width, height, ""));
        buttons.add(createButton(x+width*2, y+height*2, width, height, ""));
        
        buttons.add(createButton(x,         y+height*3, width*3, 20, "Restart"));
        buttons.add(createButton(x, y+height*3+height/3,width*3, 20, "Back"));
        
        lGameInfo = createLable(100, 0, 90, 20, "test");
        
        
        
        //added Buttons to pane
        for(int i = 4;i < 15; i++)
        {
            pBoard.add(buttons.get(i));
        }
        
        pBoard.add(lGameInfo);

    }
    
    
    private void initOptions()
    {
     int x = 180;
     int y = 35;
     int width = 100;
     int height = 20;
        
        buttons.add(createButton(100, 240,180, height, "back"));
        
        
        txtNameP1 = new JTextField(0);
        txtNameP1.setBounds(x, y, 70, height);
        
        txtNameP2 = new JTextField(0);
        txtNameP2.setBounds(x, y*2, 70, height);
        
        txtSymbP1 = new JTextField(0);
        txtSymbP1.setBounds(x, y*3, 70, height);
        
        txtSymbP2 = new JTextField(0);
        txtSymbP2.setBounds(x, y*4, 70, height);
        
        
        lNameP1 = createLable(x-100, y,   width, height, "Name P1");
        lNameP2 = createLable(x-100, y*2, width, height,  "Name p2");
        lSymbP1 = createLable(x-100, y*3, width, height,  "Symbol p1");
        lSymbP2 = createLable(x-100, y*4, width, height, "Symbol p2");
        
        
        pOptions.add(txtNameP1);
        pOptions.add(txtNameP2);
        pOptions.add(txtSymbP1);
        pOptions.add(txtSymbP2);
        pOptions.add(lNameP1);
        pOptions.add(lNameP2);
        pOptions.add(lSymbP1);
        pOptions.add(lSymbP2);
        pOptions.add(buttons.get(15) );
        
        
        
        
    }
    
    
    private void createBasePane(JPanel panel)
    {
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new CardLayout(0, 0));
    }
    
    
    private void createPane(JPanel panel)
    {
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(null);
        panel.setVisible(false);
    }
    
    
    //has to be public not able to change this
    public void actionPerformed (ActionEvent ae)
    {
        
        Object object = ae.getSource();
        CardLayout cl = (CardLayout)(pBasePane.getLayout());
        
        switch(buttons.indexOf(object))
        {
            case 0:
                steuerung.initSingleplayer();
                cl.show(pBasePane, "Board");
                break;
            case 1:
                steuerung.initMultiplayer();
                cl.show(pBasePane, "Board");
                break;
            
            case 2:
                cl.show(pBasePane, "Options");
                break;
                
            case 3:
                System.exit(0);
                break;
     
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                steuerung.playerMadeMove(buttons.indexOf(object)-5);
                break;
                
            case 13:
                steuerung.resetGame();
                resetGame();
                break;
                
            case 14:
                cl.show(pBasePane, "Menue");
                break;
                
            case 15:
                cl.show(pBasePane, "Menue");
                steuerung.optionsChanged();
                break;
        }
    }
    
    
    public void setInfo(String info)
    {
        lGameInfo.setText(info);
    }
    
    public void changeButton(int id,String title)
    {
        buttons.get(id+5).setText(title);
        buttons.get(id+5).setEnabled(true);
    }
    
    public void resetGame()
    {
        for(int i = 0; i< 8;i++)
        {
            changeButton(i, " ");
        }
    }
    
    
    
    
    /**********************************
     * 
     * Getter for the option text fields
     *
     ************************************/
    public String getPlayerName1()
    {
       return txtNameP1.getText();
    }
    
    public String getPlayerName2()
    {
        return txtNameP2.getText();
    }
    
    public String getPlayerSymb1()
    {
        return txtSymbP1.getText();
    }
    
    public String getPlayerSymb2()
    {
        return txtSymbP2.getText();
    }
}

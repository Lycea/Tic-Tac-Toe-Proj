//package v1;


import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
    private JTextField txtNameP1;
    private JTextField txtNameP2;
    
    private JTextField txtSymbP1;
    private JTextField txtSymbP2;

    private JLabel lNameP1;
    private JLabel lNameP2;
    
    private JLabel lSymbP1;
    private JLabel lSymbP2;

    //create new Steuerungs object
    CSteuerung steuerung = new CSteuerung(this);
    
    
    
    
    /**
     * Create the frame and initialises everything needed
     */
    public CInterface()
    {  
        //Frame settings
        this.setTitle("Tic-Tac-Toe");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set what happens if x was clicked
        this.setBounds(100, 100, 400, 300);
        
        //make not resizeable
        this.setResizable(false);
        
        
        
        // create the base pane object
        pBasePane = new JPanel();
        
        createBasePane(pBasePane);
        
        
        
        initMenue();
        initBoard();
        initOptions();
        
        setContentPane(pBasePane);
        
        
        //add the panes to the main pane which is a cardboard layout
        pBasePane.add(pMenue, "Menue");
        pBasePane.add(pBoard, "Board");
        pBasePane.add(pOptions, "Options");
        
        
        //register all the listeners for the buttons
        for (JButton jButton : buttons)
        {
            jButton.addActionListener(this);
        }
        
         
    }
    
    
    
   
    

    
/*****************************************************************************
 * Initialisation helper functions to make it more seperated    
 */
    //initialises the game menue
    private void initMenue()
    {
        int x = 125;
        int y = 50;
        int width = 150;
        int height = 20;
        
        
        pMenue = new JPanel();
        createPane(pMenue);
        
        
        //create button objects
        
        buttons.add(createButton(x, y,      width, height, "Singleplayer")); 
        buttons.add(createButton(x, y+1*30, width, height, "Multiplayer (offline)"));
        buttons.add(createButton(x, y+2*30, width, height, "Options"));
        buttons.add(createButton(x, y+3*30, width, height, "Exit"));
        
        //Listener added
        
        //added Buttons to pane
        pMenue.add(buttons.get(0));
        pMenue.add(buttons.get(1));
        pMenue.add(buttons.get(2));
        pMenue.add(buttons.get(3));
        
    }
    
    //initialises the game board
    private void initBoard()
    {
        //some values to make changing ui easier
        int x = 100;
        int y = 40;
        int width  = 60;
        int height = 60;
        
        pBoard = new JPanel();
        createPane(pBoard);
        
        //add nine buttons for the field
        buttons.add(createButton(x, y,          width, height, ""));
        buttons.add(createButton(x+width, y,    width, height, ""));
        buttons.add(createButton(x+width*2, y,  width, height, ""));
        buttons.add(createButton(x, y+height,   width, height, ""));
        buttons.add(createButton(x+width, y+height,   width, height, ""));
        buttons.add(createButton(x+width*2, y+height,   width, height, ""));
        buttons.add(createButton(x, y+height*2, width, height, ""));
        buttons.add(createButton(x+width, y+height*2, width, height, ""));
        buttons.add(createButton(x+width*2, y+height*2, width, height, ""));
        
        
        //add the restart and the back button
        buttons.add(createButton(x,         y+height*3, width*3, 20, "Restart"));
        buttons.add(createButton(x, y+height*3+height/3,width*3, 20, "Back"));
        
        //add the info label
        lGameInfo = createLable(100, 0, 200, 20, "info");
        
        
        
        //added Buttons to pane
        for(int i = 4;i < 15; i++)
        {
            pBoard.add(buttons.get(i));
        }
        
        //add the label to the pane
        pBoard.add(lGameInfo);
    }
    
    
    //initialises the option panel
    private void initOptions()
    {
     int x = 210;
     int y = 35;
     int width = 100;
     int height = 30;
     
     	pOptions = new JPanel();
     	createPane(pOptions);
     	
        buttons.add(createButton(100, 220,180, height, "back"));
        
        
        txtNameP1 = new JTextField("Player 1");
        txtNameP1.setBounds(x, y, 70, height);
        
        txtNameP2 = new JTextField("Player 2");
        txtNameP2.setBounds(x, y*2, 70, height);
        
        txtSymbP1 = new JTextField("x");
        txtSymbP1.setBounds(x, y*3, 70, height);
        
        txtSymbP2 = new JTextField("o");
        txtSymbP2.setBounds(x, y*4, 70, height);
        
        
        lNameP1 = createLable(x-100, y,   width, height, "Name P1");
        lNameP2 = createLable(x-100, y*2, width, height,  "Name P2");
        lSymbP1 = createLable(x-100, y*3, width, height,  "Symbol P1");
        lSymbP2 = createLable(x-100, y*4, width, height, "Symbol P2");
        
        
        pOptions.add(txtNameP1);
        pOptions.add(txtNameP2);
        pOptions.add(txtSymbP1);
        pOptions.add(txtSymbP2);
        pOptions.add(lNameP1);
        pOptions.add(lNameP2);
        pOptions.add(lSymbP1);
        pOptions.add(lSymbP2);
        
        pOptions.add(buttons.get(15));
    }
    
    
    
    
    
    
    
    
/***********************************************************************
 * Helper Methodes for the creation of objects
 */
    
    //creates a button from the given information
    private JButton createButton(int x,int y,int w,int h,String name)
    {
        JButton tempButton = new JButton(name);
        tempButton.setBounds(x, y, w, h);
        
        return tempButton;
    }
    
    //creates a base panel in the given object
    private void createBasePane(JPanel panel)
    {
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new CardLayout(0, 0));
    }
    
    //creates a normal panel in the given object
    private void createPane(JPanel panel)
    {
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));  //default border
        panel.setLayout(null); //layout null means absolute layout
        panel.setVisible(false);
    }
    
    //creates a label from the given information
    private JLabel createLable(int x,int y,int w,int h,String name)
    {
        JLabel tempButton = new JLabel(name);
        tempButton.setBounds(x, y, w, h);
        
        return tempButton;
    }
    
    
    
    //has to be public not able to change this
    //listener for the button objects
    public void actionPerformed (ActionEvent ae)
    {
        
        Object object = ae.getSource();
        CardLayout cl = (CardLayout)(pBasePane.getLayout());
        
        switch(buttons.indexOf(object))
        {
        	//first button - so initialise singleplayer
            case 0:
            	resetGame();
                steuerung.initSingleplayer();
                cl.show(pBasePane, "Board");
                break;
            //second button -so initialise multiplayer
            case 1:
            	resetGame();
                steuerung.initMultiplayer();
                cl.show(pBasePane, "Board");
                break;
            
            //third button - so open the options
            case 2:
                cl.show(pBasePane, "Options");
                break;
            
            //forth button - so close the game
            case 3:
                System.exit(0);
                break;
     
            //these nine buttons are for the game field so the player did something
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                steuerung.playerMadeMove(buttons.indexOf(object)-4);
                break;
                
            // this button is the reset button so reset the game     
            case 13:
                steuerung.resetGame();
                break;
                
            // this button is the return button in the game so show the menue again    
            case 14:
                cl.show(pBasePane, "Menue");
                break;
                
            //this is the back button in the options so show the menue again and set the options
            //cause there could be something changed
            case 15:
                cl.show(pBasePane, "Menue");
                steuerung.optionsChanged();
                break;
        }
    }
    
    
    
    
    
    
    
/*****************************************************************************************************
 *  Additional functions
 */
    
    
    
    //sets the given string into the info label in the game board
    public void setInfo(String info)
    {
        lGameInfo.setText(info);
    }
    
    //change the given number of button to the given text
    public void changeButton(int id,String title)
    {
        buttons.get(id+4).setText(title);
        buttons.get(id+4).setEnabled(true);  
    }
    
    //this function will set all buttons back to no text
    public void resetGame()
    {
        for(int i = 0; i< 9;i++)
        {
            changeButton(i, " ");
        }
    }
    
    
    
    
/**********************************
 * Getter for the option text fields
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

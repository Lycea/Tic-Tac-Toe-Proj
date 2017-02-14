package v1b;


import java.util.Scanner;

import javax.swing.text.GapContent;

 
public class CInterface 
{   
    int iaField[][] = new int[3][3];

    
    private menues m ;
    private enum menues {Menue,Game,GameBreak,Options} 
    
    
    //create new Steuerungs object
    CSteuerung steuerung = new CSteuerung(this);
    
    Scanner input = new Scanner(System.in);
    
    
    /**
     * Create the frame and initialises everything needed
     */
    public CInterface()
    {  
        
        drawMenue();
         
    }
    
    
    
   
    

    
/*****************************************************************************
 * Initialisation helper functions to make it more seperated    
 */
    //initialises the game menue
    private void drawMenue()
    {
        boolean bContinue = true;
        
        while(bContinue)
        {
            System.out.println("Tic-Tac-Toe-Menue");
            System.out.println("-----------------\n");
            
            System.out.println("(1) Singleplayer");
            System.out.println("(2) Multiplayer");
            System.out.println("(3) Options");
            System.out.println("(4) Exit");
            
            while(true)
            {
                if(getIntInput(menues.Menue.ordinal())== 4)
                {
                    bContinue = false;
                    break;
                }
            }
        }
        
    }
    
    //initialises the game board
    private void drawBoard()
    {
        
    }
    
    
    //initialises the option panel
    private void drawOptions()
    {
     
    }
    
    
    
    
    
    
    
    
/***********************************************************************
 * Helper Methodes for the creation of objects
 */
    
    //creates a button from the given information
  
    
    
    //has to be public not able to change this
    //listener for the button objects
    private int getIntInput(int pMenueNum)
    {
        int ip = input.nextInt();
        switch(pMenueNum)
        {
            case 0:
                //main menue
                break;
                
            case 1:
                //game (reset continue back)
                ip = ip+10;
                break;
                
            case 3:
                //options (change 1,2,3,4, back)
                ip =ip+20;
                break;
        }
        
        switch(ip)
        {
        	//first button - so initialise singleplayer
            case 1:
            	resetGame();
                steuerung.initSingleplayer();
                drawBoard();
                break;
            //second button -so initialise multiplayer
            case 2:
            	resetGame();
                steuerung.initMultiplayer();
                drawBoard();
                break;
            
            //third button - so open the options
            case 3:
                drawOptions();
                break;
            
            //forth button - so close the game
            case 4:
                //System.exit(0);
                return 4;
     
                
            // this button is the reset button so reset the game     
            case 11:
                steuerung.resetGame();
                break;
                
            // this button is the return button in the game so show the menue again    
            case 12:
                drawMenue();;
                break;
            // continue    
            case 13:
                drawMenue();;
                break;
             
                

            case 21:
            case 22:
            case 23:
            case 24:
                
            //this is the back button in the options so show the menue again and set the options
            //cause there could be something changed    
            case 25:
                drawMenue();
                steuerung.optionsChanged();
                break;
        }
        return 0;
    }
    
    private void getStringInput(int pMenue)
    {
        
    }
    
    
    
    
    
/*****************************************************************************************************
 *  Additional functions
 */
    
    
    
    //sets the given string into the info label in the game board
    public void setInfo(String info)
    {
        //lGameInfo.setText(info);
    }
    
    //change the given number of button to the given text
    public void changeButton(int id,String title)
    {
        /*
        buttons.get(id+4).setText(title);
        buttons.get(id+4).setEnabled(true);  
        */
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
       return "";//txtNameP1.getText();
    }
    
    public String getPlayerName2()
    {
        return "";//return txtNameP2.getText();
    }
    
    public String getPlayerSymb1()
    {
        return "";//txtSymbP1.getText();
    }
    
    public String getPlayerSymb2()
    {
        return "";//txtSymbP2.getText();
    }
}

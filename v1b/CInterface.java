package v1b;


import java.util.Scanner;


 
public class CInterface 
{   
    String iaField[][] = new String[3][3];
    
    private String sP1Symb = "o";
    private String sP2Symb = "x";
    private String sP1Name = "Player 1";
    private String sP2Name = "Player 2";
    
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
        
        setInfo("Bye Bye!!");
        
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {

        }
    }
    
    //initialises the game board
    private void drawBoard()
    {
        boolean bContinue = true;
        String r1 = "", r2="",r3="";
        String empty = "-+-+-";
        
        
        while(bContinue)
        {
            //info was printed before
            
            //print field
            
              System.out.println("\n");
            
              r1 = String.format("%s|%s|%s",iaField[0][0],iaField[0][1],iaField[0][2]);
              r2 = String.format("%s|%s|%s",iaField[1][0],iaField[1][1],iaField[1][2]);
              r3 = String.format("%s|%s|%s",iaField[2][0],iaField[2][1],iaField[2][2]);
            
              System.out.println(r1);
              System.out.println(empty);
              System.out.println(r2);
              System.out.println(empty);
              System.out.println(r3);
              
              
              System.out.println("\n\n(1) Reset"); 
              System.out.println("(2) Return"); 
              System.out.println("(3) Continue"); 
            if(getIntInput(menues.Game.ordinal())== 2)
            {
                bContinue = false;
                break;
            }
            
        }
        
        
        for(int i = 0;i < 50;i++)
        {
            System.out.println();
        }
    }
    
    
    //initialises the option panel
    private void drawOptions()
    {
        boolean bContinue = true;
        while(bContinue)
        {
            System.out.println("\n\nOptions-Menue");
            System.out.println("-----------------\n");
            System.out.println("\n(1) Change name p1   -"+ sP1Name); 
            System.out.println("(2) Change name p2   -"    + sP2Name); 
            System.out.println("(3) Change Symbol p1 -"    + sP1Symb); 
            System.out.println("(4) Change Symbol p2 -"    + sP2Symb); 
            System.out.println("(5) Back to menue"); 
            
            if(getIntInput(menues.Options.ordinal())== 5)
            {
                bContinue = false;
                break;
            }
        } 
    }
    
    
    
    
    
    
    
    private void makeSpace()
    {
        for(int i = 0; i< 100;i++)
        {
            System.out.println();
        }
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
                
            case 4:
                return ip;
        }
        
        switch(ip)
        {
        	//first button - so initialise singleplayer
            case 1:
                makeSpace();
            	resetGame();
                steuerung.initSingleplayer();
                drawBoard();
                break;
            //second button -so initialise multiplayer
            case 2:
                makeSpace();
            	resetGame();
                steuerung.initMultiplayer();
                drawBoard();
                break;
            
            //third button - so open the options
            case 3:
                makeSpace();
                drawOptions();
                break;
            
            //forth button - so close the game
            case 4:
                
                return 4;
     
                
            // this button is the reset button so reset the game     
            case 11:
                makeSpace();
                steuerung.resetGame();
                break;
                
            // this button is the return button in the game so show the menue again    
            case 12:
                makeSpace();
                drawMenue();;
                return 2;
                
            // continue    
            case 13:
                // enter step next
                boolean wrong_move = true; 
                int iRow = 0;
                int iCol = 0;
                
                do
                {
                    System.out.print(" \nWhich row:");
                    iRow = getIntInput(4);
                    if(iRow > 3 || iRow <1)
                    {
                        System.out.println("Please enter a row between 1 and 3!");
                        continue;
                    }
                    
                    
                    System.out.print(" \nWhich col:");
                    iCol = getIntInput(4);
                    if(iCol > 3 || iCol <1)
                    {
                        System.out.println("Please enter a col between 1 and 3!");
                        continue;
                    }
                    
                    
                    if(iaField[iRow-1][iCol-1].equals(" "))
                    {
                        
                    }
                    else 
                    {
                        System.out.println("Please choose an empty field!");
                        continue;
                    }
                    
                    wrong_move = false;
                     
                }
                while (wrong_move);
                
                steuerung.playerMadeMove( (iRow-1) *3   +(iCol-1));
                
                break;
             
                
            //change name p1
            case 21:
                System.out.println("Enter new name for Player 1:");
                sP1Name = getStringInput();
                steuerung.optionsChanged();
                break;
            
            case 22:
                System.out.println("Enter new name for Player 2:");
                sP2Name = getStringInput();
                steuerung.optionsChanged();
                break;
                
                
            //change symb p1
            case 23:
                System.out.println("Enter new symbol for Player 1:");
                sP1Symb = getStringInput();
                steuerung.optionsChanged();
                break;
                
                
            //change symb p2
            case 24:
                System.out.println("Enter new symbol for Player 2:");
                sP2Symb = getStringInput();
                steuerung.optionsChanged();
                break;
                
            //this is the back button in the options so show the menue again and set the options
            //cause there could be something changed    
            case 25:
                makeSpace();
                drawMenue();
                //steuerung.optionsChanged();
                return 5;
                
            case 30: 
                return ip;
            
        }
        return 0;
    }
    
    private String getStringInput()
    {
        String ip = input.next();
        
        input.reset();
        return ip;
    }
    
    
    
    
    
/*****************************************************************************************************
 *  Additional functions
 */
    
    
    
    //sets the given string into the info label in the game board
    public void setInfo(String info)
    {
        System.out.println(info);
    }
    
    //change the given number of button to the given text
    public void changeButton(int id,String title)
    {
        iaField[(int)Math.floor(id/3)] [id%3]= title;
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
      return sP1Name;
    }
    
    public String getPlayerName2()
    {
        return sP1Name;
    }
    
    public String getPlayerSymb1()
    {
        return sP1Symb;
    }
    
    public String getPlayerSymb2()
    {
        return sP2Symb;
    }
}

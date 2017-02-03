package v1;


public class CSteuerung
{
    private CGame game;
    private COptions o;
    private CInterface intf;
    private CComputer c;
    
    
    //constructor for this class
    //initialises needed things
    public CSteuerung(CInterface pInt)
    {
        intf = pInt;
        o = new COptions();
        
    }
    
    //function to reset the game
    public void resetGame()
    {
    	//resets the button looks
        intf.resetGame();
        
        
        
        //resets the came data
        
        //initialises a new game
        if(game.getHumanPlayer()==false)
        {
        	initSingleplayer();
        }
        else
        {
        	initMultiplayer();
        }
    }
    
    
    
    //function to make a move player/computer
    public void playerMadeMove(int fieldnum)
    {
        int row = 0;
        int col = 0;
        String sInfo = "";
        int num = 0;
        
        switch(fieldnum)
        {
            case 0:
                row = 0;
                col = 0;
                break;
                
            case 1:
                row = 0;
                col = 1;
                break;
                
            case 2:
                row = 0;
                col = 2;
                break;
                
                
            case 3:
                row = 1;
                col = 0;
                break;
                
            case 4:
                row = 1;
                col = 1;
                break;
                
            case 5:
                row = 1;
                col = 2;
                break;
                
            case 6:
                row = 2;
                col = 0;
                break;
                
            case 7:
                row = 2;
                col = 1;
                break;
                
            case 8:
                row = 2;
                col = 2;
                break;
        }
        
        
        
        intf.changeButton(fieldnum, o.getPlayerSymbol(game.getActualPlayer()));
        game.makeMove(row, col);
        
        switch(game.checkGameState())
        {
            case 0:
                sInfo = makeTurnString("'s Turn");
                break;
                
            case 1:
                //Player one won
                sInfo = o.getPlayerName(1)+" has won";
                break;
                
            case 2:
                sInfo = o.getPlayerName(2)+" has won";
                break;
                
            case 3:
                sInfo =  "The game has ended tied";
                break;
        }
        
        intf.setInfo(sInfo);
        
        if(game.getGameState() != 0)
        {
        	return;
        }
        
        //check if computer is there and let it make a move + do the checking
       if(game.getHumanPlayer()== false)
       {
           int[] temp = c.MakeTurn(game.getField(),game.getUsedFiels());
           switch(temp[0])
           {
           		case 0:
           			if(temp[1] == 0)
           			{
           				num = 0;
           			}
           			else if(temp[1]== 1)
           			{
           				num = 1;
           			}
           			else
           			{
           				num = 2;
           			}
           			break;
           			
           		case 1:
           			if(temp[1] == 0)
           			{
           				num = 3;
           			}
           			else if(temp[1]== 1)
           			{
           				num = 4;
           			}
           			else
           			{
           				num = 5;
           			}
           			break;
           			
           		case 2:
           			if(temp[1] == 0)
           			{
           				num = 6;
           			}
           			else if(temp[1]== 1)
           			{
           				num = 7;
           			}
           			else
           			{
           				num = 8;
           			}
           			break;
           }
           intf.changeButton(num, o.getPlayerSymbol(game.getActualPlayer()));
           game.makeMove(temp[0], temp[1]);
           
           
           switch(game.checkGameState())
           {
               case 0:
                   sInfo = makeTurnString("'s Turn");
                   break;
                   
               case 1:
                   //Player one won
                   sInfo = o.getPlayerName(1)+" has won";
                   break;
                   
               case 2:
                   sInfo = o.getPlayerName(2)+" has won";
                   break;
                   
               case 3:
                   sInfo =  "The game has ended tied";
                   break;
           }
           intf.setInfo(sInfo);
       }
    }
    
    //function to initialise a multiplayer game
    public void initMultiplayer()
    {
        String info = "";
      
        //creates a new game object
        game = new CGame(true);
        
        // gets the actual player and makes a string
        info = makeTurnString("'s turn");
        
        intf.setInfo(info);
    }
    
  //function to initialise a sibgleplayer game
    public void initSingleplayer()
    {
        String info = "";
        int num = 0;
        
        game = new CGame(false);
        c    = new CComputer();
        
        if(game.getActualPlayer() == 1)
        {
            
            info =  makeTurnString("'s turn");
        }
        else
        {
            int[] temp = c.MakeTurn(game.getField(),game.getUsedFiels());
            
            
            switch(temp[0])
            {
            		case 0:
            			if(temp[1] == 0)
            			{
            				num = 0;
            			}
            			else if(temp[1]== 1)
            			{
            				num = 1;
            			}
            			else
            			{
            				num = 2;
            			}
            			break;
            			
            		case 1:
            			if(temp[1] == 0)
            			{
            				num = 3;
            			}
            			else if(temp[1]== 1)
            			{
            				num = 4;
            			}
            			else
            			{
            				num = 5;
            			}
            			break;
            			
            		case 2:
            			if(temp[1] == 0)
            			{
            				num = 6;
            			}
            			else if(temp[1]== 1)
            			{
            				num = 7;
            			}
            			else
            			{
            				num = 8;
            			}
            			break;
            }
            
            
            intf.changeButton(num, o.getPlayerSymbol(game.getActualPlayer()));
            game.makeMove(temp[0], temp[1]);
            //game.checkGameState();
            
            
            info = makeTurnString("'s turn");
        }
        
        intf.setInfo(info);
    }
    
    //function to change the options
    public void optionsChanged()
    {
    	//set the changed options to the options class
        o.setPlayerName(1, intf.getPlayerName1()); 
        o.setPlayerName(2, intf.getPlayerName2());
        o.setPlayerSymbol(1, intf.getPlayerSymb1());
        o.setPlayerSymbol(2, intf.getPlayerSymb2());
    }
    
    //function that concats a string 
    public String makeTurnString(String pOwnPart)
    {
        String temp ="";
        String player = o.getPlayerName(game.getActualPlayer());;
        temp = player + pOwnPart +"(" +o.getPlayerSymbol(game.getActualPlayer())+")";
        return temp;
    }
}

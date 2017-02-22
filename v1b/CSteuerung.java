package v1b;


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
        
        
        col =fieldnum%3;
        row =(int)Math.floor(fieldnum/3) ;
        
        
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
           
           //array to field number
           num = temp[0]*3+temp[1];
           
          
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
            
            
          //array to field number
            num = temp[0]*3+temp[1];
            
            
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

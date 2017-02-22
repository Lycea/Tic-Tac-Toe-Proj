package v1b;

//Settings
public class COptions {
    
    //Variables
    private String sPlayerName    = "Player 1";
    private String sPlayerName2   = "Player 2";
    private String sPlayerSymbol1 = "o";
    private String sPlayerSymbol2 = "x";
    
    //get the Name of the Player
    public String getPlayerName(int i_playernum)
    {
        if(i_playernum == 1)
        {
            return sPlayerName;
        }
        else if(i_playernum == 2)
        {
            return sPlayerName2; 
        }
        return "  ";
    }

    //set the Name of the Player
    public void setPlayerName(int i_playernum, String s_Name)
    {
        if(i_playernum == 1)
        {
            sPlayerName = s_Name;
        }
        else if(i_playernum == 2)
        {
            sPlayerName2 = s_Name;
        }        
    }

    //get the Symbol of the Player
    public String getPlayerSymbol(int i_player)
    {
        if(i_player == 1)
        {
            return sPlayerSymbol1;
        }
        else if(i_player == 2)
        {
            return sPlayerSymbol2; 
        }     
        
        return "   ";
    }
 
    //Set the Symbol of the Player
    public void setPlayerSymbol(int i_player, String s_symbol)
    {
        if(i_player == 1)
        {
            sPlayerSymbol1 = s_symbol;
        }
        else if(i_player == 2)
        {
            sPlayerSymbol2 = s_symbol;
        }   
    }
    


}
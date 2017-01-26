package v1;

//Settings
public class COptions {
	
	//Variables
	private String sPlayerName;
	private String sPlayerName2;
	private String sPlayerSymbol1;
	private String sPlayerSymbol2;
	
	//get the Name of the Player
    public String getPlayerName(int i_playernum)
    {
    	if(i_playernum == 1)
    	{
    		return sPlayerName;
    	}
    	else
    	{
    		return sPlayerName2; 
    	}
    }

	//set the Name of the Player
    public void setPlayerName(int i_playernum, String s_Name)
    {
    	if(i_playernum == 1)
    	{
    		sPlayerName = s_Name;
    	}
    	else
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
    	else
    	{
    		return sPlayerSymbol2; 
    	}    	
    }
 
	//Set the Symbol of the Player
    public void setPlayerSymbol(int i_player, String s_symbol)
    {
    	if(i_player == 1)
    	{
    		sPlayerSymbol1 = s_symbol;
    	}
    	else
    	{
    		sPlayerSymbol2 = s_symbol;
    	}  	
    }
	


}

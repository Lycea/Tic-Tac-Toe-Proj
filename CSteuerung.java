package v1;

public class CSteuerung
{
    CGame game;
    //COptions o;
    CInterface intf;
    
    
    public CSteuerung(CInterface pInt)
    {
        intf = pInt;
    }
    
    public void resetGame()
    {
        
    }
    
    public void playerMadeMove(int fieldnum)
    {
        
    }
    
    public void initMultiplayer()
    {
        game = new CGame();
    }
    
    public void initSingleplayer()
    {
        String info;
        game = new CGame();
        
        intf.setInfo("Player xs turn");
    }
    
    public void optionsChanged()
    {
        intf.getPlayerName1();
        intf.getPlayerName2();
        intf.getPlayerSymb1();
        intf.getPlayerSymb2();
    }
}

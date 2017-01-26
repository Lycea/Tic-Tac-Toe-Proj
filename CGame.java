package v1;

public class CGame
{
	private boolean bHumanPlayer = true;
	private int iActualPlayer = 0;
	private int[][] iaGameArray;
	private int iGameState  = 0;
	private int iUsedFields = 0;
	
	public void reset_game()
	{
		 iGameState = 0;
		 iaGameArray = new int[3][3];
		 iUsedFields = 0;
	}
	
	public boolean getHumanPlayer()
	{
	 return bHumanPlayer;	
	}
	
	public int getActualPlayer()
	{
		return iActualPlayer;
	}
	
	private void changePlayer(int iActualPlayer)
	{
		if(iActualPlayer == 1)
		{
			iActualPlayer = 2;
		}
		else
		{
			iActualPlayer = 1;
		}
	}
	
	public int checkGameState()
	{
		int temp_state = iGameState;
		 temp_state = checkRows();
		 if(temp_state != 0)
		 {
			 iGameState = temp_state;
			 return  iGameState;
		 }
		 
		checkLines();
		if(temp_state != 0)
		 {
			 iGameState = temp_state;
			 return  iGameState;
		 }
		
		checkDiagonals();
		if(temp_state != 0)
		 {
			 iGameState = temp_state;
			 return  iGameState;
		 }
		
		if(iUsedFields == 9)
		{
			iGameState = 3;
			return iGameState;
		}
		
		return 0;
	}
	
	private int checkRows()
	{
		for(int i = 0; i <3; i++)
		{
			if(iaGameArray[i][0]==iaGameArray[i][1]&&
			   iaGameArray[i][0]==iaGameArray[i][2])
			{
				if(iaGameArray[i][0] == 0)
				{
					return 0;//check which player is it who won and return state
				}
				else if(iaGameArray[i][0] == 1)
				{
					return 1;
				}
				else if(iaGameArray[i][0] == 2)
				{
					return 2;
				}
			}
		}
		return 0;
	}
	
	private int checkLines()
	{
		for(int i = 0; i <3; i++)
		{
			if(iaGameArray[0][i]==iaGameArray[1][i]&&
			   iaGameArray[0][i]==iaGameArray[2][i])
			{
				if(iaGameArray[0][i] == 0)
				{
					return 0;//check which player is it who won and return state
				}
				else if(iaGameArray[0][i] == 1)
				{
					return 1;
				}
				else if(iaGameArray[0][i] == 2)
				{
					return 2;
				}
			}
		}
		return 0;
	}
	
	private int checkDiagonals()
	{
		if(iaGameArray[0][1] ==iaGameArray[1][1]&&
			iaGameArray[0][1]==iaGameArray[2][1])
		{
			if(iaGameArray[0][1] == 0)
			{
				return 0;//check which player is it who won and return state
			}
			else if(iaGameArray[0][1] == 1)
			{
				return 1;
			}
			else if(iaGameArray[0][1] == 2)
			{
				return 2;
			}			
		}
		else if(iaGameArray[1][0] ==iaGameArray[1][1]&&
				iaGameArray[1][0]==iaGameArray[1][2])
			{
			if(iaGameArray[1][0] == 0)
			{
				return 0;//check which player is it who won and return state
			}
			else if(iaGameArray[1][0] == 1)
			{
				return 1;
			}
			else if(iaGameArray[1][0] == 2)
			{
				return 2;
			}			
		}
		return 0;
	}
	
	private int random_Start()
	{
		int start = (Math.random() <= 0.5) ? 1 : 2;
		return start;
	}
	
	public CGame(boolean human)
	{
		 iActualPlayer = random_Start();
		 bHumanPlayer = human;
		 
	}
	
	public int getGameState()
	{
		return iGameState;
	}
	
	public void makeMove(int r, int c)
	{
		
		iaGameArray[r][c] = iActualPlayer;
		iUsedFields++;
	}
	
	public int getUsedFiels()
	{
		return iUsedFields;
	}

}

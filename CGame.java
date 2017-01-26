package v1;
//gamemachanics
public class CGame
{
	//Variables
	private boolean bHumanPlayer = true;
	private int iActualPlayer = 0;
	private int[][] iaGameArray;
	private int iGameState  = 0;
	private int iUsedFields = 0;
	
	//clear the variables
	public void reset_game() 
	{
		 iGameState = 0;
		 iaGameArray = new int[3][3];
		 iUsedFields = 0;
	}
	
	//returns if there is a human player or not
	public boolean getHumanPlayer() 
	{
	 return bHumanPlayer;	
	}
	
	//gets the actual Player
	public int getActualPlayer() 
	{
		return iActualPlayer;
	}
	
	//changes the actual player
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
	
	//check's the rows and cols if there is a winner or not
	public int checkGameState() 
	{
		int temp_state = iGameState;
		 temp_state = checkRows();
		 if(temp_state != 0) //if the gamestate isn't 0
		 {
			 iGameState = temp_state;
			 return  iGameState;
		 }
		 
		checkLines();
		if(temp_state != 0)//if the gamestate isn't 0
		 {
			 iGameState = temp_state;
			 return  iGameState;
		 }
		
		checkDiagonals();
		if(temp_state != 0)//if the gamestate isn't 0
		 {
			 iGameState = temp_state;
			 return  iGameState;
		 }
		
		if(iUsedFields == 9) //if there are no free fields to use
		{
			iGameState = 3; //game ended in a tie
			return iGameState;
		}
		
		return 0;
	}
	
	//checks if there are three identical Symbols in a Row and if so, which ones
	private int checkRows() 
	{
		for(int i = 0; i <3; i++)
		{
			if(iaGameArray[i][0]==iaGameArray[i][1]&& //if the first and the second slot are filled identical
			   iaGameArray[i][0]==iaGameArray[i][2]) //an the first and the third slot are filled identical
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
	
	//checks if there are three identical Symbols in a line and if so, which ones
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
	
	//checks if there are three identical Symbols in a diagonal and if so, which ones
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
	
	//choose a random number, so it's random which player may begin 
	private int random_Start()
	{
		int start = (Math.random() <= 0.5) ? 1 : 2; //take a random number between one and two
		return start;
	}
	
	//classconstructor, call the necessary functions to start the game
	public CGame(boolean human)
	{
		 iActualPlayer = random_Start();//choose a random player
		 bHumanPlayer = human;
		 
	}
	
	//return the state of the game
	public int getGameState()
	{
		return iGameState;
	}
	
	//set the move of the player and increments the used fields
	public void makeMove(int r, int c)
	{
		if (iaGameArray[r][c]==0)
		{
			iaGameArray[r][c] = iActualPlayer; //set the state of the actual player in the slot
			iUsedFields++; //increments the number of used fields
		}
		else
		{
			//do nothing
		}
	}
	
	//return the number of used fields
	public int getUsedFiels()
	{
		return iUsedFields;
	}

}

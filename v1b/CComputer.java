package v1b;
import java.util.Random;

public class CComputer {
    
    private int iMove[] = new int[3] ;
    
    
    public CComputer()
    {
        //do nothing
    }
    
    //check the columns for two of the same symbol and place it in between
    private boolean CheckCols( int i_array[][])
    {
    	//each col
        for(int i = 0; i <3; i++)
        {	
        	//check posibilitys
            if(i_array[0][i]==i_array[1][i] && i_array[0][i] != 0 )
            {
                iMove[0] = 2;
                iMove[1] = i;
                return true;
            }
            else if(i_array[0][i]==i_array[2][i]&& i_array[0][i] != 0)
            {
                iMove[0] = 1;
                iMove[1] = i;
                return true;   
            }
            else if(i_array[1][i]==i_array[2][i]&& i_array[1][i] != 0)
            {
                iMove[0] = 0;
                iMove[1] = i;
                return true;   
            }
        }
        return false;
    }
    
    //check the rows for two of the same symbol and place it in between
    private boolean  CheckRows(int i_array[][])
    {
    	//each row
        for(int i = 0; i <3; i++)
        {
            if((i_array[i][0]==i_array[i][1]) && i_array[i][0] != 0) 
            {
                iMove[0] = i;
                iMove[1] = 2;
               return true;
            }
            else if((i_array[i][0]==i_array[i][2])&& i_array[i][0] != 0) 
            {
                iMove[0] = i;
                iMove[1] = 1;
                return true;
            }
            else if((i_array[i][1]==i_array[i][2])&& i_array[i][1] != 0) 
            {
                iMove[0] = i;
                iMove[1] = 0;
                return true;
            }
        }
        return false;
    }
    
    //check the diagonals for two same and place it in between
    private boolean CheckDiagonals(int i_array[][])
    {
        //check top left  to  bottom right
        if((i_array[0][0] == i_array[1][1] )&& i_array[0][0] != 0)
        {
            iMove[0] = 2;
            iMove[1] = 2;
           return true;
        }
        else if((i_array[0][0] == i_array[2][2])&& i_array[0][0] != 0)
        {
            iMove[0] = 1;
            iMove[1] = 1;
           return true;
        }
        else if((i_array[1][1] == i_array[2][2])&& i_array[1][1] != 0)
        {
            iMove[0] = 0;
            iMove[1] = 0;
           return true;
        }
        
        
        //check bottom left to top right
        if((i_array[2][0] == i_array[1][1]) && i_array[2][0] != 0)
        {
            iMove[0] = 0;
            iMove[1] = 2;
           return true;
        }
        else if((i_array[2][0] == i_array[0][2]) && i_array[2][0] != 0)
        {
            iMove[0] = 1;
            iMove[1] = 1;
           return true;
        }
        else if((i_array[1][1] == i_array[0][2]) && i_array[0][2] != 0)
        {
            iMove[0] = 2;
            iMove[1] = 0;
           return true;
        }
        return false;
        
        
    }
    
    
    
    //function for the computer to make a turn
    public int[] MakeTurn(int i_array[][],int act_set)
    {
        boolean bRetry = true;
        Random random = new Random();
        
        //time as seed then it is not always the same if started new
        random.setSeed(System.currentTimeMillis());
        
        // if no one had a turn set one random
        if(act_set == 0)
        {
            iMove[0] = random.nextInt(3);
            iMove[1] = random.nextInt(3);
            return iMove;
        }
        
        
        
        //check if a row has 2 symbols of the same type
        if(CheckRows(i_array))
        {
        	//check if the to made move is doable
        	while(bRetry)
        	{
	        	if(i_array[iMove[0]][iMove[1]]!=0)
	            {
	        		//make another move
	            	 iMove[0] = random.nextInt(3);
	                 iMove[1] = random.nextInt(3);
	            }
	        	
	        	if(i_array[iMove[0]][iMove[1]]==0)
	            {
	        		//break the loop
	                bRetry = false;
	            }
	        	
        	}
            return iMove;
        }
        
        
        //check if a column has 2 symbols of the same type
        if(CheckCols(i_array))
        {
        	while(bRetry)
        	{
        		//check if the to made move is doable
	        	if(i_array[iMove[0]][iMove[1]]!=0)
	            {
	            	 iMove[0] = random.nextInt(3);
	                 iMove[1] = random.nextInt(3);
	            }
	        	if(i_array[iMove[0]][iMove[1]]==0)
	            {
	                bRetry = false;
	            }
        	}
            return iMove;
        }
        
        
        //check the two diagonals for same types
        if(CheckDiagonals(i_array))
        {
        	while(bRetry)
        	{
        		//check if the to made move is doable
	        	if(i_array[iMove[0]][iMove[1]]!=0)
	            {
	            	 iMove[0] = random.nextInt(3);
	                 iMove[1] = random.nextInt(3);
	            }
	        	if(i_array[iMove[0]][iMove[1]]==0)
	            {
	                bRetry = false;
	            }
        	}
            return iMove;
        }
        
        
        
        //no turn found till now so do a random one
        while(bRetry)
        {
            iMove[0] = random.nextInt(3);
            iMove[1] = random.nextInt(3);
            
            if(i_array[iMove[0]][iMove[1]]==0)
            {
                bRetry = false;
            }
        }
        
        return iMove;

    }

}



/*
   
      l   l
      l   l
   ---l---l---
      l   l   
      l   l   
      l   l   
   ---l---l---
      l   l   
      l   l
      l   l


      l l
     -l-l-
      l l
     -l-l-
      l l
*/
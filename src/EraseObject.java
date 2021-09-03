import java.io.*;
import java.util.*;

public class EraseObject {
private String[][] board;
public EraseObject()
{
	board = new String[20][20];
	initialize();
}

private void initialize()
{
	try
	{
		Scanner steve = new Scanner(new File("digital.txt"));
	    int numCombos = steve.nextInt();
	    while(steve.hasNextInt())
	    		board[steve.nextInt()-1][steve.nextInt()-1] = "@";
        for(int i = 0; i< board.length; i++)
          for(int c = 0; c< board.length; c++)
        	 if(board[i][c] == null)
        		 board[i][c] = "-";
       
	}
    catch(Exception e)
    {
    	System.out.println("nuub");
    }
}



private void erase(String [][] matrix, int row, int col)
{

	if(row>= 1 && row<=board.length && col>= 1 && col <= board.length)
	{
	   if(board[row-1][col-1].equals("@"))
	   {
		  board[row-1][col-1] = "-";


		 
		  erase(board, row-1, col);
		  erase(board, row, col-1);
		  erase(board, row+1, col);
		  erase(board, row, col+1);
	     
	   }
	}
	
}



public void prompt()
{
	String bob;
	Scanner in = new Scanner(System.in);
	do
	{
	
	int row=0;
	int col=0;

	System.out.print("Enter a row number (1-20): ");
	while(row<1 ||row>20)
	{
		row = tryNum();
	}
	System.out.print("Enter a column number (1-20): ");
	while(col<1 ||col>20)
	{
		col = tryNum();
	}
    erase(board,row,col);
    output();
    System.out.println("Press enter to try another coordinate or type \"end\" to quit: ");
    System.out.println();
	} while(in.nextLine().indexOf("end") == -1);

	  
}

private int tryNum()
{
	Scanner in= new Scanner(System.in);
	int num = 0;
	String total = "";

	try
	{

		total = in.nextLine();
	    num = Integer.parseInt(total);
	}
	catch(Exception e)
	{

		
	}
	if( ( num<1 ||num>20))
	{
		System.out.print("Enter an integer (1-20) noob: ");
		
	}
	return num;
}

public void output()
{
	System.out.println("  12345678901234567890");
	int row;
	for(row = 1;row<=board.length; row++)
	{
		if(row<10)
			System.out.print(" "+ row);
		else
			System.out.print(row);
	  for(int col = 0; col< board.length; col++)
		  System.out.print(board[row-1][col]);
	  System.out.println();
	}
}
}

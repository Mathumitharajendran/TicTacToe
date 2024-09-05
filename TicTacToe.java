package com.game;

import java.util.*;

public class TicTacToe {

	
	private static char board[][] =new char[3][3];
    private static char currentPlayer='X';
    
private static void initializeBoard()
{
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<3;j++)
		{
			board[i][j]='-';
		}
	}
}


private static void printBoard()
{
	System.out.println("-------------");
	for(int i=0;i<3;i++)
	{
		System.out.print("| ");
		for(int j=0;j<3;j++)
		{
			System.out.print(board[i][j]+" | ");
			
		}
		System.out.println();
		System.out.println("-------------");
	}
}


private static boolean isValidMove(int row,int col)
{
	 return (row>=0 && row<3 && col>=0 && col<3 && board[row][col]=='-');	 	
}



private static boolean isWinner()
{
for(int i=0;i<3;i++)
{
	if(board[i][0]==currentPlayer&&board[i][1]==currentPlayer&&board[i][2]==currentPlayer) 
	return true;
	{
		if(board[0][i]==currentPlayer&&board[1][i]==currentPlayer&&board[2][i]==currentPlayer)
			return true;
		{
			if(board[0][0]==currentPlayer&&board[1][1]==currentPlayer&&board[2][2]==currentPlayer)
				return true;
			{
				if(board[0][2]==currentPlayer&&board[1][1]==currentPlayer&&board[2][0]==currentPlayer)
					return true;
			
			}
		}
	}
}
return false;
}


private static boolean isBoardFull()
{
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<3;j++)
		{
			if(board[i][j]=='-')
			{
				return false;
			}
		}
	}
	return true;
}






public static void main(String[] args) {
    //TicTacToe tic= new TicTacToe();
    initializeBoard();
    printBoard();	
 
	
Scanner sc=new Scanner (System.in);
boolean gameOver=false;

while(!gameOver)
{
	System.out.println("Player "+currentPlayer+" enter the row[0-3]col[0-3]");
	int row=sc.nextInt()-1;
	int col=sc.nextInt()-1;
	
	if(isValidMove(row,col))
	{
		board[row][col]=currentPlayer;
		printBoard();
	}else
	{
		System.out.println("Invalid move");
	}
	
	if(isWinner())
	{
		System.out.println(currentPlayer+" Player wins");
		gameOver=true;
	}
	else if(isBoardFull())
	{ 
		System.out.println("Match draw");
		gameOver=true;
	}
	else
	{
		currentPlayer=(currentPlayer=='X')?'O':'X';
	}
    }
    sc.close();
    }

}


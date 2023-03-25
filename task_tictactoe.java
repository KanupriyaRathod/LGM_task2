import java.util.Scanner;
class Main{
public static void main(String[] args){
 Scanner s=new Scanner(System.in);

    char[][] grid=new char[3][3];
    
    for (int i=0;i<3;i++)
    {
       for(int j=0;j<3;j++)
        {
          grid[i][j] ='-';
        }
    }

    //Keep track whose turn it is 
    boolean isPlayer1=true;

//keep track if the has ended
  boolean gameEnded=false;
   
  while(!gameEnded){
    
//display the grid
    displayGrid(grid);
 
 //Keep track of what symbol we are using to play
  char symbol='-';
   if(isPlayer1){
    symbol='X';
  }
  else{
    symbol='0';
  }

  //Print out the player's turn
  if(isPlayer1){
  System.out.println( "Player 1's Turn (X):");  
  }
  else{
    System.out.println("Player 2's Turn (0):");
  }

int row=0;
int col=0;

while(true){
  //Get row and column from user
  System.out.println("Enter a row (0,1 or 2): ");
  row=s.nextInt();

  System.out.println("Enter a column(0,1 or 2): ");
  col=s.nextInt();

  //Check if row and column are valid
  if(row<0 || col<0 || row>2 || col>2){
    System.out.println("Row and column are out of bounds");
   }
  else if(grid[row][col]!='-'){
    //grid position has an X or 0
    System.out.println("Someone has already made a over there");
  }
  else{
//row and column are valid
       break;
      }
    }
    //Setting the position on the grid to the player's symbol
    grid[row][col]=symbol;
   
   //check if a player has won
   if(hasWon(grid) =='X'){
    //player 1 has won
    System.out.println("Player1 has won!");
    gameEnded=true;
    } 
   else if(hasWon(grid) =='0'){
    //player 2 has won
      System.out.println("Player2 has won!");
       gameEnded=true;
    }
    else{
    //nobody won
     if (hasTied(grid)){
       System.out.println("It's a tie!");
        gameEnded=true;
     }
     else{
    //continue the game and toggle the turn
       isPlayer1=!isPlayer1;
     }
    }
  }
  //print out final states of the grid
  displayGrid(grid);
}

//printing out the grid
public static void displayGrid(char[][] grid)
{
     for (int i=0;i<3;i++)
   {
       for(int j=0;j<3;j++)
       {
         System.out.print(grid[i][j]);
        }
        System.out.println();
    }
}
 
public static char hasWon(char[][] grid){
// row
 for(int i=0;i<3;i++)
{
  if(grid[i][0]==grid[i][1] && grid[i][1]==grid[i][2] && grid[i][0] !='-')
  {
    return grid[i][0];
  }
}

//col
 for(int j=0;j<3;j++)
{
   if(grid[0][j]==grid[1][j] && grid[1][j]==grid[2][j] && grid[0][j] !='-')
   {
    return grid[0][j];
   }
 }

//diagonals
  if(grid[0][0]==grid[1][1] && grid[1][1]==grid[2][2] && grid[0][0] !='-')
  {
    return grid[0][0];
  }

  if(grid[2][0]==grid[1][1] && grid[1][1]==grid[0][2] && grid[2][0] !='-')
  {
    return grid[2][0];
  }

//nobody won
   return '-';
}

//check if the grid is full
public static boolean hasTied(char[][]grid)
{
 for(int i=0;i<3;i++)  
 {
    for(int j=0;j<3;j++){
        if(grid[i][j]=='-'){
            return false;
        }
    }
 } 
 return true;
}
}

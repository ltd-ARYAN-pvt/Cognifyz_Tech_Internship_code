//Description: Implement a two-player tic-tac-toe game. Display the game board and prompt each player to enter their moves. Check for a winning condition or a draw after each move, and display the result accordingly. Allow the players to play multiple rounds if desired.

import java.util.Scanner;
class TicTacToe{
    static char[][] board;

    public TicTacToe(){
        board=new char[3][3];
        initBoard();
    }

    public void initBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
    }

    public void displayBoard(){
        System.out.println("-------------");
        for(int i=0;i<board.length;i++){
            System.out.print("| ");
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static public void placeMark(int r,int c,char mark){
        if((r>=0) && (r<=2) && (c>=0) && (c<=2)){
            board[r][c]=mark;
        }
        else{
            System.out.println("Invalid Coordinates");
        }
    }

    public boolean rowCheck(){
        for(int i=0;i<3;i++){
            if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]){
                return true;
            }
        }
        return false;
    }

    public boolean colCheck(){
        for(int j=0;j<3;j++){
            if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]){
                return true;
            }
        }
        return false;
    }

    public boolean diagCheck(){
        if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2]){
            return true;
        }
        if(board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0]){
            return true;
        }
        return false;
    }
}

class Player{
    String name;
    char mark;

    Player(String n,char m){
        name=n;
        mark=m;
    }

    void makeMove() {
        int r, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row and column");
        r = sc.nextInt();
        c = sc.nextInt();
        
        while (!isValidMove(r, c)) {
            System.out.println("Invalid move. Please try again.");
            r = sc.nextInt();
            c = sc.nextInt();
        }

        TicTacToe.placeMark(r, c, mark);
        //Comment here
        sc.close();
    }

    boolean isValidMove(int r,int c){
        if((r>=0) && (r<=2) && (c>=0) && (c<=2)){
            if(TicTacToe.board[r][c]==' '){
                return true;
            }
        }
        return false;
    }
}

public class L2_T1 {
    public static void main(String[] args) {
        TicTacToe t=new TicTacToe();
        Player p1=new Player("Aryan", 'O');
        Player p2=new Player("Sumit", 'X');
        Player currP;
        currP=p1;
        System.out.println(p1.name+" and "+p2.name+" are going to play the game of TicTacToe");
        System.out.println("*********************************");
        System.out.println();
        System.out.println("First move is given to "+currP.name);
        while(true){
            t.displayBoard();
            System.out.println(currP.name+" Turn");
            currP.makeMove();

            if(t.colCheck() || t.diagCheck() || t.rowCheck()){
                t.displayBoard();
                System.out.println(currP.name+" Won The Game");
                break;
            }
            else{
                if(currP==p1){
                    currP=p2;
                }
                else{currP=p1;}
            }
        }
    }
}
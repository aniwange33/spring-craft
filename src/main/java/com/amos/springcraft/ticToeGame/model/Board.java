package com.amos.springcraft.ticToeGame.model;

public class Board {

    private PlayingPiece [][] board;
    private  int size;
    public Board(int size)
    {
        this.size = size;
        board = new PlayingPiece[size][size];
    }



   public boolean addPiece(int x, int y, PlayingPiece playingPiece){
        if(board[x][y] == null) {
            board[x][y] = playingPiece;
            return true;
        }
        return false;
   }

   public  boolean checkFreeCell(){
         for(int i=0;i<size;i++){
           for(int j=0;j<size;j++){
               if(board[i][j]==null){
                   return  true;
               }
           }
         }
         return false;
   }

}

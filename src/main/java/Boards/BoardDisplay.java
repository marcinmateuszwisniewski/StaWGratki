package Boards;

import GameState.GameStateService;
import Ships.Coordinate;

import java.util.Set;

public class BoardDisplay {
    private GameStateService gameStateService;
    public BoardDisplay(GameStateService gameStateService){
        this.gameStateService = gameStateService;
    }

    public void printBoard(){
        displayBoard(gameStateService.getState().playerHumanBoard);
        displayBoard(gameStateService.getState().playerAIBoard);
    }

    private void displayBoard(Board board){
        Set<Coordinate> hits = board.getHits();
        Set<Coordinate> missed = board.getMissed();

        char[][] grid = new char[Board.SIZE][Board.SIZE];

        for(int i = 0; i<Board.SIZE; i++){
            for (int j = 0; j < Board.SIZE; j++) {
                grid[i][j] = '-';
            }
        }

        hits.forEach(c -> grid[c.row][c.column] = 'X');
        missed.forEach(c -> grid[c.row][c.column] = 'O');

        for(int i = 0; i<Board.SIZE; i++){
            System.out.print((char)(i+65));
            for (int j = 0; j < Board.SIZE; j++) {
                System.out.print(String.format(" %c ",grid[i][j]));
            }
            System.out.println();
        }




    }


}

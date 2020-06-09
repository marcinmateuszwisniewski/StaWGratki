package Boards;

import Constants.GameConstants;
import GameState.GameStateService;
import Ships.Coordinate;
import Ships.Ship;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class BoardDisplay {
    private GameStateService gameStateService;
    public BoardDisplay(GameStateService gameStateService){
        this.gameStateService = gameStateService;
    }

    public void printBothBoards(){
        displayBoard(gameStateService.getState().playerHumanBoard);
        displayBoard(gameStateService.getState().playerAIBoard);
    }

    public void printShipsSetup(Set<Ship> ships){

        Set<Coordinate> coordinates = ships.stream().map(Ship::getPosition).flatMap(Collection::stream).collect(Collectors.toSet());
        char[][] grid = getEmptyGrid();
        coordinates.forEach(c -> grid[c.getRow()][c.getColumn()] = 'X');
        printGrid(grid);


    }

    private void displayBoard(Board board){
        Set<Coordinate> hits = board.getHits();
        Set<Coordinate> missed = board.getMissed();

        char[][] grid = getEmptyGrid();

        hits.forEach(c -> grid[c.getRow()][c.getColumn()] = 'X');
        missed.forEach(c -> grid[c.getRow()][c.getColumn()] = 'O');

        printGrid(grid);


    }

    private void printGrid(char[][] grid) {
        for(int i = 0; i< GameConstants.BOARD_SIZE; i++){
            System.out.print((char)(i+65));
            for (int j = 0; j < GameConstants.BOARD_SIZE; j++) {
                System.out.print(String.format(" %c ",grid[i][j]));
            }
            System.out.println();
        }
    }

    private char[][] getEmptyGrid() {
        char[][] grid = new char[GameConstants.BOARD_SIZE][GameConstants.BOARD_SIZE];

        for(int i = 0; i<GameConstants.BOARD_SIZE; i++){
            for (int j = 0; j < GameConstants.BOARD_SIZE; j++) {
                grid[i][j] = '-';
            }
        }
        return grid;
    }


}

package boards;

import constants.BoardSize;
import gamestate.GameState;
import gamestate.GameStateService;
import ships.Coordinate;
import ships.Ship;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class BoardDisplay {
    private GameStateService gameStateService;
    public BoardDisplay(GameStateService gameStateService){
        this.gameStateService = gameStateService;
    }

    public void printBothBoards(){

        //TODO: Wyświetlać je obok?

        GameState state = gameStateService.getState();
        System.out.println(state.playerHumanName);
        displayBoard(state.playerHumanBoard);
        System.out.println(state.playerAIName);
        displayBoard(state.playerAIBoard);
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
        for(int i = 0; i< BoardSize.STANDARD.size; i++){
            System.out.print((char)(i+65));
            for (int j = 0; j < BoardSize.STANDARD.size; j++) {
                System.out.print(String.format(" %c ",grid[i][j]));
            }
            System.out.println();
        }
    }

    private char[][] getEmptyGrid() {
        char[][] grid = new char[BoardSize.STANDARD.size][BoardSize.STANDARD.size];

        for(int i = 0; i< BoardSize.STANDARD.size; i++){
            for (int j = 0; j < BoardSize.STANDARD.size; j++) {
                grid[i][j] = '-';
            }
        }
        return grid;
    }


}

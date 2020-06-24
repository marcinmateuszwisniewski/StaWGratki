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
    private BoardSize boardSize;
    public BoardDisplay(GameStateService gameStateService, BoardSize size){
        this.gameStateService = gameStateService;
        this.boardSize = size;
    }

    public void printBothBoards(){

        //TODO: Wyświetlać je obok?

        GameState state = gameStateService.getState();
        System.out.println(state.getPlayerOne().getName());
        displayBoard(state.getPlayerOne().getBoard());
        System.out.println(state.getPlayerTwo().getName());
        displayBoard(state.getPlayerTwo().getBoard());
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
        System.out.print(' ');
        for(int i = 0; i< boardSize.value;i++){
            System.out.print(String.format(" %d ",i));
        }
        System.out.println();
        for(int i = 0; i< boardSize.value; i++){
            System.out.print((char)(i+65));
            for (int j = 0; j < boardSize.value; j++) {
                System.out.print(String.format(" %c ",grid[i][j]));
            }
            System.out.println();
        }
    }

    private char[][] getEmptyGrid() {
        char[][] grid = new char[boardSize.value][boardSize.value];

        for(int i = 0; i< boardSize.value; i++){
            for (int j = 0; j < boardSize.value; j++) {
                grid[i][j] = '-';
            }
        }
        return grid;
    }


}

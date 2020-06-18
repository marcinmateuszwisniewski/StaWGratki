package gamestate;

import boards.Board;

public class GameState {
    public String playerOneName;
    public String playerTwoName;
    public Board playerOneBoard;
    public Board playerTwoBoard;


    GameState(String playerName, String aiName){
        this.playerOneName = playerName;
        this.playerTwoName = aiName;
        this.playerTwoBoard = boards.BoardService.newBoard();
        this.playerOneBoard = boards.BoardService.newBoard();

    }

    private GameState() {

    }

    public GameState copy() {

        GameState copy = new GameState(this.playerOneName,this.playerTwoName);
        copy.playerOneBoard = playerOneBoard.copy();
        copy.playerTwoBoard = playerTwoBoard.copy();
        return copy;
    }
}

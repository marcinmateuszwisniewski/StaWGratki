package gamestate;

import boards.Board;

public class GameState {
    public String playerHumanName;
    public String playerAIName;
    public Board playerHumanBoard;
    public Board playerAIBoard;


    GameState(String playerName, String aiName){
        this.playerHumanName = playerName;
        this.playerAIName = aiName;
        this.playerAIBoard = boards.BoardService.newBoard();
        this.playerHumanBoard = boards.BoardService.newBoard();

    }

    private GameState() {

    }

    public GameState copy() {

        GameState copy = new GameState(this.playerHumanName,this.playerAIName);
        copy.playerHumanBoard = playerHumanBoard.copy();
        copy.playerAIBoard = playerAIBoard.copy();
        return copy;
    }
}

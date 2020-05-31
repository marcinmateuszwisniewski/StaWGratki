package GameState;

public class GameState {
    public String playerHumanName;
    public String playerAIName;
    public Boards.Board playerHumanBoard;
    public Boards.Board playerAIBoard;

    GameState(String playerName, String aiName){
        this.playerHumanName = playerName;
        this.playerAIName = aiName;
        this.playerAIBoard = Boards.BoardService.newBoard();
        this.playerHumanBoard = Boards.BoardService.newBoard();

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

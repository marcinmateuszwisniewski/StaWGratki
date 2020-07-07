package gamestate;

import boards.Player;
import constants.PlayerEnum;
import lombok.Getter;
import lombok.NonNull;

public class GameState {

    @Getter
    private Player playerOne;
    @Getter
    private Player playerTwo;

    public Player getPlayer(@NonNull PlayerEnum player){

        if(player == PlayerEnum.ONE){
            return playerOne;
        }
        else if (player == PlayerEnum.TWO){
            return playerTwo;
        }
        else return null;
    }


    GameState(String playerName, String aiName){
        playerOne = new Player(playerName,boards.BoardService.newBoard());
        playerTwo = new Player(aiName,boards.BoardService.newBoard());

    }


    private GameState() {

    }

    GameState copy() {

        GameState copy = new GameState();
        copy.playerOne = this.playerOne.copy();
        copy.playerTwo = this.playerTwo.copy();
        return copy;
    }
}

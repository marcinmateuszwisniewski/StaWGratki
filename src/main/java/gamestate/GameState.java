package gamestate;

import boards.Board;
import boards.Player;
import constants.PlayerEnum;
import lombok.Getter;
import lombok.NonNull;

/**
 * The type Game state.
 */
public class GameState {

    @Getter
    private Player playerOne;
    @Getter
    private Player playerTwo;

    /**
     * Get player player.
     *
     * @param player the player
     * @return the player
     */
    public Player getPlayer(@NonNull PlayerEnum player){

        if(player == PlayerEnum.ONE){
            return playerOne;
        }
        else if (player == PlayerEnum.TWO){
            return playerTwo;
        }
        else return null;
    }


    /**
     * Instantiates a new Game state.
     *
     * @param playerName the player name
     * @param aiName     the ai name
     */
    GameState(String playerName, String aiName){
        playerOne = new Player(playerName,boards.BoardService.newBoard());
        playerTwo = new Player(aiName,boards.BoardService.newBoard());

    }


    private GameState() {

    }

    /**
     * Copy game state.
     *
     * @return the game state
     */
    GameState copy() {

        GameState copy = new GameState();
        copy.playerOne = this.playerOne.copy();
        copy.playerTwo = this.playerTwo.copy();
        return copy;
    }
}

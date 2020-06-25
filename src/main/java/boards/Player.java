package boards;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Player.
 */
@Data
@AllArgsConstructor()
public class Player {
    private String name;
    private Board board;

    /**
     * Instantiates a new Player.
     */
    Player(){}

    /**
     * Copy player.
     *
     * @return the player
     */
    public Player copy(){
        return new Player(name,board.copy());
    }
}

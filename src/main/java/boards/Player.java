package boards;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor()
public class Player {
    private String name;
    private Board board;

    Player(){}

    public Player copy(){
        return new Player(name,board.copy());
    }
}

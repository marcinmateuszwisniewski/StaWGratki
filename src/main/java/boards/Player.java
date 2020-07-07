package boards;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor()
// Tutaj możesz dodać @NoArgsConstructor() też z tego co pamiętam i ustawić mu poziom widoczności na package-private. Pytanie czy faktycznie jest Ci taki potrzebny?
public class Player {
    private String name;
    private Board board;

    Player(){}

    public Player copy(){
        return new Player(name,board.copy());
    }
}

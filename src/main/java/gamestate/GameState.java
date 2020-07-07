package gamestate;

import boards.Board;
import boards.Player;
import constants.PlayerEnum;
import lombok.Getter;
import lombok.NonNull;

public class GameState {

    // nie wiem czy robienie osobnych pól jest ok w tym przypadku
    // to jest kwestia do zastanowienia się, jeżeli chciałbyś zrobić z tego wersję webową
    // to z pewnością każdy gracz ma swoją instancję GameState
    // jeżeli nie chcesz z tego zrobić wersji webowej to IMO lepiej zrobić kolekcję graczy
    // i rozpoznawać ich po poszczególnych polach, ale już graczowskich
    // jeżeli chciałbyś to zrobić w formie getPlayer()
    // to przenieś pole identyfikujące gracza do gracza
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

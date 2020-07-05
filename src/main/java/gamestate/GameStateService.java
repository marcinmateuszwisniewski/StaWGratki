package gamestate;

public final class GameStateService {

    private GameState INSTANCE;


    public GameStateService(){

    }

    public GameState getState() {

        if (INSTANCE == null) {
            INSTANCE = new GameState("default","default");
        }
        return INSTANCE.copy();
    }

    public void updateState(GameState state){
        INSTANCE = state;
    }

}

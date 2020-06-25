package gamestate;

/**
 * The type Game state service.
 */
public final class GameStateService {

    private GameState INSTANCE;


    /**
     * Instantiates a new Game state service.
     */
    public GameStateService(){

    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public GameState getState() {

        if (INSTANCE == null) {
            INSTANCE = new GameState("default","default");
        }
        return INSTANCE.copy();
    }

    /**
     * Update state.
     *
     * @param state the state
     */
    public void updateState(GameState state){
        INSTANCE = state;
    }

}

package gameflow;

import gamestate.GameState;
import gamestate.GameStateService;
import userinput.StartGameCommandLine;

/**
 * The type Game start.
 */
public class GameStart {

    /**
     * The Command line.
     */
    StartGameCommandLine commandLine;
    /**
     * The State service.
     */
    GameStateService stateService;

    /**
     * Instantiates a new Game start.
     *
     * @param commandLine  the command line
     * @param stateService the state service
     */
    public GameStart(StartGameCommandLine commandLine, GameStateService stateService){
        this.commandLine = commandLine;
        this.stateService = stateService;
    }

    /**
     * Init.
     */
    public void init(){
        GameState gameState = stateService.getState();
        System.out.println("Tell your name");
        gameState.getPlayerOne().setName(commandLine.read());
        System.out.println("Name opponent");
        gameState.getPlayerTwo().setName(commandLine.read());
        stateService.updateState(gameState);

    }

}

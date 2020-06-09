package GameFlow;

import GameState.GameState;
import GameState.GameStateService;
import UserInput.StartGameCommandLine;

public class GameStart {

    StartGameCommandLine commandLine;
    GameStateService stateService;

    public GameStart(StartGameCommandLine commandLine, GameStateService stateService){
        this.commandLine = commandLine;
        this.stateService = stateService;
    }

    public void init(){
        GameState gameState = stateService.getState();
        System.out.println("Tell your name");
        gameState.playerHumanName = commandLine.read();
        System.out.println("Name opponent");
        gameState.playerAIName = commandLine.read();
        stateService.updateState(gameState);

    }

}

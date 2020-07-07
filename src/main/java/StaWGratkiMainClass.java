import boards.BoardDisplay;
import constants.BoardSize;
import constants.PlayerEnum;
// zła praktyka, zaśmiecasz sobie przestrzeń nazw jak importujesz wszystko
// importuj tylko to z czego korzystasz faktycznie
import gameflow.*;
import gamestate.GameStateService;
import userinput.StartGameCommandLine;

import java.util.Scanner;

public class StaWGratkiMainClass {
    public static void main(String[] args) {
      System.out.println("srawg(t)atki");
      GameStateService gs = new GameStateService();
      Scanner scanner = new Scanner(System.in);
      GameStart gameStart = new GameStart(new StartGameCommandLine(scanner),gs);
      gameStart.init();
      final BoardDisplay bd = new BoardDisplay(gs, BoardSize.STANDARD);
      //TODO: too many arguments.
        // IMO ilość argumentów jest lepsza ;D
      final ShipSetupInterface setup = new HumanControlledShipSetup(ShipSetupArgumentsProvider.getStandardHumanArgs(), gs, bd);
      setup.setup(PlayerEnum.ONE);

        
    }
}

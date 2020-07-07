package gameflow;

import boards.BoardDisplay;
import constants.ShipRoster;
import gamestate.GameStateService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ships.Coordinate;
import ships.ShipFactory;
import userinput.ShipSetupCommandLine;
import userinput.ShipSetupResponse;

import static org.mockito.Mockito.when;
class HumanControlledShipSetupTest {

    @Mock
    ShipSetupCommandLine commandLine;

    @Mock
    ShipFactory shipFactory;

    @Mock
    ShipRoster shipRoster;

    @Mock
    GameStateService sg;

    @Mock
    BoardDisplay bd;

    @InjectMocks
    HumanControlledShipSetup shipSetup;

    @Mock
    ShipSetupResponse response;


    @Test
    @Disabled
    public void testGetNextAvailableShip(){

        when(response.getFirstCoord()).thenReturn(Coordinate.of(5,5));
        when(response.getSecondCoord()).thenReturn(Coordinate.of(5,6));
        when(response.getLength()).thenReturn(4);
        when(response.getShipName()).thenReturn("debug");

        when(shipRoster.value()).thenReturn(ShipRoster.STANDARD.value());
        when(commandLine.read()).thenReturn(response);
        // postaraj się nie testować całości, chyba że chcesz się pokusić o testy integracyjne
        // zobacz ile już masz tych when() pomyśl czy jesteś w stanie testować mniejszy wycinek, a jeżeli nie to czy jesteś w stanie zrefaktoryzować kod, bo może za dużo się dzieje
        //TODO:Jak przetestować całość?
        //assertTrue(shipSetup.)
    }


}
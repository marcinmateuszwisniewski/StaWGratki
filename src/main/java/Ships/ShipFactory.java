package Ships;

import java.util.Set;

public interface ShipFactory {
    Ship launch(String name, Coordinate first, Coordinate further, int length);
}

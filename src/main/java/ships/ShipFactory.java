package ships;

public interface ShipFactory {
    Ship launch(String name, Coordinate first, Coordinate further, int length);
}

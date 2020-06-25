package ships;

/**
 * The interface Ship factory.
 */
public interface ShipFactory {
    /**
     * Launch ship.
     *
     * @param name    the name
     * @param first   the first
     * @param further the further
     * @param length  the length
     * @return the ship
     */
    Ship launch(String name, Coordinate first, Coordinate further, int length);
}

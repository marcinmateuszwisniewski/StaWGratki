package userinput;

import ships.Coordinate;

/**
 * The interface Coordinates parsing.
 */
public interface CoordinatesParsing {

    /**
     * Parse coordinates coordinate.
     *
     * @param string the string
     * @return the coordinate
     */
    Coordinate parseCoordinates(String string);
}

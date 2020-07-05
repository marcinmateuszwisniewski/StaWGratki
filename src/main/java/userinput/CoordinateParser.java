package userinput;

import constants.BoardSize;
import ships.Coordinate;

public class CoordinateParser implements CoordinatesParsing {

    private BoardSize boardSize;

    private CoordinateParser(){}

    public CoordinateParser(BoardSize size){

        this.boardSize = size;

    }

    public Coordinate parseCoordinates(String coordinate) throws IllegalArgumentException {
        if (coordinate == null || coordinate.length() < 2) {
            throw new IllegalArgumentException("coordinates are incomplete");
        }
        int row = translateLetterToRow(coordinate.toLowerCase().charAt(0));
        int column;
        try {
            column = Integer.parseInt(coordinate.substring(1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("column of: "+coordinate+" is not a number");
        }

        if (row < 0 || row >= boardSize.value)
            throw new IllegalArgumentException("wrong row:" + coordinate);
        if (column < 0 || column >= boardSize.value)
            throw new IllegalArgumentException("wrong column:" + coordinate);

        return Coordinate.of(row, column);

    }

    private static int translateLetterToRow(char charAt) throws IllegalArgumentException{
        if (!Character.isLetter(charAt))  throw new IllegalArgumentException("row is not a letter");
        return charAt - 'a';
    }
}

package ships;

import constants.BoardSize;

import java.util.HashSet;
import java.util.Set;

public class Dockyard implements ShipFactory {

    private BoardSize boardSize;

    private Dockyard(){}

    public Dockyard(BoardSize size){
        this.boardSize = size;
    }

    public Ship launch(Set<Ship> shipSet, Coordinate first, Coordinate further, int length) {

        //shipSet.forEach(ship -> ship.);

        return null;
    }

    @Override
    public Ship launch(String name, Coordinate first, Coordinate further, int originalLength) {
        Set<Coordinate> positions = new HashSet<>();
        int length = originalLength - 2;
        int rowInc = 0;
        int colInc = 0;
        if(first.isNorthTo(further)){
            rowInc += 1;
        }
        if(first.isSouthTo(further)){
            rowInc -= 1;
        }
        if(first.isWestTo(further)){
            colInc += 1;
        }
        if(first.isSouthTo(further)){
            colInc -= 1;
        }

        if(!first.isBy(further)){
            throw new IllegalArgumentException("Not side-by-side");
        }

        positions.add(new Coordinate(first));
        positions.add(new Coordinate(further));

        while (length > 0){
            final int newRow = further.getRow() + (rowInc * length);
            final int newColumn = further.getColumn() + (colInc * length);

            if(newRow >= boardSize.value || newColumn >= boardSize.value || newRow < 0 || newColumn < 0)
                throw new IllegalArgumentException("Ship don't fit into the board");

            Coordinate c = Coordinate.of(newRow, newColumn);
            positions.add(c);
            length--;
        }

        return new Ship(name, positions, originalLength);



    }
}

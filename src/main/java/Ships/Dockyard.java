package Ships;

import java.util.HashSet;
import java.util.Set;

public class Dockyard implements ShipFactory {
    public Ship launch(Set<Ship> shipSet, Coordinate first, Coordinate further, int length) {

        //shipSet.forEach(ship -> ship.);

        return null;
    }

    @Override
    public Ship launch(String name, Coordinate first, Coordinate further, int length) {
        Set<Coordinate> positions = new HashSet<>();
        length-=2;
        int rowInc = 0;
        int colInc = 0;
        if(first.isNorthTo(further)){
            colInc += 1;
        }
        if(first.isSouthTo(further)){
            colInc -= 1;
        }
        if(first.isWestTo(further)){
            rowInc += 1;
        }
        if(first.isSouthTo(further)){
            rowInc -= 1;
        }

        if(!first.isBy(further)){
            throw new IllegalArgumentException("Not side-by-side");
        }

        positions.add(new Coordinate(first));
        positions.add(new Coordinate(further));

        while (length > 0){
            positions.add(Coordinate.of(first.getRow()+rowInc, first.getColumn()+colInc));
            rowInc+=rowInc;
            colInc+=colInc;
            length--;
        }

        return new Ship(name, positions, length);



    }
}

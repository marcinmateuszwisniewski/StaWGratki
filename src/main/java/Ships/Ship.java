package Ships;

public class Ship {

    String name;

    Ship(){}

    public Ship(Ship ship){
        this.name = ship.name;
    }

    public String getName(){
        return this.name;
    }

}

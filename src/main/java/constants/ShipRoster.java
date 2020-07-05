package constants;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

public enum ShipRoster {
    STANDARD(2,2,3,4,5);

    Bag<Integer> roster;


    ShipRoster(int... args){
        roster = new HashBag<>();
        for(int i : args){
            roster.add(i);
        }
    }

    public Bag<Integer> value(){
       return new HashBag<>(roster);
    }


}

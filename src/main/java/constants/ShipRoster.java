package constants;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

/**
 * The enum Ship roster.
 */
public enum ShipRoster {
    /**
     * Standard ship roster.
     */
    STANDARD(2,2,3,4,5);

    /**
     * Roster ship roster.
     */
    Bag<Integer> roster;


    ShipRoster(int... args){
        roster = new HashBag<>();
        for(int i : args){
            roster.add(i);
        }
    }

    /**
     * Value bag.
     *
     * @return the bag
     */
    public Bag<Integer> value(){
       return new HashBag<>(roster);
    }


}

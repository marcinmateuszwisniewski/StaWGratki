package Command;

public class NameCommand extends Command {
    String name;
    public NameCommand(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

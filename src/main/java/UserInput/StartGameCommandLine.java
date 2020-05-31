package UserInput;

import Command.NameCommand;

import java.util.Scanner;

public class StartGameCommandLine {
    private Scanner scanner;

    public StartGameCommandLine(Scanner scanner){
        this.scanner = scanner;
    }

    public NameCommand takeNameCommand(){
        String name = scanner.nextLine().trim();
        while(name.length() == 0){
            name = scanner.nextLine().trim();
        }

        return new NameCommand(name);
    }


}

package UserInput;

import java.util.Scanner;

public class StartGameCommandLine {
    private final Scanner scanner;

    public StartGameCommandLine(Scanner scanner){
        this.scanner = scanner;
    }

    public String read(){
        String name = scanner.nextLine().trim();
        while(name.length() == 0){
            name = scanner.nextLine().trim();
        }

        return name;
    }


}

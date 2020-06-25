package userinput;

import java.util.Scanner;

/**
 * The type Start game command line.
 */
public class StartGameCommandLine {
    private final Scanner scanner;

    /**
     * Instantiates a new Start game command line.
     *
     * @param scanner the scanner
     */
    public StartGameCommandLine(Scanner scanner){
        this.scanner = scanner;
    }

    /**
     * Read string.
     *
     * @return the string
     */
    public String read(){
        String name = scanner.nextLine().trim();
        while(name.length() == 0){
            name = scanner.nextLine().trim();
        }

        return name;
    }


}

package userinput;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StartGameCommandLineTest {

    @Test
    void testReadNormalName() {
        Scanner scanner = new Scanner("test");
        StartGameCommandLine commandLine = new StartGameCommandLine(scanner);
        assertEquals("test",commandLine.read());
    }

    @Test
    void testReadAndTrimName() {
        Scanner scanner = new Scanner("   test   ");
        StartGameCommandLine commandLine = new StartGameCommandLine(scanner);
        assertEquals("test",commandLine.read());
    }

    @Test
    void testReadNameWithWhitespaces() {
        Scanner scanner = new Scanner("test test");
        StartGameCommandLine commandLine = new StartGameCommandLine(scanner);
        assertEquals("test test",commandLine.read());
    }

    @Test
    void testReadNameAfterNewLine() {
        Scanner scanner = new Scanner("\ntest");
        StartGameCommandLine commandLine = new StartGameCommandLine(scanner);
        assertEquals("test",commandLine.read());
    }
}
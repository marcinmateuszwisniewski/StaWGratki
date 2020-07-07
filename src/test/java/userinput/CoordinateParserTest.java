package userinput;

import boards.Board;
import constants.BoardSize;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ships.Coordinate;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateParserTest {



    @Test
    public void testAllValidLowerCaseInputsForStandardBoard(){
        CoordinateParser parser = new CoordinateParser(BoardSize.STANDARD);
        char[] letters = {'a','b','c','d','e','f','g','h','i','j'};
        for(int letterIndex = 0; letterIndex < BoardSize.STANDARD.value; letterIndex++){
            for (int number = 0; number < BoardSize.STANDARD.value; number++) {
                String input = Character.toString(letters[letterIndex]) + number;
                Coordinate output = parser.parseCoordinates(input);
                Coordinate desiredOutput = Coordinate.of(letterIndex,number);
                assertEquals(output, desiredOutput);
            }
        }
    }

    @Test
    public void testAllValidUpperCaseInputsForStandardBoard(){
        CoordinateParser parser = new CoordinateParser(BoardSize.STANDARD);
        char[] letters = {'A','B','C','D','E','F','G','H','I','J'};
        for(int letterIndex = 0; letterIndex < BoardSize.STANDARD.value; letterIndex++){
            for (int number = 0; number < BoardSize.STANDARD.value; number++) {
                String input = Character.toString(letters[letterIndex]) + number;
                Coordinate output = parser.parseCoordinates(input);
                Coordinate desiredOutput = Coordinate.of(letterIndex,number);
                assertEquals(output, desiredOutput);
            }
        }
    }

    @Test
    public void testInvalidCharactersInRowPartShouldFail(){
        CoordinateParser parser = new CoordinateParser(BoardSize.STANDARD);
        char[] letters = {'5','%','/','('};
        for(int letterIndex = 0; letterIndex < letters.length; letterIndex++){

            String input = Character.toString(letters[letterIndex]) + letterIndex;
            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> parser.parseCoordinates(input));
            assertTrue(ex.getMessage().contains("row"));
        }
    }

    @Test
    public void testInvalidCharactersInColumnPartShouldFail(){
        CoordinateParser parser = new CoordinateParser(BoardSize.STANDARD);
        String[] inputs = {"aa","as","a%", "a*", "a ","a1a","a 9"};
        for(String input : inputs){

            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> parser.parseCoordinates(input));
            assertTrue(ex.getMessage().contains("column"));

        }
    }

    @Test
    public void testInvalidTooGreatLowerCaseInputsForStandardBoardShouldFail(){
        CoordinateParser parser = new CoordinateParser(BoardSize.STANDARD);
        String[] inputs = {"ł5","k3","z9"};
        for(String input : inputs){

            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> parser.parseCoordinates(input));
            assertTrue(ex.getMessage().contains("row"));

        }
    }

    @Test
    public void testInvalidTooGreatUpperCaseInputsForStandardBoardShouldFail(){
        CoordinateParser parser = new CoordinateParser(BoardSize.STANDARD);
        String[] inputs = {"Ł5","K3","Z9"};
        for(String input : inputs){

            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> parser.parseCoordinates(input));
            assertTrue(ex.getMessage().contains("row"));

        }
    }

    @Test
    public void testInvalidTooGreatNumberOfColumnForStandardBoardShouldFail(){
        CoordinateParser parser = new CoordinateParser(BoardSize.STANDARD);
        String[] inputs = {"A11","B110","C12"};
        for(String input : inputs){

            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> parser.parseCoordinates(input));
            assertTrue(ex.getMessage().contains("column"));

        }
    }

    @Test
    public void testTooShortInputShouldFail(){
        CoordinateParser parser = new CoordinateParser(BoardSize.STANDARD);
        String[] inputs = {"A","a","1",""," "};
        for(String input : inputs){

            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> parser.parseCoordinates(input));
            assertTrue(ex.getMessage().contains("incomplete"));

        }
    }
}
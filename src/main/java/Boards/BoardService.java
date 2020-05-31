package Boards;

public class BoardService implements BoardServiceInterface {
    public boolean shootAt(String row, int column, Board board) {
        return false;
    }

    public static Board newBoard(){
        return new Board();
    }
}

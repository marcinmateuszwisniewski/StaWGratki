package boards;

/**
 * The type Board service.
 */
public class BoardService implements BoardServiceInterface {
    public boolean shootAt(String row, int column, Board board) {
        return false;
    }

    /**
     * New board board.
     *
     * @return the board
     */
    public static Board newBoard(){
        return new Board();
    }
}

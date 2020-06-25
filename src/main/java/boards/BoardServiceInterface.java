package boards;

/**
 * The interface Board service interface.
 */
public interface BoardServiceInterface {

    /**
     * Shoot at boolean.
     *
     * @param row    the row
     * @param column the column
     * @param board  the board
     * @return the boolean
     */
    boolean shootAt(String row, int column, Board board);
}

package constants;

/**
 * The enum Board size.
 */
public enum BoardSize {

    /**
     * Standard board size.
     */
    STANDARD(10);

    /**
     * The Value.
     */
    public int value;

    BoardSize(int value) {
        this.value = value;
    }
}

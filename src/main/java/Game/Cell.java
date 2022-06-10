/* Cell
 *  Version information
 *  5/10/2022
 *  Copyright User
 */

package Game;

public class Cell {
    private int size;
    private int x, y;

    private STATE state;
    private enum color {RED, GREEN, GREY};
    private int value;

    public Cell(int size) {
        this.size = size;
        this.value = 0;
        this.state = state.EMPTY;
    }

    public STATE getState() {
        return state;
    }

    public Cell(int size, int x, int y) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.state = STATE.EMPTY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void changeState(String s) {
        if (s.equals("L")) {
            this.state = STATE.O;
        } else if (s.equals("R")) {
            this.state = STATE.X;
        } else {
            this.state = STATE.EMPTY;
        }
    }

    @Override
    public String toString() {
        if (state == STATE.EMPTY) {
            return "";
        } else if (state == STATE.O) {
            return "O";
        } else {
            return "X";
        }
    }
}
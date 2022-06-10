

import Game.Cell;
import Game.Creature;
import Game.STATE;
import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;


public class Main extends PApplet {
    final int WIDTH = 800;
    final int HEIGHT = 600;
    final int SIZE = 150;
    final int ROWS = 3;
    final int COLS = 3;
    private Cell cells[][] = new Cell[ROWS][COLS];

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);

    }

    @Override
    public void setup() {
        textAlign(CENTER, CENTER);
        textSize(32);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                cells[i][j] = new Cell(SIZE, WIDTH / 2 + SIZE * j - (int) (SIZE * COLS / 2.0), HEIGHT / 2 + SIZE * i - (int) (SIZE * ROWS / 2.0));
            }

        }
        cells[(int)(Math.random() * ROWS)][(int)(Math.random() * COLS)].setValue(2);
        cells[(int)(Math.random() * ROWS)][(int)(Math.random() * COLS)].setValue(2);
    }

    @Override
    public void draw() {
        background(255);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (cells[i][j].getState() == STATE.O) {
                    fill(200, 0, 0);
                } else if (cells[i][j].getState() == STATE.X) {
                    fill(0, 200, 0);
                } else {
                    fill(100, 100, 100);
                }
                rect(cells[i][j].getX(), cells[i][j].getY(), SIZE, SIZE);
                fill(255);
                textSize(80);
                text(cells[i][j].toString(), cells[i][j].getX() + SIZE/2, cells[i][j].getY() + SIZE/2);
            }
        }
    }

/*
    @Override
    public void mouseClicked(MouseEvent event) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (event.getX() > cells[i][j].getX() &&
                        event.getX() < cells[i][j].getX() + SIZE &&
                        event.getY() > cells[i][j].getY() &&
                        event.getY() < cells[i][j].getY() + SIZE) {
                    cells[i][j].changeState();
                }
            }

        }
    }
*/

    public void mousePressed(MouseEvent event) {
        if (mouseButton == LEFT) {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (event.getX() > cells[i][j].getX() &&
                            event.getX() < cells[i][j].getX() + SIZE &&
                            event.getY() > cells[i][j].getY() &&
                            event.getY() < cells[i][j].getY() + SIZE) {
                        cells[i][j].changeState("L");
                    }
                }
            }
        } else if (mouseButton == RIGHT) {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (event.getX() > cells[i][j].getX() &&
                            event.getX() < cells[i][j].getX() + SIZE &&
                            event.getY() > cells[i][j].getY() &&
                            event.getY() < cells[i][j].getY() + SIZE) {
                        cells[i][j].changeState("R");
                    }
                }
            }
        } else {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    cells[i][j].changeState("E");
                }
            }
        }
    }



    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
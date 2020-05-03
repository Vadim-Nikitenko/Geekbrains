package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;
    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;
    private static int turn = 0;

    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private Graphics2D g2;

    private static int cellHeight;
    private static int cellWidth;
    private int gameMode;


    private boolean isInit = false;


    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (gameMode == 0) {
                    update1(e);
                } else if (turn == 0 && gameMode == 1) {
                    update1(e);
                } else {
                    update2(e);
                }
            }
        });

    }

    private void update1(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!Logic.gameFinished) {
            Logic.setHuman1XY(cellX, cellY);
            if (gameMode == 1) {
                turn = 1;
            }
            checkWin();
        }
        repaint();
    }

    private void update2(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!Logic.gameFinished) {
            Logic.setHuman2XY(cellX, cellY);
            turn = 0;
            checkWin();
        }
        repaint();
    }

    void checkWin() {
        if (Logic.gameFinished) {
            setBackground(Color.GREEN);
            new WinnerWindow().setVisible(true);
            turn = 0;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        g2.setStroke(new BasicStroke(10));
        for (int i = 0; i < Logic.SIZE_Y; i++) {
            for (int j = 0; j < Logic.SIZE_X; j++) {
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
            }
        }

    }

    private void drawO(Graphics g, int cellX, int cellY) {
        g2.setColor(new Color(0, 0, 255));
        g2.fillOval(cellX * cellWidth + 10, cellY * cellHeight + 10, cellWidth - 20, cellHeight - 20);
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        g2.setColor(new Color(255, 3, 0));
        g2.drawLine(cellX * cellWidth + 10, cellY * cellHeight + 10,
                (cellX + 1) * cellWidth - 10, (cellY + 1) * cellHeight - 10);
        g2.drawLine((cellX + 1) * cellWidth - 10, cellY * cellHeight + 10,
                cellX * cellWidth + 15, (cellY + 1) * cellHeight - 15);

    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        setBackground(Color.ORANGE);
        this.gameMode = gameMode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        isInit = true;
        repaint();
    }
}

package lesson8;

import javax.swing.*;
import java.awt.*;

public class StartNewGameWindow extends JFrame {
    private static final int WIN_HEIGHT = 470;
    private static final int WIN_WIDTH  = 400;
    private static final int WIN_POS_X  = 650;
    private static final int WIN_POS_Y  = 450;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int MIN_WIN_LENGTH = 3;
    private JRadioButton jrbHumVsAi;
    private JRadioButton jrbHumVsHum;
    private static ButtonGroup gameMode;
    private JSlider jsFieldSize1;
    private JSlider jsFieldSize2;
    private JSlider jsWinLength;
    private GameWindow gameWindow;

    public StartNewGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(WIN_POS_X, WIN_POS_Y, WIN_WIDTH, WIN_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);
        setLayout(new GridLayout(10, 0));

        add(new JLabel("Choose gameMode:"));
        jrbHumVsAi = new JRadioButton("Hum vs Ai", true);
        jrbHumVsHum = new JRadioButton("Hum vs Hum");
        gameMode = new ButtonGroup();
        gameMode.add(jrbHumVsAi);
        gameMode.add(jrbHumVsHum);
        add(jrbHumVsAi);
        add(jrbHumVsHum);

        add(new JLabel("Choose field size Y:"));
        jsFieldSize1 = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        add(jsFieldSize1);
        jsFieldSize1.setMajorTickSpacing(1);
        jsFieldSize1.setPaintLabels(true);
        jsFieldSize1.setPaintTicks(true);

        jsFieldSize1.addChangeListener(e -> {
            int fieldSize = jsFieldSize1.getValue();
            jsWinLength.setMaximum(fieldSize);
        });

        add(new JLabel("Choose field size X:"));
        jsFieldSize2 = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        add(jsFieldSize2);
        jsFieldSize2.setMajorTickSpacing(1);
        jsFieldSize2.setPaintLabels(true);
        jsFieldSize2.setPaintTicks(true);

        jsFieldSize2.addChangeListener(e -> {
            int fieldSize = jsFieldSize2.getValue();
            jsWinLength.setMaximum(fieldSize);
        });

        add(new JLabel("Choose winning length:"));
        jsWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH);
        add(jsWinLength);
        jsWinLength.setMajorTickSpacing(1);
        jsWinLength.setPaintLabels(true);
        jsWinLength.setPaintTicks(true);

        JButton btnStartGame = new JButton("Start a game");
        add(btnStartGame);
        btnStartGame.addActionListener(e -> {
            btnStartGameClick();
        });
        setVisible(false);
    }

    private void btnStartGameClick() {
        setVisible(false);
        int gameMode;
        if (jrbHumVsAi.isSelected()) {
            gameMode = BattleMap.MODE_H_V_A;
            Logic.setGameMode(0);
        } else {
            gameMode = BattleMap.MODE_H_V_H;
            Logic.setGameMode(1);
        }
        int fieldSizeX = jsFieldSize1.getValue();
        int fieldSizeY = jsFieldSize2.getValue();
        int winLength = jsWinLength.getValue();

        Logic.SIZE_X = fieldSizeX;
        Logic.SIZE_Y = fieldSizeY;
        Logic.DOTS_TO_WIN = winLength;
        Logic.initMap();
        Logic.gameFinished = false;

        gameWindow.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
}

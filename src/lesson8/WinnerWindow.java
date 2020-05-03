package lesson8;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

public class WinnerWindow extends JFrame {
    private static final int WIN_HEIGHT = 450;
    private static final int WIN_WIDTH = 400;
    private static final int WIN_POS_X = 650;
    private static final int WIN_POS_Y = 450;
    private static String text = "";

    public WinnerWindow() {
        setBounds(WIN_POS_X, WIN_POS_Y, WIN_WIDTH, WIN_HEIGHT);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setTitle("Окно победителя");
        setResizable(false);

        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Verdana", BOLD, 20));
        add(label, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        JButton btnExit = new JButton("Exit");
        bottomPanel.add(btnExit);

        btnExit.addActionListener(e -> {
            setVisible(false);
        });
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(false);
    }

    public static void setText(String text) {
        WinnerWindow.text = text;
    }
}

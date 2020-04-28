package lesson7b;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class Window extends JFrame {

    public static final String[][] BUTTON_TEXTS = {
            {"9", "8", "7", "C"},
            {"6", "5", "4", "/"},
            {"3", "2", "1", "*"},
            {"0", "+", "-", "="}
    };

    public Window() {
        setBounds(600, 200, 350, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(350, 50));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        JTextField textField = new JTextField();
        textField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        panel1.add(textField);
        add(panel1, BorderLayout.PAGE_START);

        GridLayout grid = new GridLayout(0, 4);
        JPanel panel2 = new JPanel(grid);
        String str = "";
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < BUTTON_TEXTS.length; i++) {
            for (int j = 0; j < BUTTON_TEXTS[i].length; j++) {
                JButton btn = new JButton(BUTTON_TEXTS[i][j]);
                btn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
                btn.addActionListener( e -> {
                    if(btn.getText().equals("=")){
                        try {
                            double result = calC(textField.getText());
                            textField.setText(result + "");
                            sb.setLength(0);
                            sb.append(result);
                        } catch (ScriptException ex) {
                            ex.printStackTrace();
                        }
                    } else if(btn.getText().equals("C")) {
                        textField.setText("");
                        sb.setLength(0);
                    }else {
                        if(btn.getText().equals("/") || btn.getText().equals("*") ||
                                btn.getText().equals("+") || btn.getText().equals("-")) {
                            if(sb.charAt(sb.length() - 1) == 43 || sb.charAt(sb.length() - 1) == 42 ||
                                    sb.charAt(sb.length() - 1) == 45 || sb.charAt(sb.length() - 1) == 47){
                                sb.setLength(sb.length() - 1);
                            }
                        }
                        textField.setText(sb.append(btn.getText()).toString());
                    }
                });
                panel2.add(btn);
            }
        }

        add(panel2, BorderLayout.CENTER);
        setVisible(true);

    }

    public double calC(String input) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return new BigDecimal(engine.eval(input).toString()).doubleValue();
    }

}

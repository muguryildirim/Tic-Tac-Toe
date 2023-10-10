package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    private final JFrame frame = new JFrame("Tic-Tac-Toe");
    private final JPanel titlePanel = new JPanel();
    private final JPanel buttonPanel = new JPanel();
    private final JLabel textfield = new JLabel("X's Turn");
    private final JButton[] buttons = new JButton[9];
    private boolean isXTurn = true;

    public Game() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());

        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("SAN_SERIF", Font.BOLD, 24));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(400, 100));

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("SAN_SERIF", Font.BOLD, 40));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textfield);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i] && buttons[i].getText().equals("")) {
                if (isXTurn) {
                    buttons[i].setForeground(Color.RED);
                    buttons[i].setText("X");
                    textfield.setText("O's Turn");
                } else {
                    buttons[i].setForeground(Color.BLUE);
                    buttons[i].setText("O");
                    textfield.setText("X's Turn");
                }
                isXTurn = !isXTurn;
                checkWin();
            }
        }
    }

    private void checkWin() {
        int[][] winPatterns = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
                {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] pattern : winPatterns) {
            int a = pattern[0];
            int b = pattern[1];
            int c = pattern[2];

            if (buttons[a].getText().equals(buttons[b].getText()) &&
                    buttons[b].getText().equals(buttons[c].getText()) &&
                    !buttons[a].getText().isEmpty()) {
                highlightWinningCells(a, b, c);
                disableButtons();
                textfield.setText(buttons[a].getText() + " wins!");
                return;
            }
        }

        if (isBoardFull()) {
            textfield.setText("It's a tie!");
        }
    }

    private void highlightWinningCells(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
    }

    private void disableButtons() {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    private boolean isBoardFull() {
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}

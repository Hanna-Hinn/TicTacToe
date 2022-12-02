import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TwoPlayer implements ActionListener {

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1Turn;
	JButton tryAgain = new JButton();

	TwoPlayer() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		textField.setBackground(new Color(50, 50, 50));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);

		tryAgain.setText("Restart Game");
		tryAgain.setFont(new Font("Ink Free", Font.BOLD, 75));
		tryAgain.setFocusable(false);
		tryAgain.addActionListener(this);

		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 100);

		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setBackground(new Color(150, 150, 150));

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(new Color(215,215,215));
		}

		titlePanel.add(textField);
		titlePanel.add(tryAgain, BorderLayout.WEST);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonPanel);

		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == tryAgain) {
			for (int i = 0; i < 9; i++) {
				buttons[i].setText("");
				buttons[i].setEnabled(true);
				buttons[i].setBackground(new Color(215,215,215));
			}
			firstTurn();
		}

		for (int i = 0; i < 9; i++) {

			if (e.getSource() == buttons[i]) {
				if (player1Turn) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						player1Turn = false;
						textField.setText("0 Turn");
						check();
					}
				} else {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("0");
						player1Turn = true;
						textField.setText("X Turn");
						check();
					}
				}
			}

		}

	}

	public void firstTurn() {
		if (random.nextInt(2) == 0) {
			player1Turn = true;
			textField.setText("X Turn");
		} else {
			player1Turn = false;
			textField.setText("0 Turn");
		}
	}

	public void check() {
		// check X Win
		if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
			xWins(0, 1, 2);
		}
		if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
			xWins(3, 4, 5);
		}
		if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(6, 7, 8);
		}

		if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
			xWins(0, 3, 6);
		}
		if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
			xWins(1, 4, 7);
		}
		if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(2, 5, 8);
		}
		if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(0, 4, 8);
		}

		if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
			xWins(2, 4, 6);
		}

		// check 0 Win
		if ((buttons[0].getText() == "0") && (buttons[1].getText() == "0") && (buttons[2].getText() == "0")) {
			oWins(0, 1, 2);
		}
		if ((buttons[3].getText() == "0") && (buttons[4].getText() == "0") && (buttons[5].getText() == "0")) {
			oWins(3, 4, 5);
		}
		if ((buttons[6].getText() == "0") && (buttons[7].getText() == "0") && (buttons[8].getText() == "0")) {
			oWins(6, 7, 8);
		}

		if ((buttons[0].getText() == "0") && (buttons[3].getText() == "0") && (buttons[6].getText() == "0")) {
			oWins(0, 3, 6);
		}
		if ((buttons[1].getText() == "0") && (buttons[4].getText() == "0") && (buttons[7].getText() == "0")) {
			oWins(1, 4, 7);
		}
		if ((buttons[2].getText() == "0") && (buttons[5].getText() == "0") && (buttons[8].getText() == "0")) {
			oWins(2, 5, 8);
		}
		if ((buttons[0].getText() == "0") && (buttons[4].getText() == "0") && (buttons[8].getText() == "0")) {
			oWins(0, 4, 8);
		}

		if ((buttons[2].getText() == "0") && (buttons[4].getText() == "0") && (buttons[6].getText() == "0")) {
			oWins(2, 4, 6);
		}
	}

	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}

		textField.setText("X Wins");
	}

	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}

		textField.setText("0 Wins");
	}

}

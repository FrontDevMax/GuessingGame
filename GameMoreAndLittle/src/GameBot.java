import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameBot extends JFrame {
    private Random rand = new Random();
    private JPanel botPanel;
    private JTextField playerField;
    private JButton continueButton;
    private JButton checkButton;
    private JButton exitToMenuButton;
    private JLabel answerBot;
    private JLabel message;
    private int firstNum = 0, lastNum = 100;

    public GameBot() {
        setTitle("Больше или меньше");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(botPanel);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GameBot(targetNum());
            }
        });
        exitToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GameInterface();
            }
        });
    }

    public GameBot(int targetNum) {
        setTitle("Больше или меньше");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(botPanel);
        message.setText("Введите больше или меньше");
        findNum(targetNum);

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findNum(targetNum);
            }
        });
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GameBot();
            }
        });
        exitToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GameInterface();
            }
        });
    }

    private int targetNum() {
        return Integer.parseInt(playerField.getText());
    }

    private void findNum(int targetNum) {
        try {
            int bot = rand.nextInt(firstNum, lastNum);
            answerBot.setText(Integer.toString(bot));
            if (bot > targetNum) {
                lastNum = bot;
            } else if (bot < targetNum) {
                firstNum = bot;
            } else {
                checkButton.setEnabled(false);
                message.setText("Бот угадал ваше число!");
                continueButton.setVisible(true);
            }
        } catch(NumberFormatException e) {
            message.setText("Вы ввели текст! Или ввели больше 100 или меньше 0!");
        } catch(Exception e) {
            message.setText("Некорректно ввели что-то!");
        }
    }
}
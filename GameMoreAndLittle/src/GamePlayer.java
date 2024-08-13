import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GamePlayer extends JFrame  {
    private Random rand = new Random();
    private final int botTarget = rand.nextInt(0, 100);
    private JTextField playerField;
    private JLabel messageBot;
    private JButton checkButton;
    private JPanel playerPanel;
    private JButton continueButton;
    private JButton exitToMenuButton;
    private JLabel message;

    public GamePlayer() {
        setTitle("Больше или меньше");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(playerPanel);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findNum();
            }
        });
        continueButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               findNum();
               clearFindNum();
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

    private void clearFindNum() {
        continueButton.setVisible(false);
        checkButton.setEnabled(true);
        exitToMenuButton.setVisible(false);
        playerField.setText("");
        messageBot.setText("");
    }

    private void findNum() {
        try {
            byte userNum = Byte.parseByte(playerField.getText());
            if (userNum > botTarget) {
                messageBot.setText("Меньше");
            } else if (userNum < botTarget) {
                messageBot.setText("Больше");
            } else {
                checkButton.setEnabled(false);
                message.setText("Вы угадали число!");
                continueButton.setVisible(true);
            }
        } catch(NumberFormatException e) {
            messageBot.setText("Вы ввели текст! Или ввели больше 100 или меньше 0!");
        } catch(Exception e) {
            messageBot.setText("Некорректно ввели что-то!");
        }
    }
}

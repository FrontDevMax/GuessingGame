import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameInterface extends JFrame {
    private JPanel mainPanel;
    private JButton exitButton;
    private JButton botButton;
    private JButton playerButton;

    public GameInterface() {
        setTitle("Больше или меньше");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(mainPanel);
        botButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GameBot();
            }
        });
        playerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GamePlayer();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}

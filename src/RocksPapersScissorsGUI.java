import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RocksPapersScissorsGUI extends RocksPapersScissors {

    //ICON AND BUTTON INITIALIZATION
    private static final Icon rockIcon = new ImageIcon("Icons/rock.png");
    private static final JButton rockButton = new JButton(rockIcon);
    private static final Icon paperIcon = new ImageIcon("Icons/paper.png");
    private static final JButton paperButton = new JButton(paperIcon);
    private static final Icon scissorsIcon = new ImageIcon("Icons/scissors.png");
    private static final JButton scissorButton = new JButton(scissorsIcon);

    //LABEL INITIALIZATION
    private static final JLabel enemy_choice = new JLabel(" ");
    private static final JLabel prompts = new JLabel(" ");
    private static final JLabel playerScore = new JLabel("0");
    private static final JLabel enemyScore = new JLabel("0");


    public void setGUI() {

        //JFrame Specifications
        JFrame jFrame = new JFrame("ROCK PAPER SCISSORS");
        jFrame.setLayout(new GridLayout());
        jFrame.setBounds(10, 10, 500, 600);

        //JPanel Specifications
        JPanel jPanel = new JPanel();
        jPanel.setBounds(10,10,500,600);
        jPanel.setLayout(null);
        jPanel.setBackground(Color.WHITE);
        jPanel.setVisible(true);

        //JLabel title Specifications
        JLabel title = new JLabel("ROCK PAPER SCISSORS");
        title.setBounds(65,10, 500,100);
        title.setFont(new Font("Arial",Font.BOLD, 30));

        //JLabel enemy_label Specifications
        JLabel enemy_label = new JLabel("ENEMY CHOOSES...");
        enemy_label.setBounds(250,100, 200,100);
        enemy_label.setFont(new Font("Arial",Font.PLAIN, 20));

        //JLabel enemy_choice Specifications
        enemy_choice.setBounds(290,210, 100,100);
        enemy_choice.setOpaque(true);
        enemy_choice.setBackground(Color.WHITE);

        //JLabel prompts Specifications
        prompts.setBounds(200,420, 300,100);
        prompts.setFont(new Font("Arial", Font.BOLD, 20));

        //JLabel playerScoreboard Specifications
        JLabel playerScoreboard = new JLabel("PLAYER:");
        playerScoreboard.setBounds(50,400, 200,200);
        playerScoreboard.setFont(new Font("Arial", Font.BOLD, 20));

        //JLabel enemyScoreboard Specifications
        JLabel enemyScoreboard = new JLabel("ENEMY:");
        enemyScoreboard.setBounds(370,400, 200,200);
        enemyScoreboard.setFont(new Font("Arial", Font.BOLD, 20));

        //JLabel playerScore Specifications
        playerScore.setBounds(80,440, 200,200);
        playerScore.setFont(new Font("Arial", Font.BOLD, 20));

        //JLabel enemyScore Specifications
        enemyScore.setBounds(400,440, 200,200);
        enemyScore.setFont(new Font("Arial", Font.BOLD, 20));


        //JButton ROCK Specifications
        rockButton.setBounds(50,100,100,100);
        rockButton.setOpaque(true);
        rockButton.setBackground(Color.WHITE);

        //JButton PAPER Specifications
        paperButton.setBounds(50,210,100,100);
        paperButton.setOpaque(true);
        paperButton.setBackground(Color.WHITE);

        //JButton SCISSORS Specifications
        scissorButton.setBounds(50,320,100,100);
        scissorButton.setOpaque(true);
        scissorButton.setBackground(Color.WHITE);

        //JButton QUIT
        JButton quitButton = new JButton("QUIT");
        quitButton.setBounds(200, 490,100,50);

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //ADDING ELEMENTS TO PANEL
        jPanel.add(title);
        jPanel.add(enemy_label);
        jPanel.add(enemy_choice);
        jPanel.add(prompts);
        jPanel.add(playerScoreboard);
        jPanel.add(enemyScoreboard);
        jPanel.add(playerScore);
        jPanel.add(enemyScore);
        jPanel.add(rockButton);
        jPanel.add(paperButton);
        jPanel.add(scissorButton);
        jPanel.add(quitButton);

        //ADDING PANEL TO FRAME
        jFrame.add(jPanel);
        jFrame.setVisible(true);

    }

    //GETTERS
    public JButton getRockButton() {
        return rockButton;
    }

    public JButton getPaperButton() {
        return paperButton;
    }

    public JButton getScissorButton() {
        return scissorButton;
    }

    public Icon getRockIcon() {
        return rockIcon;
    }

    public Icon getPaperIcon() {
        return paperIcon;
    }

    public Icon getScissorsIcon() {
        return scissorsIcon;
    }

    public JLabel getEnemyChoice() {
        return enemy_choice;
    }

    public JLabel getPrompts() {
        return prompts;
    }

    public JLabel getPlayerScore() {
        return playerScore;
    }

    public JLabel getEnemyScore() {
        return enemyScore;
    }
}
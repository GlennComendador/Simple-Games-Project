import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RocksPapersScissors {

    //INITIALIZATIONS
    private static final int MAX_NUMBERS = 3;
    private static int enemyScore = 0;
    private static int playerScore = 0;
    private static final RocksPapersScissorsGUI RpsGUI = new RocksPapersScissorsGUI();

    public static void main(String[] args) {

        //Initialize GUI
        RpsGUI.setGUI();

        //Run Game
        run();

    }

    private static void run() {

        //rockButton Event Handling
        RpsGUI.getRockButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                RpsGUI.getPaperButton().setBackground(Color.WHITE);
                RpsGUI.getScissorButton().setBackground(Color.WHITE);
                RpsGUI.getEnemyChoice().setBackground(Color.WHITE);

                int systemNumber = enemyAI();

                if (systemNumber == 1) {

                    RpsGUI.getEnemyChoice().setIcon(RpsGUI.getRockIcon());
                    RpsGUI.getPrompts().setText("IT'S A TIE!");

                } else if (systemNumber == 2) {

                    RpsGUI.getEnemyChoice().setIcon(RpsGUI.getPaperIcon());
                    RpsGUI.getRockButton().setBackground(Color.RED);
                    RpsGUI.getEnemyChoice().setBackground(Color.GREEN);
                    enemyWins();

                } else if (systemNumber == 3) {

                    RpsGUI.getEnemyChoice().setIcon(RpsGUI.getScissorsIcon());
                    RpsGUI.getRockButton().setBackground(Color.GREEN);
                    RpsGUI.getEnemyChoice().setBackground(Color.RED);
                    playerWins();

                }

            }
        });

        //paperButton Event Handling
        RpsGUI.getPaperButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                RpsGUI.getRockButton().setBackground(Color.WHITE);
                RpsGUI.getScissorButton().setBackground(Color.WHITE);
                RpsGUI.getEnemyChoice().setBackground(Color.WHITE);

                int systemNumber = enemyAI();

                if (systemNumber == 1) {

                    RpsGUI.getEnemyChoice().setIcon(RpsGUI.getRockIcon());
                    RpsGUI.getPaperButton().setBackground(Color.GREEN);
                    RpsGUI.getEnemyChoice().setBackground(Color.RED);
                    playerWins();

                } else if (systemNumber == 2) {

                    RpsGUI.getEnemyChoice().setIcon(RpsGUI.getPaperIcon());
                    RpsGUI.getPrompts().setText("IT'S A TIE!");

                } else if (systemNumber == 3) {

                    RpsGUI.getEnemyChoice().setIcon(RpsGUI.getScissorsIcon());
                    RpsGUI.getPaperButton().setBackground(Color.RED);
                    RpsGUI.getEnemyChoice().setBackground(Color.GREEN);
                    enemyWins();

                }
            }
        });

        //scissorButton Event Handling
        RpsGUI.getScissorButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                RpsGUI.getRockButton().setBackground(Color.WHITE);
                RpsGUI.getPaperButton().setBackground(Color.WHITE);
                RpsGUI.getEnemyChoice().setBackground(Color.WHITE);

                int systemNumber = enemyAI();

                if (systemNumber == 1) {

                    RpsGUI.getEnemyChoice().setIcon(RpsGUI.getRockIcon());
                    RpsGUI.getScissorButton().setBackground(Color.RED);
                    RpsGUI.getEnemyChoice().setBackground(Color.GREEN);
                    enemyWins();

                } else if (systemNumber == 2) {

                    RpsGUI.getEnemyChoice().setIcon(RpsGUI.getPaperIcon());
                    RpsGUI.getScissorButton().setBackground(Color.GREEN);
                    RpsGUI.getEnemyChoice().setBackground(Color.RED);
                    playerWins();

                } else if (systemNumber == 3) {

                    RpsGUI.getEnemyChoice().setIcon(RpsGUI.getScissorsIcon());
                    RpsGUI.getPrompts().setText("IT'S A TIE!");

                }

            }
        });
    }

    private static int enemyAI () {

        //ENEMY ACTIONS
        Random randomNumbers = new Random();
        return randomNumbers.nextInt(MAX_NUMBERS) + 1;

    }

    private static void playerWins() {

        RpsGUI.getPrompts().setText("YOU WIN!  ");
        playerScore++;
        RpsGUI.getPlayerScore().setText(String.valueOf(playerScore));

    }

    private static void enemyWins() {

        RpsGUI.getPrompts().setText("YOU LOSE! ");
        enemyScore++;
        RpsGUI.getEnemyScore().setText(String.valueOf(enemyScore));

    }
}
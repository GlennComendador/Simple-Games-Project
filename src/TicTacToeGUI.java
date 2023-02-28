import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends TicTacToe {

    //JButton Initialization
    private static final JButton[] buttons = new JButton[9];
    private static final JButton resetButton = new JButton("NEW GAME");

    //JLabel Initialization
    private static final JLabel isTurn = new JLabel(" ");
    private static final JLabel playerScore = new JLabel("0");
    private static final JLabel enemyScore = new JLabel("0");

    //Maximum amount of Square Choices for players and enemy to attack
    private static final int MAX_CHOICE = 9;
    //Flag to determine if PVP or PVE
    private boolean isPVE = false;
    //Flag for player or enemy's turn
    private static boolean nextTurn = false;

    public void setGUI() {

        //JFrame Specifications
        JFrame jFrame = new JFrame("Tic Tac Toe");
        jFrame.setLayout(new GridLayout());
        jFrame.setBounds(10, 10, 450, 675);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);

        //JPanel Specifications
        JPanel jPanel = new JPanel();
        jPanel.setBounds(10, 10, 450, 675);
        jPanel.setLayout(null);
        jPanel.setVisible(true);

        //Title JLabel Specifications
        //JLabel title = new JLabel(new ImageIcon("Graphics/TIC TAC TOE!.png"));
        JLabel title = new JLabel("TIC TAC TOE!");
        title.setBounds(90, 10, 300, 100);
        title.setFont(new Font("Arial", Font.BOLD, 40));

        //Player/Enemy Turn JLabel Specifications
        isTurn.setFont(new Font("Arial", Font.BOLD, 20));

        //JLabel playerScoreboard Specifications
        JLabel playerScoreboard = new JLabel("PLAYER:");
        playerScoreboard.setBounds(60,410, 200,200);
        playerScoreboard.setFont(new Font("Arial", Font.BOLD, 20));

        //JLabel enemyScoreboard Specifications
        JLabel enemyScoreboard = new JLabel("ENEMY:");
        enemyScoreboard.setBounds(300,410, 200,200);
        enemyScoreboard.setFont(new Font("Arial", Font.BOLD, 20));

        //JLabel playerScore Specifications
        playerScore.setBounds(95,440, 200,200);
        playerScore.setFont(new Font("Arial", Font.BOLD, 20));

        //JLabel enemyScore Specifications
        enemyScore.setBounds(330,440, 200,200);
        enemyScore.setFont(new Font("Arial", Font.BOLD, 20));

        //Fill Buttons Array
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(" ");
        }
        //TOP LEFT Specifications
        buttons[0].setBounds(60, 100, 100, 100);
        //TOP CENTER Specifications
        buttons[1].setBounds(170, 100, 100, 100);
        //TOP RIGHT Specifications
        buttons[2].setBounds(280, 100, 100, 100);

        //MID LEFT Specifications
        buttons[3].setBounds(60, 210, 100, 100);
        //MID CENTER Specifications
        buttons[4].setBounds(170, 210, 100, 100);
        //MID RIGHT Specifications
        buttons[5].setBounds(280, 210, 100, 100);

        //BOT LEFT Specifications
        buttons[6].setBounds(60, 320, 100, 100);
        //BOT CENTER Specifications
        buttons[7].setBounds(170, 320, 100, 100);
        //BOT RIGHT Specifications
        buttons[8].setBounds(280, 320, 100, 100);

        //Set Buttons as Transparent
//        for(int i = 0; i < MAX_CHOICE; i++) {
//            buttons[i].setOpaque(false);
//            buttons[i].setContentAreaFilled(false);
//            buttons[i].setBorderPainted(false);
//            buttons[i].setFocusPainted(false);
//        }

        //QUIT BUTTON Specifications
        JButton quitButton = new JButton("QUIT");
        quitButton.setBounds(60, 575, 70, 30);

        //Quit Button Event Handler
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //NEW GAME BUTTON Specifications
        resetButton.setBounds(280, 575, 100, 30);

        //New Game Button Event Handler
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                resetButtons();
                enableButtons();
                isTurn.setText(" ");
                resetWinFlag();

            }
        });

        //PVE to PVP Switcher Specifications
        JButton pveButton = new JButton("PLAYER VS. PLAYER");
        pveButton.setBounds(130, 575, 150, 30);

        //PVE or PVP Button Event Handler
        pveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (isPVE) {

                    pveButton.setText("PLAYER VS. PLAYER");
                    resetButtons();
                    setPlayerScore(resetPlayerScore());
                    setEnemyScore(resetEnemyScore());
                    enableButtons();
                    resetWinFlag();
                    isPVE = false;

                } else {

                    pveButton.setText("PLAYER VS. ENEMY");
                    resetButtons();
                    setPlayerScore(resetPlayerScore());
                    setEnemyScore(resetEnemyScore());
                    enableButtons();
                    resetWinFlag();
                    isPVE = true;

                }
            }
        });

        //ADDING COMPONENTS TO PANEL AND FRAME
        for(int i = 0; i < MAX_CHOICE; i++) {
            jPanel.add(buttons[i]);
        }

        jPanel.add(quitButton);
        jPanel.add(resetButton);
        jPanel.add(pveButton);
        jPanel.add(title);
        jPanel.add(isTurn);
        jPanel.add(playerScoreboard);
        jPanel.add(enemyScoreboard);
        jPanel.add(playerScore);
        jPanel.add(enemyScore);

        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    public void winDialog() {
        //Output Player Win Message
        JOptionPane.showMessageDialog(null, "PLAYER WINS!", "WINNER", JOptionPane.PLAIN_MESSAGE);
    }

    public void loseDialog() {
        //Output Enemy Win Message
        JOptionPane.showMessageDialog(null, "ENEMY WINS!", "LOSER", JOptionPane.PLAIN_MESSAGE);
    }

    public void tieDialog() {
        //Output Tie Message
        JOptionPane.showMessageDialog(null, "IT'S A TIE!", "TIE", JOptionPane.PLAIN_MESSAGE);
    }

    public void resetButtons() {
        //Reset Board
        for(int i = 0; i < MAX_CHOICE; i++) {
            buttons[i].setText(" ");
        }
        nextTurn = false;
    }

    public void disableButtons() {
        //Disable Buttons
        for(int i = 0; i < MAX_CHOICE; i++) {
            buttons[i].setEnabled(false);
        }
    }

    public void enableButtons() {
        //Disable Buttons
        for(int i = 0; i < MAX_CHOICE; i++) {
            buttons[i].setEnabled(true);
        }
    }

    public void getIsPlayerTurn() {
        isTurn.setBounds(60, 400, 300,100);
        isTurn.setText("It's Player X's Turn");
        isTurn.setForeground(Color.BLACK);
    }

    public void getIsEnemyTurn() {
        isTurn.setBounds(195, 400, 300,100);
        isTurn.setText("It's Player O's Turn");
        isTurn.setForeground(Color.BLACK);
    }


    //GETTERS
    public JButton getButtons(int index) {
        //Returns ALL Buttons
        return buttons[index];
    }

    public boolean getIsPVEorPVP() {
        return isPVE;
    }

    public int getMaxChoice() {
        return MAX_CHOICE;
    }

    public boolean getNextTurn() {
        return nextTurn;
    }

    //SETTER
    public void setNextTurn(boolean turn) {
        nextTurn = turn;
    }

    public void setPlayerScore(int Score) {
        //Gets Player Scores and Parses it to Label
        String temp = Integer.toString(Score);
        playerScore.setText(temp);
    }

    public void setEnemyScore(int Score) {
        //Gets Enemy Scores and Parses it to Label
        String temp = Integer.toString(Score);
        enemyScore.setText(temp);
    }

}
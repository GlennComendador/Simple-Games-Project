import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe {

    //VARIABLE INITIALIZATIONS
    private static int enemyScore = 0;
    private static int playerScore = 0;

    private static final boolean PLAYER_TURN = false;
    private static final boolean ENEMY_TURN = true;
    private static boolean winFlag = false;

    //OBJECT INITIALIZATIONS
    private static final TicTacToeGUI ticTacToeGUI = new TicTacToeGUI();

    public static void main(String[] args) {

        //UI INITIALIZATION
        ticTacToeGUI.setGUI();

        //RUN GAME
        do {

            if(ticTacToeGUI.getNextTurn() == PLAYER_TURN) {
                playerActions();
            }
            else if (ticTacToeGUI.getNextTurn() == ENEMY_TURN) {

                if(ticTacToeGUI.getIsPVEorPVP()) {
                    enemyAIActions();
                } else {
                    enemyPlayerActions();
                }
            }

        } while (true);
    }

    public static void playerActions() {

        //PLAYER CHOOSES WHERE TO ATTACK
        for(int i = 0; i < ticTacToeGUI.getMaxChoice(); i++) {

            //BUTTON Event Handling
            int temp = i;
            ticTacToeGUI.getButtons(i).addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    if(ticTacToeGUI.getButtons(temp).getText().equals(" ")) {
                        //If Square is Empty, Player may Select the Square
                        ticTacToeGUI.getButtons(temp).setText("X");
                        ticTacToeGUI.getButtons(temp).setFont(new Font("Arial", Font.BOLD, 80));
                        ticTacToeGUI.getIsEnemyTurn();

                        if(!winFlag) {
                            checkWin();
                        } else {
                            ticTacToeGUI.getButtons(temp).setText(" ");
                        }

                        ticTacToeGUI.setNextTurn(ENEMY_TURN);
                    }

                }
            });
        }

    }

    public static void enemyPlayerActions() {

        //PLAYER CHOOSES WHERE TO ATTACK
        for(int i = 0; i < ticTacToeGUI.getMaxChoice(); i++) {

            //BUTTON Event Handling
            int temp = i;
            ticTacToeGUI.getButtons(i).addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    if(ticTacToeGUI.getButtons(temp).getText().equals(" ")) {
                        //If Square is Empty, Player may Select the Square
                        ticTacToeGUI.getButtons(temp).setText("O");
                        ticTacToeGUI.getButtons(temp).setFont(new Font("Arial", Font.BOLD, 80));
                        ticTacToeGUI.getIsPlayerTurn();

                        if(!winFlag) {
                            checkWin();
                        } else {
                            ticTacToeGUI.getButtons(temp).setText(" ");
                        }

                        ticTacToeGUI.setNextTurn(PLAYER_TURN);
                    }

                }
            });
        }

    }

    private static void enemyAIActions() {

        //ENEMY AI CHOOSES WHERE TO ATTACK
        Random randomNumbers = new Random();
        int enemyChoice = randomNumbers.nextInt(ticTacToeGUI.getMaxChoice());

            if(ticTacToeGUI.getButtons(enemyChoice).getText().equals(" ")) {
            //Attack if AI found Empty Square
            ticTacToeGUI.getButtons(enemyChoice).setText("O");
            ticTacToeGUI.getButtons(enemyChoice).setFont(new Font("Arial", Font.BOLD, 80));
            ticTacToeGUI.getIsPlayerTurn();

            if(!winFlag) {
                checkWin();
            } else {
                ticTacToeGUI.getButtons(enemyChoice).setText(" ");
            }

            ticTacToeGUI.setNextTurn(PLAYER_TURN);
        }

    }

    private static void checkWin() {
        //Function to Check If Player or Enemy Won
        for(int i = 0; i < 7; i+=3) {
            //ROW WIN CHECKER
            if (ticTacToeGUI.getButtons(i).getText().equals("X") &&
                ticTacToeGUI.getButtons(i+1).getText().equals("X") &&
                ticTacToeGUI.getButtons(i+2).getText().equals("X")) {

                if(!winFlag) {
                    playerWins();
                }

            } else if (ticTacToeGUI.getButtons(i).getText().equals("O") &&
                       ticTacToeGUI.getButtons(i+1).getText().equals("O") &&
                       ticTacToeGUI.getButtons(i+2).getText().equals("O")) {

                if(!winFlag) {
                    enemyWins();
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            //COLUMN WIN CHECKER
            if (ticTacToeGUI.getButtons(i).getText().equals("X") &&
                ticTacToeGUI.getButtons(i+3).getText().equals("X") &&
                ticTacToeGUI.getButtons(i+6).getText().equals("X")) {

                if(!winFlag) {
                    playerWins();
                }

            } else if (ticTacToeGUI.getButtons(i).getText().equals("O") &&
                       ticTacToeGUI.getButtons(i+3).getText().equals("O") &&
                       ticTacToeGUI.getButtons(i+6).getText().equals("O")) {

                if(!winFlag) {
                    enemyWins();
                }
            }
        }

        //DIAGONAL WIN CHECKER
        if (ticTacToeGUI.getButtons(0).getText().equals("X") &&
            ticTacToeGUI.getButtons(4).getText().equals("X") &&
            ticTacToeGUI.getButtons(8).getText().equals("X") ||

            ticTacToeGUI.getButtons(2).getText().equals("X") &&
            ticTacToeGUI.getButtons(4).getText().equals("X") &&
            ticTacToeGUI.getButtons(6).getText().equals("X")
        ) {

            if(!winFlag) {
                playerWins();
            }

        }
        else if (ticTacToeGUI.getButtons(0).getText().equals("O") &&
                 ticTacToeGUI.getButtons(4).getText().equals("O") &&
                 ticTacToeGUI.getButtons(8).getText().equals("O") ||

                 ticTacToeGUI.getButtons(2).getText().equals("O") &&
                 ticTacToeGUI.getButtons(4).getText().equals("O") &&
                 ticTacToeGUI.getButtons(6).getText().equals("O")
        ) {

            if(!winFlag) {
                enemyWins();
            }

        }

        //TIE
        if(!winFlag) {
            boardIsFull();
        }

    }

    private static void boardIsFull() {
        //Function to check if Squares are not vacant
        int boardCount = 0;
        for (int i = 0; i < ticTacToeGUI.getMaxChoice(); i++) {
            if (!ticTacToeGUI.getButtons(i).getText().equals(" ")) {
                //Count how many are still vacant
                boardCount++;
            }
        }

        if (boardCount == 9) {
            ticTacToeGUI.setNextTurn(PLAYER_TURN);
            //If all squares are not vacant, and no one met Win Conditions, Game is a Tie
            ticTacToeGUI.tieDialog();
            ticTacToeGUI.disableButtons();
            //Game has Ended
            winFlag = true;
        }
    }

    private static void playerWins() {
        //Set Player as Next Turn
        ticTacToeGUI.setNextTurn(PLAYER_TURN);
        //Player has Won
        winFlag = true;
        //Add 1 Point to Player Score
        playerScore++;
        //Update Score in JLabel
        ticTacToeGUI.setPlayerScore(playerScore);
        //Show Win Dialog
        ticTacToeGUI.winDialog();
        //Disable Buttons to Prevent Press after Win
        ticTacToeGUI.disableButtons();
    }

    private static void enemyWins() {
        //Set Player as Next Turn
        ticTacToeGUI.setNextTurn(PLAYER_TURN);
        //Enemy has Won
        winFlag = true;
        //Add 1 Point to Enemy Score
        enemyScore++;
        //Update Score in JLabel
        ticTacToeGUI.setEnemyScore(enemyScore);
        //Show Lose Dialog
        ticTacToeGUI.loseDialog();
        //Disable Buttons to Prevent Press after Win
        ticTacToeGUI.disableButtons();
    }

    public static boolean resetWinFlag() {
        winFlag = false;
        return winFlag;
    }

    public static int resetPlayerScore() {
        playerScore = 0;
        return playerScore;
    }

    public static int resetEnemyScore() {
        enemyScore = 0;
        return enemyScore;
    }
}
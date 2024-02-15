import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameMenu extends JFrame{
    // defining variables
    public static int noOfBubbles=4;
    //defining the Jcomponents
    JButton startButton;
    JButton restartButton;
    JSlider difficultySlider;
    JLabel difficultyLabel;

    public GameMenu(){
        //assigning Jcomponents
        startButton = new JButton("Start");
        restartButton = new JButton("Restart");

        //creating Jslider
        difficultySlider = new JSlider(JSlider.HORIZONTAL,4,6,4);       
        difficultySlider.setMajorTickSpacing(1);
        difficultySlider.setPaintTicks(true);
        //creating JLabel to show difficulty level
        difficultyLabel= new JLabel("Select Difficulty level: Easy");
        //set the layout to FlowLayout
        setLayout(new FlowLayout());
        //adding components to frame
        add(startButton);
        add(restartButton);
        add(difficultySlider);
        add(difficultyLabel);
        //adding change event for difficulty slider
        event selectDifficultyEvent = new event();
        difficultySlider.addChangeListener(selectDifficultyEvent);
        // adding action listener event for opening game window
        GameMenuActionListener openGameMenu = new GameMenuActionListener();
        startButton.addActionListener(openGameMenu);
        restartButton.addActionListener(openGameMenu);
    }
    //adding change listener to show the changes when difficulty slider is selected
    public class event implements ChangeListener{
        public void stateChanged(ChangeEvent selectDifficultyEvent){
            //showing different difficulty levels
            noOfBubbles = difficultySlider.getValue();
            if (noOfBubbles == 4){
                difficultyLabel.setText("Difficulty Level: Easy");
            }
            else if(noOfBubbles == 5){
                difficultyLabel.setText("Difficulty Level: Medium");
            }
            else if(noOfBubbles==6){
                difficultyLabel.setText("Difficulty Level: Hard");
            }
        }
    }

    // adding action listener to open the game window
    public class GameMenuActionListener implements ActionListener{
        public void actionPerformed(ActionEvent openGameMenu){
            GameWindow gameWindow = new GameWindow();
            gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameWindow.setSize(600,600);
            gameWindow.setVisible(true);
            gameWindow.setTitle("Bubble Game window");
            // show the message to click on the game panel after the game window is opened
            JOptionPane.showMessageDialog(null, "Click on the Panel "+noOfBubbles+ " times for the bubbles to appear");
        }
    }

    public static void main(String [] args){
        GameMenu menuFrame = new GameMenu();
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(300,300);
        menuFrame.setVisible(true);
        menuFrame.setTitle("Bubble game Menu");
    }
}
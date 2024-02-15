import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindow extends JFrame{
    JPanel timerPanel;
    public static JPanel gamePanel;
    JLabel timerLabel;
    JLabel roundLabel;
    public Timer gameTimer;
    //other variables required for counting rounds and no of circles
    //arrays for tracking copordinates
    public int[] clickCoordinateX = {0,0,0,0,0,0};
    public int[] clickCoordinateY ={0,0,0,0,0,0};
    public int timeRemaining=15;
    public int bubbleCounter=0;
    public int roundNumber=1;
    public int bubbleRadius=40;
    public int mouseClickX;
    public int mouseClickY;
    public int bubblesRemaining;
    public int newRadius = 0;
    //bubble click tracker
    public int bubbleClickX;
    public int bubbleClickY;

    public GameWindow(){
        //creating the JPanel and JLabels
        //creating the timer panel       
        timerPanel = new JPanel();
        timerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, timerPanel.getPreferredSize().height));

        //creating the game panel
        gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(500, 500));
        gamePanel.validate();

        gamePanel.setBorder(BorderFactory.createLineBorder(Color.RED));
        //adding mouse listener to track the mouse clicks
        gamePanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                //printing the coordinates
                mouseClickX = e.getX();
                mouseClickY = e.getY();
                System.out.println("Mouse clicked at ("+mouseClickX+","+mouseClickY+")");
                // for (int i=0; i<6;i++){
                    
                // }
                if(bubbleCounter==0){
                    if ((mouseClickX-bubbleRadius)<0||(mouseClickX-bubbleRadius)>(586-2*bubbleRadius)||(mouseClickY-bubbleRadius)<0||(mouseClickY-bubbleRadius)>(536-2*bubbleRadius)){
                        JOptionPane.showMessageDialog(null, "The bubble is outside. Please click again!","Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        //painting the circle
                    Graphics g = gamePanel.getGraphics();
                    g.setColor(Color.BLACK);
                    g.drawOval(mouseClickX-bubbleRadius, mouseClickY-bubbleRadius, 2*bubbleRadius, 2*bubbleRadius);
                    bubbleCounter+=1;
                    clickCoordinateX[0]=mouseClickX;
                    clickCoordinateY[0]=mouseClickY;
                    System.out.println("first bubble center ("+mouseClickX+","+mouseClickY+")");
                    }
                }
                else if(bubbleCounter==1){
                    if ((mouseClickX-bubbleRadius)<0||(mouseClickX-bubbleRadius)>(586-2*bubbleRadius)||(mouseClickY-bubbleRadius)<0||(mouseClickY-bubbleRadius)>(536-2*bubbleRadius)){
                        JOptionPane.showMessageDialog(null, "The bubble is outside. Please click again!","Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(Math.sqrt(Math.pow((mouseClickX-clickCoordinateX[0]),2) + Math.pow((mouseClickY-clickCoordinateY[0]),2))<=2*bubbleRadius){
                        JOptionPane.showMessageDialog(null, "The bubbles are overlapping. Please click again!","Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        //painting the circle
                        Graphics g = gamePanel.getGraphics();
                        g.setColor(Color.BLACK);
                        g.drawOval(mouseClickX-bubbleRadius, mouseClickY-bubbleRadius, 2*bubbleRadius, 2*bubbleRadius);
                        
                        clickCoordinateX[1]=mouseClickX;
                        clickCoordinateY[1]=mouseClickY;
                        System.out.println("second bubble center ("+mouseClickX+","+mouseClickY+")");
                        bubbleCounter+=1;
                    }
                }
                else if(bubbleCounter==2){
                    if ((mouseClickX-bubbleRadius)<0||(mouseClickX-bubbleRadius)>(586-2*bubbleRadius)||(mouseClickY-bubbleRadius)<0||(mouseClickY-bubbleRadius)>(536-2*bubbleRadius)){
                        JOptionPane.showMessageDialog(null, "The bubble is outside. Please click again!","Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(Math.sqrt(Math.pow((mouseClickX-clickCoordinateX[1]),2) + Math.pow((mouseClickY-clickCoordinateY[1]),2))<=2*bubbleRadius){
                        JOptionPane.showMessageDialog(null, "The bubbles are overlapping. Please click again!","Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        //painting the circle
                        Graphics g = gamePanel.getGraphics();
                        g.setColor(Color.BLACK);
                        g.drawOval(mouseClickX-bubbleRadius, mouseClickY-bubbleRadius, 2*bubbleRadius, 2*bubbleRadius);
                        
                        clickCoordinateX[2]=mouseClickX;
                        clickCoordinateY[2]=mouseClickY;
                        System.out.println("third bubble center ("+mouseClickX+","+mouseClickY+")");
                        bubbleCounter+=1;
                    }
                }
                else if(bubbleCounter==3){
                    if ((mouseClickX-bubbleRadius)<0||(mouseClickX-bubbleRadius)>(586-2*bubbleRadius)||(mouseClickY-bubbleRadius)<0||(mouseClickY-bubbleRadius)>(536-2*bubbleRadius)){
                        JOptionPane.showMessageDialog(null, "The bubble is outside. Please click again!","Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(Math.sqrt(Math.pow((mouseClickX-clickCoordinateX[2]),2) + Math.pow((mouseClickY-clickCoordinateY[2]),2))<=2*bubbleRadius){
                        JOptionPane.showMessageDialog(null, "The bubbles are overlapping. Please click again!","Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        //painting the circle
                        Graphics g = gamePanel.getGraphics();
                        g.setColor(Color.BLACK);
                        g.drawOval(mouseClickX-bubbleRadius, mouseClickY-bubbleRadius, 2*bubbleRadius, 2*bubbleRadius);
                        
                        clickCoordinateX[3]=mouseClickX;
                        clickCoordinateY[3]=mouseClickY;
                        System.out.println("fourth bubble center ("+mouseClickX+","+mouseClickY+")");
                        bubbleCounter+=1;
                    }
                }
                else if(bubbleCounter==4){
                    if ((mouseClickX-bubbleRadius)<0||(mouseClickX-bubbleRadius)>(586-2*bubbleRadius)||(mouseClickY-bubbleRadius)<0||(mouseClickY-bubbleRadius)>(536-2*bubbleRadius)){
                        JOptionPane.showMessageDialog(null, "The bubble is outside. Please click again!","Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(Math.sqrt(Math.pow((mouseClickX-clickCoordinateX[3]),2) + Math.pow((mouseClickY-clickCoordinateY[3]),2))<=2*bubbleRadius){
                        JOptionPane.showMessageDialog(null, "The bubbles are overlapping. Please click again!","Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        //painting the circle
                        Graphics g = gamePanel.getGraphics();
                        g.setColor(Color.BLACK);
                        g.drawOval(mouseClickX-bubbleRadius, mouseClickY-bubbleRadius, 2*bubbleRadius, 2*bubbleRadius);
                        
                        clickCoordinateX[4]=mouseClickX;
                        clickCoordinateY[4]=mouseClickY;
                        System.out.println("fifth bubble center ("+mouseClickX+","+mouseClickY+")");
                        bubbleCounter+=1;
                    }
                }
                else if(bubbleCounter==5){
                    if ((mouseClickX-bubbleRadius)<0||(mouseClickX-bubbleRadius)>(586-2*bubbleRadius)||(mouseClickY-bubbleRadius)<0||(mouseClickY-bubbleRadius)>(536-2*bubbleRadius)){
                        JOptionPane.showMessageDialog(null, "The bubble is outside. Please click again!","Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(Math.sqrt(Math.pow((mouseClickX-clickCoordinateX[4]),2) + Math.pow((mouseClickY-clickCoordinateY[4]),2))<=2*bubbleRadius){
                        JOptionPane.showMessageDialog(null, "The bubbles are overlapping. Please click again!","Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        //painting the circle
                        Graphics g = gamePanel.getGraphics();
                        g.setColor(Color.BLACK);
                        g.drawOval(mouseClickX-bubbleRadius, mouseClickY-bubbleRadius, 2*bubbleRadius, 2*bubbleRadius);
                        
                        clickCoordinateX[5]=mouseClickX;
                        clickCoordinateY[5]=mouseClickY;
                        System.out.println("sixth bubble center ("+mouseClickX+","+mouseClickY+")");
                        bubbleCounter+=1;
                    }
                }

                //removes mouse listener once desired number of bubbles are generated and starts the round by startinting the timer
                if (bubbleCounter==GameMenu.noOfBubbles){
                    gamePanel.removeMouseListener(this);
                    //start timer
                    JOptionPane.showMessageDialog(null, "Round "+roundNumber+" started.");
                    Timer(timeRemaining);
                    gameTimer.start();
                    bubblesRemaining= GameMenu.noOfBubbles;
                    //mouse listener for disappearing the bubbles whn it is clicked
                    gamePanel.addMouseListener(new MouseAdapter(){
                        public void mousePressed(MouseEvent f){
                            bubbleClickX = f.getX();
                            bubbleClickY = f.getY();
                            //logic for disappearing the bubbles
                            if((Math.sqrt(Math.pow((bubbleClickX-clickCoordinateX[0]),2) + Math.pow((bubbleClickY-clickCoordinateY[0]),2))<=2*bubbleRadius)){
                                Graphics g = gamePanel.getGraphics();
                                g.setColor(Color.WHITE);
                                g.drawOval(-1, -1, 2*newRadius, 2*newRadius);
                                repaint();
                                bubblesRemaining-=1;
                                //if bubbles remaining =0 then round completed
                                if (bubblesRemaining==0){
                                    JOptionPane.showMessageDialog(null, "Round "+roundNumber+" Completed.");
                                }
                            }
                            else if((Math.sqrt(Math.pow((bubbleClickX-clickCoordinateX[1]),2) + Math.pow((bubbleClickY-clickCoordinateY[1]),2))<=2*bubbleRadius)){
                                Graphics g = gamePanel.getGraphics();
                                g.setColor(Color.WHITE);
                                g.drawOval(-1, -1, 2*newRadius, 2*newRadius);
                                repaint();
                                bubblesRemaining-=1;
                                //if bubbles remaining =0 then round completed
                                if (bubblesRemaining==0){
                                    JOptionPane.showMessageDialog(null, "Round "+roundNumber+" Completed.");
                                }
                            }
                            else if((Math.sqrt(Math.pow((bubbleClickX-clickCoordinateX[2]),2) + Math.pow((bubbleClickY-clickCoordinateY[2]),2))<=2*bubbleRadius)){
                                Graphics g = gamePanel.getGraphics();
                                g.setColor(Color.WHITE);
                                g.drawOval(-1, -1, 2*newRadius, 2*newRadius);
                                repaint();
                                bubblesRemaining-=1;
                                //if bubbles remaining =0 then round completed
                                if (bubblesRemaining==0){
                                    JOptionPane.showMessageDialog(null, "Round "+roundNumber+" Completed.");
                                    gameTimer.stop();
                                }
                            }
                            else if((Math.sqrt(Math.pow((bubbleClickX-clickCoordinateX[3]),2) + Math.pow((bubbleClickY-clickCoordinateY[3]),2))<=2*bubbleRadius)){
                                Graphics g = gamePanel.getGraphics();
                                g.setColor(Color.WHITE);
                                g.drawOval(-1, -1, 2*newRadius, 2*newRadius);
                                repaint();
                                bubblesRemaining-=1;
                                //if bubbles remaining =0 then round completed
                                if (bubblesRemaining==0){
                                    JOptionPane.showMessageDialog(null, "Round "+roundNumber+" Completed.");
                                    gameTimer.stop();
                                }
                            }
                            else if((Math.sqrt(Math.pow((bubbleClickX-clickCoordinateX[4]),2) + Math.pow((bubbleClickY-clickCoordinateY[4]),2))<=2*bubbleRadius)){
                                Graphics g = gamePanel.getGraphics();
                                g.setColor(Color.WHITE);
                                g.drawOval(-1, -1, 2*newRadius, 2*newRadius);
                                repaint();
                                bubblesRemaining-=1;
                                //if bubbles remaining =0 then round completed
                                if (bubblesRemaining==0){
                                    JOptionPane.showMessageDialog(null, "Round "+roundNumber+" Completed.");
                                    gameTimer.stop();
                                }
                            }
                            else if((Math.sqrt(Math.pow((bubbleClickX-clickCoordinateX[5]),2) + Math.pow((bubbleClickY-clickCoordinateY[5]),2))<=2*bubbleRadius)){
                                Graphics g = gamePanel.getGraphics();
                                g.setColor(Color.WHITE);
                                g.drawOval(-1, -1, 2*newRadius, 2*newRadius);
                                repaint();
                                bubblesRemaining-=1;
                                //if bubbles remaining =0 then round completed
                                if (bubblesRemaining==0){
                                    JOptionPane.showMessageDialog(null, "Round "+roundNumber+" Completed.");
                                    gameTimer.stop();
                                }
                            }
                        } 
                    });
                    
                }
            }
        });
        //creating the jlabels
        timerLabel = new JLabel("Time Remaining: 15 seconds");
        roundLabel = new JLabel("Round: 1");
        //setting the layout and adding the labels to jpanels
        setLayout(new BorderLayout());
        timerPanel.add(timerLabel);
        timerPanel.add(roundLabel);
        //adding the panels to jframe
        add(timerPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        
    }

    public void Timer(int remianiningTime){
        gameTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                timerLabel.setText("Time Remaining: " + timeRemaining + " seconds");
                if (timeRemaining==0){
                    gameTimer.stop();   //what is the difference between initialising the timer variable while declaring and defining first and initializing
                    JOptionPane.showMessageDialog(null, "Time up. Restart the game!");
                }
            }
        });
    }

}

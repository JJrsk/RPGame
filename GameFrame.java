import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * The central frame through which maps are instantiated and the game is run
 */

public class GameFrame extends JFrame{

    private static final Map MAP_0_0 = new Map0_0();
    private static final Map MAP_1_0 = new Map1_0();

    public GameFrame(){

        runMap_0_0(-1, null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("We're doing it boys");
        setSize(640,480);
        setVisible(true);
    }

    public void runMap_0_0(int from, Player p){
       this.setContentPane(MAP_0_0);
       MAP_0_0.createPlayer(from, p);

       MAP_0_0.runMe = true;

        new Timer(16, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(MAP_0_0.keepGoing())
                    MAP_0_0.repaint();
                else if(MAP_0_0.runMe){
                    switch(MAP_0_0.getExitDirection()){
                        case Map.UP:
                            //TODO put some fencing here in-game or something
                            System.out.println("Don't go there");
                            break;
                        case Map.DOWN:
                            //implemented later
                            System.out.println("Not yet");
                            break;
                        case Map.LEFT:
                            System.out.println("Please no");
                            break;
                        case Map.RIGHT:
                            MAP_0_0.runMe = false;
                            runMap_1_0(Map.LEFT,MAP_0_0.getPlayer());
                            break;
                        default:
                            System.out.println("Something is horribly wrong");
                    }
                }
            }
        }).start();

    }
    
    public void runMap_1_0(int from, Player p){
        this.setContentPane(MAP_1_0);
        MAP_1_0.createPlayer(from, p);

        MAP_1_0.runMe = true;

        new Timer(16, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(MAP_1_0.keepGoing())
                    MAP_1_0.repaint();
                else if(MAP_1_0.runMe){
                    switch(MAP_1_0.getExitDirection()){
                        case Map.UP:
                            //TODO put some fencing here in-game or something
                            System.out.println("Don't go there");
                            break;
                        case Map.DOWN:
                            //implemented later
                            System.out.println("Not yet");
                            break;
                        case Map.LEFT:
                            MAP_1_0.runMe = false;
                            runMap_0_0(Map.RIGHT,MAP_1_0.getPlayer());
                            break;
                        case Map.RIGHT:
                            //MAP_0_0.runMe = false;
                            //runMap_1_0(Map.LEFT,MAP_0_0.getPlayer());
                            break;
                        default:
                            System.out.println("Something is horribly wrong");
                    }
                }
                System.out.println("X: " + MAP_1_0.getPlayer().getX());

            }
        }).start();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new GameFrame();
            }
        });
    }
}

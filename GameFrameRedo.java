import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * The central frame through which maps are instantiated and the game is run
 */

public class GameFrameRedo extends JFrame{

   // private static final Map MAP_0_0 = new Map0_0();
   // private static final Map MAP_1_0 = new Map1_0();
    private static final Map[][] maps = {{new Map0_0()},{new Map1_0()}};
    private Map map;
    private int row = 0, col = 0;
    private Player player;

    public GameFrameRedo(){

        runMap_0_0(-1);

        //this code is getting worse by the second
        final GameFrameRedo g = this;

        player = map.getPlayer();

        new Timer(16, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                player = map.getPlayer();

                if(map.keepGoing()){
                    map.repaint();
                    System.out.println("X: " + map.getPlayer().getX());
                }
                else {
                    switch(map.getExitDirection()){
                        case Map.UP:
                            //TODO put some fencing here in-game or something
                            System.out.println("Don't go there");
                            break;
                        case Map.DOWN:
                            //implemented later
                            System.out.println("Not yet");
                            break;
                        case Map.LEFT:
                            runMap_0_0(Map.RIGHT);
                            System.out.println("Please no");
                            break;
                        case Map.RIGHT:
                            map = maps[1][0];
                            map.runMap(g,Map.LEFT,player);
                            break;
                        default:
                            System.out.println("Something is horribly wrong");
                    }
                }
            }
        }).start();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("We're doing it boys");
        setSize(640,480);
        setVisible(true);
    }

     public void runMap_0_0(int from){
       this.setContentPane(maps[0][0]);
       map = maps[0][0];
       map.createPlayer(from,player);
    }
    
    public void runMap_1_0(int from){
        this.setContentPane(maps[1][0]);
        map = maps[1][0];
        map.createPlayer(from,player);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new GameFrameRedo();
            }
        });
    }
}

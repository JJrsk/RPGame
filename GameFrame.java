import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * The central frame through which maps are instantiated and the game is run
 */

public class GameFrame extends JFrame{

    public GameFrame(){
        final Map MAP_0_0 = new Map0_0();
        
        runMap_0_0();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("We're doing it boys");
        setSize(600,400);
        setVisible(true);
    }

    public void runMap_0_0(){
        final Map MAP_0_0 = new Map0_0();

        this.setContentPane(MAP_0_0);
        new Timer(16, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MAP_0_0.repaint();
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

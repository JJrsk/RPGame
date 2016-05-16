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

        this.setContentPane(map0_0);
        
        new Timer(16, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel.repaint();
            }
        }).start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("We're doing it boys");
        setSize(600,400);
        setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new GameFrame();
            }
        }
    }
}

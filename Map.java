import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.swing.*;

/**
 * An abstract class representing a basic overworld map.
 * Contains a list of entities, a reference to the player, and more
 * stuff TBA
 */

public abstract class Map extends JPanel{
    /**
     * An ArrayList of all non-player entities in this map
     */
    private ArrayList<Entity> entities;

    private Player player;

    /**
     * A list of the basic executable movement commands for the player
     * to use; released is the command key triggered when an arrow key
     * is released and signals to stop the player's animation.
     */
    private final String[] commands = {"UP","DOWN","LEFT","RIGHT"};
    private final String released = "KEY RELEASED";

    public Map(){
        entities = new ArrayList<Entity>();
        //assigns each arrow key to the panelAction listener
        for(int i = 0; i < commands.length; i++)
            registerKeyboardAction(panelAction,
                commands[i],
                KeyStroke.getKeyStroke(commands[i]),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
       
        //does the same for each key release
        registerKeyboardAction(panelAction,released,
                KeyStroke.getKeyStroke(KeyEvent.VK_UP,0,true),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
        registerKeyboardAction(panelAction,released,
                KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0,true),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
        registerKeyboardAction(panelAction,released,
                KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,true),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
        registerKeyboardAction(panelAction,released,
                KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,true),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

        //you technically aren't supposed to use registerKeyboardAction
        //but the alternative requires a lot more coding for no good reason
        createPlayer();
    }

    /**
     * Instantiates the player at a location specified by the subclass
     */
    public void createPlayer();

    public void addEntity(Entity e){
        entities.add(e);
    }

    //passes the player a move command when an arrow is pressed
    private ActionListener panelAction = new ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String command = (String) e.getActionCommand();
            player.move(e);

            repaint();
        }
    }

    @Override
    public Dimension getPreferredSize(){
        return (new Dimension(600,400));
    }

    /**
     * Updates the animations and positions of every entity in the map,
     * including the player. Called by super.repaint and if I didn't
     * screw up, will run every game tick.
     */
    @Override
    public void paintComponents(Graphics g){
        super.paintComponent(g);
        for(Entity e : this.entities){
            e.update();
            g.drawImage(e.getAnimation().getSprite(), e.getX, e.getY, null);
        }
        player.update();
        g.drawImage(player.getAnimation().getSprite(),player.getX,player.getY,null);

    }
}

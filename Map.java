import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;

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
     * is released and signals to stop the player's animation; directions
     * are simply for ease of use in getExitDirection.
     */
    private final String[] commands = {"UP","DOWN","LEFT","RIGHT"};
    private final String released = "KEY RELEASED";

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    //THE KLUDGY WORKAROUND TO END ALL KLUDGY WORKAROUNDS
    public boolean runMe;

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
    }

    /**
     * Creates the player at a default location; called when a new
     * Player must be constructed.
     */
    public void createPlayer(){
        player = new Player(160,120, SetUp.player12);
    }

    /**
     * Creates the player using a specified "from" direction, ie the
     * direction of the map that sent this player.
     */
    public void createPlayer(int from, Player p){
        if(p == null){
            createPlayer();
            return;
        }

        switch(from){
            case UP:
                this.player = new Player(p.getX(),0);
                break;
            case DOWN:
                this.player = new Player(p.getX(),this.getHeight() - p.getHeight());
                break;
            case LEFT:
                this.player = new Player(0,p.getY());
                break;
            case RIGHT:
                this.player = new Player(this.getWidth() - p.getWidth(), p.getY());
                break;
            default:
                createPlayer();
        }
    }

    public void addEntity(Entity e){
        entities.add(e);
    }
    
    /**
     * Used to determine whether this version of the map should keep
     * running in the driver class.
     * @return true if the player is still inside the map
     *      false otherwise
     */
    public boolean keepGoing(){
        return player.getRegion().intersects(this.getBounds());
    }

    /**
     * Determines from which direction the player is leaving this map.
     */
    public int getExitDirection(){
        if(player.getX() < 0)
            return LEFT;
        if(player.getX() + player.getWidth() >= this.getWidth())
            return RIGHT;
        if(player.getY() < 0)
            return UP;
        if(player.getY() + player.getHeight() >= this.getHeight())
            return DOWN;

        return -1;
    }

    /**
     * Returns the player; used for updating the map while preserving
     * the player's state
     */
    public Player getPlayer(){
        return player;
    }

    //passes the player a move command when an arrow is pressed
    private ActionListener panelAction = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            String command = (String) e.getActionCommand();
            player.move((String) e.getActionCommand());

            repaint();
        }
    };

    public void runMap(GameFrameRedo g, int from, Player p){
        g.setContentPane(this);
        this.createPlayer(from, p);

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
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Entity e : this.entities){
            e.update();
            if(e.intersects(player))
                e.collide(player);
            g.drawImage(e.getAnimation().getSprite(), e.getX(), e.getY(), null);
        }
        player.update();
        g.drawImage(player.getAnimation().getSprite(),player.getX(),player.getY(),null);

    }
}

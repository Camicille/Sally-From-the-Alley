import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
/**
 * The main game world.
 * 
 * @author Chandler Clarke
 *  makeMapRow,createPlatforms, readMap, and scrollHorizontal original versions by Ed Parrish
 * @version Alpha 1.2
 */
public class GameWorld extends World{
    //Static world variables
    private static final int WORLD_WIDTH = 600;
    private static final int WORLD_HEIGHT = 400;
    private String[] map;
    //Stat Caps
    private static final int MAX_HEALTH = 10;
    //Stats variables
    private int score;
    private int health;
    //Static Actors
    public Witch player = new Witch();
    //Tile Variables (by Ed Parrish)
    private static final int TILE_WIDTH = 32;
    private static final int TILE_HEIGHT = 32;
    private int leftX; // leftmost x coordinate for a tile
    private int topY;  // highest y coordinate for a tile
    //Health Arrays
    private HealthCounter[] healthCounters;
    private int[] healthX;
    /**
     * Constructor for objects of class GameWorld.
     */
    public GameWorld(){  
        super(800, 600, 1, false);
        leftX = TILE_WIDTH / 2 - TILE_WIDTH;
        topY = TILE_HEIGHT - getHeight() % TILE_HEIGHT;
        readMap("maps/map1.txt"); //Sets starting map
        initializeHealthArray();
        health = 10;  //Setting starting health
    }

    public void act(){
        updateHealthImage();
    }

    public void readMap(String fileName)
    {
        removeObjects(getObjects(null)); // remove all actors
        ArrayList<String> list = new ArrayList();  // construct ArrayList
        Scanner in = new Scanner(
                new BufferedReader(
                    new InputStreamReader(
                        getClass().getResourceAsStream(fileName))));
        while (in.hasNext()) { // while not at end of file
            String line = in.nextLine();
            list.add(line); // add lines to list
            //System.out.println(line);
        }
        in.close();
        map = list.toArray(new String[0]); // convert to array
        createPlatforms(map); // add platforms from map
        addObject(player, getWidth() / 2, 0); // add player
    }

    /**
     * Create and arrange platforms in the world.
     */
    public void createPlatforms(String[] map)
    {
        for (int y = 0; y < map.length; y++){
            makeMapRow(y, map);
        }
    }

    /**
     * Add a row of tiles to the world.
     *
     * @param y The row number in the map grid.
     */
    public void makeMapRow(int y, String[] map)
    {
        int tileY = topY + TILE_HEIGHT * y;
        String row = map[y];
        for (int x = 0; x < row.length(); x++)
        {
            int tileX = leftX + TILE_WIDTH * x;
            char tileType = row.charAt(x);
            if (tileType == 'B'){
                addObject(new Spider(), tileX, tileY);
            }
            else if (tileType == 'M'){
                addObject(new Branches(), tileX, tileY);
            }
            else if (tileType == '2'){
                WorldPortal port = new WorldPortal("maps/map2.txt");
                GreenfootImage img = port.getImage(); // adjust y-position
                int adjustY = TILE_HEIGHT / 2 - img.getHeight() / 2;
                addObject(port, tileX, tileY + adjustY);
            }
            else if (tileType != ' '){
                System.out.println("Wrong tile type: " + tileType);
            }
        }
    }

    /**
     * Used to add or subtract points
     */    
    public void changeScore(int points){
        score = points + score;
    }

    /**
     * Returns the current number of points
     */
    public int getScore(){
        return score;
    }

    /**
     * Used to add or subtract health points
     */    
    public void changeHealth(int healthChange){
        health = health + healthChange;
        if (health >= MAX_HEALTH)
            health = MAX_HEALTH;
    }

    /**
     * Returns the current number of health points
     */
    public int getHealth(){
        return health;
    }

    private void initializeHealthArray(){
        healthCounters = new HealthCounter[10];
        healthX = new int[10];
        for (int i = 0; i< 10; i++){
            healthCounters[i] = new HealthCounter();
            healthX[i] = i * 17;
        }
    }

    private void updateHealthImage(){
        resetHealthContainers();
        for (int y = 0; y < health; y++){
            addObject(healthCounters[y], player.getX() + healthX[y] + 200, 20);
        }
    }

    private void resetHealthContainers(){
        List<HealthCounter> healthContainers = getObjects(HealthCounter.class);
        removeObjects(healthContainers);
    }

    public void scrollHorizontal(double dx)
    {
        List<Actor> actors = getObjects(null);
        for (Actor a : actors){
            if (a instanceof Witch){
                // Allow smooth moving
                Witch p = (Witch) a;
                double moveX = p.getExactX() - dx;
                p.setLocation(moveX, p.getY());
            }
            else if (a instanceof Branches)
            {
                Branches c = (Branches) a;
                // Allow smooth moving
                double moveX = c.getExactX() - dx;
                c.setLocation(c.getExactX() - dx, c.getExactY());
                // Set endpoints
                // int leftX = (int)Math.round(c.getLeftX() - dx);
                //  int rightX = (int)Math.round(c.getRightX() - dx);
                //c.setRangeX(leftX, rightX);
            }
            else{
                int moveX = (int) Math.round(a.getX() - dx);
                a.setLocation(moveX, a.getY());
            }

        }
    }
}

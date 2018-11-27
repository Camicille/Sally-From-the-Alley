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
    //Stats variables
    private int score;
    //Static Actors
    public Witch player = new Witch();
    //Tile Variables (by Ed Parrish)
    private static final int TILE_WIDTH = 32;
    private static final int TILE_HEIGHT = 32;
    private int leftX; // leftmost x coordinate for a tile
    private int topY;  // highest y coordinate for a tile

    /**
     * Constructor for objects of class GameWorld.
     */
    public GameWorld(){ //Uses a numerical value to determine what map to load.   
        super(800, 600, 1, false);
        leftX = TILE_WIDTH / 2 - TILE_WIDTH;
        topY = TILE_HEIGHT - getHeight() % TILE_HEIGHT;
        readMap("maps/map1.txt");
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

    public void scrollHorizontal(double dx)
    {
        List<Actor> actors = getObjects(null);
        for (Actor a : actors)
        {
            if (a instanceof Witch)
            {
                // Allow smooth moving
                Witch p = (Witch) a;
                double moveX = p.getExactX() - dx;
                p.setLocation(moveX, p.getY());
            }
            else
            {
                int moveX = (int) Math.round(a.getX() - dx);
                a.setLocation(moveX, a.getY());
            }
            // else if (a instanceof Enemy)
            // {
            // Enemy c = (Enemy) a;
            // // Allow smooth moving
            // c.setLocation(c.getExactX() - dx, c.getExactY());
            // // Set endpoints
            // int leftX = (int)Math.round(c.getLeftX() - dx);
            // int rightX = (int)Math.round(c.getRightX() - dx);
            // c.setRangeX(leftX, rightX);

        }
    }
}

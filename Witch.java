import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main character
 * 
 * @author Marlene Inoue & Ed Parrish
 * @version 1.2 28 November 2018
 */
public class Witch extends Sprite {
    private static final double MOVE_SPEED = 1.6;

    //gravity and jumping
    private static final double GRAVITY = 0.8;
    private static final double MAX_VEL = 15;
    private static final int JUMP = 10;
    private boolean canJump = true;
    
    //running animation array
    private static GreenfootImage faceRight;
    private static GreenfootImage faceLeft;
    private static GreenfootImage[] runRightImages;
    private static GreenfootImage[] runLeftImages;
    private static final int RUN_COUNT = 6; //FIXME: NEED TO CHANGE AMOUNT OF IMAGEAS
    
    //time of fireball fire
    private counter coolDown = new counter(0,50,1);
    
    //checking whether facing left or right
    private int facing = 1;
    
    //animation
    private IncQuo animationSpeed = new IncQuo(1, 5);
    private static polar animationCount;
    /**
     * Default constructor of Witch
     */
    public Witch() {
        initializeImages();
    }
    
    /**
     * Put the images into the image arrays
     */
    public static void initializeImages() {
        if (runRightImages == null) {
            //make standing pimage
            faceRight = new GreenfootImage("standing.png");
            faceLeft = new GreenfootImage(faceRight);
            faceLeft.mirrorHorizontally();
            
            //load running images
            runRightImages = new GreenfootImage[RUN_COUNT];
            for (int i = 0; i < RUN_COUNT; ++i) {
                String file = "run" + (i + 1) + ".png";
                runRightImages[i] = new GreenfootImage(file);
            }
            runLeftImages = flipImages(runRightImages);
            
            animationCount = new polar(RUN_COUNT - 1);
        }
    }
    
    /**
     * Flip the images from facing right to left
     * 
     * @param imgs  the images to be added to the left facing image array
     */
    private static GreenfootImage[] flipImages(GreenfootImage[] imgs) {
        GreenfootImage[] flip = new GreenfootImage[imgs.length];
        
        for (int i = 0; i < imgs.length; ++i) {
            flip[i] = new GreenfootImage(imgs[i]);
            flip[i].mirrorHorizontally();
        }
            
        return flip;
    }
    
    /**
     * 
     */
    public void checkVertical() {
        double yVel = getYVelocity();
        
        if (yVel == 0) return;
        
        int lookY = 0;
        
        if (yVel > 0) {
            lookY = (int) (yVel + GRAVITY + getImage().getHeight() / 2);
        } else {
            lookY = (int) (yVel + GRAVITY - getImage().getHeight() / 2);
        }
        
        //check for vertical collision in this cycle
        Actor actor = getOneObjectAtOffset(0, lookY, Platforms.class);
        if (actor == null) {
            //no collision in this cycle
            
            canJump = false;
        } else {
            //collision detected
            moveToContactVertical(actor);
            
            if (yVel > 0) canJump = true;
            
            setYVelocity(0.0);
        }
    }
    
    /**
     * Move the Witch into contact with the specified actor vertically
     * 
     * @param target  the target this sprite is approaching
     */
    public void moveToContactVertical(Actor target) {
        int height2 = (target.getImage().getHeight() + getImage().getHeight()) / 2;
        int newY = 0;
        
        if (target.getY() > getY()) {
            newY = target.getY() - height2;
        } else {
            newY = target.getY() + height2;
        }
        
        setLocation(getX(), newY);
    }
    
    /**
     * Moves based on velocity, overriding the move() method in sprite to
     * enable scrolling
     */
    @Override public void move() //@Ed
    {
        super.move();
        double dx = getXVelocity();
        GameWorld w = (GameWorld )getWorld();
        
        if (w == null || dx == 0) return;
        
        w.scrollHorizontal(dx);
        setLocation(w.getWidth() / 2, getY()); // stay in horizontal center
    }
        
    /**
     * Checks and responds to certain key presses
     */
    private void keyPress() {
        if (Greenfoot.isKeyDown("d")) {
            setXVelocity(MOVE_SPEED);
            
            facing = 1;
            
            if (animationSpeed.poll() > 0) {
                setImage(runRightImages[animationCount.poll()]);
            }
        } else if (Greenfoot.isKeyDown("a")) {
            setXVelocity(-MOVE_SPEED);
            
            facing = -1;
            
            if (animationSpeed.poll() > 0) {
                setImage(runLeftImages[animationCount.poll()]);
            }
        } else {
            setXVelocity(0.0);
            
            if (facing > 0) {
                setImage(faceRight);
            }
            else if (facing < 0) {
                setImage(faceLeft);
            }
        }

        if (Greenfoot.isKeyDown("space")) {
            jump();
        }
        
        if(Greenfoot.isKeyDown("f")){
            if(coolDown.full()){
                getWorld().addObject(new Fireball(5 * facing),
                                     getX()+facing*getImage().getWidth(),
                                     getY());
                coolDown.set(0);
            }
        }        
    }

    /**
     * Makes character jump
     */
    private void jump() {
        if (canJump) {
            setYVelocity(-JUMP);
            canJump = false;
        }
    }

    /**
     * Apply gravity when the Witch is jumping or falling
     */
    public void applyGravity() {
        double yVelocity = getYVelocity() + GRAVITY;
        if (yVelocity > MAX_VEL) {
            yVelocity = MAX_VEL;
        }

        setYVelocity(yVelocity);
    }

    /**
     * Reducing Witch's hp when touching an enemy
     */
    private void touchEnemies() {
        GameWorld world = (GameWorld) getWorld();
        
        if (world.getHealth() <= 0) {
            world.removeObject(this);
        }
        
    }

    /**
     * At end game, when the cat walks to the witch
     */
    private void touchCat() {
        if (isTouching(Cat.class)) {
            setLocation(getX(), getY() - 5);
        }
    }

    /**
     * Act - do whatever the Witch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        keyPress();
        checkVertical();
        
        
        touchCat();

        move();
        applyGravity();
        coolDown.poll(); 
        touchEnemies();
    }
}
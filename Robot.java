import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    private GreenfootImage robotimage1= new GreenfootImage("man01.png");
    private GreenfootImage robotimage2= new GreenfootImage("man02.png");
    private int lives = 3;
    private int score = 0;
    private int pizzaEaten = 0;
     private GreenfootImage endover = new GreenfootImage("gameover.png");
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        robotMovement();
        detectWallCollision();
        detectBlockCollision();
        detectHome();
        eatPizza();
        showStatus();
    }    
    
    public void robotMovement()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation( getX(), getY() -3);
            animate();
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation( getX(), getY() +3);
            animate();
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation( getX() -3, getY());
            animate();
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation( getX() +3, getY());
            animate();
        }
    }
    
    public void detectWallCollision()
    {
        if(isTouching(Wall.class))
        {
            setLocation( 25, 50);
            Greenfoot.playSound("hurt.wav");
        }
    }
    
    public void detectBlockCollision()
    {
        if(isTouching(Block.class))
        {
            setLocation( 25, 50);
            Greenfoot.playSound("hurt.wav");
            removeLife();
        }
    }
    public void detectHome()
    {
        
       if(isTouching(Home.class))
     {
       setLocation(25,50);
       Greenfoot.playSound("yipee.wav");
       increaseScore();
       if(pizzaEaten==5)
       {
           Greenfoot.stop();
        }
       }
    }
    public void eatPizza()
    {
        pizzaEaten = pizzaEaten + 1;
        if(isTouching(Pizza.class))
        {
            Greenfoot.playSound("eat.wav");
            removeTouching(Pizza.class);
        }
    }
    public void animate()
    {
        if(getImage()==robotimage1)
        {
            setImage(robotimage2);
        }
        else
        {
            setImage(robotimage1);
        }
    }
    public void removeLife()
    {
        lives = lives -1;
        testEndGame();
    }
    public void testEndGame()
    {
        if(lives==0)
        {
            Greenfoot.stop();
            setImage(endover);
        }
    }
    public void increaseScore()
    {
        score = score + 1;
    }
    public void showStatus()
    {
        getWorld().showText("Lives : "+lives, 70,540);
        getWorld().showText("Pizzas : "+pizzaEaten, 70,560);
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RobotWorld here.
 * 
 * @author (Alexander Edwards) 
 * @version (a version number or a date)
 */
public class RobotWorld extends World
{

    /**
     * Constructor for objects of class RobotWorld.
     * 
     */
    public RobotWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        addObject(new Robot(), 25, 50);
        addObject(new Wall(), 50, 150);
        addObject(new Wall(), 150, 150);
        addObject(new Wall(), 250, 150);
        addObject(new Wall(), 560, 150);
        addObject(new Wall(), 650, 150);
        addObject(new Wall(), 750, 150);
        addObject(new Block(), 404, 150);
        addObject(new Home(), 750, 550);
        addObject(new ScorePanel(), 80, 550);
        addObject(new Pizza(), 130, 50);
        addObject(new Pizza(), 480, 50);
        addObject(new Pizza(), 160, 280);
        addObject(new Pizza(), 400, 560);
        addObject(new Pizza(), 400, 330);
        showText("Lives: 3", 70, 540);
        showText("Pizzas: 0", 70, 560);
    }
}

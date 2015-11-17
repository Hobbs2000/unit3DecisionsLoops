import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.*;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;
    
    // the game board will have 10 rows and 10 columns
    private final int ROWS = 10;
    private final int COLS = 10;
    
    Scanner in = new Scanner(System.in);
    Random numGen = new Random();
    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);
        
        // create a world based on the grid
        world = new ActorWorld(grid);
        
        //Determine if the pattern will be random or not
        //When testing, disable/comment out the user input and pre set willBeRandom to false
        boolean willBeRandom;
        System.out.print("Would you like a random pattern(1) or the default pattern(2)?: ");
        if (in.nextInt() == 1)
        {
            willBeRandom = true;
        }
        else
        {
            willBeRandom = false;
        }
        
        // populate the game
        populateGame(willBeRandom);
        world.show();
        
        //Start Generation loop
        //When testing, disable/comment out the entire loop and preset the amount of generations you want to run
        while (true)
        {
            try
            {
                Thread.sleep(250);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
            createNextGeneration();
            // display the newly constructed and populated world
            world.show();
        }
        
    }
    
    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame(boolean isRand)
    {
        if (!isRand)
        {
            //This creates the default cell pattern of 5 cells in a straight horazontal line
            
            // constants for the location of the three cells initially alive
            final int X1 = 3, Y1 = 4;
            final int X2 = 4, Y2 = 4;
            final int X3 = 5, Y3 = 4;   
            final int X4 = 6, Y4 = 4;   
            final int X5 = 7, Y5 = 4;
            
            // the grid of Actors that maintains the state of the game
            //  (alive cells contains actors; dead cells do not)
            Grid<Actor> grid = world.getGrid();
            
            // create and add rocks (a type of Actor) to the three intial locations
            Rock rock1 = new Rock();
            Location loc1 = new Location(Y1, X1);
            grid.put(loc1, rock1);
            
            Rock rock2 = new Rock();
            Location loc2 = new Location(Y2, X2);
            grid.put(loc2, rock2);
        
            Rock rock3 = new Rock();
            Location loc3 = new Location(Y3, X3);
            grid.put(loc3, rock3);
            
            Rock rock4 = new Rock();
            Location loc4 = new Location(Y4, X4);
            grid.put(loc4, rock4);
            
            Rock rock5 = new Rock();
            Location loc5 = new Location(Y5, X5);
            grid.put(loc5, rock5);
        }
        else
        {
            //This creates a random pattern of cells
            
            Grid<Actor> grid = world.getGrid();
            
            int lastY = -1, lastX = -1;
            int y, x;
            Location loc;
            
            //This randomly makes how many cells are going to be made alive
            int cells = numGen.nextInt(ROWS*COLS);
            for (int i = 1; i <= cells; i++)
            {
                //Randomly makes the coordinates of the cell
                y = numGen.nextInt(ROWS);
                x = numGen.nextInt(COLS);
                Rock rock = new Rock();
                
                //Will run the while loop until the coordinates are not the same as the last coordinates
                //This will prevent SOME overlapping actors, but not all
                while (y == lastY || x == lastX)
                {
                    y = numGen.nextInt(ROWS);
                    x = numGen.nextInt(COLS);
                }
                lastY = y;
                lastX = x;
                loc = new Location(y, x);
                grid.put(loc, rock);
            }
        }
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    private void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
        
        // insert magic here...
        
        /*Make an array for all the cells that will be killed at the end of the generation
          Need to do this to prevent to many cells being killed off
          What would have happened is that a cell would have been killed, then that would have 
          affected the next cell to be checked, and thats not supposed to happen*/
        int arraySize = ROWS * COLS;
        int D_place = 0;
        int R_place = 0;
        Location[] deadCells = new Location[arraySize];
        Location[] revivedCells = new Location[arraySize];

        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                Location loc = new Location(row, col);
                //Will run if the cell is alive
                if (getActor(row, col) != null)
                {
                    //Checks to see if that cell qualifies to be marked for death
                    if ((grid.getNeighbors(loc).size() < 2) || ((grid.getNeighbors(loc)).size() > 3))
                    {
                        deadCells[D_place] = loc;
                        D_place++;
                    }
                }
                else
                {
                    //Checks to see if that dead cell is qualified to become marked for revival
                    if ((grid.getNeighbors(loc).size()) == 3)
                    {
                        revivedCells[R_place] = loc;
                        R_place++;
                    }
                }
            }
        }
 
        //Officially Removes all cells marked for death in that generation
        for (int i = 0; i < D_place; i++)
        {
            grid.remove(deadCells[i]);
        }
        
        //Officially Adds all cells marked for revival in that generation
        for (int i = 0; i < R_place; i++)
        {
            Rock rock = new Rock();
            grid.put(revivedCells[i], rock);
        }
    }

    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }
    
    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }
    
    
    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args)
    {
        GameOfLife game = new GameOfLife();
    }

}
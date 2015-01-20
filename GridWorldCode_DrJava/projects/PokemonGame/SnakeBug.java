/*213175
 * Date Modified April 2, 2011
 * SnakeBug.java
 * Makes the Snake Object which will be used in the snake game.
 */

import info.gridworld.actor.*; 
import info.gridworld.grid.*; 
import java.util.ArrayList;
import java.util.Random;

public class SnakeBug extends Bug{
  
  private int grow;
  private ArrayList<Location> snake;
  Random rand = new Random();
  
  public SnakeBug(){
    grow = 4;
    snake = new ArrayList<Location>();
  }
  
  public void newFlower(){
    Grid<Actor> gr = getGrid();
    int row, column;
    Location temporarylocation = new Location (1, 1); // temporarily sets the value so that there's no compile-time error about not initializing it.
    Flower flower = new Flower();
    boolean keeplooking = true;
    while (keeplooking){
      row = rand.nextInt(gr.getNumRows());
      column = rand.nextInt(gr.getNumCols());
      temporarylocation = new Location (row, column);
      if (gr.get(temporarylocation) == null)
        keeplooking = false;
    }
    Location location = new Location (temporarylocation.getRow(), temporarylocation.getCol());
    flower.putSelfInGrid (gr, location);
  }
  
  public void eraseTail(){
    Grid<Actor> gr = getGrid();
    Actor rock = gr.get(snake.get(snake.size()-1));
    rock.removeSelfFromGrid();
    snake.remove(snake.size()-1);
  }
  
  public void addRockBehindHead (Location loc){
    Grid<Actor> gr = getGrid();
    Rock rock = new Rock();
    rock.putSelfInGrid(gr, loc);
    snake.add(0, loc);
  }
  
  public void act (){
    Grid<Actor> gr = getGrid();
    if (!canMove()){
      javax.swing.JOptionPane.showMessageDialog(null, "Score: " + snake.size(), "GAME OVER!", 0);
      removeSelfFromGrid();
    }
    else{
      Actor neighbor = gr.get(getLocation().getAdjacentLocation(getDirection()));
      if (neighbor instanceof Flower){
        grow += 10;
        neighbor.removeSelfFromGrid();
        newFlower();
      }
      Location loc = getLocation();
      move();
      addRockBehindHead (loc);
      if (grow > 0) grow--;
      else eraseTail();
    }
  }
}
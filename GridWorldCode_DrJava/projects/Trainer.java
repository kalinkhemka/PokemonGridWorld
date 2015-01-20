import info.gridworld.actor.*; 
import info.gridworld.grid.*; 
import java.util.Scanner;
import java.util.ArrayList;

public class Trainer extends Bug{
  
  private String name;
  private ArrayList<Pokemon> pokemonBag = new ArrayList<Pokemon>();
  private static final int MAX_POKEMON = 6;
  protected String directionSuffix;
  Actor oldActor = null, nextActor;
  
  
  Scanner sc = new Scanner(System.in);
  
  public Trainer(String name){
    this.name = name;
    //Mew mew = new Mew();
    pokemonBag.add(new Mew());
  }
  
  public void move(){
    Grid<Actor> gr = getGrid();
    if (gr == null)
      return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(getDirection());
    if (gr.isValid(next)) {
      /*nextActor = gr.get(next);
      moveTo(next);
      if (oldActor != null) gr.put(loc, oldActor);
      oldActor = nextActor;  */
      nextActor = gr.put(next, this);
      gr.put(loc, oldActor);
      oldActor = nextActor;
    }
    else
      removeSelfFromGrid();
  }
  
  public String getImageSuffix(){
    return "_" + directionSuffix;
  }
  
  
  public boolean canMove(){
    Grid<Actor> gr = getGrid();
    if (gr == null)
      return false;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(getDirection());
    if (!gr.isValid(next))
      return false;
    Actor neighbor = gr.get(next);
    return (neighbor == null) || (neighbor instanceof TallGrass) || (neighbor instanceof Green) || (neighbor instanceof Path);
        // not ok to move onto water or rocks
    }
  
  public void act (){
  }
  }
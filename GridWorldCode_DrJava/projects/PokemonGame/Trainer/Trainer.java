import info.gridworld.actor.*; 
import info.gridworld.grid.*; 
import java.util.ArrayList;

public class Trainer extends Bug{
  
  private String name;
  private ArrayList<Pokemon> pokemonBag = new ArrayList<Pokemon>();
  private static final int MAX_POKEMON = 6;
  protected String directionSuffix;
  Actor oldActor = null, nextActor;
  private boolean world2 = false, worlds = false, switched = false;
  
  public Trainer(String name){
    this.name = name;
    pokemonBag.add(new Mew(5));
    setColor(null);
    
  }
  
  private String getName(){
    return name;
  }
  
  public void getOldActor(Grid gr, Location loc){
    oldActor = (Actor)(gr.get(new Location(6,10)));
  }
  
  public void move(){
    Grid<Actor> gr = getGrid();
    if (gr == null)
      return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(getDirection());
    if (gr.isValid(next)) {
      nextActor = gr.get(next);
      moveTo(next);
      if (oldActor != null) 
        oldActor.putSelfInGrid(gr, loc);
      oldActor = nextActor;
    }
    else
      removeSelfFromGrid();
  }

  public String getImageSuffix(){
    if (oldActor instanceof Path)
      return "-path_" + directionSuffix;
    if (oldActor instanceof Green)
      return "-green_" + directionSuffix;
    if (oldActor instanceof Cave43)
      return "-stairs_" + directionSuffix;
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
    return (neighbor == null) || (neighbor instanceof TallGrass) || (neighbor instanceof Green) || (neighbor instanceof Path) || (neighbor instanceof Cave43) || (neighbor instanceof Cave33);
        // not ok to move onto water or rocks
    }
  
  public void act (){
    Grid<Actor> gr = getGrid();
    Location location = new Location(6,0);
    Location rightLoc = new Location(6,19);
    
      if (oldActor instanceof Cave33){
        if (getLocation().equals(new Location(3,15))){
          removeSelfFromGrid();
          oldActor.putSelfInGrid(gr, new Location(3,15));
          oldActor = gr.get(new Location(11,10));
          putSelfInGrid(gr, new Location(11,10));
          directionSuffix = "down";
        }
        else{
          if (getLocation().equals(new Location(10,10))){
          removeSelfFromGrid();
          oldActor.putSelfInGrid(gr, new Location(10,10));
          oldActor = gr.get(new Location(4,15));
          putSelfInGrid(gr, new Location(4,15));
          directionSuffix = "down";
          }
        }
      }
      
      if (getLocation().equals(location)){
        if ((world2 == true) && (switched == false)){
          ((PokemonGrid)gr).fillWorld1();
          oldActor = gr.get(new Location(6,19));
          putSelfInGrid(gr, new Location(6,19));
          world2 = false;
          switched = true;
        }
      }else{
        if (getLocation().equals(rightLoc)){
          if ((world2 == false) && (switched == false)){
            ((PokemonGrid)gr).fillWorld2();
            oldActor = gr.get(new Location(6,0));
            putSelfInGrid(gr, new Location(6,0));
            world2 = true;
            switched = true;
          }
        }else switched = false;
      }  
  }
}



/*java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventDispatcher(){
      public boolean dispatchKeyEvent(java.awt.event.KeyEvent event){
        String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
        if (key.equals( "pressed UP")){
          trainer.setDirection(0);
          if (trainer.canMove())
            trainer.move();
          trainer.directionSuffix = "up";
          trainer.setDirection(0);}
        if (key.equals("pressed RIGHT")){
          trainer.setDirection(90);
          if (trainer.canMove())
            trainer.move();
          trainer.directionSuffix = "right";
          trainer.setDirection(0);}
        if (key.equals("pressed DOWN")){
          trainer.setDirection(180);
          if (trainer.canMove())
            trainer.move();
          trainer.directionSuffix = "down";
          trainer.setDirection(0);}
        if (key.equals("pressed LEFT")){
          trainer.setDirection(270);
          if (trainer.canMove())
            trainer.move();
          trainer.directionSuffix = "left";
          trainer.setDirection(0);} 
        return true;        
      }     
    }*/
import java.util.ArrayList;

public class Scyther extends Pokemon{
 
  public Scyther(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(70, 110, 80, 55, 80, 105, 100, level, "bug");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new AirSlash());
    atks.add(new BugBuzz());
    atks.add(new HyperBeam());
    atks.add(new BugBite());
    setAttacks(atks);
    setName("Scyther");
  }
}
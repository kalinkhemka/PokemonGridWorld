import java.util.ArrayList;

public class Wartortle extends Pokemon{
 
  public Wartortle(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(59, 63, 80, 65, 80, 58, 142, level, "water");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new WaterPulse());
    atks.add(new IceBeam());
    atks.add(new MuddyWater());
    atks.add(new ZenHeadbutt());
    setAttacks(atks);
    setName("Wartortle");
  }
}
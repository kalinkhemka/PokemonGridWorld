import java.util.ArrayList;

public class Corsola extends Pokemon{
 
  public Corsola(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(55, 55, 85, 85, 65, 85, 133, level, "water");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new Bubble());
    atks.add(new PowerGem());
    atks.add(new IceBeam());
    atks.add(new MuddyWater());
    setAttacks(atks);
    setName("Corsola");
  }
}
import java.util.ArrayList;

public class Charmeleon extends Pokemon{
 
  public Charmeleon(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(58, 64, 58, 80, 65, 80, 142, level, "fire");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new FlameBurst());
    atks.add(new Flamethrower());
    atks.add(new MegaKick());
    atks.add(new Crunch());
    setAttacks(atks);
    setName("Charmeleon");
  }
}
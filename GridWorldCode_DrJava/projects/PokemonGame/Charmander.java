import java.util.ArrayList;

public class Charmander extends Pokemon{
 
  public Charmander(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(39, 52, 43, 60, 50, 65, 62, level, "fire");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new Scratch());
    atks.add(new Ember());
    atks.add(new Flamethrower());
    atks.add(new ShadowClaw());
    setAttacks(atks);
    setName("Charmander");
  }
}
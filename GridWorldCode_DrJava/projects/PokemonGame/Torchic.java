import java.util.ArrayList;

public class Torchic extends Pokemon{
 
  public Torchic(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(45, 60, 40, 70, 50, 45, 62, level, "fire");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new Ember());
    atks.add(new Peck());
    atks.add(new FlameCharge());
    atks.add(new Bounce());
    setAttacks(atks);
    setName("Torchic");
  }
}
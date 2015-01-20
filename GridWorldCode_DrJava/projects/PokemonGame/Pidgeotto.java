import java.util.ArrayList;

public class Pidgeotto extends Pokemon{
 
  public Pidgeotto(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(63, 60, 55, 50, 50, 71, 122, level, "flying");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new AirSlash());
    atks.add(new QuickAttack());
    atks.add(new Hurricane());
    atks.add(new OminousWind());
    setAttacks(atks);
    setName("Pidgeotto");
  }
}
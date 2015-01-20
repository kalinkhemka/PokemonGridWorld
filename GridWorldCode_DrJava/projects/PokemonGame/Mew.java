import java.util.ArrayList;

public class Mew extends Pokemon{
 
  public Mew(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(100, 100, 100, 100, 100, 100, 169, level, "psychic");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new Pound());
    atks.add(new MegaPunch());
    atks.add(new ShadowBall());
    atks.add(new Psychic());
    setAttacks(atks);
    setName("Mew");
  }
}
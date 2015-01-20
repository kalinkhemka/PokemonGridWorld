import java.util.ArrayList;

public class Togepi extends Pokemon{
 
  public Togepi(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(35, 20, 65, 40, 65, 20, 49, level, "normal");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new LastResort());
    atks.add(new Psychic());
    atks.add(new ShadowBall());
    atks.add(new Tackle());
    setAttacks(atks);
    setName("Togepi");
  }
}
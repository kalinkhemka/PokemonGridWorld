import java.util.ArrayList;

public class Snorlax extends Pokemon{
 
  public Snorlax(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(160, 110, 65, 65, 110, 30, 189, level, "normal");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new BodySlam());
    atks.add(new Earthquake());
    atks.add(new Lick());
    atks.add(new LastResort());
    setAttacks(atks);
    setName("Snorlax");
  }
}
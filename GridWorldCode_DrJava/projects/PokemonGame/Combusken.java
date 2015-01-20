import java.util.ArrayList;

public class Combusken extends Pokemon{
 
  public Combusken(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(60, 85, 60, 85, 60, 55, 142, level, "fire");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new Ember());
    atks.add(new FlareBlitz());
    atks.add(new BrickBreak());
    atks.add(new Bounce());
    setAttacks(atks);
    setName("Combusken");
  }
}
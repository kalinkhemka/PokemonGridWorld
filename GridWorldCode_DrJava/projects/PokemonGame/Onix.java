import java.util.ArrayList;

public class Onix extends Pokemon{
 
  public Onix(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(35, 45, 160, 30, 45, 70, 77, level, "rock");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new RockThrow());
    atks.add(new StoneEdge());
    atks.add(new Earthquake());
    atks.add(new DragonRush());
    setAttacks(atks);
    setName("Onix");
  }
}
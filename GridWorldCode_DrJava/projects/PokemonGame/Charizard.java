import java.util.ArrayList;

public class Charizard extends Pokemon{
 
  public Charizard(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(78, 84, 78, 109, 85, 100, 240, level, "fire");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new AirSlash());
    atks.add(new BlastBurn());
    atks.add(new DragonRush());
    atks.add(new GigaImpact());
    setAttacks(atks);
    setName("Charizard");
  }
}
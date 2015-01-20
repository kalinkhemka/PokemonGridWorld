import java.util.ArrayList;

public class Blastoise extends Pokemon{
 
  public Blastoise(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(79, 83, 100, 85, 105, 78, 239, level, "water");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new HydroCannon());
    atks.add(new Blizzard());
    atks.add(new GigaImpact());
    atks.add(new ZenHeadbutt());
    setAttacks(atks);
    setName("Blastoise");
  }
}
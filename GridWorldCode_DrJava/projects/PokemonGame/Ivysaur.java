import java.util.ArrayList;

public class Ivysaur extends Pokemon{
 
  public Ivysaur(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(60, 62, 63, 80, 80, 60, 142, level, "grass");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new TakeDown());
    atks.add(new RazorLeaf());
    atks.add(new SludgeBomb());
    atks.add(new SolarBeam());
    setAttacks(atks);
    setName("Ivysaur");
  }
}
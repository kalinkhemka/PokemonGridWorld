import java.util.ArrayList;

public class Blaziken extends Pokemon{
 
  public Blaziken(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(80, 120, 70, 110, 70, 80, 239, level, "fire");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new FirePunch());
    atks.add(new Overheat());
    atks.add(new SkyUppercut());
    atks.add(new FocusBlast());
    setAttacks(atks);
    setName("Blaziken");
  }
}
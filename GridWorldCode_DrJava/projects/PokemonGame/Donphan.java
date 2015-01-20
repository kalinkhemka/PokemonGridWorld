import java.util.ArrayList;

public class Donphan extends Pokemon{
 
  public Donphan(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(90, 120, 120, 60, 60, 50, 175, level, "ground");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new FireFang());
    atks.add(new ThunderFang());
    atks.add(new HeadSmash());
    atks.add(new Earthquake());
    setAttacks(atks);
    setName("Donphan");
  }
}
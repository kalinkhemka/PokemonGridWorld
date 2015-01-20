import java.util.ArrayList;

public class Squirtle extends Pokemon{
 
  public Squirtle(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(44, 48, 65, 50, 64, 43, 63, level, "water");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new WaterGun());
    atks.add(new SkullBash());
    atks.add(new MudSlap());
    atks.add(new ZenHeadbutt());
    setAttacks(atks);
    setName("Squirtle");
  }
}
import java.util.ArrayList;

public class Kangaskhan extends Pokemon{
 
  public Kangaskhan(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(105, 95, 80, 40, 80, 90, 172, level, "normal");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new MegaPunch());
    atks.add(new ShadowBall());
    atks.add(new GigaImpact());
    atks.add(new ZenHeadbutt());
    setAttacks(atks);
    setName("Kangaskhan");
  }
}
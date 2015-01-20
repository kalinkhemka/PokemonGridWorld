import java.util.ArrayList;

public class Pidgeot extends Pokemon{
 
  public Pidgeot(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(83, 80, 75, 70, 70, 91, 211, level, "flying");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new Hurricane());
    atks.add(new SkyAttack());
    atks.add(new HeatWave());
    atks.add(new Twister());
    setAttacks(atks);
    setName("Pidgeot");
  }
}
import java.util.ArrayList;

public class Altaria extends Pokemon{
 
  public Altaria(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(75, 70, 90, 70, 105, 80, 172, level, "dragon");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new DragonPulse());
    atks.add(new SkyAttack());
    atks.add(new DragonMeteor());
    atks.add(new HeatWave());
    setAttacks(atks);
    setName("Altaria");
  }
}
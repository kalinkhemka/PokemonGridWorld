import java.util.ArrayList;

public class Pidgey extends Pokemon{
 
  public Pidgey(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(40, 45, 40, 35, 35, 56, 50, level, "flying");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new Gust());
    atks.add(new QuickAttack());
    atks.add(new Twister());
    atks.add(new WingAttack());
    setAttacks(atks);
    setName("Pidgey");
  }
}
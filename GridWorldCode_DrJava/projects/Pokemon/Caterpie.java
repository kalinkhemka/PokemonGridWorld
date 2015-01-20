public class Caterpie extends Pokemon
{
  
  Move thunderbolt = new Move(1,55,"Pound");
  Move quickAtk = new Move(0,20,"String Shot");
  Move shock = new Move(1,40,"Tackle");
  String name;
  int exp, level, hp, attack, defense, sAtk, speed, sDef,curHp;
  int baseHp = 35, baseAtk = 55,baseDef=30,baseSpA=50,baseSD = 40,baseSpd = 90;
  boolean dead = false;
  Move[] moves = {thunderbolt,quickAtk,shock};
  public Caterpie(String nickname,int experience)
  {
    super( nickname, experience);
  }
  public int getDef()
  {
    return defense;
  }
  public int attack(int def, int moveNum)
  {
    System.out.println(name+"Attacks opponent with "+moves[moveNum]+" dealing "+ (int)(((((2*level/5+2)*attack*moves[moveNum].getPow()/def)/5)+2)*1.25*1/10));
    return (int)(((((2*level/5+2)*attack*moves[moveNum].getPow()/def)/5)+2)*1.25*1/10);
    
  }
  public void damage(int dam)
  {
    curHp-=dam;
    if(curHp<=0)
    {
      dead=true;
    }
    System.out.println(name+" has " +curHp+" HP left");
  }
  public void addExp(int expr)
  {
    exp+=expr;
    level=(int)(exp/1000);
    if(level==25)
    {
      System.out.println(name+ " evolved");
      baseHp = 55;
      baseAtk = 65;
      baseDef=50;
      baseSpA=70;
      baseSD = 60;
      baseSpd = 100;
    }
    hp = baseHp*(level/2);
    attack = baseAtk*(level/2);
    defense = baseDef*(level/2);
    sAtk = baseSpA*(level/2);
    speed = baseSpd*(level/2);
    sDef = baseSD*(level/2);
    curHp = hp;
    
  }
  public int getRate()
  {
    return (int)((hp-curHp)/hp);
  }
  public boolean dead()
  {
    return dead;
  }
  public Move[] getmoves()
  {
    return moves;
  }
  public String toString()
  {
    return name;
  }
}
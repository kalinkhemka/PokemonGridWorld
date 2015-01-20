public class Pokemon
{
  String name;
  int exp, level, hp, attack, defense, sAtk, speed, sDef,curHp;
  int baseHp = 35, baseAtk = 55,baseDef=30,baseSpA=50,baseSD = 40,baseSpd = 90;
  Move move1 ,move2 ,move3;
  boolean dead = false;
  Move[] moves = new Move[3];
  public Pokemon(String nickname,int experience, int type)
  {
    name = nickname;
    exp=experience;
    level=(int)(exp/1000);
    hp = baseHp*(level/2);
    attack = baseAtk*(level/2);
    defense = baseDef*(level/2);
    sAtk = baseSpA*(level/2);
    speed = baseSpd*(level/2);
    sDef = baseSD*(level/2);
    curHp = hp;
    if(type == 1)
    {
    move1 =  new Move(1,95,"Thunderbolt");
    move2 =new Move(0,40,"Quick Attack");
    move3 = new Move(1,50,"Shock");
    moves[0] =move1;
    moves[1]=move2;
    moves[2]=move3;
    }
     if(type == 2)
    {
    move1 =  new Move(1,95,"Fly");
    move2 =new Move(0,50,"Wing Attack");
    move3 = new Move(1,40,"Quick Attack");
    moves[0] =move1;
    moves[1]=move2;
      moves[2]=move3;
    }
    if(type == 3)
    {
    move1 =  new Move(1,95,"Earthquake");
    move2 =new Move(0,45,"Rock Throw");
    move3 = new Move(1,40,"Pound");
    moves[0] =move1;
    moves[1]=move2;
    moves[2]=move3;
    }
    if(type == 4)
    {
    move1 =  new Move(1,85,"Stone Edge");
    move2 =new Move(0,60,"Magnitude");
    move3 = new Move(1,20,"Tackle");
    moves[0] =move1;
    moves[1]=move2;
    moves[2]=move3;
    }
    if(type == 5)
    {
    move1 =  new Move(1,75,"Bug Buzz");
    move2 =new Move(0,55,"String Shot");
    move3 = new Move(1,40,"Tackle");
    moves[0] =move1;
    moves[1]=move2;
    moves[2]=move3;
    }
    if(type == 6)
    {
    move1 =  new Move(1,85,"Crunch");
    move2 =new Move(0,50,"Gnaw");
    move3 = new Move(1,40,"Tackle");
    moves[0] =move1;
    moves[1]=move2;
    moves[2]=move3;
    }
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
public class Move
{
  int type;
  int power;
  String name;
  public Move(int t, int p, String meh)
  {
    type = t;
    power = p;
    name = meh;
  }
  public int getPow()
  {
    return power;
  }
  
  public int getType()
  {
    return type;
  }
  public String toString()
  {
    return name;
  }
}
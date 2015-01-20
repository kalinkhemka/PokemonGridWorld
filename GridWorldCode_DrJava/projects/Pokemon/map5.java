import info.gridworld.actor.*; 

public class map5
{
  public static Actor[][] map= {
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Black()},
    {new Black(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Black()},
    {new Black(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Black()},
    {new Black(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Dp_turnback_cave(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()}
  };

public map5()
  {
    
  }
  public Actor[][] getMap()
  {
    return map;
  }
}
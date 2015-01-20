import info.gridworld.actor.*; 

public class map4
{
  public static Actor[][] map= {
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new boy1(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()}
  };

public map4()
  {
    
  }
  public Actor[][] getMap()
  {
    return map;
  }
}
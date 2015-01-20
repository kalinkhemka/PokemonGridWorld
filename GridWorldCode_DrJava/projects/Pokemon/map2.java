import info.gridworld.actor.*; 

public class map2
{
  public static Actor[][] map= {
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Warp_tile_gen1(),new girl1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()}
  };

public map2()
  {
    
  }
  public Actor[][] getMap()
  {
    return map;
  }
}
import info.gridworld.actor.*; 

public class map3
{
  public static Actor[][] map= {
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()}
  };

public map3()
  {
    
  }
  public Actor[][] getMap()
  {
    return map;
  }
}
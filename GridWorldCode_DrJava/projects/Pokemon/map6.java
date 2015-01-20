import info.gridworld.actor.*; 

public class map6
{
  public static Actor[][] map= {
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new leader1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black()},
    {new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black()},
    {new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black()},
    {new Black(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Warp_tile_gen1(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()},
    {new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black(),new Black()}
  };

public map6()
  {
    
  }
  public Actor[][] getMap()
  {
    return map;
  }
}
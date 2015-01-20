import info.gridworld.grid.*;
import info.gridworld.actor.*;

public class PokemonGrid extends BoundedGrid
{
	public PokemonGrid()
	{
		super(20,20);
	}

	public void fillWorld1()
    {

    	for(int i = 0; i < getNumRows(); i++)
		{
			for(int j= 0; j< getNumCols(); j++)
			{
				putIn(new Location(i,j), new Green());
			}
		}

		for(int i = 0; i < 5; i++)
		{
			for(int j= 0; j< 9; j++)
			{
				putIn(new Location(i,j), new TallGrass());
			}
		}

		for(int i = 9; i < getNumCols(); i++)
		{
			putIn(new Location(0,i), new TallGrass());
		}

		for(int i = 9; i < getNumCols(); i++)
		{
			putIn(new Location(getNumRows()-1,i), new TallGrass());
		}

		for(int i = 0; i < getNumCols(); i++)
		{
			putIn(new Location(6,i), new Path());
		}
		for(int i = 2; i < getNumRows()-2; i++)
		{
			putIn(new Location(i,10), new Path());
		}


		putIn(new Location(1,12), new WaterCorner(0));
		putIn(new Location(2,12), new WaterSide(0));
		putIn(new Location(3,12), new WaterSide(0));
		putIn(new Location(4,12), new WaterCorner(270));
		for(int i = 13; i < 20; i++)
		{
			putIn(new Location(1,i), new WaterSide(90));
			putIn(new Location(2,i), new Water());
			putIn(new Location(3,i), new Water());
			putIn(new Location(4,i), new WaterSide(270));
		}


		for(int i = 2; i < 15; i++)
		{
			putIn(new Location (i, 15), new Path());
		}
		putIn(new Location (2, 14), new Path());
		putIn(new Location (2, 16), new Path());
		putIn(new Location (3, 14), new Path());
		putIn(new Location (3, 16), new Path());


		for(int i = 8; i < getNumRows(); i++)
		{
			for(int j= 0; j< 9; j++)
			{
				putIn(new Location(i,j), new TallGrass());
			}
		}

		putIn(new Location(11,0), new WaterCorner(0));
		for(int i = 12; i < getNumRows()-1; i++)
		{
			putIn(new Location(i,0), new WaterSide(0));
		}
		putIn(new Location(getNumRows()-1,0), new WaterCorner(270));
		for(int i = 1; i < 5; i++)
		{
			putIn(new Location(11,i), new WaterSide(90));
			for(int j = 12; j < getNumRows()-1; j++)
			{
				putIn(new Location(j,i), new Water());
			}
			putIn(new Location(getNumRows()-1,i), new WaterSide(270));
		}
		putIn(new Location(11,5), new WaterCorner(90));
		for(int i = 12; i < getNumRows()-1; i++)
		{
			putIn(new Location(i,5), new WaterSide(180));
		}
		putIn(new Location(getNumRows()-1,5), new WaterCorner(180));

		for(int i = 8; i < getNumRows(); i++)
		{
			putIn(new Location(i,12), new TallGrass());
			putIn(new Location(i,13), new TallGrass());
			putIn(new Location(i,17), new TallGrass());
			putIn(new Location(i,18), new TallGrass());
			putIn(new Location(i,19), new TallGrass());
		}
		for(int i = 16; i < getNumRows(); i++)
		{
			putIn(new Location(i,14), new TallGrass());
			putIn(new Location(i,15), new TallGrass());
			putIn(new Location(i,16), new TallGrass());
		}

		putIn(new Location(17,15), new WaterCorner(0));
		putIn(new Location(17,16), new WaterSide(90));
		putIn(new Location(17,17), new WaterCorner(90));
		putIn(new Location(18,15), new WaterCorner(270));
		putIn(new Location(18,16), new WaterSide(270));
		putIn(new Location(18,17), new WaterCorner(180));

    }

    public void fillWorld2()
    {
    	for(int i = 0; i < getNumRows(); i++)
		{
			for(int j= 0; j< getNumCols(); j++)
			{
				putIn(new Location(i,j), new Green());
			}
		}

		for(int i = 0; i < 5; i++)
		{
			for(int j= 0; j< 10; j++)
			{
				putIn(new Location(i,j), new TallGrass());
			}
		}

		for(int i = 8; i < getNumRows(); i++)
		{
			for(int j= 16; j< getNumCols(); j++)
			{
				putIn(new Location(i,j), new TallGrass());
			}
		}

		for(int i = 0; i < 6; i++)
		{
			for(int j= 12; j< 19; j++)
			{
				putIn(new Location(i,j), new TallGrass());
			}
		}

		putIn(new Location(5,15), new Path());

		for(int i = 7; i < 13; i++)
		{
			for(int j= 7; j< 15; j++)
			{
				putIn(new Location(i,j), new TallGrass());
			}
		}

		for(int i = 8; i < getNumRows(); i++)
		{
			for(int j= 0; j< 5; j++)
			{
				putIn(new Location(i,j), new TallGrass());
			}
		}

		for(int i = 0; i < getNumCols(); i++)
		{
			putIn(new Location(6,i), new Path());
		}

		for(int i = 0; i < 6; i++)
		{
			putIn(new Location(i,11), new Path());
		}
		for(int i = 0; i < 6; i++)
		{
			putIn(new Location(i,getNumCols()-1), new Path());
		}

		for(int j = 6; j < 14; j ++)
		{
			putIn(new Location(j,6), new Path());
		}

		for(int j = 6; j < 14; j ++)
		{
			putIn(new Location(j,14), new Path());
		}

		for(int i = 6; i < 15; i++)
		{
			putIn(new Location(13,i), new Path());
		}
		putIn(new Location(12,10), new Path());

		putIn(new Location(1,0), new WaterCorner(90));
		putIn(new Location(2,0), new WaterSide(180));
		putIn(new Location(3,0), new WaterSide(180));
		putIn(new Location(4,0), new WaterCorner(180));

		putIn(new Location(8,8), new Cave11());
		putIn(new Location(8,9), new Cave12());
		putIn(new Location(8,10), new Cave13());
		putIn(new Location(8,11), new Cave14());
		putIn(new Location(8,12), new Cave15());
		putIn(new Location(9,8), new Cave21());
		putIn(new Location(9,9), new Cave22());
		putIn(new Location(9,10), new Cave23());
		putIn(new Location(9,11), new Cave24());
		putIn(new Location(9,12), new Cave25());
		putIn(new Location(10,8), new Cave31());
		putIn(new Location(10,9), new Cave32());
		putIn(new Location(10,10), new Cave33());
		putIn(new Location(10,11), new Cave34());
		putIn(new Location(10,12), new Cave35());
		putIn(new Location(11,8), new Cave41());
		putIn(new Location(11,9), new Cave42());
		putIn(new Location(11,10), new Cave43());
		putIn(new Location(11,11), new Cave44());
		putIn(new Location(11,12), new Cave45());

		putIn(new Location(1,13), new Cave11());
		putIn(new Location(1,14), new Cave12());
		putIn(new Location(1,15), new Cave13());
		putIn(new Location(1,16), new Cave14());
		putIn(new Location(1,17), new Cave15());
		putIn(new Location(2,13), new Cave21());
		putIn(new Location(2,14), new Cave22());
		putIn(new Location(2,15), new Cave23());
		putIn(new Location(2,16), new Cave24());
		putIn(new Location(2,17), new Cave25());
		putIn(new Location(3,13), new Cave31());
		putIn(new Location(3,14), new Cave32());
		putIn(new Location(3,15), new Cave33());
		putIn(new Location(3,16), new Cave34());
		putIn(new Location(3,17), new Cave35());
		putIn(new Location(4,13), new Cave41());
		putIn(new Location(4,14), new Cave42());
		putIn(new Location(4,15), new Cave43());
		putIn(new Location(4,16), new Cave44());
		putIn(new Location(4,17), new Cave45());

		for(int i = 0; i < getNumCols(); i++)
		{
			putIn(new Location(14, i), new TallGrass());
		}

		putIn(new Location(15,5), new WaterCorner(0));
		for(int i = 16; i < getNumRows()-1; i++)
		{
			putIn(new Location(i,5), new WaterSide(0));
		}
		putIn(new Location(getNumRows()-1,5), new WaterCorner(270));
		for(int i = 6; i < getNumCols()-1; i++)
		{
			putIn(new Location(15,i), new WaterSide(90));
			for(int j = 16; j < getNumRows()-1; j++)
			{
				putIn(new Location(j,i), new Water());
			}
			putIn(new Location(getNumRows()-1,i), new WaterSide(270));
		}
		putIn(new Location(15,getNumCols()-1), new WaterCorner(90));
		for(int i = 16; i < getNumRows()-1; i++)
		{
			putIn(new Location(i,getNumCols()-1), new WaterSide(180));
		}
		putIn(new Location(getNumRows()-1,getNumCols()-1), new WaterCorner(180));


    }

    public void putIn(Location loc, WaterCorner a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, WaterSide a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Water a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Path a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Green a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, TallGrass a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave11 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave12 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave13 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave14 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave15 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave21 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave22 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave23 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave24 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave25 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave31 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave32 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave33 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave34 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave35 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave41 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave42 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave43 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave44 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
    public void putIn(Location loc, Cave45 a)
    {
    	a.putSelfInGrid((Grid)this, loc);
    }
}

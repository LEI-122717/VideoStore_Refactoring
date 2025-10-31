package ficha3;

import ficha3.Price;

public class RegularPrice extends Price
{

	public RegularPrice()
	{
	}

	public RegularPrice(boolean blueray)
	{
		super(blueray);
	}

	public double getRentalAmount(int duration)
	{
		return 2 + (duration > 2 ? (duration - 2) * 1.5 : 0) + (is_blueray() ? 1 : 0);
	}

	public int getFrequentRentalPoints(int duration)
	{
		return is_blueray() ? 2 : 1;
	}
}

package ficha3;

import ficha3.Price;

public class ChildrensPrice extends Price
{

	public ChildrensPrice()
	{
	}


	public double getRentalAmount(int duration)
	{
		return 1.5 + (duration > 3 ? (duration - 3) * 1.5 : 0);
	}

	public int getFrequentRentalPoints(int duration)
	{
		return 1;
	}

}

package ficha3;

import ficha3.Movie;

public class Rental
{
    ficha3.Movie _movie;
    private int		_daysRented;

    public Rental(ficha3.Movie movie, int daysRented)
    {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented()
    {
        return _daysRented;
    }

    public Movie getMovie()
    {
        return _movie;
    }
}


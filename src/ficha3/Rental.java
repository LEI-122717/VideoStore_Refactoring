package ficha3;

import vNew.Movie;

public class Rental
{
    vNew.Movie _movie;
    private int		_daysRented;

    public Rental(vNew.Movie movie, int daysRented)
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


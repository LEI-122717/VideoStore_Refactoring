package ficha3;

import ficha3.Price;

public class Movie {

    private String _title;
    private ficha3.Price _price;

    public Movie(String title, ficha3.Price price) {
        _title = title;
        _price = price;
    }

    public String getTitle() {
        return _title;
    }

    public Price getPrice()
    {
        return _price;
    }
}

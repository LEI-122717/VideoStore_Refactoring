package ficha3;

import vNew.Price;

public class Movie {

    private String _title;
    private vNew.Price _price;

    public Movie(String title, vNew.Price price) {
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

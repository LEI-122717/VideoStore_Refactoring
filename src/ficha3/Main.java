package ficha3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import demo.Database;
import ficha3.BestPrice;
import ficha3.ChildrensPrice;
import ficha3.Customer;
import ficha3.MafiaPrice;
import ficha3.Movie;
import ficha3.NewReleasePrice;
import ficha3.Price;
import ficha3.RegularPrice;
import ficha3.Rental;

/***********************************************************
 * Filename: Main.java
 *
 * @author fba 6 de Mai de 2013
 ***********************************************************/
public abstract class Main
{

    /***********************************************************
     * @param args
     * @throws IOException
     ***********************************************************/
    public static void main(String[] args) throws IOException
    {
        Scanner teclado = new Scanner(System.in);
        int response = -1;

        System.out.println("Escolha uma opcao:\n1 - criar objectos e gravar\n2 - fazer load da DB\n");
        response = teclado.nextInt();
        switch (response)
        {
            case 1:
                ficha3.Customer who = new ficha3.Customer("Barack Obama");

                ficha3.Price p1 = new RegularPrice(false);
                ficha3.Movie m1 = new ficha3.Movie("Life of Amalia", p1);
                ficha3.Price p2 = new ChildrensPrice();
                ficha3.Movie m2 = new ficha3.Movie("Peter Pan", p2);
                ficha3.Price p3 = new NewReleasePrice(true);
                ficha3.Movie m3 = new ficha3.Movie("Donna del Lago", p3);
                ficha3.Price p4 = new BestPrice();
                ficha3.Movie m4 = new ficha3.Movie("La Belle Epoque", p4);
                Price p5 = new ficha3.MafiaPrice(true);
                ficha3.Movie m5 = new Movie("Al Capone 2", new MafiaPrice(true));

                who.addRental(new ficha3.Rental(m1, 1));
                who.addRental(new ficha3.Rental(m2, 2));
                who.addRental(new ficha3.Rental(m3, 3));
                who.addRental(new ficha3.Rental(m4, 2));
                who.addRental(new Rental(m5, 7));

                Database.store(who);

                Database.close();

                System.out.println(who.statement());

                PrintWriter html = new PrintWriter(new FileWriter("webPages/statement.html"));
                html.println(who.htmlStatement());
                html.close();
                break;
            case 2:
                LoadDB();
                break;

            default:
                break;
        }

    }

    // from db
    public static void LoadDB() throws IOException
    {
//		query um customer pelo nome
        ficha3.Customer who = Database.get(Customer.class,  "_name", "Barack Obama");

        System.out.println(who.statement());

        PrintWriter html = new PrintWriter(new FileWriter("webPages/statement.html"));
        html.println(who.htmlStatement());
        html.close();

        Database.close();
    }

}

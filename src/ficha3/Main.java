package ficha3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import demo.Database;
import vNew.BestPrice;
import vNew.ChildrensPrice;
import vNew.Customer;
import vNew.MafiaPrice;
import vNew.Movie;
import vNew.NewReleasePrice;
import vNew.Price;
import vNew.RegularPrice;
import vNew.Rental;

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
                vNew.Customer who = new vNew.Customer("Barack Obama");

                vNew.Price p1 = new RegularPrice(false);
                vNew.Movie m1 = new vNew.Movie("Life of Amalia", p1);
                vNew.Price p2 = new ChildrensPrice();
                vNew.Movie m2 = new vNew.Movie("Peter Pan", p2);
                vNew.Price p3 = new NewReleasePrice(true);
                vNew.Movie m3 = new vNew.Movie("Donna del Lago", p3);
                vNew.Price p4 = new BestPrice();
                vNew.Movie m4 = new vNew.Movie("La Belle Epoque", p4);
                Price p5 = new vNew.MafiaPrice(true);
                vNew.Movie m5 = new Movie("Al Capone 2", new MafiaPrice(true));

                who.addRental(new vNew.Rental(m1, 1));
                who.addRental(new vNew.Rental(m2, 2));
                who.addRental(new vNew.Rental(m3, 3));
                who.addRental(new vNew.Rental(m4, 2));
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
        vNew.Customer who = Database.get(Customer.class,  "_name", "Barack Obama");

        System.out.println(who.statement());

        PrintWriter html = new PrintWriter(new FileWriter("webPages/statement.html"));
        html.println(who.htmlStatement());
        html.close();

        Database.close();
    }

}

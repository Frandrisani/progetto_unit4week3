package FrancescoAndrisani.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "catalogo")
public class Book extends Catalogo{
    // attributi
    private String autore;
    private String genere;

    // costruttore
    public Book(long isbn, String titolo, int annoDiPubblicazione, int numeroPagine, String autore, String genere){
        super(isbn, titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
    public Book() {}

    // getter e setter

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    // toString

    @Override
    public String toString() {
        return "Book{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}

package FrancescoAndrisani.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "catalogo")
public class Magazines extends Catalogo {
    // attributi
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    // costruttore
    public Magazines(long isbn, String titolo, int annoDiPubblicazione, int numeroPagine, Periodicita periodicita){
        super(isbn, titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    // getter e setter

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    // toString

    @Override
    public String toString() {
        return "Magazines{" +
                "periodicita=" + periodicita +
                ", isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}

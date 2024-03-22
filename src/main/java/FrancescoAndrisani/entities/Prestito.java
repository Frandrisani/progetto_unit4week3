package FrancescoAndrisani.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "catalogo")
public class Prestito {
    // attributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Utente utente;
    private Catalogo oggetto;
    private LocalDate inizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    // costruttore
    public Prestito(Utente utente, Catalogo oggetto, LocalDate inizioPrestito){
        this.utente = utente;
        this.oggetto = oggetto;
        this.inizioPrestito = inizioPrestito;
    }
    public Prestito() {
    }
    public Prestito(LocalDate dataRestituzioneEffettiva){
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    // getter e setter

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Catalogo getOggetto() {
        return oggetto;
    }

    public void setOggetto(Catalogo oggetto) {
        this.oggetto = oggetto;
    }

    public LocalDate getInizioPrestito() {
        return inizioPrestito;
    }

    public void setInizioPrestito(LocalDate inizioPrestito) {
        this.inizioPrestito = inizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        //Con una ricerca web scopro che il metodo plusDays() è un metodo di LocalDate che permette di aggiungere un numero di giorni al giorno
        //link documentazione:https://www.geeksforgeeks.org/localdate-plusdays-method-in-java-with-examples/
        this.dataRestituzionePrevista = this.inizioPrestito.plusDays(30);
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", oggetto=" + oggetto +
                ", inizioPrestito=" + inizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}

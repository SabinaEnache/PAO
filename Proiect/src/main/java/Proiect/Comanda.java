package Proiect;
import java.util.*;
public class Comanda {
    private static int id = 0;
    private double valoare;
    private List<Produs> produse;

    public Comanda() {
        id++;
        this.valoare = 0.0;
        this.produse = new ArrayList<>();
    }
    public double getValoare() {
        return this.valoare;
    }

    public List<Produs> getProduse() {
        return this.produse;
    }

    public int getIdComanda() {
        return this.id;
    }

    private void calcvaloare() {
        double valoareNoua = 0.0;
        for (Produs produs : produse) {
            valoareNoua += produs.getPret();
        }
         this.valoare = valoareNoua;
    }
    public void adaugaProdus(Produs produs) {
        this.produse.add(produs);
        calcvaloare();
    }
    public void eliminaProdus(Produs produs) {
        this.produse.remove(produs);
        calcvaloare();
    }

    public boolean esteOnline() {
        return this instanceof ComandaOnline;
    }

}

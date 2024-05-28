package Proiect.Domain;
import java.util.*;
import Proiect.Domain.Produs;
public class Meniu {
    private List<Produs> produse;
    public Meniu(){
        this.produse = new ArrayList<>();
    }
    public void adaugaProdus(Produs produs){
        produse.add(produs);
    }

    public void eliminaProdus(String nume){
        Iterator<Produs> iterator = produse.iterator();
        while (iterator.hasNext()) {
            Produs produs = iterator.next();
            if (produs.getNumeProdus().equalsIgnoreCase(nume)) {
                iterator.remove();
                System.out.println("Produsul " + nume + " a fost șters.");
                return;
            }
        }

    }
    public void schimbaPret(String numeProdus, double pretNou) {
        for (Produs produs : produse) {
            if (produs.getNumeProdus().equalsIgnoreCase(numeProdus)) {
                produs.setPret(pretNou);
                System.out.println("Prețul produsului " + numeProdus + " a fost actualizat.");
                return;
            }
        }
        System.out.println("Produsul " + numeProdus + " nu a fost găsit în meniu.");
    }

    public List<Produs> getProduse(){
        return produse;
    }

    public void afisareMeniu(){
        for(Produs produs : produse){
            System.out.println(produs.toString());
        }
    }
    private static Meniu instance;
    public static Meniu getInstance(){
        if(instance == null){
            instance = new Meniu();
        }
        return instance;
    }
}

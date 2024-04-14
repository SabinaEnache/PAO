package Proiect;
import java.util.*;
public class Meniu {
    private List<Produs> produse;
    public Meniu(){
        this.produse = new ArrayList<>();
    }
    public void adaugaProdus(Produs produs){
        produse.add(produs);
    }

    public void eliminaProdus(Produs produs){
        produse.remove(produs);
    }

    public List<Produs> getProduse(){
        return produse;
    }
}

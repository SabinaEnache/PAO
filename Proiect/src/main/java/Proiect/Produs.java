package Proiect;
import java.util.*;

public class Produs {
    private String numeProdus;
    private double pret;
    private List<Ingredient> ingrediente;

    public Produs(String nume, double pret){
        this.numeProdus =nume;
        this.pret=pret;
        this.ingrediente = new ArrayList<>();
    }
    public String getNumeProdus() {
        return numeProdus;
    }
    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    public double getPret() {
        return pret;
    }
    public void setPret(double pret) {
        this.pret = pret;
    }
    public void adaugaIngredient(Ingredient ingredient) {
        ingrediente.add(ingredient);
    }

    public void eliminaIngredient(Ingredient ingredient) {
        ingrediente.remove(ingredient);
    }

    public List<Ingredient> getIngrediente() {
        return this.ingrediente;
    }
}

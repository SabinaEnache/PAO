package Proiect;
import java.util.*;
public class Inventar {
    private Map<Ingredient, Double> stoc;
    public Inventar(){
        this.stoc = new HashMap<>();
    }
    // Metoda pentru a verifica dacă un ingredient este disponibil în inventar
    public boolean ingredientDisponibil(Ingredient ingredient, double cantitate) {
        return stoc.getOrDefault(ingredient, 0.0) >= cantitate;
    }


}

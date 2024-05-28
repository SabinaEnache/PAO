package Proiect.Domain;

public class Ingredient {
    private String numeIngredient;
    private int cantitate;
    private UM unitate_masura;
    public Ingredient(String nume, int cantitate, UM unitate_masura){
        this.numeIngredient =nume;
        this.cantitate = cantitate;
        this.unitate_masura = unitate_masura;
    }
    public Ingredient(String nume, int cantitate){
        this.numeIngredient = nume;
        this.cantitate = cantitate;
    }
    public Ingredient(String nume){
        this.numeIngredient = nume;
        this.cantitate = 50;
        this.unitate_masura = UM.ml;
    }
    public String getNumeIngredient() {
        return this.numeIngredient;
    }
    public void setNumeIngredient(String numeIngredient) {
        this.numeIngredient = numeIngredient;
    }

    public int getCantitate() {
        return this.cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate= cantitate;
    }

    public UM getUnitate_masura(){
        return this.unitate_masura;
    }
    public void setUnitate_masura(){
        this.unitate_masura=unitate_masura;
    }

    @Override
    public String toString(){
        return "Ingredient: Nume = " + this.numeIngredient + ", Cantitate = " + this.cantitate + " " + (this.unitate_masura!=null ? this.unitate_masura :""); //daca ingredientul nu are unitate de masura, sa nu scrie nimic (altefl scrie null - cazul ceai)
    }
}

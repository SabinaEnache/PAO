package Proiect;

public class Ingredient {
    private String numeINgredient;
    private double cantitate;
    private UM unitate_masura;

    public Ingredient(String nume, int cantitate, UM unitate_masura){
        this.numeINgredient =nume;
        this.cantitate = cantitate;
        this.unitate_masura = unitate_masura;
    }
    public String getNumeINgredient() {
        return this.numeINgredient;
    }
    public void setNumeINgredient(String numeINgredient) {
        this.numeINgredient = numeINgredient;
    }

    public double getCantitate() {
        return this.cantitate;
    }

    public void setCantitate(double cantitate) {
        this.cantitate= cantitate;
    }

    public UM getUnitate_masura(){
        return this.unitate_masura;
    }
    public void setUnitate_masura(){
        this.unitate_masura=unitate_masura;
    }

}

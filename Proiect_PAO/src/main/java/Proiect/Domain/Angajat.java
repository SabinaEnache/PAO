package Proiect.Domain;
import java.util.*;
public class Angajat {
    private String nume;
    private int salariu;
    private Date data_angajare;
    public Angajat(String nume, int salariu){
        this.nume=nume;
        this.salariu=salariu;
        this.data_angajare= new Date();
    }
    public void setNume(String nume){
        this.nume=nume;
    }
    public String getNume(){
        return this.nume;
    }
    public void setSalariu(int salariu){
        this.salariu=salariu;
    }
    public int getSalariu(){
        return this.salariu;
    }
    public Date getData_angajare(){
        return this.data_angajare;
    }

    @Override
    public String toString() {
        return "Angajat: \n Nume: " + this.nume + "\n Salariu: " + this.salariu +"\n Data angajare: " + this.data_angajare;
    }



}

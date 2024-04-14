package Proiect;
import java.util.*;
public class Angajat {
    private String nume;
    private int salariu;
    private Date data_angajare;
    public Angajat(String nume, int salariu, Date data){
        this.nume=nume;
        this.salariu=salariu;
        this.data_angajare=data;
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
}

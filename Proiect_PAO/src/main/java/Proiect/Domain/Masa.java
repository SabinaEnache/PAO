package Proiect.Domain;

public class Masa {
    private int numarMasa;
    private int nr_locuri;
    private boolean ocupata;

    public Masa(int numarMasa, int nr_locuri) {
        this.numarMasa = numarMasa;
        this.nr_locuri = nr_locuri;
        this.ocupata = false; // La început, masa nu este ocupată
    }
    public int getNumarMasa() {
        return this.numarMasa;
    }
    public boolean esteOcupata() {
        return ocupata;
    }
    public void ocupaMasa() {
        this.ocupata = true;
    }
    public void elibereazaMasa() {
        this.ocupata = false;
    }

    public static void main(String[] args) {
        Masa masa1 = new Masa(1, 2);
        Masa masa2 = new Masa(2, 4);
        Masa masa3 = new Masa(3, 2);
        Masa masa4 = new Masa(4, 4);
    }
}


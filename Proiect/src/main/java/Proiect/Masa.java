package Proiect;

public class Masa {
    private int numarMasa;
    private boolean ocupata;

    public Masa(int numarMasa) {
        this.numarMasa = numarMasa;
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
}


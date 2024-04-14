package Proiect;

public class Recenzie {
    private String client;
    private String comentariu;
    private int nota;

    // Constructor
    public Recenzie(String numeClient, String comentariu, int rating) {
        this.client = numeClient;
        this.comentariu = comentariu;
        setNota(rating); // chemam set-erul ca sa se faca si verificarea
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getComentariu() {
        return this.comentariu;
    }

    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }

    public int getNota() {
        return this.nota;
    }

    public void setNota(int nota) {
        if (nota >= 1 && nota <= 10) {
            this.nota = nota;
        } else {
            System.out.println("Rating-ul trebuie să fie între 1 și 10.");
        }
    }
}

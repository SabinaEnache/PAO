package Proiect.Domain;

import java.util.HashMap;
import java.util.Map;

public class ComandaOnline extends Comanda {
    private String numeClient;
    private String adresaLivrare;
    public ComandaOnline(String numeClient, String adresa){
        super();
        this.numeClient = numeClient;
        this.adresaLivrare = adresa;
    }
    public String getNumeClient() {
        return this.numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }
    public String getAdresaLivrare() {
        return adresaLivrare;
    }
    public void setAdresaLivrare(String adresaLivrare) {
        this.adresaLivrare = adresaLivrare;
    }

}

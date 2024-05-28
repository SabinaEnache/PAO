package Proiect;

import Proiect.service.Service;
import Proiect.config.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int optiune = 12;
        Service service = new Service();
        int alegere1=0;
        String alegere2;
        boolean ok = true;
        SetupDatabase Setup = new SetupDatabase();
        Setup.createAngajatTable();
        Setup.createComandaOnlineTable();
        Setup.createComandaTable();
        Setup.createProdusTable();
        Setup.createMasaTable();
        Setup.createIngredientTable();
        Setup.createRecenzieTable();
        System.out.println("Alege una dintre urmatoarele optiuni pentru a merge mai departe:");
        optiuni();
        while(ok){
            try{
                alegere1 = scanner.nextInt();
                if (alegere1 < 1 || alegere1 > optiune)
                    throw new RuntimeException("Optiune invalida.");
            }
            catch(InputMismatchException e){
                System.out.println("Alegerea trebuie sa fie un numar intre 1 si 11.");
                break;
            }
            if(alegere1 == 11)
                break;
            switch (alegere1){
                case 1:
                    service.VeziMeniu();
                    break;
                case 2:
                    service.AdaugaComanda();
                    break;
                case 3:
                    service.AdaugaRezervare();
                    break;
                case 4:
                    service.AdaugaProdus();
                    break;
                case 5:
                    service.EliminaProdus();
                    break;
                case 6:
                    service.SchimbaPret();
                    break;
                case 7:
                    service.VerifRezervari();
                    break;
                case 8:
                    service.CumparaIngrediente();
                    break;
                case 9:
                    service.MaresteSalariu();
                    break;
                case 10:
                    service.CitesteRecenzii();
                    break;
            }
            System.out.println("Doriti sa faceti altceva? Da/Nu");
            alegere2 = scanner.next();
            if(alegere2.equalsIgnoreCase("Da"))
                optiuni();
            else
                if(alegere2.equalsIgnoreCase("Nu"))
                    ok = false;
                else
                    throw new RuntimeException("Optiune invalida.");
        }
    }
    private static void optiuni(){
        System.out.println("1. Vezi meniul");
        System.out.println("2. Adauga comanda");
        System.out.println("3. Adauga rezervare");
        System.out.println("4. Adauga produs in meniu");
        System.out.println("5. Elimina produs din meniu");
        System.out.println("6. Schimba pretul unui produs");
        System.out.println("7. Verifica rezervari");
        System.out.println("8. Cumpara ingrediente");
        System.out.println("9. Mareste salariul unui angajat");
        System.out.println("10. Citeste recenzii");
        System.out.println("11. Iesi");
    }
}
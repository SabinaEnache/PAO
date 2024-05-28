package Proiect.service;
import Proiect.Domain.*;
import Proiect.repository.*;

import java.sql.SQLOutput;
import java.util.*;

public class Service {
    public Service(){
        initializare();
    }
    private Meniu meniu;
    private ProdusRepository produsRep;
    private Scanner scanner;
    private AngajatRepository angajatRep;
    private void initializare(){
        meniu = Meniu.getInstance();
        produsRep = new ProdusRepository();
        scanner = new Scanner(System.in);
        angajatRep = new AngajatRepository();
        Ingredient espresso = new Ingredient("Espresso", 30, UM.ml);
        Ingredient lapte_cappuccino = new Ingredient("Lapte", 150, UM.ml);
        Ingredient lapte_latte = new Ingredient("Lapte", 200, UM.ml);
        Ingredient cold_brew_concentrat = new Ingredient("Cold brew concentrat", 150, UM.ml);
        Ingredient apa = new Ingredient("Apa fierbinte/rece", 150, UM.ml);
        Ingredient plic_ceai =  new Ingredient("Plic ceai", 1);
        Ingredient gheata = new Ingredient("Gheata", 90, UM.g);
        Ingredient zahar = new Ingredient("Zahar", 3, UM.g);
        Ingredient aroma = new Ingredient("Sirop", 5, UM.ml);

        Produs latte = new Produs("Latte", 10);
        latte.adaugaIngredient(espresso);
        latte.adaugaIngredient(lapte_latte);
        Produs latte_aromat = new Produs("Latte aromat", 12);
        latte_aromat.adaugaIngredient(espresso);
        latte_aromat.adaugaIngredient(lapte_latte);
        latte_aromat.adaugaIngredient(aroma);
        Produs iced_latte = new Produs("Iced latte", 12);
        iced_latte.adaugaIngredient(espresso);
        iced_latte.adaugaIngredient(lapte_latte);
        iced_latte.adaugaIngredient(gheata);
        Produs cappuccino = new Produs("Cappuccino", 9);
        cappuccino.adaugaIngredient(espresso);
        cappuccino.adaugaIngredient(lapte_cappuccino);
        Produs cappuccino_aromat = new Produs("Cappuccino aromat", 12);
        cappuccino_aromat.adaugaIngredient(espresso);
        cappuccino_aromat.adaugaIngredient(lapte_cappuccino);
        cappuccino_aromat.adaugaIngredient(aroma);
        Produs cold_brew = new Produs("Cold brew", 13);
        cold_brew.adaugaIngredient(cold_brew_concentrat);
        cold_brew.adaugaIngredient(apa);
        cold_brew.adaugaIngredient(gheata);
        Produs cold_brew_latte = new Produs("Cold brew latte", 15);
        cold_brew_latte.adaugaIngredient(cold_brew_concentrat);
        cold_brew_latte.adaugaIngredient(lapte_latte);
        cold_brew_latte.adaugaIngredient(gheata);
        cold_brew_latte.adaugaIngredient(aroma);
        Produs ceai = new Produs("Ceai cald/rece", 7);
        ceai.adaugaIngredient(plic_ceai);
        ceai.adaugaIngredient(apa);
        ceai.adaugaIngredient(zahar);
        Produs iced_tea = new Produs("Iced tea", 10);
        iced_tea.adaugaIngredient(plic_ceai);
        iced_tea.adaugaIngredient(apa);
        iced_tea.adaugaIngredient(gheata);
        iced_tea.adaugaIngredient(zahar);

        meniu.adaugaProdus(latte);
        produsRep.insertProdus(latte);
        meniu.adaugaProdus(latte_aromat);
        produsRep.insertProdus(latte_aromat);
        meniu.adaugaProdus(iced_latte);
        produsRep.insertProdus(iced_latte);
        meniu.adaugaProdus(cappuccino);
        produsRep.insertProdus(cappuccino);
        meniu.adaugaProdus(cappuccino_aromat);
        produsRep.insertProdus(cappuccino_aromat);
        meniu.adaugaProdus(cold_brew);
        produsRep.insertProdus(cold_brew);
        meniu.adaugaProdus(cold_brew_latte);
        produsRep.insertProdus(cold_brew_latte);
        meniu.adaugaProdus(ceai);
        produsRep.insertProdus(ceai);
        meniu.adaugaProdus(iced_tea);
        produsRep.insertProdus(iced_tea);

        Angajat angajat1 = new Angajat("Enache Sabina", 4500);
        angajatRep.insert(angajat1);
        Angajat angajat2 = new Angajat("Ion Dragos", 2300);
        angajatRep.insert(angajat2);
        Angajat angajat3 = new Angajat("Vidroiu Dana", 2300);
        angajatRep.insert(angajat3);
    }

    public void VeziMeniu(){
        meniu.afisareMeniu();
    }

//semi ok
    public void AdaugaComanda(){
        System.out.println("Functia nu a fost implementata inca");
    }

    public void AdaugaRezervare(){
        System.out.println("Functia nu a fost implementata inca");
    }
//ok
    public void AdaugaProdus(){
        System.out.println("Care este numele produsului pe care doriti sa il adaugati?");
        String numetemp = scanner.next();
        System.out.println("Care va fi pretul produsului?");
        double prettemp = scanner.nextDouble();
        Produs produsnou = new Produs(numetemp, prettemp);
        produsRep.insertProdus(produsnou);
        meniu.adaugaProdus(produsnou);
        System.out.println("Introduceți un ingredient (sau 'stop' pentru a termina): ");
        while (true) {
            String ingr = scanner.next();
            if (ingr.equalsIgnoreCase("stop")) {
                break;
            }
            Ingredient ingredient = new Ingredient(ingr);
            produsnou.adaugaIngredient(ingredient);
        }
    }
//ok
    public void EliminaProdus(){
        System.out.println("Care este numele produsului pe care doriti sa il eliminati?");
        String numetemp = scanner.next();
        meniu.eliminaProdus(numetemp);
        produsRep.deleteProdus(numetemp);
    }
//ok
    public void SchimbaPret(){
        System.out.println("Care este produsul al carui pret vreti sa-l schimbati?");
        String numetemp = scanner.next();
        System.out.println("Care este noul pret?");
        double prettemp = scanner.nextDouble();
        meniu.schimbaPret(numetemp, prettemp);
        produsRep.updatePret(prettemp, numetemp);
    }

    public void VerifRezervari(){
        System.out.println("Functia nu a fost implementata inca");
    }

    public void CumparaIngrediente(){
        System.out.println("Functia nu a fost implementata inca");
    }
//ok
    public void MaresteSalariu(){
        System.out.println("Salariul cui doriti sa il mariti?");
        angajatRep.afiseazaAngajatii();
        int idtemp = scanner.nextInt();
        System.out.println("Cu ce procent doriti sa ii mariti salariul?");
        int mariretemp = scanner.nextInt();
        angajatRep.updateSalariu(mariretemp, idtemp);
        System.out.println("salariul a fost actualizat");
    }

    public void CitesteRecenzii(){
        System.out.println("Functia nu a fost implementata inca");
    }

}

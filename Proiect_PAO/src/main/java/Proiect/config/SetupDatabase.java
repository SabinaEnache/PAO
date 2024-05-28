package Proiect.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {
    public void createIngredientTable(){
        String comandaSQL = """
                create table if not exists Ingredient (
                idIngredient int PRIMARY KEY AUTO_INCREMENT,
                numeIngredient varchar(25),
                cantitate int)
                """;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(comandaSQL);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void createProdusTable(){
        String comandaSQL = """
                create table if not exists Produs(
                idProdus int primary key auto_increment,
                numeProdus varchar(40),
                pret int)
                """;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            statement.execute(comandaSQL);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void createAngajatTable(){
        String comandaSQL = """
                create table if not exists Angajat(
                idAngajat int primary key auto_increment,
                numeAngajat varchar(50),
                salariu int,
                data_angajare Date
                )
                """;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            statement.execute(comandaSQL);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void createComandaTable(){
        String comandaSQL = """
                create table if not exists Comanda(
                idComanda int primary key auto_increment,
                valoare double 
                )
                """;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            statement.execute(comandaSQL);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void createComandaOnlineTable(){
        String comandaSQL = """
                create table if not exists ComandaOnline(
                idComandaOnline int primary key auto_increment,
                valoareOnline double,
                numeClient varchar(40),
                adresaLivrare varchar(60))
                """;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            statement.execute(comandaSQL);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void createRecenzieTable(){
        String comandaSQL = """
                create table if not exists Recenzie(
                idRecenzie int PRIMARY KEY AUTO_INCREMENT,
                numeClient varchar(40),
                comentariu varchar(150),
                nota int,
                check (nota >= 1 and nota <=10)
                )
                """;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            statement.execute(comandaSQL);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void createMasaTable(){
        String comandaSQL = """
                create table if not exists Masa(
                numarMasa int primary key auto_increment,
                numarLocuri int,
                ocupata boolean)
                """;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            statement.execute(comandaSQL);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}

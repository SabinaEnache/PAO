package Proiect.repository;
import Proiect.Domain.*;
import Proiect.config.DatabaseConfiguration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
public class AngajatRepository {
    public void insert(String nume, int salariu){
        String insertAngajat = "insert into Angajat (numeAngajat, salariu) values(?,?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertAngajat);
            preparedStatement.setString(1, nume);
            preparedStatement.setInt(2, salariu);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void insert(Angajat angajat){
        String insertAngajat = "insert into Angajat (numeAngajat, salariu) values(?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertAngajat);
            preparedStatement.setString(1, angajat.getNume());
            preparedStatement.setInt(2, angajat.getSalariu());
            preparedStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void updateSalariu(int marire, int id){
        String updateSalariu = "Update Angajat set salariu = salariu * (1 + ? / 100) where idAngajat = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSalariu);
            preparedStatement.setInt(1, marire);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void afiseazaAngajatii() {
        String query = "SELECT * FROM Angajat";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Lista angajaților:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idAngajat");
                String nume = resultSet.getString("numeAngajat");
                int salariu = resultSet.getInt("salariu");

                System.out.println("ID: " + id + ", Nume: " + nume +", Salariu: " + salariu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Angajat> getById(int id){
        String select = "Select * from Angajat a where a.id = ? ";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToAngajat(resultSet);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Angajat> mapToAngajat(ResultSet resultSet) throws SQLException{
        if(resultSet.next()){
            int id = resultSet.getInt("id");
            String nume = resultSet.getString("nume");
            int salariu = resultSet.getInt("salariu");
            return Optional.of(new Angajat( nume, salariu));
        }
        return Optional.empty();
    }

}

package Proiect.repository;
import Proiect.Domain.*;
import Proiect.config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
public class ComandaRepository {
    //insert
    public void adaugaComanda(Comanda comanda){
        String insertComanda = "insert into Comanda(valoare) values(?)";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(insertComanda);
            preparedStatement.setDouble(1, comanda.getValoare());
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Optional<Comanda> getById(int id){
        String select = "Select * from Comanda a where a.id = ? ";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToComanda(resultSet);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Comanda> mapToComanda(ResultSet resultSet) throws SQLException{
        if(resultSet.next()){
            int id = resultSet.getInt("id");
            double valoare = resultSet.getDouble("valoare");
            return Optional.of(new Comanda());
        }
        return Optional.empty();
    }
}

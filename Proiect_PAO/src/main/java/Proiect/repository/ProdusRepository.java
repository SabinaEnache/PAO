package Proiect.repository;
import Proiect.Domain.*;
import Proiect.config.DatabaseConfiguration;

import java.sql.*;
import java.util.Optional;
public class ProdusRepository {
    public void insertProdus(String nume, double pret){
        if (produsExista(nume)) {
            return;
        }
        String insertProdus = "insert into Produs (numeProdus, pret) values (?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertProdus);
            preparedStatement.setString(1, nume);
            preparedStatement.setDouble(2, pret);
            preparedStatement.execute();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void insertProdus(Produs produs){
        if (produsExista(produs.getNumeProdus())) {
            return;
        }
        String insertProdus = "insert into Produs (numeProdus, pret) values (?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertProdus);
            preparedStatement.setString(1, produs.getNumeProdus());
            preparedStatement.setDouble(2, produs.getPret());
            preparedStatement.execute();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updatePret( double pret, String nume){
        String updatePret = "Update Produs set pret = ? where numeProdus = ? ";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updatePret);
            preparedStatement.setDouble(1, pret);
            preparedStatement.setString(2, nume);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteProdus(String nume){
        String deleteProdus = "Delete from Produs where numeProdus = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteProdus);
            preparedStatement.setString(1, nume);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Optional<Produs> getById(int id){
        String select = "select * from produs p where p.id = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToProdus(resultSet);

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Produs> mapToProdus(ResultSet resultSet) throws SQLException{
        if(resultSet.next()){
            int id = resultSet.getInt("idProdus");
            String nume = resultSet.getString("numeProdus");
            double pret = resultSet.getDouble("pret");
            return Optional.of(new Produs(nume, pret));
        }
        return Optional.empty();
    }

    public void insertProdusCallable(Produs produs){
        String sql = "{call insertProdus(?,?)";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try{
            CallableStatement call = conn.prepareCall(sql);
            call.setString(1, produs.getNumeProdus());
            call.setDouble(2, produs.getPret());

            call.registerOutParameter(1, Types.INTEGER);
            call.execute();
            System.out.println("Produsul a fost adaugat la meniu");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private boolean produsExista(String numeProdus) {
        String query = "SELECT COUNT(*) FROM Produs WHERE numeProdus = ?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, numeProdus);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

package org.example.service;

import java.sql.*;

import static org.example.connection.ConnectionDB.connect;
public class BookService {
    private Connection connection = connect();
    public void register(int code,String nameBook, String nameAuthor,String date){
        String sql = "INSERT INTO livros (code,namebook,nameauthor,date) VALUES (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, code);
            preparedStatement.setString(2, nameBook);
            preparedStatement.setString(3, nameAuthor);
            preparedStatement.setString(4, date);
            preparedStatement.executeUpdate();
            System.out.println("Livro registrado!\n");
        }catch (SQLException e){
                e.printStackTrace();
        }
    }
    public void changeInfo(int code,String nameAuthor){
        String sql = "UPDATE livros SET nameauthor = ? WHERE code = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameAuthor);
            preparedStatement.setInt(2, code);
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Livro alterado com sucesso!\n");
            } else {
                System.out.println("Nenhum livro encontrado com o código fornecido.\n");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteBook(int code){
        String sql = "DELETE FROM livros WHERE code = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, code);
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Livro deletado com sucesso!\n");
            } else {
                System.out.println("Nenhum livro encontrado com o código fornecido.\n");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void showTheBookByCode(int code) {
        String sql = "SELECT * FROM livros WHERE code = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,code);
            ResultSet result = preparedStatement.executeQuery();
            System.out.println("------- LIVRO -------");
            while (result.next()){
                System.out.println("Código: "+result.getInt("code")+
                        "\nTítulo: "+result.getString("namebook")+
                        "\nAutor: "+result.getString("nameauthor")+
                        "\nData de lançamento: "+result.getString("date")+"\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void showTheBooks() {
        String sql = "SELECT * FROM livros";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            System.out.println("======= LIVROS =======");
            while (result.next()){
                System.out.println("Código: "+result.getInt("code")+
                        "\nTítulo: "+result.getString("namebook")+
                        "\nAutor: "+result.getString("nameauthor")+
                        "\nData de lançamento: "+result.getString("date")+
                        "\n---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
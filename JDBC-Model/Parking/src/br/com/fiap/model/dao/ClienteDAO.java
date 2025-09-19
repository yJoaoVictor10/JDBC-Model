package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO implements IDAO{
    private Connection con;
    private Cliente cliente;


    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object){
        cliente = (Cliente) object;
        String sql = "INSERT INTO ddd_cliente(nome_cliente, placa) VALUES(?, ?)"; // Não precisa do id pois o banco gera automaticamente
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
                ps.setString(1, cliente.getNomeCliente());
                ps.setString(2, cliente.getPlaca());
                if(ps.executeUpdate() > 0){
                    return "Inserido com sucesso";
                }else{
                    return "Erro ao inserir";
                }

        }catch (SQLException e){
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String alterar(Object object){
        cliente = (Cliente) object;
        String sql = "UPDATE ddd_cliente SET nome_cliente = ?, placa = ? WHERE id_cliente = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getPlaca());
            ps.setInt(3, cliente.getIdCliente());
            if(ps.executeUpdate() > 0){
                return "Alterado com sucesso";
            }else{
                return "Erro ao inserir";
            }
        }catch (SQLException e){
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String excluir(Object object){
        cliente = (Cliente) object;
        String sql = "DELETE FROM ddd_cliente WHERE id_cliente = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, cliente.getIdCliente());
            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso";
            }else{
                return "Erro ao inserir";
            }
        }catch (SQLException e){
            return "Erro de SQL :" + e.getMessage();
       }
    }

    public String listarUm(Object object){
        cliente = (Cliente) object;
        String sql = "SELECT * FROM ddd_cliente WHERE id_cliente = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, cliente.getIdCliente());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return String.format("ID: %d\nNome: %s\nPlaca: %s", rs.getInt("id_cliente"), rs.getString("nome_cliente"), rs.getString("placa"));

            }else{
                return "Erro ao listar";
            }
        }catch (SQLException e){
            return "Erro de SQL: " + e.getMessage();
        }
    }
}

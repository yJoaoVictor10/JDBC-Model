package br.com.fiap.controller;

import br.com.fiap.model.dao.ClienteDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Cliente;

import java.sql.Connection;

public class ClienteController {
    public String inserirCliente(String nome, String placa){
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        cliente.setNomeCliente(nome);
        cliente.setPlaca(placa);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.inserir(cliente);

        ConnectionFactory.fecharConexao(con);
        return resultado;

    }
    public String alterarCliente(int id, String nome, String placa){
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(id);
        cliente.setNomeCliente(nome);
        cliente.setPlaca(placa);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.alterar(cliente);

        ConnectionFactory.fecharConexao(con);
        return resultado;

    }
    public String excluirCliente(int id){
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(id);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.excluir(cliente);

        ConnectionFactory.fecharConexao(con);
        return resultado;

    }
    public String listarCliente(int id){
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(id);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.listarUm(cliente);

        ConnectionFactory.fecharConexao(con);
        return resultado;

    }
}

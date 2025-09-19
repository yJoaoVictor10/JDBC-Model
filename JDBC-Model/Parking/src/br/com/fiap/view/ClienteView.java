package br.com.fiap.view;

import br.com.fiap.controller.ClienteController;

import javax.swing.*;

public class ClienteView {
    public static void main(String[] args) {
        int id, opcao;
        String nome, placa;

        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};
        ClienteController clienteController = new ClienteController();
        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um cliente", "Atenção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,  escolha, escolha[0]);

                switch (opcao){
                    case 0:
                        nome = JOptionPane.showInputDialog("Digite o nome do cliente");
                        placa = JOptionPane.showInputDialog("Digite a placa do carro");
                        System.out.println(clienteController.inserirCliente(nome, placa));
                        break;
                    case 1:
                        id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do cliente"));
                        nome = JOptionPane.showInputDialog("Digite o novo nome do cliente");
                        placa = JOptionPane.showInputDialog("Digite a nova placa do carro");
                        System.out.println(clienteController.alterarCliente(id, nome, placa));
                        break;
                    case 2:
                        id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do cliente"));
                        System.out.println(clienteController.excluirCliente(id));
                        break;
                    case 3:
                        id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do cliente"));
                        System.out.println(clienteController.listarCliente(id));
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }catch (Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa");
    }
}

package br.com.fiap.view;

import br.com.fiap.controller.CarroController;
import br.com.fiap.controller.ClienteController;

import javax.swing.*;

public class ParkingView {
    public static void main(String[] args) {
        int id, opcaoModel, opcaoManipular;
        String nome, placa, cor, descricao;

        String[] escolhaModel = {"Carro", "Cliente"};
        String[] escolhaManipular = {"Inserir", "Alterar", "Excluir", "Listar"};
        CarroController carroController = new CarroController();
        ClienteController clienteController = new ClienteController();

        do {
            try {
                opcaoModel = JOptionPane.showOptionDialog(null, "Escolha uma opção que você deseja manipular", "Atenção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolhaModel, escolhaModel[0]);
                opcaoManipular = JOptionPane.showOptionDialog(null, "Escolha a ação desejada", "Atenção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolhaManipular, escolhaManipular[0]);
                if (opcaoModel == 0){
                    placa = JOptionPane.showInputDialog("Digite a placa do carro");
                    switch (opcaoManipular){
                        case 0:
                            cor = JOptionPane.showInputDialog("Digite a cor do carro");
                            descricao = JOptionPane.showInputDialog("Digite uma descrição para o carro");
                            System.out.println(carroController.inserirCarro(placa, cor, descricao));
                            break;
                        case 1:
                            cor = JOptionPane.showInputDialog("Digite a nova cor do carro");
                            descricao = JOptionPane.showInputDialog("Digite uma nova descrição para o carro");
                            System.out.println(carroController.alterarCarro(placa, cor, descricao));
                            break;
                        case 2:
                            System.out.println(carroController.excluirCarro(placa));
                            break;
                        case 3:
                            System.out.println(carroController.listarUmCarro(placa));
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                } else if (opcaoModel == 1){
                    switch (opcaoManipular){
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
                }else{
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Obrigado por utilizar o sistema!");
    }
}

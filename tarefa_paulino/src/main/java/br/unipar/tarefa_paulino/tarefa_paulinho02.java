package br.unipar.tarefa_paulino;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Comparator;


class Cliente {
    int codigo;
    String nome;
    String dataNascimento;
    String cpf;

    Cliente(int codigo, String nome, String dataNascimento, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\nNome: " + nome + "\nData de Nascimento: " + dataNascimento + "\nCPF: " + cpf;
    }
}

class CadastroClientes {
    ArrayList<Cliente> clientes;

    CadastroClientes() {
        this.clientes = new ArrayList<>();
    }

    void adicionarCliente(Cliente cliente) {
        if (this.clientes.size() < 5) {
            this.clientes.add(cliente);
            this.clientes.sort(Comparator.comparingInt(c -> c.codigo));
        } else {
            JOptionPane.showMessageDialog(null, "Limite de clientes atingido.");
        }
    }

    Cliente buscarCliente(int codigo) {
        for (Cliente cliente : this.clientes) {
            if (cliente.codigo == codigo) {
                return cliente;
            }
        }
        return null;
    }

    void exibirClientes() {
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : this.clientes) {
            sb.append(cliente.toString()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}

public class tarefa_paulinho02 {
    public static void main(String[] args) {
        CadastroClientes cadastro = new CadastroClientes();
        while (cadastro.clientes.size() < 5) {
            String input = JOptionPane.showInputDialog("Código cliente (ou 'sair' para encerrar):");
            if (input.equalsIgnoreCase("sair")) {
                break;
            }
            int codigo = Integer.parseInt(input);
            String nome = JOptionPane.showInputDialog("Nome :");
            String dataNascimento = JOptionPane.showInputDialog("Data de nascimento :");
            String cpf = JOptionPane.showInputDialog("CPF :");
            cadastro.adicionarCliente(new Cliente(codigo, nome, dataNascimento, cpf));
        }
        String input = JOptionPane.showInputDialog("Código do cliente para pesquisa:");
        int codigo = Integer.parseInt(input);
        Cliente cliente = cadastro.buscarCliente(codigo);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente encontrado:\n" + cliente.toString());
        }
        cadastro.exibirClientes();
    }
}

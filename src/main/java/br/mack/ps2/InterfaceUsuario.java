package br.mack.ps2;

import br.mack.ps2.entidades.Controle;
import br.mack.ps2.persistencia.ControleDAO;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    ControleDAO dao;
    Scanner in;

    public InterfaceUsuario(ControleDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opc = 0;
        do {
            System.out.println("\n==============");
            System.out.println("==== Menu ====");
            System.out.println("==============");
            System.out.println("\t1. Create");
            System.out.println("\t2. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();

            //necessário para ler a quebra de linha (enter)
            in.nextLine();

            switch (opc) {
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    System.out.println("tchau :)");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while (opc != 3);
    }

    private void create() {
        Controle controle = new Controle();

        System.out.println("\n******************");
        System.out.println("*** Novo aluno ***");
        System.out.println("******************");
        System.out.print("\nInforme o TIA do aluno: ");
        controle.setTia(in.nextInt());
        //necessário para ler o \n da entrada (enter)
        in.nextLine();

        System.out.print("Informe o Horário de Entrada: ");
        controle.setEntrada(in.nextLine());

        System.out.print("Informe o Horário de Saída: ");
        controle.setSaida(in.nextLine());

        if (dao.create(controle)) {
            System.out.println("TIA adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o aluno");
        }
    }

    private void read() {
        List<Controle> cntr = dao.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Alunos Cadastrados ***");
        System.out.println("***********************************");
        for(Controle controle : cntr) {
            System.out.println(controle);
        }
    }

}

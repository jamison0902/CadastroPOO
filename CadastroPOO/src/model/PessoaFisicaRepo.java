/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package model;

import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author jsq
 */
public class PessoaFisicaRepo {

    private ArrayList<PessoaFisica> arrayPessoaFisica;

    public PessoaFisicaRepo() {
        this.arrayPessoaFisica = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoa) {
        this.arrayPessoaFisica.add(pessoa);
    }

    public void alterar(int id) {
        int controle = 0;
        for (PessoaFisica element : this.arrayPessoaFisica) {
            if (element.getId() == id) {
                
                Scanner input = new Scanner(System.in);
                controle++;
                
                if (controle == 1) {
                    this.getTitulo();
                }
                
                element.exibir();
                
                System.out.println("Informe as alterações:");
                System.out.print("Digite o ID da Pessoa Física\n");
                String PessoaFisicaId = input.nextLine();

                System.out.println("Digite o Nome da Pessoa Física");
                String PessoaFisicaNome = input.nextLine();

                System.out.println("Digite o CPF da Pessoa Física");
                String PessoaFisicaCpf = input.nextLine();

                System.out.println("Digite a Idade da Pessoa Física");
                String PessoaFisicaIdade = input.nextLine();
                
                element.setId(Integer.parseInt(PessoaFisicaId));
                element.setNome(PessoaFisicaNome);
                element.setCpf(PessoaFisicaCpf);
                element.setIdade(Integer.parseInt(PessoaFisicaIdade));
                
                System.out.println("Pessoa Física Alterada.");
            }
        }
        if (controle == 0) {
            this.getTitulo();
            System.out.println("   Nenhuma Pessoa Física com o ID Fornecido   ");
        }
        System.out.println("-----------------------------------------------");        
    }

    public void excluir(int id) {
        for (Iterator<PessoaFisica> itr = arrayPessoaFisica.iterator(); itr.hasNext();) {
            PessoaFisica pessoa = itr.next();
            if (pessoa.getId() == id) {
                itr.remove();
                System.out.println("Pessoa Física Removida.");
            }
        }
    }

    public void obter(int id) {
        int controle = 0;
        for (PessoaFisica element : this.arrayPessoaFisica) {
            if (element.getId() == id) {
                controle++;
                if (controle == 1) {
                    this.getTitulo();
                }
                element.exibir();
            }
        }
        if (controle == 0) {
            this.getTitulo();
            System.out.println("   Nenhuma Pessoa Física com o ID Fornecido   ");
        }
        System.out.println("-----------------------------------------------");
    }

    public void obterTodos() {
        if (!arrayPessoaFisica.isEmpty()) {
            this.getTitulo();
            for (PessoaFisica s : arrayPessoaFisica) {
                s.exibir();
            }
            System.out.println("-----------------------------------------------");
        }
    }

    public void persistir(String nAquivo) {
        try {
            try (PrintWriter fileOut = new PrintWriter("src/file/" + nAquivo + "Fisica.bin")) {
                for (PessoaFisica s : arrayPessoaFisica) {
                    fileOut.print(s.getId());
                    fileOut.print("," + s.getNome());
                    fileOut.print("," + s.getCpf());
                    fileOut.print("," + s.getIdade());
                    fileOut.println();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao gravar os dados de Pessoa Física");
        }
        System.out.println("Dados de Pessoa Física Armazenados");
    }

    public void recuperar(String nAquivo) {
        try {
            try (Scanner fileIn = new Scanner(new File("src/file/" + nAquivo + "Fisica.bin"))) {
                while (fileIn.hasNext()) {
                    // Read the  string
                    String raw = fileIn.nextLine();
                    // Split on ,
                    String[] arr = raw.split("\\,");
                    // Instanciando Pessoa
                    PessoaFisica pf = new PessoaFisica(Integer.parseInt(arr[0]), arr[1], arr[2], Integer.parseInt(arr[3]));
                    //Insere a pessoa no repositorio
                    this.inserir(pf);
                }
            }
        } catch (IOException e) {
            System.out.println("Nenhuma informação de Pessoa Física recuperada.");
        }
        System.out.println("Dados de Pessoa Física Recuperados.");
    }

    public void getTitulo() {
        System.out.println("===============================================");
        System.out.println("                Pessoa Física                  ");
        System.out.println("===============================================");
    }    
}

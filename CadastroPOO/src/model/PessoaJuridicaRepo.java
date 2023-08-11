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
public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> arrayPessoaJuridica;

    public PessoaJuridicaRepo() {
        this.arrayPessoaJuridica = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoa) {
        this.arrayPessoaJuridica.add(pessoa);
    }

    public void alterar(int id) {
        int controle = 0;
        for (PessoaJuridica element : this.arrayPessoaJuridica) {
            if (element.getId() == id) {

                Scanner input = new Scanner(System.in);
                controle++;

                if (controle == 1) {
                    this.getTitulo();
                }

                element.exibir();

                System.out.println("Informe as alterações:");
                System.out.print("Digite o ID da Pessoa Jurídica\n");
                String PessoaJuridicaId = input.nextLine();

                System.out.println("Digite o Nome da Pessoa Jurídica");
                String PessoaJuridicaNome = input.nextLine();

                System.out.println("Digite o CNPJ da Pessoa Jurídica");
                String PessoaJuridicaCnpj = input.nextLine();

                element.setId(Integer.parseInt(PessoaJuridicaId));
                element.setNome(PessoaJuridicaNome);
                element.setCnpj(PessoaJuridicaCnpj);                

                System.out.println("Pessoa Jurídica Alterada.");
            }
        }
        if (controle == 0) {
            this.getTitulo();
            System.out.println("   Nenhuma Pessoa Jurídica com o ID Fornecido   ");
        }
        System.out.println("-----------------------------------------------");

    }

    public void excluir(int id) {
        for (Iterator<PessoaJuridica> itr = arrayPessoaJuridica.iterator(); itr.hasNext();) {
            PessoaJuridica pessoa = itr.next();
            if (pessoa.getId() == id) {
                itr.remove();
                System.out.println("Pessoa Jurídica Removida.");
            }
        }
    }

    public void obter(int id) {
        int controle = 0;
        for (PessoaJuridica element : this.arrayPessoaJuridica) {
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
            System.out.println("   Nenhuma Pessoa Jurídica com o ID Fornecido   ");
        }
        System.out.println("-----------------------------------------------");
    }

    public void obterTodos() {
        if (!this.arrayPessoaJuridica.isEmpty()) {
            this.getTitulo();
            for (PessoaJuridica s : arrayPessoaJuridica) {
                s.exibir();
            }
            System.out.println("-----------------------------------------------");
        }
    }

    public void persistir(String nAquivo) {
        try {
            try (PrintWriter fileOut = new PrintWriter("src/file/" + nAquivo + "Juridica.bin")) {
                for (PessoaJuridica s : arrayPessoaJuridica) {
                    fileOut.print(s.getId());
                    fileOut.print("," + s.getNome());
                    fileOut.print("," + s.getCnpj());
                    fileOut.println();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao gravar os dados de Pessoa Jurídica");
        }
        System.out.println("Dados de Pessoa Jurídica Armazenados");
    }

    public void recuperar(String nAquivo) {
        try {
            try (Scanner fileIn = new Scanner(new File("src/file/" + nAquivo + "Juridica.bin"))) {
                while (fileIn.hasNext()) {
                    // Read the  string
                    String raw = fileIn.nextLine();
                    // Split on ,
                    String[] arr = raw.split("\\,");
                    // Instanciando Pessoa
                    PessoaJuridica pj = new PessoaJuridica(Integer.parseInt(arr[0]), arr[1], arr[2]);
                    //Insere a pessoa no repositorio
                    this.inserir(pj);
                }
            }
        } catch (IOException e) {
            System.out.println("Nenhuma informação de Pessoa Jurídica recuperada.");
        }
        System.out.println("Dados de Pessoa Jurídica Recuperados.");
    }

    public void getTitulo() {
        System.out.println("===============================================");
        System.out.println("               Pessoa Jurídica                 ");
        System.out.println("===============================================");
    }
}

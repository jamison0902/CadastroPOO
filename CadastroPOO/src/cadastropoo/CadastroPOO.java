/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.util.Scanner;

// Classes
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author jsq
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();

        // Menu
        Scanner input = new Scanner(System.in);
        OUTER:
        while (true) {
            System.out.println("===============================================");
            System.out.println("               Menu de Opções                  ");
            System.out.println("===============================================");
            System.out.println("1. Incluir Pessoa");
            System.out.println("2. Alterar Pessoa");
            System.out.println("3. Excluir Pessoa");
            System.out.println("4. Busca pelo ID");
            System.out.println("5. Exibir Todos");
            System.out.println("6. Persistir Dados");
            System.out.println("7. Recuperar Dados");
            System.out.println("8. Finalizar Programa");
            System.out.println("===============================================");
            String option = input.nextLine();

            switch (option) {
                case "1" -> { // Incluir Pessoa
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica\n");
                    String tipoPessoa = input.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F")) {
                        System.out.print("Digite o ID da Pessoa Física\n");
                        String PessoaFisicaId = input.nextLine();

                        System.out.println("Digite o Nome da Pessoa Física");
                        String PessoaFisicaNome = input.nextLine();

                        System.out.println("Digite o CPF da Pessoa Física");
                        String PessoaFisicaCpf = input.nextLine();

                        System.out.println("Digite a Idade da Pessoa Física");
                        String PessoaFisicaIdade = input.nextLine();

                        PessoaFisica pf = new PessoaFisica(Integer.parseInt(PessoaFisicaId), PessoaFisicaNome, PessoaFisicaCpf, Integer.parseInt(PessoaFisicaIdade));
                        repoPF.inserir(pf);
                    } else {
                        System.out.print("Digite o ID da Pessoa Jurídica\n");
                        String PessoaJuridicaId = input.nextLine();

                        System.out.println("Digite o Nome da Pessoa Jurídica");
                        String PessoaJuridicaNome = input.nextLine();

                        System.out.println("Digite o CNPJ da Pessoa Jurídica");
                        String PessoaJuridicaCnpj = input.nextLine();

                        PessoaJuridica pj = new PessoaJuridica(Integer.parseInt(PessoaJuridicaId), PessoaJuridicaNome, PessoaJuridicaCnpj);
                        repoPJ.inserir(pj);
                    }
                }
                case "2" -> { // Alterar pelo ID
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica\n");
                    String tipoPessoa = input.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F")) {
                        System.out.print("Digite o ID da Pessoa Física\n");
                        String PessoaFisicaId = input.nextLine();
                        repoPF.alterar(Integer.parseInt(PessoaFisicaId));
                    } else {
                        System.out.print("Digite o ID da Pessoa Jurídica\n");
                        String PessoaJuridicaId = input.nextLine();
                        repoPJ.alterar(Integer.parseInt(PessoaJuridicaId));
                    }
                }
                case "3" -> { // Remover pelo ID
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica\n");
                    String tipoPessoa = input.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F")) {
                        System.out.print("Digite o ID da Pessoa Física\n");
                        String PessoaFisicaId = input.nextLine();
                        repoPF.excluir(Integer.parseInt(PessoaFisicaId));
                    } else {
                        System.out.print("Digite o ID da Pessoa Jurídica\n");
                        String PessoaJuridicaId = input.nextLine();
                        repoPJ.excluir(Integer.parseInt(PessoaJuridicaId));
                    }
                }
                case "4" -> { // Obter pelo ID
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica\n");
                    String tipoPessoa = input.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F")) {
                        System.out.print("Digite o ID da Pessoa Física\n");
                        String PessoaFisicaId = input.nextLine();
                        repoPF.obter(Integer.parseInt(PessoaFisicaId));
                    } else {
                        System.out.print("Digite o ID da Pessoa Jurídica\n");
                        String PessoaJuridicaId = input.nextLine();
                        repoPJ.obter(Integer.parseInt(PessoaJuridicaId));
                    }
                }
                case "5" -> { // Obter Todos
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica\n");
                    String tipoPessoa = input.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F")) {
                        repoPF.obterTodos();
                    } else {
                        repoPJ.obterTodos();
                    }
                }
                case "6" -> { // Persistir Arquivo
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica\n");
                    String tipoPessoa = input.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F")) {
                        System.out.print("Digite o nome do arquivo para persistir Pessoa Física\n");
                        String PessoaFisicaArq = input.nextLine();
                        repoPF.persistir(PessoaFisicaArq);
                    } else {
                        System.out.print("Digite o nome do arquivo para persistir Pessoa Jurídica\n");
                        String PessoaJuridicaArq = input.nextLine();
                        repoPJ.persistir(PessoaJuridicaArq);
                    }
                }
                case "7" -> { // Recuperar Arquivo
                    System.out.print("F - Pessoa Física | J - Pessoa Jurídica\n");
                    String tipoPessoa = input.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F")) {
                        System.out.print("Digite o nome do arquivo para recuperar de Pessoa Física\n");
                        String PessoaFisicaArq = input.nextLine();
                        repoPF.recuperar(PessoaFisicaArq);
                    } else {
                        System.out.print("Digite o nome do arquivo para recuperar de Pessoa Jurídica\n");
                        String PessoaJuridicaArq = input.nextLine();
                        repoPJ.recuperar(PessoaJuridicaArq);
                    }
                }
                default -> {
                    break OUTER;
                }
            }
        }
    }

}

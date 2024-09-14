package com.poo.escola.Entidades;

import java.util.*;

public class Secretaria extends Pessoa {
    private String email;
    private String senha;

    // Lista para armazenar secretárias
    private static List<Secretaria> listaSecretarias = new ArrayList<>();

    public static void menuAluno() {
        int opcaoAluno = 8;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n- MENU -");
            System.out.println("O que você deseja fazer?");
            System.out.println("1- Cadastrar novo aluno");
            System.out.println("2- Atualizar aluno");
            System.out.println("3- Excluir aluno");
            System.out.println("4- Listar alunos");
            System.out.println("0- Sair\n");
            System.out.print("Digite uma opção: ");

            try {
                opcaoAluno = sc.nextInt();
                System.out.println("\n");

                switch (opcaoAluno) {
                    case 1:
                        Aluno.cadastrarAluno();
                        break;
                    case 2:
                        Aluno.atualizarAluno();
                        break;
                    case 3:
                        Aluno.removerAluno();
                        break;
                    case 4:
                        Aluno.mostrarListaAlunos();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número inteiro!");
                sc.next(); // Limpa a entrada inválida
            }
        } while (opcaoAluno != 0);
    }

    public static void menuProfessor() {
        int opcaoProfessor = 8;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n- MENU -");
            System.out.println("O que você deseja fazer?");
            System.out.println("1- Cadastrar novo professor");
            System.out.println("2- Atualizar professor");
            System.out.println("3- Excluir professor");
            System.out.println("4- Listar professores");
            System.out.println("0- Sair\n");
            System.out.print("Digite uma opção: ");

            try {
                opcaoProfessor = sc.nextInt();
                System.out.println("\n");

                switch (opcaoProfessor) {
                    case 1:
                        Professor.cadastrarProfessor();
                        break;
                    case 2:
                        Professor.atualizarProfessor();
                        break;
                    case 3:
                        Professor.removerProfessor();
                        break;
                    case 4:
                        Professor.mostrarListaProfessores();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número inteiro!");
                sc.next(); // Limpa a entrada inválida
            }
        } while (opcaoProfessor != 0);
    }

    public static void popularSecretaria() {
        Secretaria secretaria1 = new Secretaria();
        secretaria1.setEmail("sc@gmail.com");
        secretaria1.setSenha("Sc@!1973");
        listaSecretarias.add(secretaria1);
    }

    public static List<Secretaria> getListaSecretarias() {
        return listaSecretarias;
    }

    // Getters e setters para email e senha
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

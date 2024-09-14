package com.poo.escola.Entidades;

import com.poo.escola.Entidades.enums.Situacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.poo.escola.Entidades.Aluno.obterAlunoPorEmail;

public class Menu {
    private static Situacao situacao;
    private static String usuarioLogado = null;
    private static String tipoUsuario = null;

    public static void imprimirHistorico(String usuarioLogado) {
        Aluno aluno = obterAlunoPorEmail(usuarioLogado);

        if (aluno != null) {
            System.out.println("Histórico do Aluno: ");
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Email: " + aluno.getEmail());

            Notas.carregarNotasDoArquivo();

            List<Notas> notasDoAluno = new ArrayList<>();
            for (Notas nota : Notas.getListaNotas()) {
                if (nota.getAluno().equals(aluno)) {
                    notasDoAluno.add(nota);
                }
            }

            if (!notasDoAluno.isEmpty()) {
                for (Notas nota : notasDoAluno) {
                    if (nota.getNota() >= 6) {
                        situacao = Situacao.APROVADO;
                        break;
                    } else if (nota.getNota() < 3) {
                        situacao = Situacao.REPROVADO;
                        break;
                    } else {
                        situacao = Situacao.EM_RECUPERACAO;
                        break;
                    }
                }
                System.out.println("Situação: " + situacao.getStts());
                System.out.println("Notas: ");
                for (Notas nota : notasDoAluno) {
                    System.out.println("Disciplina: " + nota.getDisciplina().getNomeDisciplina());
                    System.out.println("Nota: " + nota.getNota());
                }
            } else {
                System.out.println("Nenhuma nota encontrada.");
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Bem-vindo ao sistema, faça seu login --");
        System.out.println("Email: ");
        String emailUsuario = sc.nextLine();
        System.out.println("Senha: ");
        String senha = sc.nextLine();

        boolean usuarioValido = false;

        for (Secretaria s : Secretaria.getListaSecretarias()) {
            if (emailUsuario.equals(s.getEmail()) && senha.equals(s.getSenha())) {
                usuarioLogado = emailUsuario;
                tipoUsuario = "Secretaria";
                System.out.println("Login realizado com sucesso. (Secretaria)!");
                usuarioValido = true;
                break;
            }
        }

        for (Professor p : Professor.getListaProfessores()) {
            if (emailUsuario.equals(p.getEmail()) && senha.equals(p.getSenha())) {
                usuarioLogado = emailUsuario;
                tipoUsuario = "Professor";
                System.out.println("Login realizado com sucesso. (Professor)!");
                usuarioValido = true;
                break;
            }
        }

        for (Aluno a : Aluno.getListaAlunos()) {
            if (emailUsuario.equals(a.getEmail()) && senha.equals(a.getSenha())) {
                usuarioLogado = emailUsuario;
                tipoUsuario = "Aluno";
                System.out.println("Login realizado com sucesso. (Aluno)!");
                usuarioValido = true;
                break;
            }
        }

        if (!usuarioValido) {
            System.out.println("Email ou senha inválidos. Tente novamente.");
            login();
        }
    }

    public static void menuFinal() {
        int opcao = 8;
        if (usuarioLogado == null) {
            System.out.println("Você precisa fazer login primeiro.");
            login();
        }

        do {
            System.out.println("\n- MENU -");
            System.out.println("O que você deseja fazer?");
            if (tipoUsuario.equals("Secretaria")) {
                System.out.println("1- Menu do Aluno.");
                System.out.println("2- Menu do Professor.");
            } else if (tipoUsuario.equals("Professor")) {
                System.out.println("1- Dar notas.");
            } else if (tipoUsuario.equals("Aluno")) {
                System.out.println("1- Meu histórico.");
            }
            System.out.println("0- Sair\n");
            System.out.print("Digite uma opção: ");
            Scanner sc = new Scanner(System.in);

            try {
                opcao = sc.nextInt();
                System.out.println("\n");
                switch (opcao) {
                    case 1:
                        if (tipoUsuario.equals("Secretaria")) {
                            Secretaria.menuAluno();
                        } else if (tipoUsuario.equals("Professor")) {
                            Professor.darNotas();
                        } else if (tipoUsuario.equals("Aluno")) {
                            Menu.imprimirHistorico(usuarioLogado);
                        }
                        break;
                    case 2:
                        if (tipoUsuario.equals("Secretaria")) {
                            Secretaria.menuProfessor();
                        }
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        usuarioLogado = null;
                        tipoUsuario = null;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número inteiro!");
                sc.next();
            }

        } while (opcao != 0);
    }
}

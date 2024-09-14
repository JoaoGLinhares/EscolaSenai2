package com.poo.escola.Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Professor extends Pessoa {
    private Date dataAdmissao;
    private Double salario;
    private String email;
    private String senha;

    public static List<Professor> listaProfessores = new ArrayList<>();

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

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

    public static void cadastrarProfessor() {
        System.out.println(" -- Cadastrando novo professor -- ");
        System.out.print("Nome: ");
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        Professor professor = new Professor();
        professor.setNome(nome);
        Professor.listaProfessores.add(professor);
    }

    public static void atualizarProfessor() {
        if (!Professor.listaProfessores.isEmpty()) {
            System.out.println("Lista de professores: ");
            mostrarListaProfessores();
            System.out.print("Digite o número do professor para atualizar: ");
            Scanner sc = new Scanner(System.in);
            int indiceProfessor = sc.nextInt() - 1;
            if (indiceProfessor >= 0 && indiceProfessor < Professor.listaProfessores.size()) {
                Professor professorAtualizar = Professor.listaProfessores.get(indiceProfessor);
                System.out.print("Digite o novo nome: ");
                sc.nextLine();
                String novoNome = sc.nextLine();
                professorAtualizar.setNome(novoNome);
                System.out.println("Professor atualizado com sucesso.\n");
            } else {
                System.out.println("Número do professor inválido.\n");
            }
        } else {
            System.out.println("Não há professores cadastrados.");
        }
    }

    public static void removerProfessor() {
        if (!Professor.listaProfessores.isEmpty()) {
            System.out.println("Lista de professores: ");
            mostrarListaProfessores();
            System.out.print("Digite o número do professor para remover: ");
            Scanner sc = new Scanner(System.in);
            int indiceProfessor = sc.nextInt() - 1;
            if (indiceProfessor >= 0 && indiceProfessor < Professor.listaProfessores.size()) {
                Professor.listaProfessores.remove(indiceProfessor);
                System.out.println("Professor removido com sucesso.\n");
            } else {
                System.out.println("Número do professor inválido.\n");
            }
        } else {
            System.out.println("Não há professores cadastrados.");
        }
    }

    public static void mostrarListaProfessores() {
        if (!Professor.listaProfessores.isEmpty()) {
            System.out.println("Lista de professores: ");
            for (int i = 0; i < listaProfessores.size(); i++) {
                Professor professor = listaProfessores.get(i);
                System.out.println((i + 1) + "- " + professor.getNome() + " / Salário: " +
                        professor.getSalario() + " / E-mail: " + professor.getEmail() +
                        " / Data de Admissão: " + professor.getDataAdmissao());
            }
        } else {
            System.out.println("Não há professores cadastrados.\n");
        }
    }

    public static List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public static void popularProfessores() {
        Professor professor1 = new Professor();
        professor1.setNome("Arthur");
        professor1.setSalario(3200.00);
        professor1.setEmail("arthurG@gmail.com");
        professor1.setDataAdmissao(new Date());
        professor1.setSenha("MA@!1999");
        listaProfessores.add(professor1);

        Professor professor2 = new Professor();
        professor2.setNome("Pedro");
        professor2.setSalario(3200.00);
        professor2.setEmail("pedroG@gmail.com");
        professor2.setDataAdmissao(new Date());
        professor2.setSenha("PE@!1999");
        listaProfessores.add(professor2);

        Professor professor3 = new Professor();
        professor3.setNome("Lucas");
        professor3.setSalario(3200.00);
        professor3.setEmail("LucasG@gmail.com");
        professor3.setDataAdmissao(new Date());
        professor3.setSenha("LU@!1999");
        listaProfessores.add(professor3);

        Professor professor4 = new Professor();
        professor4.setNome("Mario");
        professor4.setSalario(3200.00);
        professor4.setEmail("marioG@gmail.com");
        professor4.setDataAdmissao(new Date());
        professor4.setSenha("MA@!1999");
        listaProfessores.add(professor4);
    }

    public static void darNotas() {
        System.out.println("Atribuindo notas");
        Aluno.mostrarListaAlunos();
        System.out.print("Digite o número do aluno para atribuir a nota: ");
        Scanner sc = new Scanner(System.in);
        int indiceAluno = sc.nextInt() - 1;

        if (indiceAluno >= 0 && indiceAluno < Aluno.getListaAlunos().size()) {
            Disciplina.mostrarListaDisciplinas();
            System.out.print("Agora, digite o número da disciplina para a qual deseja atribuir a nota: ");
            int indiceDisciplina = sc.nextInt() - 1;

            if (indiceDisciplina >= 0 && indiceDisciplina < Disciplina.getListaDisciplinas().size()) {
                Notas nota = new Notas();
                System.out.print("Qual a nota do aluno? ");
                double notaAluno = sc.nextDouble();

                nota.setNota(notaAluno);
                nota.setAluno(Aluno.getListaAlunos().get(indiceAluno));
                nota.setDisciplina(Disciplina.getListaDisciplinas().get(indiceDisciplina));

                Notas.listaNotas.add(nota);
                Notas.salvarNotasNoArquivo();

                System.out.println("Nota atribuída com sucesso!\n");
            } else {
                System.out.println("Número da disciplina inválido.\n");
            }
        } else {
            System.out.println("Número do aluno inválido.\n");
        }
    }
}

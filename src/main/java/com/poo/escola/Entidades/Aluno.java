package com.poo.escola.Entidades;

import com.poo.escola.Entidades.enums.Situacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Aluno extends Pessoa {
    private Date dataDeMatricula;
    private String curso;
    private Situacao situacao;

    private List<Notas> listaNotas = new ArrayList<>();

    public List<Notas> getListaNotas() {
        return listaNotas;
    }

    public void adicionarNota(Notas nota) {
        this.listaNotas.add(nota);
    }

    public static List<Aluno> listaAlunos = new ArrayList<>();

    public Date getDataDeMatricula() {
        return dataDeMatricula;
    }

    public void setDataDeMatricula(Date dataDeMatricula) {
        this.dataDeMatricula = dataDeMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "dataDeMatricula=" + dataDeMatricula +
                ", curso='" + curso + '\'' +
                ", situacao=" + situacao.getStts() +
                '}';
    }

    public static void cadastrarAluno() {
        System.out.println(" -- Cadastrando novo aluno -- ");
        System.out.print("Nome: ");
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        listaAlunos.add(aluno);
    }

    public static void atualizarAluno() {
        if (!listaAlunos.isEmpty()) {
            System.out.println("Lista de alunos: ");
            mostrarListaAlunos();

            System.out.print("Digite o número do aluno para atualizar: ");
            Scanner sc = new Scanner(System.in);
            int indiceAluno = sc.nextInt() - 1;

            if (indiceAluno >= 0 && indiceAluno < listaAlunos.size()) {
                Aluno alunoAtualizar = listaAlunos.get(indiceAluno);

                System.out.print("Digite o novo nome: ");
                sc.nextLine();
                String novoNome = sc.nextLine();
                alunoAtualizar.setNome(novoNome);

                System.out.println("Aluno atualizado com sucesso.\n");
            } else {
                System.out.println("Número do aluno inválido.\n");
            }
        } else {
            System.out.println("Não há alunos cadastrados.");
        }
    }

    public static void removerAluno() {
        if (!listaAlunos.isEmpty()) {
            System.out.println("Lista de alunos: ");
            mostrarListaAlunos();

            System.out.print("Digite o número do aluno para remover: ");
            Scanner sc = new Scanner(System.in);
            int indiceAluno = sc.nextInt() - 1;

            if (indiceAluno >= 0 && indiceAluno < listaAlunos.size()) {
                listaAlunos.remove(indiceAluno);
                System.out.println("Aluno removido com sucesso.\n");
            } else {
                System.out.println("Número do aluno inválido.\n");
            }
        } else {
            System.out.println("Não há alunos cadastrados.");
        }
    }

    public static void mostrarListaAlunos() {
        if (!listaAlunos.isEmpty()) {
            System.out.println("Lista de alunos: ");
            for (int i = 0; i < listaAlunos.size(); i++) {
                Aluno aluno = listaAlunos.get(i);
                System.out.println((i + 1) + "- " + aluno.getNome() +
                        " / Data de matrícula: " + aluno.getDataDeMatricula() +
                        " / Curso: " + aluno.getCurso());
            }
        } else {
            System.out.println("Não há alunos cadastrados.\n");
        }
    }

    public static void popularAlunos() {
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Luan");
        aluno1.setEmail("luanG@gmail.com");
        aluno1.setCurso("Desenvolvimento de Software");
        aluno1.setSenha("Lu!1984@");
        listaAlunos.add(aluno1);

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Carlos");
        aluno2.setDataDeMatricula(new Date());
        aluno2.setEmail("carlosS@gmail.com");
        aluno2.setCurso("Desenvolvimento de Software");
        aluno2.setSenha("carl!1984@");
        listaAlunos.add(aluno2);

        Aluno aluno3 = new Aluno();
        aluno3.setNome("Marcos");
        aluno3.setDataDeMatricula(new Date());
        aluno3.setEmail("marcosS@gmail.com");
        aluno3.setCurso("Desenvolvimento de Software");
        aluno3.setSenha("mark!1984@");
        listaAlunos.add(aluno3);
    }

    public static List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public static Aluno obterAlunoPorEmail(String email) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getEmail().equals(email)) {
                return aluno;
            }
        }
        return null;
    }
}

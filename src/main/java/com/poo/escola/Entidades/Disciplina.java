package com.poo.escola.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nomeDisciplina;
    private List<Notas> listaNotas = new ArrayList<>();

    public List<Notas> getListaNotas() {
        return listaNotas;
    }

    public void adicionarNota(Notas nota) {
        this.listaNotas.add(nota);
    }

    public static List<Disciplina> listaDisciplinas = new ArrayList<>();

    public static Disciplina obterDisciplinaPorNome(String nome) {
        for (Disciplina disciplina : listaDisciplinas) {
            if (disciplina.getNomeDisciplina().equals(nome)) {
                return disciplina;
            }
        }
        return null;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public static List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public static void mostrarListaDisciplinas() {
        if (!listaDisciplinas.isEmpty()) {
            System.out.println("Lista de disciplinas: ");
            for (Disciplina d : listaDisciplinas) {
                System.out.println(listaDisciplinas.indexOf(d) + "- " + d.getNomeDisciplina());
            }
        } else {
            System.out.println("Não há disciplinas cadastradas. \n");
        }
    }

    public static void popularDisciplinas() {
        Disciplina disciplina1 = new Disciplina();
        disciplina1.setNomeDisciplina("JAVA");
        listaDisciplinas.add(disciplina1);

        Disciplina disciplina2 = new Disciplina();
        disciplina2.setNomeDisciplina("LÓGICA");
        listaDisciplinas.add(disciplina2);

        Disciplina disciplina3 = new Disciplina();
        disciplina3.setNomeDisciplina("BANCO DE DADOS");
        listaDisciplinas.add(disciplina3);
    }
}

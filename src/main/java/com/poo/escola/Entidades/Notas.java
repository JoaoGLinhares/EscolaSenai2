package com.poo.escola.Entidades;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Notas {
    private Double nota;
    private Aluno aluno;
    private Disciplina disciplina;

    public static List<Notas> listaNotas = new ArrayList<>();

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public static List<Notas> getListaNotas() {
        return listaNotas;
    }

    public static void salvarNotasNoArquivo() {
        File arquivo = new File("notas.txt");
        System.out.println("Salvando notas no arquivo: " + arquivo.getAbsolutePath());
        if (!arquivo.canWrite()) {
            System.out.println("Sem permissão de escrita no arquivo. Tentando conceder permissão...");
            arquivo.setWritable(true); // Concede permissão de escrita ao arquivo
        }
        if (arquivo.exists()) {
            arquivo.delete(); // Exclui o arquivo se ele já existir
        }
        try {
            arquivo.createNewFile(); // Cria um novo arquivo
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo: " + e.getMessage());
            return; // Sai do método caso haja erro na criação do arquivo
        }
        try (FileWriter writer = new FileWriter(arquivo, true)) {
            for (Notas nota : listaNotas) {
                writer.write(nota.getAluno().getEmail() + "," + nota.getDisciplina().getNomeDisciplina() + "," + nota.getNota() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarNotasDoArquivo() {
        File arquivo = new File("notas.txt");
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado: " + arquivo.getAbsolutePath());
            return;
        }

        listaNotas.clear(); // Limpa a lista antes de carregar os novos dados

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo.getAbsolutePath()))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                processarLinha(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private static void processarLinha(String linha) {
        String[] partes = linha.split(",");
        if (partes.length != 3) {
            System.out.println("Formato de linha inválido: " + linha);
            return;
        }

        Aluno aluno = Aluno.obterAlunoPorEmail(partes[0]);
        Disciplina disciplina = Disciplina.obterDisciplinaPorNome(partes[1]);

        if (aluno != null && disciplina != null) {
            try {
                Double nota = Double.parseDouble(partes[2]);
                Notas notaObjeto = new Notas();
                notaObjeto.setAluno(aluno);
                notaObjeto.setDisciplina(disciplina);
                notaObjeto.setNota(nota);
                aluno.adicionarNota(notaObjeto);
                disciplina.adicionarNota(notaObjeto);
                listaNotas.add(notaObjeto);
            } catch (NumberFormatException e) {
                System.out.println("Formato de nota inválido: " + partes[2]);
            }
        } else {
            System.out.println("Erro ao carregar a nota: Aluno ou disciplina não encontrado");
        }
    }
}

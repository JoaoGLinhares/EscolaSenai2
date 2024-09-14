package com.poo.escola;


import com.poo.escola.Entidades.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscolaApplication {

    public static void main(String[] args)  {
        SpringApplication.run(EscolaApplication.class, args);

        Disciplina.popularDisciplinas();
        Secretaria.popularSecretaria();
        Aluno.popularAlunos();
        Professor.popularProfessores();
        Menu.menuFinal();

        // Na hora de escolher o índice, lembre-se: número 1 corresponde ao índice 0 e assim por diante.
        // Ao lançar a nota como professor, vá no método popularProfessores e pegue o login que é o email e a senha.
        // Para lançar a nota, utilize o formato com vírgula (ex: 9,2) e não com ponto (9.2), pois retorna nulo.

        // Depois de algumas horas tentando descobrir o erro de leitura do arquivo,
        // descobrimos que na gravação estava sendo utilizado o "nome" e na leitura o "email".
        // Além disso, foi necessário chamar o this.notas corretamente.
        // Foram necessárias várias tentativas para resolver isso, além de instanciar a lista de notas
        // tanto na Disciplina quanto no Aluno.

    }

}

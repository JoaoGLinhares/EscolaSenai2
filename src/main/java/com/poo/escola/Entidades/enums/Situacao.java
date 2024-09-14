package com.poo.escola.Entidades.enums;

public enum Situacao {

    APROVADO("Aprovado!"),
    REPROVADO("Reprovado!"),
    EM_RECUPERACAO("Em recuperação");

    private final String stts;

    private Situacao(String stts) {
        this.stts = stts;
    }

    public String getStts() {
        return stts;
    }
   
}

package com.poo.escola.Entidades.enums;

public enum UnidadeFederal {
    
    RJ("Rio de Janeiro"),
    SP("São Paulo"),
    MG("Minas Gerais"),
    ES("Espírito Santo"),

    PR("Paraná"),
    SC("Santa Catarina"),
    RS("Rio Grande do Sul"),

    DF("Distrito Federal"),
    GO("Goiás"),
    MS("Mato Grosso do Sul"),
    MT("Mato Grosso"),

    AL("Alagoas"),
    BA("Bahia"),
    CE("Ceará"),
    MA("Maranhão"),
    PB("Paraíba"),
    PE("Pernambuco"),
    PI("Piauí"),
    RN("Rio Grande do Norte"),
    SE("Sergipe"),

    AC("Acre"),
    AP("Amapá"),
    AM("Amazonas"),
    PA("Pará"),
    RO("Rondônia"),
    RR("Roraima"),
    TO("Tocantins");

    private final String nomePorExtenso;

    UnidadeFederal(String nomePorExtenso) {
        this.nomePorExtenso = nomePorExtenso;
    }

    public String getNomePorExtenso() {
        return nomePorExtenso;
    }
}

package com.poo.escola.Entidades;

import com.poo.escola.Entidades.enums.UnidadeFederal;

public class Endereco {

    private String logradouro;
    private int numero;
    private String complemento;
    private String cidade;
    private UnidadeFederal estado;
    private String cep;

    public Endereco(String logradouro, int numero, String complemento, 
                    String cidade, UnidadeFederal estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UnidadeFederal getEstado() {
        return estado;
    }

    public void setEstado(UnidadeFederal estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "Logradouro='" + logradouro + '\'' +
                ", Número=" + numero +
                ", Complemento='" + complemento + '\'' +
                ", Cidade='" + cidade + '\'' +
                ", Estado='" + estado.getNomePorExtenso() + '\'' +
                ", CEP='" + cep + '\'' +
                '}';
    }
}

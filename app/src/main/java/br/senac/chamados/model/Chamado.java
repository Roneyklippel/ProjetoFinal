package br.senac.chamados.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Chamado {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("dataAbertura")
    @Expose
    private Date dataAbertura;

    @SerializedName("descricao")
    @Expose
    private String descricao;


    private Status status;

    @SerializedName("solucao")
    @Expose
    private String solucao;

    public Chamado() {

    }

    public Chamado(int id, Date dataAbertura, String descricao, Status status, String solucao) {
        this.id = id;
        this.dataAbertura = dataAbertura;
        this.descricao = descricao;
        this.status = status;
        this.solucao = solucao;
    }

    public Chamado(long l, Status sexta, Status naoenviada) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    @NonNull
    @Override
    public String toString() {
        return "Chamado: " +
                " dataAbertura = " + dataAbertura +
                ", descrição = '" + descricao + '\'' +
                ", status = '" + status + '\'' +
                ", solução = '" + solucao + '\'' +
                '}';


    }
}

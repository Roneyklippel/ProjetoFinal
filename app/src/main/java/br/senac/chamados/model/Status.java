package br.senac.chamados.model;

public enum Status {
    ABERTO{
        @Override
        public String toString(){
            return "ABERTO";
        }
    },
    FECHADO{
        @Override
        public String toString(){
            return "FECHADO";
        }
    }
}

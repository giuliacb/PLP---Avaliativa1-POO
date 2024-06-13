package models;

public abstract class Contato {
    protected String nome;
    protected String telefone;

    public Contato(String var1, String var2) {
        this.nome = var1;
        this.telefone = var2;
    }

    public abstract String getDetalhes();

    public String toString() {
        String var10000 = this.nome;
        return var10000 + " - Telefone: " + this.telefone + " - " + this.getDetalhes();
    }
}

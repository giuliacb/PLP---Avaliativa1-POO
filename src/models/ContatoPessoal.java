package models;

public class ContatoPessoal extends Contato {
    private String aniversario;

    public ContatoPessoal(String nome, String telefone, String aniversario) {
        super(nome, telefone);
        this.aniversario = aniversario;
    }

    @Override
    public String getDetalhes() {
        return "Aniversário: " + aniversario;
    }
}

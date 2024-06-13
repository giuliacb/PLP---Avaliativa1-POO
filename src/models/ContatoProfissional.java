package models;

public class ContatoProfissional extends Contato {
    private String empresa;

    public ContatoProfissional(String nome, String telefone, String empresa) {
        super(nome, telefone);
        this.empresa = empresa;
    }

    @Override
    public String getDetalhes() {
        return "Empresa: " + empresa;
    }
}

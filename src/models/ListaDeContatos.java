package models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaDeContatos {
    private List<Contato> contatos;

    public ListaDeContatos() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void listarContatos() {
        for (int i = 0; i < contatos.size(); i++) {
            System.out.println((i + 1) + ". " + contatos.get(i));
        }
    }

    public void removerContato(int indice) {
        if (indice >= 0 && indice < contatos.size()) {
            contatos.remove(indice);
        } else {
            System.out.println("Índice de contato inválido");
        }
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public synchronized void salvarBackup(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Contato contato : contatos) {
                writer.write(contato.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

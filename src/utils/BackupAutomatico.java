package utils;

import models.ListaDeContatos;

public class BackupAutomatico implements Runnable {
    private ListaDeContatos lista;
    private String filePath;

    public BackupAutomatico(ListaDeContatos lista, String filePath) {
        this.lista = lista;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        while (true) {
            lista.salvarBackup(filePath);
            System.out.println("Backup automático realizado.");
            try {
                Thread.sleep(60000); // Backup a cada 60 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

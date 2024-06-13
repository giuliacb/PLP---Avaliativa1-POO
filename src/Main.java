//GIULIA CAMPELO BEZERRA
//2212130008

import models.*;
import utils.BackupAutomatico;
//import utils.Relogio;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDeContatos lista = new ListaDeContatos();
        Scanner scanner = new Scanner(System.in);

        // Thread para backup automático
        Thread tBackup = new Thread(new BackupAutomatico(lista, "backup.txt"));
        tBackup.setDaemon(true);
        tBackup.start();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Contato Pessoal");
            System.out.println("2. Adicionar Contato Profissional");
            System.out.println("3. Listar Contatos");
            System.out.println("4. Remover Contato");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    System.out.print("Nome do Contato: ");
                    String nomePessoal = scanner.nextLine();
                    System.out.print("Telefone do Contato: ");
                    String telefonePessoal = scanner.nextLine();
                    System.out.print("Aniversário do Contato (YYYY-MM-DD): ");
                    String aniversario = scanner.nextLine();
                    Contato pessoal = new ContatoPessoal(nomePessoal, telefonePessoal, aniversario);
                    lista.adicionarContato(pessoal);
                    break;
                case "2":
                    System.out.print("Nome do Contato: ");
                    String nomeProfissional = scanner.nextLine();
                    System.out.print("Telefone do Contato: ");
                    String telefoneProfissional = scanner.nextLine();
                    System.out.print("Empresa do Contato: ");
                    String empresa = scanner.nextLine();
                    Contato profissional = new ContatoProfissional(nomeProfissional, telefoneProfissional, empresa);
                    lista.adicionarContato(profissional);
                    break;
                case "3":
                    lista.listarContatos();
                    break;
                case "4":
                    System.out.print("Número do Contato a remover: ");
                    int indice = Integer.parseInt(scanner.nextLine()) - 1;
                    lista.removerContato(indice);
                    break;
                case "5":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}

/*
Definições de classe e Abstração:
    Contato é uma classe abstrata que define a estrutura básica de um contato e inclui um método abstrato getDetalhes.
    ContatoPessoal e ContatoProfissional herdam de Contato e implementam o método getDetalhes.

Encapsulamento:
    ListaDeContatos encapsula a lista de contatos e fornece métodos para adicionar, listar e remover contatos. Além disso,
    tem um método salvarBackup para salvar os contatos em um arquivo.

Concorrência:
    A classe BackupAutomatico implementa Runnable e realiza backups automáticos da lista de contatos em intervalos regulares
    (a cada 10 segundos) em um thread separado.

    EXEMPLO 2: A classe Relogio implementa Runnable e exibe o tempo atual continuamente em um thread separado.

Entrada e Saída:
    O menu no console permite interação do usuário para adicionar, listar e remover contatos.
 */


// Thread para exibir o relógio (outro exemplo de concorrência)
//        Thread tRelogio = new Thread(new Relogio());
//        tRelogio.setDaemon(true);
//        tRelogio.start();
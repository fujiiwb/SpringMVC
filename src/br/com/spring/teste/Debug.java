package br.com.spring.teste;

import java.util.Scanner;

import br.com.spring.Utilities.UtilitiesVar;

public class Debug {

    protected Integer resposta = null;
    public String menu = "" + UtilitiesVar.getSeparator(2)
                         + "\n --- MENU PRINCIPAL ---\n"
                         + UtilitiesVar.getSeparator(2)
                         + "\n  1 - Usuario"
                         + "\n  0 - SAIR\n"
                         + UtilitiesVar.getSeparator(2);

    public static void main(String[] args) {
        new Debug().init();
    }

    public Debug() {
        super();
    }

    public void init() {
        try (Scanner entrada = new Scanner(System.in)) {
            OUTER: do {
                System.out.println(menu);
                System.out.print("[MenuPrincipal] Resposta: ");
                resposta = entrada.nextInt();
                INNER: switch (resposta) {
                    case 1:
                        new UsuarioDebug().init();
                        break INNER;
                    case 0:
                        System.out.println("[MenuPrincipal] Fim da execução!");
                        break OUTER;
                    default:
                        System.out.println("[MenuPrincipal] Opção Inexistente!");
                        break INNER;
                }
                System.out.println("\n\n\n");
            } while (resposta != null && !resposta.equals(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

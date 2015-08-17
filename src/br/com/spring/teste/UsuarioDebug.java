package br.com.spring.teste;

import java.util.Scanner;

import br.com.spring.Utilities.UtilitiesVar;
import br.com.spring.dao.UsuarioDAO;
import br.com.spring.domain.Usuario;

public class UsuarioDebug extends Debug {

    private UsuarioDAO dao = new UsuarioDAO();
    public String menu = "" + UtilitiesVar.getSeparator(2)
                         + "\n --- MENU USUARIO ---\n"
                         + UtilitiesVar.getSeparator(2)
                         + "\n  1 - Inserir"
                         + "\n  2 - Atualizar"
                         + "\n  3 - Remover (por ID)"
                         + "\n  4 - Buscar (por ID)"
                         + "\n  5 - Listar"
                         + "\n  0 - SAIR\n"
                         + UtilitiesVar.getSeparator(2);

    public UsuarioDebug() {
        super();
    }

    public static void main(String[] args) {
        new Debug().init();
    }

    @Override
    public void init() {
        try (Scanner entrada = new Scanner(System.in)) {
            OUTER: do {
                System.out.println(menu);
                System.out.print("[MenuUsuario] Resposta: ");
                resposta = entrada.nextInt();
                INNER: switch (resposta) {
                    case 1:
                        inserir();
                        break INNER;
                    case 4:
                        buscar();
                        break INNER;
                    case 0:
                        System.out.println("[MenuUsuario] Fim da execução!");
                        break OUTER;
                    default:
                        System.out.println("[MenuUsuario] Opção Inexistente!");
                        break INNER;
                }
                System.out.println("\n\n\n");
            } while (resposta != null && !resposta.equals(0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resposta = null;
        }
    }

    private void inserir() {
        try (Scanner entrada = new Scanner(System.in)) {
            Usuario usuario = new Usuario();
            System.out.print("[InserirUsuario] Digite o Primeiro Nome: ");
            usuario.setNome(entrada.nextLine());
            System.out.print("[InserirUsuario] Digite o Ultimo Nome: ");
            usuario.setSobrenome(entrada.nextLine());
            System.out.print("[InserirUsuario] Digite o Username: ");
            usuario.setUsername(entrada.nextLine());
            System.out.print("[InserirUsuario] Digite a Senha: ");
            usuario.setSenha(entrada.nextLine());
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.sessionOpen();
            usuarioDAO.insertUsuario(usuario);
            usuarioDAO.sessionClose();
            System.out.println("[InserirUsuario] Usuario inserido com Sucesso!");
        } catch (Exception e) {
            System.out.println("[InserirUsuario] Ocorreu um erro ao inserir o Usuario: " + e.toString());
            e.printStackTrace();
        }
    }

    private void buscar() {
        Usuario usuario = null;
        System.out.print("[BuscarUsuario] Digite o ID: ");
        try (Scanner entrada = new Scanner(System.in)) {
            dao.sessionOpen();
            String id = entrada.next();
            usuario = dao.getUsuarioPorId(Long.valueOf(id));
            if (usuario == null) {
                System.out.println("[BuscarUsuario] Usuario nao encontrado!");
            } else {
                System.out.println("[BuscarUsuario] id: " + usuario.getId());
                System.out.println("[BuscarUsuario] Primeiro Nome: " + usuario.getNome());
                System.out.println("[BuscarUsuario] Ultimo Nome: " + usuario.getSobrenome());
                System.out.println("[BuscarUsuario] Username: " + usuario.getUsername());
                System.out.println("[BuscarUsuario] Senha: " + usuario.getSenha());
            }
        } catch (Exception e) {
            System.out.println("[BuscarUsuario] Ocorreu um erro ao inserir o Usuario: " + e.toString());
            e.printStackTrace();
        } finally {
            dao.sessionClose();
        }
    }
}

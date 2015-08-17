package br.com.spring.tarefas.controller;

import static br.com.spring.Utilities.UtilitiesVar.getPage;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.spring.dao.UsuarioDAO;
import br.com.spring.domain.Usuario;

@Controller
public class UsuarioControllerOLD {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @RequestMapping(value = "/usuario1")
    public String usuarios(Model model) {
        List<Usuario> usuarios = null;
        try {
            usuarioDAO.sessionOpen();
            usuarios = usuarioDAO.getListUsuarios();
            System.out.println(usuarios.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            usuarioDAO.sessionClose();
        }
        model.addAttribute("usuarios", usuarios);
        return getPage("usuario");
    }

    @RequestMapping(value = "/usuario/altera")
    public String alterar(Long id, Model model) {
        try {
            usuarioDAO.sessionOpen();
            model.addAttribute("usuario", usuarioDAO.getUsuarioPorId(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            usuarioDAO.sessionClose();
        }
        return getPage("usuario/alterar");
    }

    @RequestMapping("usuario/alterar")
    public String alterar(Model model, Usuario usuario) {
        try {
            System.out.println("updatin: " + usuario);
            usuarioDAO.sessionOpen();
            usuarioDAO.updateUsuario(usuario);
            model.addAttribute("mensagem", "Dados alterados com sucesso!");
        } catch (Exception e) {
            model.addAttribute("mensagem", "Erro ao alterar os dados!");
            e.printStackTrace();
        } finally {
            model.addAttribute("title", "Spring - Alteração Usuário");
            model.addAttribute("redirect", "../usuario");
            usuarioDAO.sessionClose();
        }
        return getPage("mensagem");
    }

    @RequestMapping(value = "/usuario/add")
    public String inserePrepara() {
        return getPage("usuario/add");
    }

    @RequestMapping(value = "/usuario/adicionar", method = RequestMethod.POST)
    public String insere(@ModelAttribute Usuario usuario, Model model) {
        boolean valido = Boolean.TRUE;
        if (usuario.getUsername() == null || usuario.getUsername().trim().equals("")) {
            valido = Boolean.FALSE;
            model.addAttribute("msgUsername", "Username inválido!");
        }
        if (usuario.getSenha() == null || usuario.getSenha().trim().equals("")) {
            valido = Boolean.FALSE;
            model.addAttribute("msgSenha", "Senha inválida!");
        }
        if (usuario.getNome() == null || usuario.getNome().trim().equals("")) {
            valido = Boolean.FALSE;
            model.addAttribute("msgNome", "Nome inválido!");
        }
        if (usuario.getSobrenome() == null || usuario.getSobrenome().trim().equals("")) {
            valido = Boolean.FALSE;
            model.addAttribute("msgSobrenome", "Sobrenome inválido!");
        }
        if (!valido) {
            model.addAttribute("msgErro", "Preencha os dados necessários para prosseguir!");
            model.addAttribute("usuario", usuario);
            return getPage("usuario/add");
        }
        try {
            usuarioDAO.sessionOpen();
            usuarioDAO.insertUsuario(usuario);
            model.addAttribute("usuarios", usuarioDAO.getListUsuarios());
            model.addAttribute("msg", "Usuário Inserido com Sucesso!");
            return getPage("usuario");
        } catch (Exception e) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("msgErro", "Ocorreu um erro ao inserir o Usuário!");
            e.printStackTrace();
        } finally {
            usuarioDAO.sessionClose();
        }
        return getPage("usuario/add");
    }
}

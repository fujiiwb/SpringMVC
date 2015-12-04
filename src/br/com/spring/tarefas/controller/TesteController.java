package br.com.spring.tarefas.controller;

import static br.com.spring.Utilities.UtilitiesVar.getPage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.spring.dao.UsuarioDAO;
import br.com.spring.domain.Teste;
import br.com.spring.domain.Usuario;

@Controller
@RequestMapping("/teste")
public class TesteController {

    public TesteController() {
        super();
    }

    @RequestMapping(value = "/ajax")
    public String ajax() {
        return getPage("teste/ajax");
    }

    @RequestMapping(value = "/info")
    public String info() {
        return getPage("teste/info");
    }

//    @javax.ws.rs.Consumes("application/json")
    @RequestMapping(value = "/ajax/do", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public @ResponseBody Teste doAjax(Model model, HttpServletRequest request, @RequestBody Teste teste) {
        System.out.println("Teste: " + teste);
        model.addAttribute("message", "teste--");
        return teste;
    }
    
    @RequestMapping(value="/table")
    public String table(Model model) {
        List<Usuario> usuarios = new ArrayList<>();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.sessionOpen();
            usuarios = usuarioDAO.getListUsuarios();
            model.addAttribute("usuarios", usuarios);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            usuarioDAO.sessionClose();
        }
        return getPage("teste/table");
    }
}

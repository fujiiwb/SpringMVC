package br.com.spring.tarefas.controller;

import static br.com.spring.Utilities.UtilitiesVar.getErrorMessage;
import static br.com.spring.Utilities.UtilitiesVar.getPage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.spring.dao.UsuarioDAO;
import br.com.spring.domain.Usuario;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    //    @Autowired
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @RequestMapping(value = {"", "/"})
    public String inicial(Model model) {
        try {
            usuarioDAO.sessionOpen();
            List<Usuario> usuarios = usuarioDAO.getListUsuarios();
            model.addAttribute("usuarios", usuarios);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            usuarioDAO.sessionClose();
        }
        return getPage("usuario");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("usuario", new Usuario());
        return getPage("usuario/create");
    }

    @RequestMapping(value = "/create/do", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String doCreate(Model model, Usuario usuario) {
        System.out.println("u: " + usuario);
        ModelAndView mandv = new ModelAndView();
        try {
            usuarioDAO.sessionOpen();
            usuarioDAO.insertUsuario(usuario);
            model.addAttribute("usuarios", usuarioDAO.getListUsuarios());
            model.addAttribute("message", "Usuario criado com sucesso");
            mandv.addObject("message", "teste");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erro ao criar o usuario");
        } finally {
            usuarioDAO.sessionClose();
        }
        return getPage("usuario/create");
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model) {
        List<Usuario> list = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setNome("teste");
        list.add(usuario);
        model.addAttribute("usuarios", list);
        return getPage("usuario/search");
    }

    @RequestMapping(value = "/search/do", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public @ResponseBody List<Usuario> doSearch(Model model, @RequestBody String busca) {
        ModelAndView mandv = new ModelAndView();
        List<Usuario> usuarios = new ArrayList<>();
        try {
            usuarioDAO.sessionOpen();
            usuarios = usuarioDAO.getListUsuariosPorNome(busca.replaceAll("\"", ""));
            model.addAttribute("usuarios", usuarios);
            mandv.addObject("usuarios", usuarios);
            model.addAttribute("message", "Teste");
            mandv.addObject("message", "Teste");
            System.out.println(usuarios.size());
        } catch (Exception e) {
            model.addAttribute("message", getErrorMessage("na busca"));
            e.printStackTrace();
        } finally {
            usuarioDAO.sessionClose();
        }
        return usuarios;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, Long id) {
        try {
            usuarioDAO.sessionOpen();
            model.addAttribute("usuario", usuarioDAO.getUsuarioPorId(id));
        } catch (Exception e) {
            model.addAttribute("message", getErrorMessage(null));
            e.printStackTrace();
        } finally {
            usuarioDAO.sessionClose();
        }
        return getPage("usuario/update");
    }

    @RequestMapping(value = "/update/do", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public @ResponseBody Usuario doUpdate(Model model, @RequestBody Usuario usuario) {
        System.out.println("u: " + usuario);
        ModelAndView mandv = new ModelAndView();
        try {
            usuarioDAO.sessionOpen();
            usuarioDAO.updateUsuario(usuario);
            model.addAttribute("message", "Dados salvos com sucesso!");
        } catch (Exception e) {
            model.addAttribute("message", getErrorMessage("ao alterar o usuário"));
            e.printStackTrace();
        } finally {
            usuarioDAO.sessionClose();
        }
        mandv.addObject("message", "teste");
        return usuario;
    }
}

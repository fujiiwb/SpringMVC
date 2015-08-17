package br.com.spring.tarefas.controller;

import static br.com.spring.Utilities.UtilitiesVar.getPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.spring.dao.SpringDBDAO;

/**
 * @author GKFujii
 */
@Controller
public class HelloWorld {

    @RequestMapping("/")
    public String executeA() {
        return getPage("inicio");
    }
    
    @RequestMapping("/inicial")
    public String executeB() {
        return getPage("inicio");
//        return getPage("ok");
    }
    
    @RequestMapping("/ok")
    public String executeC() {
        return getPage("ok");
    }
    
    @RequestMapping("/hardreset")
    public String geraTabelas() {
        SpringDBDAO daoSpringDB = new SpringDBDAO();
        try {
            daoSpringDB.sessionOpen();
            daoSpringDB.generateDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            daoSpringDB.sessionClose();
        }
        return getPage("inicio");
    }

    @RequestMapping("/teste")
    public String execute2() {
        System.out.println("Executando /teste");
        try {
            //Parte II
            br.com.spring.dao.CredencialDAO daoCredencial = new br.com.spring.dao.CredencialDAO();
            daoCredencial.sessionOpen();
            System.out.println("getList");
            java.util.List<br.com.spring.domain.Credencial> credenciais = daoCredencial.getListCredencial();
            for (br.com.spring.domain.Credencial credencial1 : credenciais) {
                System.out.println(credencial1);
            }
            //Parte III
            br.com.spring.dao.UsuarioDAO daoUsuario = new br.com.spring.dao.UsuarioDAO(daoCredencial.getSession());
//            br.com.spring.domain.Usuario usuario = new br.com.spring.domain.Usuario();
//            usuario.setNomePrimeiro("nomePrimeiro");
//            usuario.setNomeUltimo("nomeUltimo");
//            usuario.setUsername("username_5");
//            usuario.setSenha("senha");
//            daoUsuario.insertUsuario(usuario);
            new br.com.spring.teste.Debug();
            for (br.com.spring.domain.Usuario user : daoUsuario.getListUsuarios()) {
                System.out.println(user);
            }
//            credencial.setId(null);
//            credencial.setUsername(credencial.getUsername() + " -");
//            credencial.getSistema().setId(null);
//            credencial.getSistema().setNome(credencial.getSistema().getNome() + " -");
//            credencial.getUsuario().setId(null);
//            credencial.getUsuario().setUsername(credencial.getUsuario().getUsername() + " -");
            //            new br.com.spring.dao.CredencialDAO().
            daoCredencial.sessionClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}

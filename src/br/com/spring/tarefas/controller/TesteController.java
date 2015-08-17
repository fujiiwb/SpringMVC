package br.com.spring.tarefas.controller;

import static br.com.spring.Utilities.UtilitiesVar.getPage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.spring.domain.Teste;

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

//    @javax.ws.rs.Consumes("application/json")
    @RequestMapping(value = "/ajax/do", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public @ResponseBody Teste doAjax(Model model, HttpServletRequest request, @RequestBody Teste teste) {
        System.out.println("Teste: " + teste);
        model.addAttribute("message", "teste--");
        return teste;
    }
}

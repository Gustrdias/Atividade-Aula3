package br.com.atividade3.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.atividade3.model.Cliente;
import br.com.atividade3.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping("/")
	public String main() {  
	    return "Index";
	  }
	@GetMapping("/cliente")
    public String getCliente(Cliente cliente) {
    return "CadastroCliente";
   }
   @PostMapping("/addcliente")
   public String addUser(Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "CadastroCliente";
        }
        clienteRepository.save(cliente);
        return "Index";
   }
   @RequestMapping("/lstclientes") 
   public String listaClientes(Model model) {
     model.addAttribute("clientes", clienteRepository.findAll());
     return "ListaCliente";
   }
	
	@GetMapping(path="/alterar/{id}")
	 public String clienteSelecionado(@PathVariable(value="id") long id,Model model) {
	     model.addAttribute("dadosCliente", clienteRepository.findById(id));
		return "EditarCliente";
	}
	
	@DeleteMapping("/excluir/{id}")
	public String deleteCliente(@PathVariable(value="id") long id) {
		clienteRepository.deleteById((long) id);
		return "Index";
	}
	@PutMapping("/alterar/{id}")
	public String editarCliente(@PathVariable(value="id") long id,Cliente cliente) {
		Optional<Cliente> clienteAtual=clienteRepository.findById(id);
		clienteAtual.get().setAddress(cliente.getAddress());
		clienteAtual.get().setName(cliente.getName());
		clienteAtual.get().setEmail(cliente.getEmail());
		clienteRepository.save(clienteAtual.get());
		
		return "Index";
	}
	
}

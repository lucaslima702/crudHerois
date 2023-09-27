package br.com.example.demo.teste;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class usuarioController {

	@Autowired
	Heroi heroiService;

	@PostMapping("/adicionarHeroi")
	public ResponseEntity<?> adicionaHeroi(@RequestBody Heroi heroi) {
		heroiService.addHeroi(heroi);
		return new ResponseEntity<ArrayList<Heroi>>(heroiService.retornaHerois(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getHerois")
	public ResponseEntity<?> getHerois(){
		return new ResponseEntity<ArrayList<Heroi>>(heroiService.retornaHerois(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/alterarHeroi")
	public ResponseEntity<?> alterarHeroi(@RequestBody  Heroi heroi, String id) {
		heroiService.alterarHeroi(heroi);
		return new ResponseEntity<ArrayList<Heroi>>(heroiService.retornaHerois(), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletarHeroi/{id}")
	public ResponseEntity<?> deletarHeroi(@PathVariable("id") int id){
		heroiService.deletaHeroi(id);
		return new ResponseEntity<ArrayList<Heroi>>(heroiService.retornaHerois(), HttpStatus.ACCEPTED);
		
	}
}

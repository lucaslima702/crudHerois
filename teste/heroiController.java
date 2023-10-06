package br.com.example.demo.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class heroiController {

	@Autowired
	HeroiService heroiService;

	@PostMapping("/adicionarHeroi")
	public ResponseEntity<?> adicionaHeroi(@RequestBody Heroi heroi) {
		heroiService.addHeroi(heroi);
		return new ResponseEntity<String> ("Heroi " + heroi.getNome() + " adicionado com sucesso !", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getHerois")
	public ResponseEntity<?> getHerois(){
		return new ResponseEntity<List<Heroi>> (heroiService.retornaHerois(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/alterarHeroi/{id}")
	public ResponseEntity<?> alterarHeroi(@PathVariable("id") Long id, @RequestBody Heroi heroi ) {
		String heroiAntigo = heroiService.getHeroiById(id).getNome();
		heroiService.alterarHeroi(heroi, id);
		return new ResponseEntity<String> ("Heroi " + heroiAntigo + " alterado para o heroi " + heroi.getNome(), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletarHeroi/{id}")
	public ResponseEntity<?> deletarHeroi(@PathVariable("id") Long id){
		String heroiDeletado = heroiService.getHeroiById(id).getNome();
		heroiService.deletaHeroi(id);
		return new ResponseEntity<String> ("Heroi " + heroiDeletado + " deletado do banco de dados.", HttpStatus.ACCEPTED);
		
	}
}

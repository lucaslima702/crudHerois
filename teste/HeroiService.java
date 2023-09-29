package br.com.example.demo.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroiService {

	@Autowired
	HeroiRepository heroiRepository;
	
	public List<Heroi> retornaHerois() {
		return heroiRepository.findAll();
	}

	public void addHeroi(Heroi h) {
		heroiRepository.save(h);
	}

	public void alterarHeroi(Heroi heroi) {
		heroiRepository.delete(getHeroiById(heroi.getId()));
		heroiRepository.save(heroi);
	}

	public void deletaHeroi(int id) {
		Heroi heroi = getHeroiById(id);
		heroiRepository.delete(heroi);
	}

	private Heroi getHeroiById(int id) {
		Heroi heroiSelecionado = null;
		for (Heroi heroi : heroiRepository.findAll()) {
			if(heroi.getId() == id) {
				heroiSelecionado = heroi;
			}
		}
		return heroiSelecionado;
	}
}


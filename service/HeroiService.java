package br.com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.demo.heroi.Heroi;
import br.com.example.demo.repository.HeroiRepository;

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

	public void alterarHeroi(Heroi h, Long id) {
		Heroi heroi = getHeroiById(id);
		heroi.setNome(h.getNome());
		heroi.setPoder(h.getPoder());
		heroiRepository.save(heroi);
	}

	public void deletaHeroi(Long id) {
		Heroi heroi = getHeroiById(id);
		heroiRepository.delete(heroi);
	}

	public Heroi getHeroiById(Long id) {
		Heroi heroiSelecionado = null;
		for (Heroi heroi : heroiRepository.findAll()) {
			if(heroi.getId().equals(id)) {
				heroiSelecionado = heroi;
			}
		}
		return heroiSelecionado;
	}
}


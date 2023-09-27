package br.com.example.demo.teste;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
public class Heroi {
	
	String nome;
	String poder;
	Integer id;

	@JsonIgnore
	public ArrayList<Heroi> listaHerois = new ArrayList<Heroi>();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPoder() {
		return poder;
	}

	public void setPoder(String poder) {
		this.poder = poder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Heroi> retornaHerois() {
		return listaHerois;
	}

	public void addHeroi(Heroi h) {
		listaHerois.add(h);
	}

	public void alterarHeroi(Heroi heroi) {
		listaHerois.remove(heroi.getId() - 1);
		listaHerois.add(heroi);
	}

	public void deletaHeroi(int id) {
		Heroi heroi = getHeroiById(id);
		listaHerois.remove(heroi);
	}

	private Heroi getHeroiById(int id) {
		Heroi heroiSelecionado = null;
		for (Heroi heroi : listaHerois) {
			if(heroi.getId() == id) {
				heroiSelecionado = heroi;
			}
		}
		return heroiSelecionado;
	}
}

package br.com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.demo.heroi.Heroi;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Long>{

}

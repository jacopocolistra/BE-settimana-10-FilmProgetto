package it.film.dao;

import java.util.List;


import it.film.entity.Film;



public interface IFilmDao {

	public void salva(Film f);
	public void aggiorna(Film f);
	public Film trova(int id);
	public void elimina(int id);
	public List<Film> trovaTutti();
	public List<Film> trovaRegista();}

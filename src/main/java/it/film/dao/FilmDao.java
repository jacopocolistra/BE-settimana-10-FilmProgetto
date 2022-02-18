package it.film.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.film.entity.Film;



public class FilmDao {

	private EntityManager em = EntityManagerHelper.getEntityManager();

	public void salva(Film f) {em.getTransaction().begin();em.persist(f);em.getTransaction().commit();}

	public void aggiorna(Film f) {em.getTransaction().begin();em.merge(f);em.getTransaction().commit();}

	public Film trova(String regista) {Query q = em.createQuery("SELECT f from Film f WHERE f.regista = '" + regista + "'");
		Film f = (Film) q.getSingleResult();
			return f;}

	public Film trovaAnno(String anno) {Film film = em.find(Film.class, anno);
			return film;}

	public void elimina(int id) {em.getTransaction().begin();em.remove(em.find(Film.class, id));em.getTransaction().commit();}
	
	public List<Film> trovaTutti() {Query q = em.createNamedQuery("trovatutti");
		List<Film> listaFilm = q.getResultList();
			return listaFilm;}
	
	/**
	 * Funzione di ierca per regista
	 * @param regista
	 * @return regista - il nome del regista da trovare
	 */
	
	public List<Film> trovaRegista(String regista){Query q = em.createQuery("SELECT f from Film f WHERE f.regista = '" + regista + "'");
		List<Film> listaRegista = q.getResultList();
			return listaRegista;}}

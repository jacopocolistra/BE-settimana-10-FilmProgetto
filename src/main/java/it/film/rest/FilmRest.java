package it.film.rest;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.film.dao.FilmDao;
import it.film.dto.FilmDto;
import it.film.entity.Film;


@RequestMapping("/film")
@RestController
@Api(value="FilmRest", tags="Crea ed Elimina film")
public class FilmRest {


Logger log = LoggerFactory.getLogger(getClass());
FilmDao filmdao;

public FilmDao getFilmdao() {if(filmdao == null) {filmdao = new FilmDao();}
	return filmdao;}

@GetMapping
@ApiOperation(
		value="Mostra la lista di tutti i film presenti",
		produces="application/json",
		response = Film.class, responseContainer = "List" 
		)

public ResponseEntity<List<Film>> trovaTutti(){
	try {return new ResponseEntity<List<Film>>(getFilmdao().trovaTutti(),HttpStatus.OK);
		}catch(Exception e) {return new  ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.BAD_REQUEST);}}

@DeleteMapping("/{id}")
@ApiOperation(value= "Elimina un film")
public ResponseEntity<String> deleteFilm(@PathVariable int id) {
	try {getFilmdao().elimina(id);return new ResponseEntity<String>("Film eliminato!", HttpStatus.OK);
		}catch(Exception e) {return new ResponseEntity<String>("Il film non è stato eliminato", HttpStatus.BAD_REQUEST);}}

@PostMapping
@ApiOperation(
		value="Inserisci un nuovo film",
		consumes = "application/json")
public ResponseEntity<String> inseisciFilm(@RequestBody FilmDto fDto) {
	if(fDto.getTitolo()== null || fDto.getTitolo().isBlank()) {log.error("DEFICIENTE, aggiungi il titolo");
		return new ResponseEntity<String>("Il titolo del Film DEVE essere inserito!", HttpStatus.I_AM_A_TEAPOT);}
	
	Film f = new Film();
	String incasso = BCrypt.hashpw(fDto.getIncasso(), BCrypt.gensalt());
	f.setTitolo(fDto.getTitolo());
	f.setAnno(fDto.getAnno());
	f.setTipo(fDto.getTipo());
	f.setRegista(fDto.getRegista());
	f.setIncasso(incasso);
	
	try {getFilmdao().salva(f);
		return new ResponseEntity<String>("Inserimento avvenuto con grande successo!" + f + "se criptiamo l'incasso esce fuori: " + incasso, HttpStatus.OK);
	}catch(Exception e) {return new ResponseEntity<String>("Inserimento non avvenuto!", HttpStatus.BAD_REQUEST);}}

@PutMapping("/{id}")
@ApiOperation(
		value="Aggiorna il film nel Database",
		consumes = "application/json")
public ResponseEntity<String> aggiornaFilm(@RequestBody FilmDto fDto, @PathVariable int id) {Film f = new Film();
	String incasso = BCrypt.hashpw(fDto.getIncasso(), BCrypt.gensalt());
	f.setTitolo(fDto.getTitolo());
	f.setAnno(fDto.getAnno());
	f.setTipo(fDto.getTipo());
	f.setRegista(fDto.getRegista());
	f.setIncasso(fDto.getIncasso());
	f.setIncasso(incasso);
	f.setId(id);
	try {getFilmdao().aggiorna(f);
		return new ResponseEntity<String>("Aggiornamento avvenuto con grande successo!" + f + "se criptiamo l'incasso esce fuori: " + incasso, HttpStatus.OK);
	}catch (Exception e) {return new ResponseEntity<String>("Aggiornamento non avvenuto!", HttpStatus.BAD_REQUEST);}}

@GetMapping("/byregista")
@ApiOperation(
		value = "ricerca per regista",
		produces = "application/json",
		response = Film.class)
public ResponseEntity<List<Film>> cercaRegista(@RequestParam String regista) {
	try {log.info("La ricerca non è stata completata");
		return new ResponseEntity<List<Film>>(getFilmdao().trovaRegista(regista), HttpStatus.OK);
		}catch (Exception e) {return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.METHOD_NOT_ALLOWED);}}}


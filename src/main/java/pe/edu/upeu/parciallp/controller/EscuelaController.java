package pe.edu.upeu.parciallp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import pe.edu.upeu.parciallp.entity.Escuela;
import pe.edu.upeu.parciallp.entity.Facultad;
import pe.edu.upeu.parciallp.service.EscuelaService;
import pe.edu.upeu.parciallp.service.FacultadService;

@RestController
@RequestMapping("/api/escuela")
@CrossOrigin(origins = "http://localhost:4200")
public class EscuelaController {
    
    @Autowired
    private EscuelaService escuelaService;
    private FacultadService facultadService;

    @GetMapping
    public ResponseEntity<List<Escuela>> readAll() {
        try {
            List<Escuela> escuelas = escuelaService.readAll();
            if (escuelas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(escuelas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Escuela> create(@Valid @RequestBody Escuela esc) {
        try {
            Facultad facultad = facultadService.read(esc.getFacultad().find())
                                              .orElseThrow(() -> new EntityNotFoundException("Facultad no encontrada"));

            esc.setFacultad(facultad);

            Escuela e = escuelaService.create(esc);
            return new ResponseEntity<>(e, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escuela> getEscuelaId(@PathVariable("id") Long id){
		try {
			Escuela e = escuelaService.read(id).get();
			return new ResponseEntity<>(e, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEscuela(@PathVariable("id") Long id) {
        try {
            escuelaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEscuela(@PathVariable("id") Long id, @Valid @RequestBody Escuela esc){

		Optional<Escuela> e = escuelaService.read(id);
		if(!e.isEmpty()) {
			return new ResponseEntity<>(escuelaService.update(esc), HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.OK);
		}		
	
}
}

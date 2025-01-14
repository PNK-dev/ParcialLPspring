package pe.edu.upeu.parciallp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import pe.edu.upeu.parciallp.entity.Facultad;
import pe.edu.upeu.parciallp.service.FacultadService;

@RestController
@RequestMapping("/api/facultad")
@CrossOrigin(origins = "http://localhost:4200")
public class FacultadController {

    @Autowired
    private FacultadService facultadService;

    @GetMapping
    public ResponseEntity<List<Facultad>> readAll() {
        try {
            List<Facultad> facultades = facultadService.readAll();
            if (facultades.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(facultades, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Facultad> crear(@Valid @RequestBody Facultad fac) {
        try {
            Facultad f = facultadService.create(fac);
            return new ResponseEntity<>(f, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facultad> getFacultadId(@PathVariable("id") Long id){
		try {
			Facultad f = facultadService.read(id);
			return new ResponseEntity<>(f, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delFacultad(@PathVariable("id") Long id) {
        try {
            facultadService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFacultad(@PathVariable("id") Long id, @Valid @RequestBody Facultad fac){
		Facultad f = facultadService.update(fac);
		if (f.getIdfacultad()>0) {
			return new ResponseEntity<>(facultadService.update(fac), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}

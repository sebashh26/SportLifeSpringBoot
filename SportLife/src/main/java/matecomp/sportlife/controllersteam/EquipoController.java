package matecomp.sportlife.controllersteam;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

import matecomp.sportlife.modelsteam.Equipo;
import matecomp.sportlife.repositoriessteam.EquipoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EquipoController {

	@Autowired
	EquipoRepository equipoRepository;

	@GetMapping("/equipos")
	public List<Equipo> getAllEquipos() {
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
		return equipoRepository.findAll(sortByCreatedAtDesc);
	}

	@PutMapping(value = "/equipos/{id}")
	public ResponseEntity<Equipo> updateEquipo(@PathVariable("id") String id, @Valid @RequestBody Equipo equipo) {
		Equipo equipoData = equipoRepository.findOne(id);
		if (equipoData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		equipoData.setTitle(equipo.getTitle());
		equipoData.setCompleted(equipo.getCompleted());
		Equipo updatedEquipo = equipoRepository.save(equipoData);
		return new ResponseEntity<>(updatedEquipo, HttpStatus.OK);
	}

	@PostMapping("/equipos")
	public Equipo createEquipo(@Valid @RequestBody Equipo equipo) {
		equipo.setCompleted(false);
		return equipoRepository.save(equipo);
	}

	@GetMapping(value = "/equipos/{id}")
	public ResponseEntity<Equipo> getEquipoById(@PathVariable("id") String id) {
		Equipo equipo = equipoRepository.findOne(id);
		if (equipo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(equipo, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/equipos/{id}")
	public void deleteEquipo(@PathVariable("id") String id) {
		equipoRepository.delete(id);
	}
}
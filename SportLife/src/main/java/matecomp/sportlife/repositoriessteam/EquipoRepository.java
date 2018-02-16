package matecomp.sportlife.repositoriessteam;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import matecomp.sportlife.modelsteam.Equipo;
@Repository
public interface EquipoRepository extends MongoRepository<Equipo, String> {



}

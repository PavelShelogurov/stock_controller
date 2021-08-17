package dev.stockController.repository;

import dev.stockController.model.Instrument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstrumentRepository extends MongoRepository<Instrument, String> {
    Optional<Instrument> findByName(String name);
}

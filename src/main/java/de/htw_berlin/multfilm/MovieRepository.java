package de.htw_berlin.multfilm;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieDto, Long> { }

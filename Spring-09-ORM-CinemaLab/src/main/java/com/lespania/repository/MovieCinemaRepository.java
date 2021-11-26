package com.lespania.repository;

import com.lespania.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {
}

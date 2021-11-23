package com.lespania.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MovieCinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieCinemaId;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    public MovieCinema(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "MovieCinema{" +
                "dateTime=" + dateTime +
                '}';
    }

}

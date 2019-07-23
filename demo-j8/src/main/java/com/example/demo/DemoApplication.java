package com.example.demo;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    RouterFunction<?> routes(ReservationRouterHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/all"), handler::all);
    }

    @Bean
    CommandLineRunner runner(ReservationRepository reservationRepository) {
        return args -> {
            reservationRepository.deleteAll()
                    .thenMany(Flux.just("Blanch Netter",
                            "Cleta Carlile",
                            "Sharla Sartwell",
                            "Aiko Whitmore",
                            "Krystina Kummer",
                            "Shelley Napolitano",
                            "Devon Knauf",
                            "Felecia Odea",
                            "Crystal Gourley",
                            "Brenna Garrity",
                            "Darcel Rieger",
                            "Lizzette Baskin",
                            "Genie Helfrich",
                            "Hanna Simmer",
                            "Lenore Swick",
                            "Raphael Bohon",
                            "Danilo Mitschke",
                            "Argelia Parsley",
                            "Horacio Macomber",
                            "Thaddeus Carson",
                            "Larraine Mccracken",
                            "Shannon Livesay",
                            "Tracie Schultheis",
                            "Almeda Lemond",
                            "Harry Mcquade",
                            "Kasie Dally",
                            "James Pinette",
                            "Walter Hertz",
                            "Emelina Babineaux",
                            "Barton Jagger",
                            "Tom Gianni",
                            "Nana Kegler",
                            "Hannelore Press",
                            "Duane Lagarde",
                            "Leonardo Nails",
                            "Arline Dunkin",
                            "Marjorie Lemon",
                            "Piedad Ellery",
                            "Denna Angus",
                            "Tawnya Tritt",
                            "Layla Boyster",
                            "Jed Redmon",
                            "Fran Mounce",
                            "Pauletta Leeman",
                            "Bianca Edwards",
                            "Berneice Cotter",
                            "Tameka Lindenberg",
                            "Melissa Cancel",
                            "Rachel Graver",
                            "Ria Mcdowell").map(name ->
                            new Reservation(UUID.randomUUID().toString(), name))
                            .flatMap(reservationRepository::save))
                    .subscribe();

            reservationRepository.findAll().subscribe(System.out::println);
        };
    }

}

@Component
class ReservationRouterHandler {

    private final ReservationService service;

    ReservationRouterHandler(ReservationService service) {
        this.service = service;
    }

    public Mono<ServerResponse> all(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(service.all(), Reservation.class)
                .doOnError(throwable -> new IllegalStateException("Oh NOO!!"));
    }
}


@Service
class ReservationService {

    private final ReservationRepository reservationRepository;

    ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Flux<Reservation> all() {
        return reservationRepository.findAll();
    }


}


@Repository
interface ReservationRepository extends ReactiveCrudRepository<Reservation, Long> {
}


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("reservation")
class Reservation {

    private String id;
    private String name;

}

@Configuration
@EnableR2dbcRepositories
class PostgresConfig extends AbstractR2dbcConfiguration {

    @Override
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.
                        builder()
                        .host("postgres")
                        .port(5432)
                        .username("root")
                        .password("root")
                        .database("testepostgres")
                        .build());
    }
}

package br.com.alura.dojoplaces.Place;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    boolean existsByCode(String code);

}

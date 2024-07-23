package com.spds.ecommerce.dao;
import com.spds.ecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
//@RepositoryRestResource
public interface CountryRepository extends JpaRepository<Country, Integer> {
}

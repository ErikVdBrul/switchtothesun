package com.example.country;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class CountryService {
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.getAllCountries();
    }

    public void addCountry(CountryDTO country) {
        countryRepository.addCountry(new Country(country.name()));
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteCountry(id);
    }

}

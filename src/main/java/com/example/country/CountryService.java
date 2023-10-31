package com.example.country;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import com.example.continent.ContinentRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class CountryService {
    private CountryRepository countryRepository;
    private ContinentRepository continentRepository;

    public CountryService(CountryRepository countryRepository, ContinentRepository continentRepository) {
        this.countryRepository = countryRepository;
        this.continentRepository = continentRepository;
    }

    public List<CountryDTO> getAllCountries() {
        return countryRepository.getAllCountries()
                .stream()
                .map(c -> toDTO(c))
                .toList();
    }

    public void addCountry(CountryDTO country) {
        countryRepository.addCountry(new Country(country.name()));
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteCountry(id);
    }

    private CountryDTO toDTO(Country c) {
        return new CountryDTO(c.getId(), c.getName(), c.getPopulation(), c.getLandArea(), c.getGdp());
    }

    public List<CountryDTO> getAllCountriesByContinent(String continent) {
        return continentRepository.findContinentByName(continent)
                .getCountryList()
                .stream()
                .map(c -> toDTO(c))
                .collect(Collectors.toList());
    }

}

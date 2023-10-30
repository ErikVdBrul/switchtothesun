package com.example.attraction;

import com.example.country.Country;

public record AttractionDTO(Long id,
                            String name,
                            AttractionType type,
                            Country country) {
}

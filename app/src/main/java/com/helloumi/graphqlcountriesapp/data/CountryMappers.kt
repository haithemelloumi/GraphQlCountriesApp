package com.helloumi.graphqlcountriesapp.data

import com.helloumi.graphqlcountriesapp.domain.DetailedCountry
import com.helloumi.graphqlcountriesapp.domain.SimpleCountry
import com.helloumi.CountriesQuery
import com.helloumi.CountryQuery

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.map { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
    )
}

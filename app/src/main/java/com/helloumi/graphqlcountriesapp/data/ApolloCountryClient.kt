package com.helloumi.graphqlcountriesapp.data


import com.apollographql.apollo.ApolloClient
import com.helloumi.graphqlcountriesapp.domain.CountryClient
import com.helloumi.graphqlcountriesapp.domain.DetailedCountry
import com.helloumi.graphqlcountriesapp.domain.SimpleCountry
import com.helloumi.CountriesQuery
import com.helloumi.CountryQuery


class ApolloCountryClient(
    private val apolloClient: ApolloClient
): CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: listOf()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}

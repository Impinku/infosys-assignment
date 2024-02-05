@Project
Feature: iTunes search API

  @TC=1
  Scenario: Validate i tunes search api with parameter with URL-encoded
    Given Call i tunes search api with encoded url with parameter "term" as "jack johnson"
    Then Verify status code is "200"
    Then Verify result count is "50"

  @TC=2
  Scenario: The two-letter country code for the store you want to search
    Given Call i tunes search api with encoded url with parameters "term" as "jack johnson" and "country" as "us"
    Then Verify status code is "200"
    Then Verify result count is "50"
    # Tested with country code us,ca,in etc.....

  @TC=3
  Scenario: Validate i tunes search api with term and media parameters
    Given Call i tunes search api with encoded url with parameters "term" as "jack johnson" and "media" as "all"
    Then Verify status code is "200"
    Then Verify result count is "50"
    #You can add all(default),movie(count=3), podcast(count=9), music(count=50), musicVideo, audiobook, shortFilm, tvShow, software, ebook

  @TC=4
  Scenario: Validate i tunes search api with term and entity parameters
    Given Call i tunes search api with encoded url with parameters "term" as "jack johnson" and "entity" as "musicVideo"
    Then Verify status code is "200"
    Then Verify result count is "16"
    Then Verify WrapperType is "track"


  @TC=5
  Scenario: Validate i tunes search api with term and Attributes parameter
    Given Call i tunes search api with encoded url with parameters "term" as "maroon" and "entity" as "allArtist" and "attribute" as "allArtistTerm"
    Then Verify status code is "200"
    Then Verify result count is "16"
    Then Verify WrapperType is "artist"
    Then Verify artistName is "Maroon 5"

  @TC=6
  Scenario: The number of search results you want the iTunes Store to return.
    Given Call i tunes search api with encoded url with parameters "term" as "jack johnson" and "limit" as "25"
    Then Verify status code is "200"
    Then Verify result count is "25"

  @TC=7
  Scenario: A flag indicating whether or not you want to include explicit content in your search results
    Given Call i tunes search api with encoded url with parameters "term" as "jack johnson" and "limit" as "25"
    Then Verify status code is "200"
    Then Verify result count is "25"
    Then Verify collectionExplicitness is "Yes"

  @TC=8
  Scenario: The language, English or Japanese, you want to use when returning search results. Specify the language using the five-letter codename
    Given Call i tunes search api with encoded url with parameters "media" as "movie" and "term" as "jack johnson"
    Then Verify status code is "200"
    Then Verify result count is "3"


  @TC=9
  Scenario: Validate i tunes search api with term and canada i tunes store parameter
    Given Call i tunes search api with "jim+jones" and country "ca"
    Then Verify status code is "200"
    Then Verify result count is "50"

  @TC=10
  Scenario: Validate i tunes search api with term and united states i tunes store and entity parameter
    Given Call i tunes search api with "yelp" and country "us" and entity "software"
    Then Verify status code is "200"
    Then Verify result count is "50"

  @TC=11
  Scenario: Validate i tunes search api with invalid parameter
    Given Call i tunes search api with invalid param
    Then Verify status code is "400"
    Then Verify result count is "0"

  @TC=12
  Scenario: Validate The search result key version you want to receive back from your search. The default is 2
    Given Call i tunes search api with encoded url with parameters "term" as "jack johnson" and "media" as "all"
    Then Verify status code is "200"
    Then Verify result count is "50"
    Then Verify version number is "2"
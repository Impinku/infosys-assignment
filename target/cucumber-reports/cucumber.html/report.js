$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/iTunesSearchAPI.feature");
formatter.feature({
  "name": "iTunes search API",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Project"
    }
  ]
});
formatter.scenario({
  "name": "Validate The search result key version you want to receive back from your search. The default is 2",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Project"
    },
    {
      "name": "@TC\u003d12"
    }
  ]
});
formatter.step({
  "name": "Call i tunes search api with encoded url with parameters \"term\" as \"jack johnson\" and \"media\" as \"all\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.Call_i_tunes_search_api_with_encoded_url_with_multiple_parameter(String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify status code is \"200\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.Verify_status_code_is_200(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify result count is \"50\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.Verify_result_count_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify version number is \"2\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.Verify_version_number_is(int)"
});
formatter.result({
  "status": "passed"
});
});
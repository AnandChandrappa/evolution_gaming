$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/favorites.feature");
formatter.feature({
  "name": "Validating Favourites scenarios",
  "description": "  As a user I should be able to search Adds and add them to Favourites and remove",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@EvolutionGaming"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Search Advertisements through navigation and add to Favourites and verify count",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I click on \"\u003cCategory\u003e\" link under \"\u003cSection\u003e\" section",
  "keyword": "When "
});
formatter.step({
  "name": "I click on \"\u003cSubcategory\u003e\" link",
  "keyword": "And "
});
formatter.step({
  "name": "I navigate to Adds result page",
  "keyword": "Then "
});
formatter.step({
  "name": "I select first \"\u003ccount\u003e\" advertisements in result page",
  "keyword": "And "
});
formatter.step({
  "name": "I click on Add selected to Memo",
  "keyword": "And "
});
formatter.step({
  "name": "I go to Memo and verify advertisements count as \"\u003ccount\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Category",
        "Section",
        "Subcategory",
        "count"
      ]
    },
    {
      "cells": [
        "Plumbing",
        "Construction",
        "Boilers",
        "3"
      ]
    }
  ]
});
formatter.background({
  "name": "Open browser",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on Adds homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.user_is_on_Adds_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Search Advertisements through navigation and add to Favourites and verify count",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@EvolutionGaming"
    }
  ]
});
formatter.step({
  "name": "I click on \"Plumbing\" link under \"Construction\" section",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.iClickOnLinkUnderSection(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"Boilers\" link",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.i_click_on_link(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to Adds result page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.iNavigateToAddsResultPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select first \"3\" advertisements in result page",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.iSelectFirstAdvertisementsInResultPage(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Add selected to Memo",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.iClickOnAddSelectedToMemo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I go to Memo and verify advertisements count as \"3\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.iGoToMemoAndVerifyAdvertisementsCountAs(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Open browser",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on Adds homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.user_is_on_Adds_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "To verify funcationality of remove adds from favourites",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@EvolutionGaming"
    }
  ]
});
formatter.step({
  "name": "I click on \"Special clothing\" link under \"Clothes\" section",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.iClickOnLinkUnderSection(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to Adds result page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.iNavigateToAddsResultPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select first \"4\" advertisements in result page",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.iSelectFirstAdvertisementsInResultPage(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Add selected to Memo",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.iClickOnAddSelectedToMemo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I go to Memo and verify advertisements count as \"4\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.iGoToMemoAndVerifyAdvertisementsCountAs(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I remove an Add and from Memo and verify the adds count",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.favourites_steps.iRemoveAnAddAndFromMemoAndVerifyTheAddsCount()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
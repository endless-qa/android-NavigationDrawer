
Android Navigation Drawer Sample UI Testing
===================================

The following basic functionality is covered by the automated tests:
- displaying the default planet on app start and validating the available planets (BasicFunctionalityTests);
- selecting a planet from the menu and validating that through the correct title and the image displayed (PlanetSelectionFeatureParametrizedTests);
- initiating quick search for a currently opened planet and validating intents sent (QuickSearchFeatureTests).

Tests Design Approach
--------------

The PageObject design pattern is used for designing the framework, encapsulating the logic of UI interaction and separation it from the business logic in tests. 

All classes with functional tests extend the BaseTestModel parent class which contains initialization logic before each test (navigating to the NavigationDrawerActivity) and screenshot taking logic after each test. The BaseTestModel class in turn extends the TestHelper class which holds extra methods that make tester's life easier (handling the arisen QuickSearch, getting current activity).

As Espresso doesn't have a matcher for asserting image from resources on a view out-of-the-box, the DrawableMatcher has been created. It serves the purpose of validating that a correct drawable is displayed on an ImageView, using its name as a search criteria (makes sence for the sample app). As there might be many custom matchers in future, there is the CustomMatchers wrapper class that aligns the DrawableMatcher usage with the Esspresso-like style.

Running Tests
---------------

**Spoon** framework is configured for running tests on multiple connected devices, taking screenshots after each test and generating a final report. In order to run tests, navigate to the project's root folder, run the **gradlew spoon** command, wait for the tests to be executed on all connected devices and find a final report in the **\Application\build\spoon-output** folder.
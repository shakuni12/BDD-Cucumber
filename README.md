To run the project, where you have clone the repository open cmd to that path and run command mvn clean and mvn install(maven and java should be installed in system).
At the time of browser launch if code is throwing exception then webdriver is not compatible with browser, check the browser version and download and replace same version webdriver in src/test/java/resources/Drivers.
Browser can be changed from config.properties browser=chrome for chrome browser and browser=firefox for mozilla
Last step is failing to show the failure screenshot. To verify report refresh the project after run and check target folder there will be index.html.

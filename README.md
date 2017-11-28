# OpenBDT
___

##### - Installing/updating all dependencies:
- Inside OpenBDT project folder:
```sh
    cd openbdt
    mvn install -DskipTests
 ````
- The dependencies should be installed in your local maven repository.

##### - Running the sample test:

- Set the 'webdriver.chrome.driver' key's value in 'thucydides.properties' to the chrome driver location
- Set where serenity-bdd report will be saved changing the 'serenity.outputDirectory' key value to a folder location in your local file system ( may not exist).
- Inside project folder, insert the command:
```sh
    mvn verify io.openbdt:openbdt.plugin.maven:format-report
```
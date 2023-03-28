FROM xscntrlregprod.azurecr.io/soa/dtw/dtwcore/docker/dtautomation:1.0

COPY src home/masterframework/src

COPY ExtentReport.html home/masterframework/extentreport.html

COPY pom.xml home/masterframework/pom.xml

COPY testng.xml home/masterframework/testng.xml

WORKDIR home/masterframework

## Running tests
RUN mvn clean test



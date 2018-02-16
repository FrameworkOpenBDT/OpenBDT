
# OpenBDT Framework
Considering you are using maven as a dependency manager of your project, do the following instructions.
#### How to Install/update this artifact?
 Inside OpenBDT project folder, type the command bellow in console:
```
    mvn install -DskipTests
```
- The following dependencies will be installed:
	- openbdt.core
	- openbdt.report
	- openbdt.plugin.maven
	
 Those dependencies should be installed in your local maven repository.

#### How would I use this framework?
This framework is designed to make you think and produce testing scripts in the most easy way possible, therefore is always important to let you focus in the important thing (the business side of the project).
Currently, you can make your testing scripts to web browsers, smartphones and desktop.
For each target device, there is an specific artifact that must be included in your project pom.xml file.

### Web Testing
---
The following artifact must be installed:

- [openbdt.web](https://github.com/FrameworkOpenBDT/openbdt.web)

#### Archetype
You can easily generate your web testing project by the [openbdt web archetype](https://github.com/FrameworkOpenBDT/archetype-web).

#### Demo
To use this [demo project](https://github.com/FrameworkOpenBDT/sample-master) is necessary to have these libraries already installed:
- The OpenBDT framework
- [openbdt.web](https://github.com/FrameworkOpenBDT/openbdt.web)
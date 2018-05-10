# OpenBDT Framework
Considering you are using maven as a dependency manager of your project, do the following instructions.
#### How to Install/update this artifact?
 Inside OpenBDT project folder, type the command bellow in console:
```
    mvn install -DskipTests
```
- The following dependencies will be installed:
	- openbdt
	- openbdt.core
	- openbdt.report
	- openbdt.plugin.maven
	- openbdt.web
		- openbdt.adapter.selenium
		- openbdt.web-starter
	- openbdt.mobile
		- openbdt.adapter.appium
		- openbdt.mobile-starter
	- openbdt.desktop
		- openbdt.adapter.desktop
		- openbdt.desktop-starter
	
 Those dependencies should be installed in your local maven repository.

## How would I use this framework?
This framework is designed to make you think and produce testing scripts in the most easy way possible, therefore is always important to let you focus in the important thing (the business side of the project).
Currently, you can make your testing scripts to web browsers, smartphones and desktop.
For each target device there is an specific project setup. 

### Web Testing
---
#### Archetype
You can easily generate your web testing project from the [openbdt web archetype](https://github.com/FrameworkOpenBDT/archetype-web).

### Mobile Testing
---
#### Archetype
You can easily generate your mobile testing project from the [openbdt mobile archetype](https://github.com/FrameworkOpenBDT/archetype-mobile).

### Desktop Testing
---
#### Archetype
You can easily generate your desktop testing project from the [openbdt desktop archetype](https://github.com/FrameworkOpenBDT/archetype-desktop).

## Wiki

The wiki is currently available at https://github.com/FrameworkOpenBDT/archetype-web/wiki.
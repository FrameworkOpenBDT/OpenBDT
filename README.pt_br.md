

# OpenBDT Framework
Considerando que este projeto utiliza o maven como gerenciador de dependências, faça os seguintes procedimentos. 
## Como instalar/atualizar este Framework? 
 Dentro da pasta Openbdt, digite o comando abaixo no console:
```
    mvn install -DskipTests
```
- As seguintes dependências serão instaladas:
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
	
Estas dependências deverão ser instaladas no repositório local de sua máquina.

## Como posso estar utilizando este Framework?
Este Framework foi desenvolvido para buscar facilitar sua vida no que se refere a teste automatizado, portanto é sempre importante focar no que é mais importante (menos configuração e consequentemente mais produtividade). 
Atualmente, você poderá desenvolver seus scripts de teste para navegadores, dispositivos móveis e computadores de mesa. 
Para cada dispositivo alvo há um projeto correspondente.

### Testando Navegadores
---
#### Archetype
Você pode, facilmente, gerar seu projeto para teste de navegadores usando o  [archetype do openbdt para web](https://github.com/FrameworkOpenBDT/archetype-web).

### Testando dispositivos móveis
---
#### Archetype
Você pode, de forma tranquila, gerar seu projeto de teste automatizado para dispositivos móveis utilizando o [archetype openbdt para celulares](https://github.com/FrameworkOpenBDT/archetype-mobile).

### Testando aplicações em Desktop
---
#### Archetype
Você poderá gerar seu projeto de  automação desktop com o [archetype do openbdt para pc](https://github.com/FrameworkOpenBDT/archetype-desktop).
## Bugs?
Encontrou algum bug? Gostaria de uma melhoria ou tem uma sugestão? Então por quê não criar uma bem detalhada? Desta forma, nós poderemos retornar um feedback, ou até mesmo uma solução da maneira mais rápida possível.
## Wiki

Em caso de dúvidas consulte a wiki que pode ser encontrada nesse link: https://github.com/FrameworkOpenBDT/archetype-web/wiki.
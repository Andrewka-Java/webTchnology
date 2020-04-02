## Андрей Мурин

Лабораторные работы по курсу веб-технологии ИПКиП БрГТУ.

Структура модулей webTechnology:

	- webService
	- webClient
		

## Описание:
Данный проект включает в себя веб-сервер и веб-клиент.
Общение между приложениями основано на SOAP-сообщениях.


## Процесс запуска приложений

1. Откройте проект webService и выполните:
	- mvn clean compile
	- Будут сгенерированы Java-классы(сущность, объекты запроса и ответа) из xsd-схемы.

2. Запустите класс Application.java в webService.
	- В браузере по адрессу http://localhost:8080/ws/dish.wsdl будет доступно wsdl-описание.
	
3. Откройте проект webClient и выполните:
	- mvn clean compile
	- Будут сгенерированы Java-классы(сущность, объекты запроса и ответа) из wsdl-схемы указанной пунктом выше.

4. Запустите класс Application.java в webClient.
	- В браузере по адрессу http://localhost:8088/index будет доступно приложение.
	
4. Для завершения приложения следует остановить стартовые классы(Application.java)
	- Если под Linux возникли проблемы с остановкой приложения, введите в терминал следущее:
	- fuser -n tcp -k 8080 (убьет выбранный порт) 

## Технологии

При написании приложения использовались следующие технологии:
- Maven
- Spring Boot
- Spring WS
- MyBatis
- Thymeleaf


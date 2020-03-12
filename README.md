## Андрей Мурин

Лабораторные работы по курсу веб-технологии ИПКиП БрГТУ

Структура модулей webTechnology:

moduleName:
	src:
		main/java/com.webtechnology:
			controllers:
				CookController.java
			dao:
				DishDao.java(Интерфейс)
			model:
				Dish.java

			Application.java (Start.java)
			

		resources:
			static:
				css:
					style.css
				img:
					images.jpg
		templates:
			ftl-templates(шаблоны Freemarker)

		application.properties
		shema.sql
		data.sql

## Описание:
Для сборки проекта используется технолоигия Maven. 
Spring Boot содержит встроенный контейнер сервлетов - Tomcat, который разворачивает приложение на 8080 порту по умолчанию.
	Выполняет скрипты schema.sql и data.sql по умолчанию.
	shema.sql - содержит описание схемы таблицы.
	data.sql -  заполняет таблицу значениями по умолчанию
MyBatis используется для выполнения sql-скриптов в БД(CRUD-операции).
Freemarker - шаблонизатор, для отображения данных на стороне клиента(в браузере).

## Процесс запуска приложения

1. Откройте проект и перейдите в соответсвующий модуль, выполните*:
	mvn clean install

2. Запустите класс Application.java или Start.class* 

3. Перейдите в браузер и в URL введите*:
	localhost:8080/index

4. Для завершения приложения следует остановить стартовый класс(Application.java или Start.java)
	Если под Linux возникли проблемы с остановкой приложения, введите в терминал следущее:
	
	fuser -n tcp -k 8080 (убьет выбранный порт) 

Примечание *: данные пункты не нужно выполнять для лабораторной работы 1

## Технологии

При написании приложения использовались следующие технологии:
- Maven
- Spring Boot
- MyBatis
- Freemarker


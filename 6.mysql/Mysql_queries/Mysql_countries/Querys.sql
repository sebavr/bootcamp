/*1. ¿Qué consulta harías para obtener todos los países que hablan esloveno? 
Tu consulta debe devolver el nombre del país, el idioma y el porcentaje de idioma. 
Tu consulta debe organizar el resultado por porcentaje de idioma en orden descendente. (1)*/

SELECT countries.name, languages.language, languages.percentage
from countries
join languages on countries.id=languages.country_id
where language='Slovene'
order by languages.percentage desc;

/*2. ¿Qué consulta ejecutarías para mostrar el número total de ciudades para cada país? 
Su consulta debe devolver el nombre del país y el número total de ciudades. 
Tu consulta debe organizar el resultado por el número de ciudades en orden descendente. (3)*/

SELECT countries.name, count(cities.name) as cities
from countries
join cities on countries.id=cities.country_id
group by countries.name
order by count(cities.name) desc;

/*3. ¿Qué consulta harías para obtener todas las ciudades de México con una población de más de 500,000? 
Tu consulta debe organizar el resultado por población en orden descendente. (1)*/

SELECT cities.name, cities.population
from cities
join countries on countries.id=cities.country_id
where countries.name='mexico' and cities.population >500000
order by cities.population desc;

/*4. ¿Qué consulta ejecutarías para obtener todos los idiomas en cada país con un porcentaje
 superior al 89%? Tu consulta debe organizar el resultado por porcentaje en orden descendente. (1)*/
 
SELECT countries.name, languages.language, languages.percentage
from countries
join languages on countries.id=languages.country_id
where languages.percentage>89
order by languages.percentage desc;

/*5. ¿Qué consulta haría para obtener todos los países con un área de superficie inferior a 501 
y una población superior a 100,000? (2)*/

SELECT countries.name, countries.surface_area, cities.population
from countries
 join cities on countries.id=cities.country_id
where countries.surface_area<501 and cities.population >100000
group by countries.name;


/*6. ¿Qué consulta harías para obtener países con solo Monarquía Constitucional con un capital
 superior a 200 y una esperanza de vida superior a 75 años? (1)*/
 
 SELECT countries.name,countries.government_form, countries.capital,countries.life_expectancy
 from countries
 where countries.government_form='Constitutional Monarchy' and countries.capital>200 and countries.life_expectancy>75;

/*7. ¿Qué consulta harías para obtener todas las ciudades de Argentina dentro del distrito de Buenos Aires
 y tener una población superior a 500,000? La consulta debe devolver el nombre del país,
 el nombre de la ciudad, el distrito y la población. (2)*/
 
  SELECT countries.name, cities.name , cities.district,cities.population
  from countries
  join cities on countries.id=cities.country_id
  where countries.name='argentina' and cities.population>500000 and cities.district='Buenos Aires' ;
  
  /*8. ¿Qué consulta harías para resumir el número de países en cada región? 
  La consulta debe mostrar el nombre de la región y el número de países. 
  Además, la consulta debe organizar el resultado por el número de países en orden descendente. (2)*/
  
  SELECT countries.region, count(countries.id) as paises
  from countries
  group by countries.region
  order by  count(countries.id) desc;
  

  

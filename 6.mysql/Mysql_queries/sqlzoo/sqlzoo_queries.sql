/*------------------------------SELECT basics---------------------------------------*/

/*1.The example uses a WHERE clause to show the population of 'France'. Note that strings
 (pieces of text that are data) should be in 'single quotes';*/
 
 SELECT population FROM world
  WHERE name = 'Germany';
  
  
/*2.Checking a list The word IN allows us to check if an item is in a list. 
The example shows the name and population for the countries 'Brazil', 'Russia', 'India' and 'China'.
Show the name and the population for 'Sweden', 'Norway' and 'Denmark'.*/

SELECT name, population,gdp FROM world
  WHERE name IN ('Sweden', 'Norway', 'Denmark','Chile');
  
/*3.Which countries are not too small and not too big? BETWEEN allows range checking (range specified is inclusive of boundary values). The example below shows countries with an area of 250,000-300,000 sq. km. Modify it to show the country and the area for countries with an area between 200,000 and 250,000.*/
  
SELECT name, area FROM world
  WHERE area BETWEEN 200000 AND 250000;
  
  
/*------------------------------SELECT NAMES---------------------------------------*/

/*1.Find the country that start with Y*/
SELECT name FROM world
  WHERE name LIKE 'Y%';
  
  /*2.Find the countries that end with y*/
  
  SELECT name FROM world
  WHERE name LIKE '%Y';
  
  
  
  
  
  
  
  
  

/*3.
Give the name and the per capita GDP for those countries with a population of at least 200 million.*/

SELECT name,gdp/population AS per_capita_GDP
FROM world
WHERE population > 200000000;

/*4.
Show the name and population in millions for the countries of the continent 
'South America'. Divide the population by 1000000 to get population in millions.*/

SELECT name, population/1000000 
FROM world
WHERE continent like 'South America';

/*5.
Show the name and population for France, Germany, Italy*/

select name, population
from world
where name in ('france','germany','italy');

/*6.
Show the countries which have a name that includes the word 'United'*/

select name from world
where name like '%united%';

/*7.
Two ways to be big: A country is big if it has an area of more than 3 million sq km or it has 
a population of more than 250 million.
Show the countries that are big by area or big by population. Show name, population and area.*/

select name,population, area from world
where area>3000000 or population >250000000;

/*8.
Exclusive OR (XOR). Show the countries that are big by area (more than 3 million) or big by population (more than 250 million) but not both. Show name, population and area.
Australia has a big area but a small population, it should be included.
Indonesia has a big population but a small area, it should be included.
China has a big population and big area, it should be excluded.
United Kingdom has a small population and a small area, it should be excluded.*/

select  name,population, area from world
where   not( name in ('United States','china','india')) and area>3000000 or population >250000000 and not(area>3000000 or population >250000000 );

/*2--------------------------------------- SELECT from World-----------------------------*/

/*1.Observe the result of running this SQL command to show the name, 
continent and population of all countries.*/

SELECT name, continent, population FROM world;

/*2.Show the name for the countries that have a population of at least 200 million.
 200 million is 200000000, there are eight zeros.*/

SELECT name
  FROM world
 WHERE population > 200000000;
 

/*3.Give the name and the per capita GDP for those countries with a population of at least 200 million.*/

SELECT name,gdp/population AS per_capita_GDP
FROM world
WHERE population > 200000000;

/*4.
Show the name and population in millions for the countries of the continent 'South America'.
 Divide the population by 1000000 to get population in millions.*/
 
 SELECT name, population/1000000 
FROM world
WHERE continent like 'South America';

/*5.Show the name and population for France, Germany, Italy*/

select name, population
from world
where name in ('france','germany','italy');

/*6.Show the countries which have a name that includes the word 'United'*/

select name from world
where name like '%united%';

/*.7.Two ways to be big: A country is big if it has an area of more than 3 million sq km or it
 has a population of more than 250 million.Show the countries that are big by area or big 
 by population. Show name, population and area.*/

select name,population, area from world
where area>3000000 or population >250000000;

/*2--------------------------------------- SELECT names-----------------------------*/


/*1.Find the country that start with Y*/

SELECT name FROM world
  WHERE name LIKE 'Y%';

/*2.Find the countries that end with y*/

SELECT name FROM world
  WHERE name LIKE '%Y';

/*3.Find the countries that contain the letter x*/

SELECT name FROM world
  WHERE name LIKE '%x%';

/*4.Find the countries that end with land*/

SELECT name FROM world
  WHERE name LIKE '%land';

/*5.Find the countries that start with C and end with ia*/

SELECT name FROM world
  WHERE name LIKE 'c%ia';

/*6.Find the country that has oo in the name*/

SELECT name FROM world
  WHERE name LIKE '%oo%';

/*7.Find the countries that have three or more a in the name*/

SELECT name FROM world
  WHERE name LIKE '%a%a%a%';


/*8.Find the countries that have "t" as the second character.*/

SELECT name FROM world
 WHERE name LIKE '_t%'
ORDER BY name;

/*9.Lesotho and Moldova both have two o characters separated by two other characters.

Find the countries that have two "o" characters separated by two others.*/

SELECT name FROM world
 WHERE name LIKE '%o__o%';


/*10.Cuba and Togo have four characters names.

Find the countries that have exactly four characters.*/

SELECT name FROM world
 WHERE name LIKE '____';


/*11.The capital of Luxembourg is Luxembourg. Show all the countries where the capital is the same as the name of the country

Find the country where the name is the capital city.*/

SELECT name
  FROM world
 WHERE name =capital;

/*12.The capital of Mexico is Mexico City. Show all the countries where the capital has the country together with the word "City".

Find the country where the capital is the country plus "City".*/


SELECT name
  FROM world
 WHERE capital LIKE concat(name, ' city');


/*13.Find the capital and the name where the capital includes the name of the country.*/

SELECT capital, name
  FROM world
 WHERE name =capital;

/*14.Find the capital and the name where the capital is an extension of name of the country.

You should include Mexico City as it is longer than Mexico. You should not include Luxembourg as the capital is the same as the country.*/

SELECT capital, name
  FROM world
 WHERE capital  like concat(name,'_%');


/*15.
For Monaco-Ville the name is Monaco and the extension is -Ville.

Show the name and the extension where the capital is an extension of name of the country.

You can use the SQL function REPLACE.*/

SELECT name, REPLACE(capital, name, '') extension, capital
FROM world
 WHERE capital LIKE concat('%', name, '%')
AND capital > name;




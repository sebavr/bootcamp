-- 1.List each country name where the population is larger than that of 'Russia'


SELECT name FROM world
  WHERE population >
     (SELECT population FROM world
      WHERE name='Russia');

-- 2.Show the countries in Europe with a per capita GDP greater than 'United Kingdom'.


SELECT name FROM world
  WHERE gdp/population >
     (SELECT gdp/population FROM world
      WHERE name='United Kingdom') and continent='Europe';
      

-- 3.List the name and continent of countries in the continents containing either Argentina or Australia. Order by name of the country.


SELECT name,continent  FROM world
  WHERE continent in
     (SELECT continent FROM world
      WHERE name='Argentina' or  name='Australia');
      
      

-- 4.Which country has a population that is more than Canada but less than Poland? Show the name and the population.
 
SELECT name,population FROM world
  WHERE population >
     (SELECT population FROM world
      WHERE name='Canada') and population <
     (SELECT population FROM world
      WHERE name='Poland');
      
-- 5.Show the name and the population of each country in Europe. Show the population as a percentage of the population of Germany.

SELECT name,concat(round(population/(select population from world where name='Germany')*100,0),'%') FROM world WHERE continent='Europe'


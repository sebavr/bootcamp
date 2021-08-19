-- 1.List the films where the yr is 1962 [Show id, title]

SELECT id, title
 FROM movie
 WHERE yr=1962;
 
 -- 2. Give year of 'Citizen Kane'.
 
 SELECT yr
 FROM movie
 WHERE title='Citizen Kane';
 
 -- 3.List all of the Star Trek movies, include the id, title and yr (all of these movies include the words Star Trek in the title). Order results by year.
 
 select id, title,yr
from movie
where title like '%Star Trek%';

-- 4. What id number does the actor 'Glenn Close' have?

select id
from actor
where name like 'Glenn Close';


-- 5.What is the id of the film 'Casablanca'
select id
from movie
where title like  'Casablanca';

-- 6.The cast list is the names of the actors who were in the movie.

SELECT name
  FROM movie, casting, actor
  WHERE title='Casablanca'
    AND movieid=movie.id
    AND actorid=actor.id
;

-- 7.Obtain the cast list for the film 'Alien'

SELECT name
  FROM movie, casting, actor
  WHERE title='Alien'
    AND movieid=movie.id
    AND actorid=actor.id
;

-- 8.List the films in which 'Harrison Ford' has appeared

SELECT title
  FROM movie, casting, actor
  WHERE name='Harrison Ford'
    AND movieid=movie.id
    AND actorid=actor.id
;

-- 9. List the films where 'Harrison Ford' has appeared - but not in the starring role. [Note: the ord field of casting gives the position of the actor. If ord=1 then this actor is in the starring role]

SELECT title
  FROM movie, casting, actor
  WHERE name='Harrison Ford' and ord!=1
    AND movieid=movie.id
    AND actorid=actor.id
;

-- 10.List the films together with the leading star for all 1962 films.

SELECT  title, name
  FROM movie, casting, actor
  WHERE yr='1962' and ord=1
    AND movieid=movie.id
    AND actorid=actor.id
;

-- 11. Which were the busiest years for 'Rock Hudson', show the year and the number of movies he made each year for any year in which he made more than 2 movies.

SELECT yr,COUNT(title) FROM
  movie JOIN casting ON movie.id=movieid
        JOIN actor   ON actorid=actor.id
WHERE name='Doris Day'
GROUP BY yr
HAVING COUNT(title) > 1;

-- 12. List the film title and the leading actor for all of the films 'Julie Andrews' played in.

SELECT title, name
  FROM movie, casting, actor
  WHERE name='Julie Andrews' 
    AND movieid=movie.id
    AND actorid=actor.id
;


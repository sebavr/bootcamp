/*1.Change the query shown so that it displays Nobel prizes for 1950.*/

SELECT yr, subject, winner
  FROM nobel
 WHERE yr = 1950;
 
 /*2.Show who won the 1962 prize for Literature.*/
 
 SELECT winner
  FROM nobel
 WHERE yr = 1962
   AND subject = 'Literature';
   
/*3.Show the year and subject that won 'Albert Einstein' his prize.*/

select yr, subject
from nobel
where winner='Albert Einstein';

/*4.
Give the name of the 'Peace' winners since the year 2000, including 2000.*/

select winner
from nobel
where subject='Peace' and yr>='2000';

/*5.Show all details (yr, subject, winner) of the Literature prize winners for 1980 to 1989 inclusive.*/

select yr, subject, winner
from nobel
where subject='Literature' and yr>='1980' and yr<='1989';

/*6.Show all details of the presidential winners:

Theodore Roosevelt
Woodrow Wilson
Jimmy Carter
Barack Obama*/

SELECT * FROM nobel
 WHERE winner in ('Theodore Roosevelt','Woodrow Wilson','Jimmy Carter','Barack Obama');
 
 /*7.Show the winners with first name John*/
 
 SELECT winner FROM nobel
 WHERE left(winner,4)='John';
 
 
 /*8.Show the year, subject, and name of Physics winners for 1980 together with the Chemistry winners for 1984.*/

 SELECT yr, subject, winner 
FROM nobel
 WHERE yr='1980' and subject='Physics' or (subject='Chemistry' and yr='1984');
 
 /*9.Show the year, subject, and name of winners for 1980 excluding Chemistry and Medicine*/
 
 SELECT yr, subject, winner 
FROM nobel
 WHERE yr='1980' and not subject in ('Medicine','Chemistry');
 
 /*10.Show year, subject, and name of people who won a 'Medicine' prize in an early year (before 1910, not including 1910) together with winners of a 'Literature' prize in a later year (after 2004, including 2004)*/
 
 SELECT yr, subject, winner 
FROM nobel
 WHERE (subject like 'Medicine' and  yr<'1910') or  (subject like 'Literature' and yr>='2004');
 
 /*11.Find all details of the prize won by PETER GRÜNBERG*/
 
 SELECT yr, subject, winner 
FROM nobel
 WHERE winner='PETER GRÜNBERG';
 
 /*12.Find all details of the prize won by EUGENE O'NEILL*/
 
 SELECT *
FROM nobel
WHERE winner = 'Eugene O''Neill';

/*13.List the winners, year and subject where the winner starts with Sir. Show the the most recent first, then by name order.
*/
SELECT winner, yr, subject
FROM nobel
WHERE winner LIKE 'sir%'
ORDER BY yr DESC, winner;


/*
14.The expression subject IN ('Chemistry','Physics') can be used as a value - it will be 0 or 1.
Show the 1984 winners ordered by subject and winner name; but list Chemistry and Physics last.
*/
SELECT winner, subject, subject IN ('Physics','Chemistry')
FROM nobel
WHERE yr=1984
ORDER BY subject IN ('Physics','Chemistry'),subject,winner;




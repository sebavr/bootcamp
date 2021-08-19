/*1. ¿Qué consulta ejecutaría para obtener los ingresos totales para marzo de 2012?*/

SELECT MONTHNAME(charged_datetime) Marzo, sum(amount)
from billing
WHERE charged_datetime >= '2012-03-01' AND  charged_datetime <= '2012-03-31';


/*2. ¿Qué consulta ejecutaría para obtener los ingresos totales recaudados del 
cliente con una identificación de 2?*/

Select c.client_id,sum(b.amount) Monto_total
from billing b
join clients c on b.client_id=c.client_id
where c.client_id='2';


/*3. ¿Qué consulta ejecutaría para obtener todos los sitios que posee client = 10?*/
select c.client_id, s.domain_name
from clients c
join sites s on c.client_id=s.client_id
where c.client_id='10';


/*4. ¿Qué consulta ejecutaría para obtener el número total de sitios creados por mes por año
 para el cliente con una identificación de 1? ¿Qué pasa con el cliente = 20?*/

select client_id, count(domain_name) sitios,monthname(created_datetime) mes,YEAR(created_datetime) año
from sites
where client_id='1'
GROUP BY MONTH(created_datetime), YEAR(created_datetime);

select client_id, count(domain_name) sitios,monthname(created_datetime) mes,YEAR(created_datetime) año
from sites
where client_id='20'
GROUP BY MONTH(created_datetime), YEAR(created_datetime);

/*5. ¿Qué consulta ejecutaría para obtener el número total de clientes
 potenciales generados para cada uno de los sitios entre el 1 de enero de 2011 y 
 el 15 de febrero de 2011?*/
 
 SELECT s.domain_name website, count(l.leads_id) nº_leads,l.registered_datetime
 from sites s
 join leads l on l.site_id=s.site_id
 where l.registered_datetime<'2011-02-15' and l.registered_datetime >'2011-01-01'
 group by s.domain_name;
 

/*6. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y 
el número total de clientes potenciales que hemos generado para cada uno de nuestros 
clientes entre el 1 de enero de 2011 y el 31 de diciembre de 2011?*/

select concat(c.first_name,' ',c.last_name) cliente, count(l.leads_id) numero_leads
from clients c
join sites s on s.client_id=c.client_id
join leads l on l.site_id=s.site_id
where l.registered_datetime between '2011-01-01' and '2011-12-31'
group by cliente
order by numero_leads desc;


/*7. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y
 el número total de clientes potenciales que hemos generado para cada cliente 
 cada mes entre los meses 1 y 6 del año 2011?*/
 
select concat(c.first_name,' ',c.last_name) cliente, count(l.leads_id) numero_leads, monthname(l.registered_datetime)
from clients c
join sites s on s.client_id=c.client_id
join leads l on l.site_id=s.site_id
where l.registered_datetime between '2011-01-01' and '2011-06-30'
group by l.leads_id;




/*8. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y 
el número total de clientes potenciales que hemos generado para cada uno de los sitios de nuestros 
clientes entre el 1 de enero de 2011 y el 31 de diciembre de 2011? Solicite esta consulta por ID de cliente.
 Presente una segunda consulta que muestre todos los clientes, los nombres del sitio y 
 el número total de clientes potenciales generados en cada sitio en todo momento.*/

select concat(c.first_name,' ',c.last_name) cliente,s.domain_name website, count(l.leads_id) numero_leads,date_format(l.registered_datetime,'%M %e, %Y') fecha
from clients c
join sites s on s.client_id=c.client_id
join leads l on l.site_id=s.site_id
where l.registered_datetime between '2011-01-01' and '2011-12-31'
group by website
order by cliente;

select concat(c.first_name,' ',c.last_name) cliente,s.domain_name website, count(l.leads_id) numero_leads
from clients c
left join sites s on s.client_id=c.client_id
left join leads l on l.site_id=s.site_id
group by website
order by cliente;
/*9. Escriba una sola consulta que recupere los ingresos totales recaudados de cada cliente 
para cada mes del año. Pídalo por ID de cliente.*/

select c.client_id ,concat(c.first_name,' ',c.last_name) cliente,sum(b.amount) monto, monthname(b.charged_datetime) mes, year(b.charged_datetime) año
from clients c
join billing b on b.client_id=c.client_id
group by cliente,año,mes
order by cliente;


/*10. Escriba una sola consulta que recupere todos los sitios 
que posee cada cliente. Agrupe los resultados para que cada fila muestre un nuevo cliente. 
Se volverá más claro cuando agregue un nuevo campo llamado 'sitios' que tiene todos los sitios
 que posee el cliente. (SUGERENCIA: use GROUP_CONCAT)*/
 
SELECT concat(c.first_name,' ',c.last_name) client, GROUP_CONCAT(s.domain_name SEPARATOR ' / ')  sites 
FROM clients c
left JOIN sites s ON c.client_id=s.client_id 
group by client

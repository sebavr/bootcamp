
/*Muestra las relaciones entre amigos*/
SELECT u.first_name nombre,u.last_name apellido, u2.first_name as nombre_amigo,u2.last_name as apellido_amigo
FROM users u2
join friendships f on f.friend_id=u2.id
join users u on u.id=f.user_id;

/*Devuelva a todos los usuarios que son amigos de Kermit, 
asegúrese de que sus nombres se muestren en los resultados.*/

SELECT u.first_name nombre,u.last_name apellido
FROM users u2
join friendships f on f.friend_id=u2.id
join users u on u.id=f.user_id
where u2.first_name='Kermit';

/*Devuelve el recuento de todas las amistades.*/
SELECT u.first_name nombre,u.last_name apellido, count(u2.first_name) total_amigos
FROM users u2
join friendships f on f.friend_id=u2.id
right join users u on u.id=f.user_id
group by u.first_name;

/*Descubre quién tiene más amigos y devuelve el recuento de sus amigos.*/
SELECT u.first_name nombre,u.last_name apellido, count(u2.first_name) total_amigos
FROM users u2
join friendships f on f.friend_id=u2.id
right join users u on u.id=f.user_id

group by u.first_name;

/*Crea un nuevo usuario y hazlos amigos de Eli Byers, Kermit The Frog y Marky Mark.*/

insert into users (first_name,last_name,created_at,updated_at)
values ('Mario','Bros','2019-02-08 11:12:11',null);

insert into friendships (user_id,friend_id,created_at,updated_at)
values ('6','2','2019-02-08 11:12:11',null);

insert into friendships (user_id,friend_id,created_at,updated_at)
values ('6','4','2019-02-08 11:12:11',null);

insert into friendships (user_id,friend_id,created_at,updated_at)
values ('6','5','2019-02-08 11:12:11',null);

/*Devuelve a los amigos de Eli en orden alfabético.*/
SELECT u.first_name nombre,u.last_name apellido, u2.first_name as nombre_amigo,u2.last_name as apellido_amigo
FROM users u2
join friendships f on f.friend_id=u2.id
join users u on u.id=f.user_id
where u.first_name like 'Eli'
order by u2.first_name asc;

/*Eliminar a Marky Mark de los amigos de Eli.*/

DELETE FROM friendships WHERE user_id='2' and friend_id='5';

/*Devuelve todas las amistades, mostrando solo el nombre y apellido de ambos amigos*/

SELECT concat(u.first_name,' ',u.last_name) nombre, concat( u2.first_name ,' ',u2.last_name) nombre_amigo
FROM users u2
join friendships f on f.friend_id=u2.id
right join users u on u.id=f.user_id;




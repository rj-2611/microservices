DROP TABLE IF EXISTS trip_info;
 DROP TABLE IF EXISTS driver;
create table trip_info(
   trip_id INT NOT NULL AUTO_INCREMENT,
   emp_name VARCHAR(100),
   emp_mobile BIGINT,
   cust_name VARCHAR(100),
   cust_mobile BIGINT,
   source VARCHAR(100),
   destination VARCHAR(100),
   pickup_time DATETIME,
   drop_time DATETIME,
   PRIMARY KEY ( trip_id )
);

insert into trip_info values (1,'Joey',8080808080,'Chandler',9090909090,'Megapolis','Shivaji Chowk','2019-09-10 06:20:00','2019-09-10 07:05:00'),
(2,'Ross',7070707070,'Rachel',6060606060,'Pune','Mumbai','2019-09-05 03:37:00','2019-09-05 07:05:00'),
(3,'Monica',5050505050,'Phoebee',4040404040,'Marunji','Magarpatta','2019-09-07 01:45:00','2019-09-07 02:30:00');


create table driver(
   id INT NOT NULL AUTO_INCREMENT,
   emp_name VARCHAR(100),
   emp_mobile VARCHAR(100),
   status INT,
 PRIMARY KEY ( id )
);


insert into driver values (1,'IronMan','833083876',1),
(2,'Narendra Modi','8328115425',1),
(3,'Superman','9652563522',1),
(4,'Walter','8965856258',1),
(5,'Harry Potter','7965856258',1);
--(7,'Harry','9988856258',0),
--(8,'Potter','9885856258',1),
--(9,'Benedict','9965356258',1),
--(10,'Cumberbatch','9965656258',1),
--(11,'Krish','9465856258',1),
--(12,'Dr. Strange','9565856258',1),
--(13,'Tony Stark','9688856258',1),
--(14,'Kohli','9999856258',1),
--(15,'Dhoni','9965856299',1),
--(16,'Jadeja','9965858888',1),
--(17,'Sharma','9965857777',1),
--(18,'Chulbul Pandey','9965866666',1),
--(19,'Vijay Deenanath Chauhan','9965878945',1),
--(20,'Tendulkar','9965812345',1),
--(21,'SpiderMan','9965841255',1),
--(22,'Lalu Yadav','9965856365',1),
--(23,'Arijit Singh','9999856258',1);




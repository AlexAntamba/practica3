-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.18-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema losandes
--

CREATE DATABASE IF NOT EXISTS losandes;
USE losandes;

--
-- Definition of table `auditoria`
--

DROP TABLE IF EXISTS `auditoria`;
CREATE TABLE `auditoria` (
  `codigo` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `accion` varchar(50) NOT NULL,
  `detalle` varchar(50) NOT NULL,
  `fecreg` varchar(50) NOT NULL,
  PRIMARY KEY  (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `auditoria`
--

/*!40000 ALTER TABLE `auditoria` DISABLE KEYS */;
INSERT INTO `auditoria` (`codigo`,`usuario`,`accion`,`detalle`,`fecreg`) VALUES 
 (1,'jorge','login','Ha Entrado en sesion','2009-02-18 16:55:53'),
 (2,'luis','login','Ha Entrado en sesion','2009-02-18 17:01:11'),
 (3,'luis','login','Ha Entrado en sesion','2009-02-18 17:02:49'),
 (4,'luis','login','Ha Entrado en sesion','2009-02-18 17:06:50'),
 (5,'luis','login','Ha Entrado en sesion','2009-02-18 17:07:19'),
 (6,'luis','login','Ha Entrado en sesion','2009-02-18 17:08:37'),
 (7,'luis','login','Ha Entrado en sesion','2009-02-18 17:09:17'),
 (8,'lucki','login','Ha Entrado en sesion','2009-02-18 17:09:53'),
 (9,'lucki','login','Ha Entrado en sesion','2009-02-18 17:10:46'),
 (10,'luis','login','Ha Entrado en sesion','2009-02-18 17:13:48'),
 (11,'chino','login','Ha Entrado en sesion','2009-02-18 17:15:23'),
 (12,'lucki','login','Ha Entrado en sesion','2009-02-18 17:21:23'),
 (13,'luis','login','Ha Entrado en sesion','2009-02-18 17:23:47'),
 (14,'lucki','login','Ha Entrado en sesion','2009-02-18 17:24:22'),
 (15,'luis','login','Ha Entrado en sesion','2009-02-18 17:31:52'),
 (16,'lucki','login','Ha Entrado en sesion','2009-02-18 17:32:29'),
 (17,'luis','login','Ha Entrado en sesion','2009-02-18 17:36:36'),
 (18,'lucki','login','Ha Entrado en sesion','2009-02-18 17:45:18'),
 (19,'lucki','login','Ha Entrado en sesion','2009-02-18 17:50:27'),
 (20,'lucki','login','Ha Entrado en sesion','2009-02-18 17:52:09'),
 (21,'lucki','login','Ha Entrado en sesion','2009-02-18 17:53:22'),
 (22,'lucki','login','Ha Entrado en sesion','2009-02-18 17:54:05'),
 (23,'lucki','login','Ha Entrado en sesion','2009-02-18 17:54:19'),
 (24,'jorge','login','Ha Entrado en sesion','2009-02-18 17:54:46');
/*!40000 ALTER TABLE `auditoria` ENABLE KEYS */;


--
-- Definition of table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE `empleados` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY  (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `empleados`
--

/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` (`codigo`,`nombre`,`apellido`,`direccion`,`email`,`telefono`,`estado`) VALUES 
 (1,'Daniel','Rodriguez','Av palomino 2458','dani@empre.com','4238574',1),
 (2,'Alex ','Peña','Melgar 256','a.................@factor.com','7124591',1),
 (3,'Marlene','Chacon','Los portales 1251','marle@hotmail.com','2547812',1),
 (4,'Johan','Baldeon','Elm Street 6666666666666666666','johan_baldeon@gmail.com','6876876846',1),
 (5,'Johan','Baldeon','sxxfx','joha.nll@hotmail.com','1241242314',0);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;


--
-- Definition of table `hornos`
--

DROP TABLE IF EXISTS `hornos`;
CREATE TABLE `hornos` (
  `codigo` int(11) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `garantia` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `fecreg` varchar(50) NOT NULL,
  `dimensiones` varchar(50) NOT NULL,
  `stock` int(11) NOT NULL,
  `precio` double NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY  (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hornos`
--

/*!40000 ALTER TABLE `hornos` DISABLE KEYS */;
INSERT INTO `hornos` (`codigo`,`modelo`,`garantia`,`descripcion`,`fecreg`,`dimensiones`,`stock`,`precio`,`estado`) VALUES 
 (1,'Azitec','1 año','con puertas de alumnio','5/2/2009','24 x 30 x 15',45,345,1),
 (2,'RTM','2 años','con fibrillas de diamanates','5/2/2009','15 x 20 x 12',39,672,1),
 (3,'Inresa','2 años','con lunas antireflex','5/2/2009','20 x 30 x 15',84,596,1),
 (4,'Marite','2 años','para productos grande','5/2/2009','50 x 25 x 40',103,357,1),
 (5,'Dimitri','1.5 años','Acerado interno','5/2/2009','54 x 15 x 19',45,124,1),
 (6,'Sarcar','2 años','Calentado automatico','5/2/2009','21 x 20 x 19',156,431,1),
 (7,'Marrufini','8 meses','pequeño','5/2/2009','10 x 10 x 8',151,321,1),
 (8,'Rataki','3 años','con alarma integrada','5/2/2009','35 x 41 x 25',107,701,1),
 (9,'aaaaaaaa','2 años','asaaaaaa','5/2/2009','20 x 30 x 15',66666,1e+066,0),
 (10,'aaaaaaaa','2 años','fffffff','5/2/2009','20 x 30 x 15',5,0.99999,1);
/*!40000 ALTER TABLE `hornos` ENABLE KEYS */;


--
-- Definition of table `materiales`
--

DROP TABLE IF EXISTS `materiales`;
CREATE TABLE `materiales` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `durabilidad` varchar(50) NOT NULL,
  `fecreg` varchar(50) NOT NULL,
  `detuso` varchar(50) NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY  (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `materiales`
--

/*!40000 ALTER TABLE `materiales` DISABLE KEYS */;
INSERT INTO `materiales` (`codigo`,`nombre`,`tipo`,`durabilidad`,`fecreg`,`detuso`,`stock`,`estado`) VALUES 
 (1,'fierro','Metal','5 años','5/2/2009','construccion',20,1),
 (2,'cedro','Madera','2.5 años','5/2/2009','construccion',20,1),
 (3,'caoba','Madera','3 años','5/2/2009','cajones de molde',20,1),
 (4,'tornillo','Madera','4 años','5/2/2009','molde principal',20,1),
 (5,'pernos','Metal','5 años y 2 meses','5/2/2009','ajustes de metal',20,1),
 (6,'clavos','Metal','42 meses','5/2/2009','fijaciones',20,1),
 (7,'esponja','Metal','2 usos','5/2/2009','esponja de metal crudo',20,1),
 (8,'tacos','Madera','1 uso','5/2/2009','para ajustes de madera',20,1),
 (9,'lija','Otro','10 usos','5/2/2009','lija para madera',20,1),
 (10,'Tripley','Madera','2.5 años','5/2/2009','Bases de hornos',20,1),
 (11,'Hierro','Metal','30 años','5/2/2009','Hierro para hacer acero',20,1),
 (12,'aaaaaa','Metal','aaaaaaaaa','5/2/2009','aaaaaauiotyuitgyiguytbuytbuyto',50009,0);
/*!40000 ALTER TABLE `materiales` ENABLE KEYS */;


--
-- Definition of table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
CREATE TABLE `proveedores` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `fechainicio` varchar(50) NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY  (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proveedores`
--

/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` (`codigo`,`nombre`,`direccion`,`telefono`,`email`,`ciudad`,`fechainicio`,`estado`) VALUES 
 (1,'Luis Fermin','Los portales','3253641','dhhhw@hot.com','Lima','5/2/2009',1),
 (2,'Andy','La rinconada 125','4565789','mamani@tuto.com','Lima','5/2/2009',1),
 (3,'Raul Delgado','Jr Amazonas 250','4862354','raulito@peru.com','Trujillo','5/2/2009',1),
 (4,'Armando Ganoza','Av pardo','5685432','ganoza@jahu.com','Tumbes','5/2/2009',1),
 (5,'Fermin','Av La marina 2526','4568527','ferfa@empresa.com','Chiclayo','5/2/2009',1),
 (6,'Eduardo Peralta','Los laureles 2410','4527834','pepa@factory.com','Ilo','5/2/2009',1),
 (7,'Angela Del Rosario','Av. Chalaca 1254','4628957','rosari@chala.com','Lima','5/2/2009',1),
 (8,'Sandra ','Av. Palomino','4896325','xina@uni.com','Arequipa','5/2/2009',1),
 (9,'Otocunz','Av. San fernando 4125','4567812','razs@empre.com','Trujillo','5/2/2009',1),
 (10,'Paulina ','Jr. Los Rosales','6217843','luli@yaju.com','Ica','5/2/2009',1),
 (11,'Maria','El porvenir 147','8214673','mary@casa.com','Lima','5/2/2009',1),
 (12,'<>','\'\'','1241245435','johan@hotmail.com','LIMA','5/2/2009',1);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;


--
-- Definition of table `tb_detallefactura`
--

DROP TABLE IF EXISTS `tb_detallefactura`;
CREATE TABLE `tb_detallefactura` (
  `codigo` int(11) default NULL,
  `codHorno` int(11) default NULL,
  `cantidad` int(11) default NULL,
  `precio` decimal(10,0) default NULL,
  `subtotal` decimal(10,0) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_detallefactura`
--

/*!40000 ALTER TABLE `tb_detallefactura` DISABLE KEYS */;
INSERT INTO `tb_detallefactura` (`codigo`,`codHorno`,`cantidad`,`precio`,`subtotal`) VALUES 
 (1,1,1,'345','345'),
 (1,2,2,'672','1344'),
 (1,3,1,'596','596'),
 (2,1,1,'345','345'),
 (3,1,1,'345','345'),
 (4,4,2,'357','714'),
 (4,7,1,'321','321'),
 (4,10,4,'1','4'),
 (4,3,1,'596','596'),
 (4,1,1,'345','345');
/*!40000 ALTER TABLE `tb_detallefactura` ENABLE KEYS */;


--
-- Definition of table `tb_detalleordendecompra`
--

DROP TABLE IF EXISTS `tb_detalleordendecompra`;
CREATE TABLE `tb_detalleordendecompra` (
  `nro` int(11) default NULL,
  `codigo` int(11) default NULL,
  `cantidad` int(11) default NULL,
  `subtotal` decimal(10,0) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_detalleordendecompra`
--

/*!40000 ALTER TABLE `tb_detalleordendecompra` DISABLE KEYS */;
INSERT INTO `tb_detalleordendecompra` (`nro`,`codigo`,`cantidad`,`subtotal`) VALUES 
 (1,1,1,'345'),
 (1,2,2,'1344'),
 (1,3,1,'596'),
 (2,1,1,'345'),
 (3,4,2,'714'),
 (3,7,1,'321'),
 (3,10,4,'4'),
 (3,3,1,'596'),
 (3,1,1,'345');
/*!40000 ALTER TABLE `tb_detalleordendecompra` ENABLE KEYS */;


--
-- Definition of table `tb_factura`
--

DROP TABLE IF EXISTS `tb_factura`;
CREATE TABLE `tb_factura` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `nroOrden` int(11) default NULL,
  `total` decimal(10,0) default NULL,
  `fecha` varchar(30) default NULL,
  PRIMARY KEY  (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_factura`
--

/*!40000 ALTER TABLE `tb_factura` DISABLE KEYS */;
INSERT INTO `tb_factura` (`codigo`,`nombre`,`nroOrden`,`total`,`fecha`) VALUES 
 (1,'Luis Canales',1,'2285','5/2/2009'),
 (2,'Lucki Fernandez',2,'345','5/2/2009'),
 (3,'Lucki Fernandez',2,'345','5/2/2009'),
 (4,'Lucki Fernandez',3,'1980','5/2/2009');
/*!40000 ALTER TABLE `tb_factura` ENABLE KEYS */;


--
-- Definition of table `tb_ordendecompra`
--

DROP TABLE IF EXISTS `tb_ordendecompra`;
CREATE TABLE `tb_ordendecompra` (
  `nro` int(11) NOT NULL,
  `estado` int(11) default NULL,
  `prioridad` varchar(15) default NULL,
  `fecha` varchar(30) default NULL,
  PRIMARY KEY  (`nro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_ordendecompra`
--

/*!40000 ALTER TABLE `tb_ordendecompra` DISABLE KEYS */;
INSERT INTO `tb_ordendecompra` (`nro`,`estado`,`prioridad`,`fecha`) VALUES 
 (1,1,'Alta','5/2/2009'),
 (2,1,'Alta','5/2/2009'),
 (3,1,'Alta','5/2/2009');
/*!40000 ALTER TABLE `tb_ordendecompra` ENABLE KEYS */;


--
-- Definition of table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `login` varchar(50) NOT NULL,
  `password` varchar(50) default NULL,
  `nombre` varchar(50) default NULL,
  `tipoUsuario` varchar(50) default NULL,
  PRIMARY KEY  (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`login`,`password`,`nombre`,`tipoUsuario`) VALUES 
 ('arturo','lightofheaven','Arturo Marruffo','Administrador'),
 ('chino','123456','Jesus','CAMOTITO'),
 ('jorge','jorge','Jorge Luis Jimenez','Administrador'),
 ('lucki','lucki','Lucki Fernandez','ESCLAVO DE LAS RATAS'),
 ('luis','luis','Luis Canales','GORDITO INSACIABLE');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

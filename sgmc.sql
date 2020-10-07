-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 20/02/2020 às 11:11
-- Versão do servidor: 10.4.10-MariaDB
-- Versão do PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sgmc`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `admin`
--

CREATE TABLE `admin` (
  `idAdmin` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `admin`
--

INSERT INTO `admin` (`idAdmin`, `idUsuario`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `descricao`) VALUES
(1, 'Hidraulico'),
(2, 'Ferramentaria'),
(3, 'Eletrico'),
(4, 'Construcao Civil'),
(5, 'Arame');

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `razaoSocial` varchar(45) DEFAULT NULL,
  `inscricaoEstadual` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `rg` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `estadoCivil` varchar(45) DEFAULT NULL,
  `sexo` varchar(30) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `idEndereco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`idCliente`, `cnpj`, `razaoSocial`, `inscricaoEstadual`, `nome`, `cpf`, `rg`, `telefone`, `celular`, `email`, `dataNascimento`, `estadoCivil`, `sexo`, `numero`, `complemento`, `idEndereco`) VALUES
(1, '', '', '', 'Leonardo Campos', '11100555405', '2255566633', '3226655405', '22988653251', 'leo.campos@outlook.com', '1997-03-20', 'Solteiro(a)', 'Masculino', 105, 'Proximo a Padaria P', 1),
(2, NULL, NULL, NULL, 'Rhonda Roth', '16010330 .6700', '16201218 .2354', '(095) 75628 0240', NULL, 'Proin.sed.turpis@utaliquamiaculis.com', '2012-01-21 20:43:12', NULL, NULL, NULL, NULL, 1),
(3, NULL, NULL, NULL, 'Scarlett Slater', '16041214 .0618', '16220915 .6658', '(097) 37829 1027', NULL, 'massa.Integer@Nuncmaurissapien.org', '2006-12-02 08:50:30', NULL, NULL, NULL, NULL, 2),
(4, NULL, NULL, NULL, 'Keely Rosa', '16030625 .5530', '16010624 .4486', '(065) 48917 9939', NULL, 'Donec.at.arcu@vitaeposuereat.org', '2017-05-16 02:35:46', NULL, NULL, NULL, NULL, 2),
(5, NULL, NULL, NULL, 'Sonia Terrell', '16161012 .6417', '16820523 .5198', '(067) 98133 8875', NULL, 'Nulla.dignissim@aliquetPhasellusfermentum.net', '1989-10-04 03:13:28', NULL, NULL, NULL, NULL, 2),
(6, NULL, NULL, NULL, 'Nyssa Townsend', '16480213 .4488', '16940608 .4963', '(082) 61429 9716', NULL, 'Donec.tempor@justo.ca', '1991-03-25 01:02:19', NULL, NULL, NULL, NULL, 2),
(7, NULL, NULL, NULL, 'Cecilia Donovan', '16711218 .9449', '16491216 .9341', '(079) 01549 4065', NULL, 'dui.Suspendisse@Curabiturconsequat.org', '1995-11-29 12:37:10', NULL, NULL, NULL, NULL, 1),
(8, NULL, NULL, NULL, 'Freya Hardin', '16320607 .8101', '16420302 .8396', '(034) 94487 1221', NULL, 'mauris.erat.eget@quam.org', '1991-04-22 20:57:44', NULL, NULL, NULL, NULL, 1),
(9, NULL, NULL, NULL, 'Jessamine Oneal', '16080812 .0554', '16130906 .3129', '(081) 52793 8075', NULL, 'et@Nullamsuscipit.com', '1994-05-15 15:27:19', NULL, NULL, NULL, NULL, 2),
(10, NULL, NULL, NULL, 'Uta Morrow', '16510821 .4197', '16200117 .0881', '(081) 62917 4503', NULL, 'cursus.a@velpedeblandit.co.uk', '1999-07-14 12:15:01', NULL, NULL, NULL, NULL, 1),
(11, NULL, NULL, NULL, 'Phyllis Wright', '16010406 .9240', '16170115 .7974', '(014) 12139 6766', NULL, 'nec@ornarelectusjusto.com', '1982-07-31 13:40:59', NULL, NULL, NULL, NULL, 2),
(22, NULL, NULL, NULL, 'Lisandra Gilmore', '16340204 .3917', '16460926 .9545', '(026) 36662 9587', NULL, 'nisi.magna@lectus.com', '2010-08-11 07:33:10', NULL, NULL, NULL, NULL, 2),
(23, NULL, NULL, NULL, 'Roanna Emerson', '16191119 .4593', '16850420 .3657', '(063) 15700 8061', NULL, 'amet@justoPraesentluctus.co.uk', '2008-09-26 23:20:23', NULL, NULL, NULL, NULL, 1),
(24, NULL, NULL, NULL, 'Aretha Jarvis', '16690606 .0402', '16820917 .6257', '(066) 05125 0355', NULL, 'dignissim.magna@dolorsitamet.org', '1997-11-23 20:34:24', NULL, NULL, NULL, NULL, 1),
(25, NULL, NULL, NULL, 'Chloe Haynes', '16090310 .2986', '16760206 .8905', '(073) 64678 2864', NULL, 'fames@tristique.edu', '2004-02-05 14:33:04', NULL, NULL, NULL, NULL, 1),
(26, NULL, NULL, NULL, 'Fiona Weiss', '16240606 .3632', '16020116 .8846', '(067) 35912 2871', NULL, 'at.augue.id@ornare.org', '1998-02-07 10:09:26', NULL, NULL, NULL, NULL, 2),
(27, NULL, NULL, NULL, 'Amaya Foster', '16330114 .2513', '16090406 .9705', '(055) 35917 4177', NULL, 'ipsum.primis@elementumlorem.net', '2000-11-16 20:39:26', NULL, NULL, NULL, NULL, 2),
(28, NULL, NULL, NULL, 'Iona Bush', '16940726 .7039', '16421106 .8632', '(095) 83106 4325', NULL, 'nisi.dictum.augue@odioNaminterdum.co.uk', '2011-04-06 21:57:23', NULL, NULL, NULL, NULL, 1),
(29, NULL, NULL, NULL, 'Chiquita Fields', '16330620 .3443', '16430115 .5851', '(015) 35649 4546', NULL, 'senectus.et@semper.net', '2014-10-17 10:39:39', NULL, NULL, NULL, NULL, 2),
(30, NULL, NULL, NULL, 'Lana Boyer', '16941122 .4331', '16600209 .6235', '(049) 93705 6931', NULL, 'sem@ante.edu', '1990-11-14 09:46:35', NULL, NULL, NULL, NULL, 1),
(31, NULL, NULL, NULL, 'Clementine Bright', '16160708 .2912', '16360322 .1536', '(095) 65388 2486', NULL, 'urna@elit.ca', '2017-07-22 14:22:48', NULL, NULL, NULL, NULL, 2),
(32, NULL, NULL, NULL, 'Leslie Franco', '16580301 .2367', '16641021 .2945', '(087) 18917 7428', NULL, 'ac@ut.ca', '2002-02-18 08:47:38', NULL, NULL, NULL, NULL, 1),
(33, NULL, NULL, NULL, 'Amber Higgins', '16280913 .6134', '16820414 .3088', '(021) 30444 2903', NULL, 'eget@massaVestibulumaccumsan.ca', '1983-07-28 01:16:39', NULL, NULL, NULL, NULL, 1),
(34, NULL, NULL, NULL, 'Quin Kirby', '16481112 .3639', '16900213 .1788', '(016) 13161 9171', NULL, 'pharetra.nibh@Duisrisusodio.co.uk', '1981-12-04 08:56:04', NULL, NULL, NULL, NULL, 2),
(35, NULL, NULL, NULL, 'Lynn Carson', '16851127 .1820', '16450217 .6672', '(076) 82923 9289', NULL, 'natoque.penatibus@faucibusorci.org', '2019-06-19 16:01:56', NULL, NULL, NULL, NULL, 1),
(36, NULL, NULL, NULL, 'Joelle Blankenship', '16591215 .9273', '16550815 .9554', '(074) 41080 7922', NULL, 'orci.lacus.vestibulum@Fuscedolorquam.com', '2016-09-24 08:25:25', NULL, NULL, NULL, NULL, 2),
(37, NULL, NULL, NULL, 'Callie Pope', '16181017 .8051', '16190717 .7131', '(083) 31424 6861', NULL, 'Quisque.fringilla@ipsum.org', '2016-07-14 03:37:05', NULL, NULL, NULL, NULL, 1),
(38, NULL, NULL, NULL, 'Miriam Fleming', '16840113 .8691', '16130127 .4070', '(088) 23591 2048', NULL, 'semper@Donec.net', '2003-10-23 02:41:24', NULL, NULL, NULL, NULL, 1),
(39, NULL, NULL, NULL, 'Petra Dunlap', '16380109 .6516', '16880610 .7200', '(094) 93042 1503', NULL, 'at@liberodui.co.uk', '2001-11-10 16:24:04', NULL, NULL, NULL, NULL, 1),
(40, NULL, NULL, NULL, 'Robin Sykes', '16271215 .2764', '16830817 .5887', '(062) 11421 3282', NULL, 'Donec@orciluctuset.org', '2016-09-24 15:15:57', NULL, NULL, NULL, NULL, 1),
(41, NULL, NULL, NULL, 'Kirby Cotton', '16320408 .8458', '16060726 .7705', '(076) 67783 8281', NULL, 'aliquet.Phasellus.fermentum@facilisisfacilisi', '1983-06-20 15:37:10', NULL, NULL, NULL, NULL, 2),
(52, NULL, NULL, NULL, 'Cassidy Watson', '16340612 .6536', '16820415 .7146', '(051) 49710 2200', NULL, 'sagittis.lobortis@tempus.net', '2014-04-02 11:31:48', NULL, NULL, NULL, NULL, 2),
(53, NULL, NULL, NULL, 'Ursa Long', '16920826 .0977', '16410429 .9336', '(018) 42792 8594', NULL, 'erat@CuraeDonec.net', '1983-02-05 21:37:10', NULL, NULL, NULL, NULL, 2),
(54, NULL, NULL, NULL, 'Clementine Keller', '16590312 .4179', '16120404 .5064', '(041) 63368 1770', NULL, 'Morbi.accumsan.laoreet@Classaptent.co.uk', '2007-08-21 17:02:08', NULL, NULL, NULL, NULL, 2),
(55, NULL, NULL, NULL, 'Cally Stephens', '16430529 .2825', '16031010 .2603', '(061) 04989 2672', NULL, 'arcu.Nunc@luctusCurabituregestas.ca', '1994-05-17 03:40:13', NULL, NULL, NULL, NULL, 1),
(56, NULL, NULL, NULL, 'Cleo Reese', '16850320 .1363', '16121003 .2155', '(082) 17658 0194', NULL, 'ipsum@Fuscemollis.co.uk', '1982-12-25 20:29:19', NULL, NULL, NULL, NULL, 2),
(57, NULL, NULL, NULL, 'Tara Fulton', '16071117 .0233', '16540707 .7303', '(098) 42033 9239', NULL, 'risus@varius.net', '1999-10-01 05:26:32', NULL, NULL, NULL, NULL, 1),
(58, NULL, NULL, NULL, 'Kaye Ryan', '16560802 .6836', '16830904 .1781', '(025) 77357 6342', NULL, 'tincidunt.vehicula.risus@egestasa.ca', '1989-11-24 22:41:36', NULL, NULL, NULL, NULL, 1),
(59, NULL, NULL, NULL, 'Bethany Wooten', '16690517 .6126', '16000914 .4627', '(055) 03245 5560', NULL, 'nonummy.ultricies@Nullatincidunt.co.uk', '1999-02-27 23:24:55', NULL, NULL, NULL, NULL, 2),
(60, NULL, NULL, NULL, 'Veronica Wright', '16300514 .9913', '16970406 .6175', '(043) 65116 9621', NULL, 'massa@Suspendissecommodotincidunt.co.uk', '1995-12-06 00:19:00', NULL, NULL, NULL, NULL, 1),
(61, NULL, NULL, NULL, 'Olga Peterson', '16290524 .0723', '16320112 .4496', '(075) 38771 2008', NULL, 'elementum@sagittisaugue.edu', '2018-05-14 22:16:40', NULL, NULL, NULL, NULL, 1),
(62, NULL, NULL, NULL, 'Neve Bishop', '16001202 .4576', '16200718 .2658', '(098) 05699 0215', NULL, 'nibh@pellentesqueeget.edu', '2019-01-09 03:25:20', NULL, NULL, NULL, NULL, 2),
(63, NULL, NULL, NULL, 'Zenia Mcpherson', '16570609 .7614', '16570918 .0623', '(029) 54629 3208', NULL, 'consequat.purus@neque.edu', '2013-11-07 18:54:14', NULL, NULL, NULL, NULL, 1),
(64, NULL, NULL, NULL, 'Lillian Grant', '16291106 .7367', '16850803 .3290', '(013) 25183 5395', NULL, 'Curabitur.vel@nonummyac.edu', '2016-03-31 23:01:28', NULL, NULL, NULL, NULL, 1),
(65, NULL, NULL, NULL, 'Hyacinth Mcpherson', '16600724 .6025', '16990122 .1912', '(094) 17471 5441', NULL, 'ridiculus@morbitristiquesenectus.edu', '1988-11-05 22:25:09', NULL, NULL, NULL, NULL, 1),
(66, NULL, NULL, NULL, 'Britanney Haney', '16170526 .4750', '16111010 .9830', '(069) 16816 7837', NULL, 'natoque.penatibus.et@sem.edu', '2010-11-01 16:39:44', NULL, NULL, NULL, NULL, 1),
(67, NULL, NULL, NULL, 'Danielle Hester', '16820618 .7364', '16360326 .3793', '(029) 63472 2194', NULL, 'pharetra.nibh.Aliquam@tellusNunclectus.com', '1990-12-07 20:29:21', NULL, NULL, NULL, NULL, 1),
(68, NULL, NULL, NULL, 'Dana Rosario', '16550821 .8749', '16141025 .5390', '(072) 46099 1742', NULL, 'pede.et.risus@imperdietnecleo.net', '2010-07-08 04:22:31', NULL, NULL, NULL, NULL, 2),
(69, NULL, NULL, NULL, 'Quemby Odonnell', '16110313 .7061', '16200124 .8570', '(086) 01911 3576', NULL, 'a.malesuada@tempor.edu', '2001-04-14 20:46:56', NULL, NULL, NULL, NULL, 2),
(70, NULL, NULL, NULL, 'Kaitlin Cooke', '16110815 .2487', '16561019 .6379', '(045) 34656 2345', NULL, 'velit@orciadipiscing.co.uk', '2002-01-06 19:10:16', NULL, NULL, NULL, NULL, 1),
(71, NULL, NULL, NULL, 'Deirdre Snow', '16960803 .6753', '16450109 .8893', '(047) 86467 4473', NULL, 'porta.elit@arcuac.org', '1997-09-09 00:56:36', NULL, NULL, NULL, NULL, 1),
(72, NULL, NULL, NULL, 'Quemby Nelson', '16660819 .6967', '16901127 .7671', '(083) 19082 4773', NULL, 'Aliquam.nec.enim@lacus.ca', '2006-03-28 19:45:35', NULL, NULL, NULL, NULL, 2),
(73, NULL, NULL, NULL, 'Xandra Booth', '16720214 .9485', '16780218 .4924', '(028) 28189 9739', NULL, 'semper@sempererat.co.uk', '1993-03-24 15:06:36', NULL, NULL, NULL, NULL, 2),
(74, NULL, NULL, NULL, 'Elaine Saunders', '16750514 .0744', '16030420 .2963', '(015) 74251 9903', NULL, 'mollis.lectus@turpis.org', '2015-12-08 23:53:49', NULL, NULL, NULL, NULL, 2),
(75, NULL, NULL, NULL, 'Jennifer Graves', '16811008 .6264', '16250408 .0710', '(098) 24937 2975', NULL, 'ac@acmattisornare.net', '2000-07-22 05:44:30', NULL, NULL, NULL, NULL, 1),
(76, NULL, NULL, NULL, 'Michelle Fisher', '16400927 .0986', '16640914 .7623', '(012) 24001 7436', NULL, 'sit.amet@eratinconsectetuer.org', '1993-01-27 00:32:50', NULL, NULL, NULL, NULL, 2),
(77, NULL, NULL, NULL, 'Keelie Welch', '16970611 .2282', '16350505 .3748', '(012) 36933 9714', NULL, 'lorem@ornareFusce.ca', '2005-08-11 09:51:32', NULL, NULL, NULL, NULL, 1),
(78, NULL, NULL, NULL, 'Rachel Oneal', '16771224 .4271', '16290728 .3895', '(078) 21610 4241', NULL, 'lacinia.at.iaculis@dolorDonec.edu', '1988-05-29 06:30:31', NULL, NULL, NULL, NULL, 1),
(79, NULL, NULL, NULL, 'Callie Delacruz', '16871021 .6154', '16640404 .2340', '(014) 82563 3466', NULL, 'faucibus@conguea.ca', '1995-05-18 18:49:52', NULL, NULL, NULL, NULL, 1),
(80, NULL, NULL, NULL, 'Orla Jackson', '16411004 .7521', '16660617 .1251', '(077) 53090 5833', NULL, 'lacinia.at.iaculis@adipiscing.net', '1991-09-07 03:28:14', NULL, NULL, NULL, NULL, 1),
(81, NULL, NULL, NULL, 'Mallory Kramer', '16170902 .3905', '16541109 .9186', '(016) 01952 2849', NULL, 'Duis.a.mi@nequeMorbi.co.uk', '2017-05-20 16:19:07', NULL, NULL, NULL, NULL, 2),
(82, NULL, NULL, NULL, 'Petra Winters', '16131114 .4222', '16731013 .7562', '(047) 26756 8995', NULL, 'fringilla@Suspendisse.org', '2013-10-04 00:32:44', NULL, NULL, NULL, NULL, 2),
(83, NULL, NULL, NULL, 'Anne Nichols', '16890816 .3960', '16670706 .7663', '(094) 29388 4391', NULL, 'tincidunt.adipiscing.Mauris@parturient.org', '2003-10-03 18:11:06', NULL, NULL, NULL, NULL, 2),
(84, NULL, NULL, NULL, 'Imani Rhodes', '16331019 .6146', '16790708 .0472', '(064) 08151 0229', NULL, 'metus.Aliquam@sit.com', '2015-01-15 09:53:40', NULL, NULL, NULL, NULL, 2),
(85, NULL, NULL, NULL, 'Zenaida Lowery', '16160530 .7360', '16590606 .0685', '(062) 08460 4744', NULL, 'rutrum.lorem@Cras.com', '1999-10-18 13:27:55', NULL, NULL, NULL, NULL, 2),
(86, NULL, NULL, NULL, 'Wynter Fuentes', '16510714 .7794', '16030330 .3333', '(059) 13190 5396', NULL, 'dapibus.id.blandit@et.edu', '1987-12-11 22:13:44', NULL, NULL, NULL, NULL, 2),
(87, NULL, NULL, NULL, 'Miriam Meyer', '16580603 .2750', '16341101 .8249', '(033) 02512 1083', NULL, 'eget@faucibusMorbivehicula.net', '2007-06-17 19:12:15', NULL, NULL, NULL, NULL, 2),
(88, NULL, NULL, NULL, 'Alexa Alston', '16850911 .2325', '16170722 .2038', '(081) 22228 3596', NULL, 'pede.Praesent.eu@anunc.net', '1989-03-15 18:10:30', NULL, NULL, NULL, NULL, 2),
(89, NULL, NULL, NULL, 'Tatyana Russell', '16120210 .5928', '16140128 .6800', '(017) 80892 8066', NULL, 'dolor.nonummy@nullaatsem.co.uk', '2018-03-15 18:44:57', NULL, NULL, NULL, NULL, 2),
(90, NULL, NULL, NULL, 'Melyssa Gray', '16161004 .7159', '16340908 .6414', '(059) 04897 2315', NULL, 'neque.sed@pede.ca', '2009-02-14 16:14:03', NULL, NULL, NULL, NULL, 2),
(91, NULL, NULL, NULL, 'Quail Hopper', '16150202 .4399', '16440913 .3669', '(066) 93943 6866', NULL, 'odio.a@actellus.com', '1998-08-16 23:10:19', NULL, NULL, NULL, NULL, 1),
(92, NULL, NULL, NULL, 'Lenore Dalton', '16421208 .0099', '16630430 .9302', '(049) 42267 9850', NULL, 'condimentum.Donec@ultricesDuis.com', '1987-12-08 09:07:44', NULL, NULL, NULL, NULL, 2),
(93, NULL, NULL, NULL, 'Ruby Galloway', '16030110 .3750', '16060108 .0583', '(035) 52477 4900', NULL, 'Proin.vel@pharetrafelis.org', '1990-05-01 04:07:56', NULL, NULL, NULL, NULL, 1),
(94, NULL, NULL, NULL, 'Joelle West', '16670416 .7300', '16910723 .2382', '(017) 04192 8878', NULL, 'a.purus@Mauris.co.uk', '2019-09-11 14:58:02', NULL, NULL, NULL, NULL, 2),
(95, NULL, NULL, NULL, 'Serena Reed', '16070627 .5377', '16501202 .8097', '(096) 97046 9705', NULL, 'ac.metus.vitae@euismod.com', '2000-02-22 20:01:17', NULL, NULL, NULL, NULL, 1),
(96, NULL, NULL, NULL, 'Cassandra Pacheco', '16090529 .5507', '16761202 .2488', '(033) 54814 6268', NULL, 'libero.lacus@Nulla.edu', '2007-10-29 06:21:35', NULL, NULL, NULL, NULL, 1),
(97, NULL, NULL, NULL, 'Lynn Martinez', '16680115 .5182', '16101214 .7771', '(091) 75666 5185', NULL, 'diam.Duis.mi@velarcuCurabitur.co.uk', '1982-10-08 09:10:24', NULL, NULL, NULL, NULL, 1),
(98, NULL, NULL, NULL, 'Zenaida Wells', '16791220 .7995', '16181210 .0749', '(042) 98997 5655', NULL, 'sodales.nisi.magna@odio.ca', '1984-12-15 09:39:26', NULL, NULL, NULL, NULL, 2),
(99, NULL, NULL, NULL, 'Kitra Burch', '16891021 .7440', '16750718 .7412', '(035) 82904 7537', NULL, 'augue.eu.tellus@sedduiFusce.edu', '1987-08-14 17:39:05', NULL, NULL, NULL, NULL, 1),
(100, NULL, NULL, NULL, 'Jade Wade', '16291105 .0785', '16450510 .1719', '(097) 44400 7668', NULL, 'Quisque@leo.com', '1989-12-20 17:22:31', NULL, NULL, NULL, NULL, 1),
(101, NULL, NULL, NULL, 'Sandra Bridges', '16620818 .1633', '16670926 .5174', '(064) 59083 2733', NULL, 'at.augue@magnisdisparturient.ca', '1994-12-21 08:19:13', NULL, NULL, NULL, NULL, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `colaborador`
--

CREATE TABLE `colaborador` (
  `idColaborador` int(11) NOT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `rg` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `estadoCivil` varchar(45) DEFAULT NULL,
  `sexo` varchar(30) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `idEndereco` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `colaborador`
--

INSERT INTO `colaborador` (`idColaborador`, `cpf`, `rg`, `dataNascimento`, `telefone`, `celular`, `estadoCivil`, `sexo`, `numero`, `complemento`, `idEndereco`, `idUsuario`) VALUES
(1, '11100555504', '2270560434', '1988-01-18', '3226655304', '32999755114', 'Solteiro(a)', 'Masculino', 103, 'Proximo a Padaria P', 1, 2),
(2, '11122233304', '228887773', '1987-05-16', NULL, '32999156352', 'Solteiro(a)', 'Masculino', 109, NULL, 5, 3),
(3, '10121132305', '227778883', '1992-05-25', NULL, '32988166332', 'Solteiro(a)', 'Masculino', 109, NULL, 5, 4),
(4, '11121236307', '225559993', '1991-02-20', NULL, '32988906752', 'Solteiro(a)', 'Masculino', 109, NULL, 5, 5),
(5, '11523245309', '221113333', '1995-11-05', NULL, '32991957342', 'Solteiro(a)', 'Masculino', 109, NULL, 5, 6);

-- --------------------------------------------------------

--
-- Estrutura para tabela `endereco`
--

CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL,
  `logradouro` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `uf` varchar(45) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `endereco`
--

INSERT INTO `endereco` (`idEndereco`, `logradouro`, `cidade`, `bairro`, `uf`, `cep`) VALUES
(1, 'Rua Santana ', 'Juiz de Fora', 'Centenario', 'MG', '36599000 '),
(2, 'Rua Americo Luz', 'Juiz de Fora', 'Manoel Honorio', 'MG', '36045010 '),
(3, 'Rua Guimarães', 'Juiz de Fora', 'Nova Era', 'MG', '36017000'),
(4, 'Rua Mamede Camilo', 'Juiz de Fora', 'Nova Era', 'MG', '36017000'),
(5, 'Rua Guimarães', 'Juiz de Fora', 'Adolfo Vireque', 'MG', '35660000'),
(6, 'Rua Pedro Francisco Assis', 'Juiz de Fora', 'Adolfo Vireque', 'MG', '35881000'),
(7, 'Rua Dilermando Cruz', 'Juiz de Fora', ' Lourdes', 'MG', '35380000'),
(8, 'Rua Bahia', 'Juiz de Fora', 'Poço Rico', 'MG', '35940000'),
(9, 'Rua Ulisses Escobar', 'Juiz de Fora', 'Parque Guadalajara', 'MG', '35413000'),
(10, 'Rua Alves Junior', 'Juiz de Fora', 'Centenario', 'MG', '36045000');

-- --------------------------------------------------------

--
-- Estrutura para tabela `formaPagamento`
--

CREATE TABLE `formaPagamento` (
  `idFormaPgto` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `conta` varchar(45) DEFAULT NULL,
  `agencia` varchar(11) DEFAULT NULL,
  `nomeBanco` varchar(40) DEFAULT NULL,
  `tipoConta` varchar(40) DEFAULT NULL,
  `numMaxParcelas` int(11) DEFAULT NULL,
  `intervaloParcelas` int(11) DEFAULT NULL,
  `taxaBanco` double DEFAULT NULL,
  `taxaOperadora` double DEFAULT NULL,
  `multaAtraso` double DEFAULT NULL,
  `situacaoConfirmacao` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `formaPagamento`
--

INSERT INTO `formaPagamento` (`idFormaPgto`, `nome`, `conta`, `agencia`, `nomeBanco`, `tipoConta`, `numMaxParcelas`, `intervaloParcelas`, `taxaBanco`, `taxaOperadora`, `multaAtraso`, `situacaoConfirmacao`) VALUES
(1, 'Credito', '15842', '444', 'Caixa Economica', 'Conta Corrente', 10, 30, 5.8, 6, 4.5, 'AutomÃ¡tico'),
(2, 'A vista', '647848', '8', 'Caixa Economica', 'Conta PoupanÃ§a', 1, 0, 1, 1.5, 0, 'AutomÃ¡tico'),
(3, 'Debito', '647848', '888', 'Caixa Economica', 'Conta PoupanÃ§a', 1, 0, 1, 2, 1, 'AutomÃ¡tico');

-- --------------------------------------------------------

--
-- Estrutura para tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `idFornecedor` int(11) NOT NULL,
  `nomeFantasia` varchar(45) DEFAULT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `nomeRepresentante` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `idEndereco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `fornecedor`
--

INSERT INTO `fornecedor` (`idFornecedor`, `nomeFantasia`, `cnpj`, `nomeRepresentante`, `email`, `telefone`, `numero`, `complemento`, `idEndereco`) VALUES
(1, 'Marangon', '40653743/0004-30 ', 'Júlio Bonifácio', 'marangon@email.com', '3232657504', 104, 'Bloco B', 2),
(2, 'ABC Construcao', '08626942/0008-10', 'Leandro Gomez', 'abc.construcao@email.com', '3226657405', 105, 'Bloco A', 1),
(3, 'Sovan EPI\'s', '04684932/0008-52', 'Ulisses Castilho', 'sovan.epi@email.com', '3226657896', 327, 'Próximo a Gerdau Ferro e Aço', 9),
(4, 'Gerdau Ferro e Aço', '05685931/0007-09', 'Márcio Gomes', 'gerdau.metais@email.com', '3226647798', 326, NULL, 9),
(5, 'Hidraúlica Tropeiro', '34674912/0208-51', 'Matheus Fernandes', 'tropeiro.hidraulica@email.com', '3226658899', 404, NULL, 8),
(6, 'JV Construção Civil', '76675030/1007-17', 'Otávio Buarque', 'jv.construcao@email.com', '3226658099', 410, NULL, 8),
(7, 'DiFabri Decorações', '63674731/0004-51', 'Mariana Calixto', 'difabri.decoracoes@email.com', '3226656474', 802, NULL, 7),
(8, 'Degraus Andaimes', '35574021/0054-19', 'Túlio Muniz', 'degrau.andaimes@email.com', '3226647889', 806, NULL, 7),
(9, 'Mauro Materiais Elétricos', '34682632/0002-43', 'Tatiana Mendes', 'mauro.eletricos@emailcom', '3226657896', 530, NULL, 6),
(10, 'Armazém dos Fios', '25885523/0007-39', 'Gabriel Silveira', 'amazem.fios@email.com', '3226647798', 240, NULL, 5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `itensOrdem`
--

CREATE TABLE `itensOrdem` (
  `idItensOrdem` int(11) NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `idProduto` int(11) NOT NULL,
  `idOrdemSrv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `itensOrdem`
--

INSERT INTO `itensOrdem` (`idItensOrdem`, `quantidade`, `idProduto`, `idOrdemSrv`) VALUES
(1, 1, 1, 1),
(2, 5, 1, 2),
(3, 1, 10, 3),
(4, 25, 3, 4),
(5, 100, 6, 5),
(6, 1, 7, 6),
(7, 5, 10, 7),
(8, 10, 5, 8);

-- --------------------------------------------------------

--
-- Estrutura para tabela `itensVenda`
--

CREATE TABLE `itensVenda` (
  `idItensVenda` int(11) NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `precoUnitario` float DEFAULT NULL,
  `idVenda` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `itensVenda`
--

INSERT INTO `itensVenda` (`idItensVenda`, `quantidade`, `precoUnitario`, `idVenda`, `idProduto`) VALUES
(1, 2, 30, 1, 1),
(2, 50, 1, 2, 2),
(3, 3, 30, 3, 1),
(4, 1, 96, 4, 10),
(5, 10, 10, 5, 6),
(6, 1, 206, 6, 4),
(7, 1, 176, 7, 7),
(8, 15, 10, 8, 8),
(9, 10, 0.4, 9, 9),
(10, 10, 10, 10, 5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `ordemServico`
--

CREATE TABLE `ordemServico` (
  `idOrdemSrv` int(11) NOT NULL,
  `numOS` int(11) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `dataPedido` varchar(45) DEFAULT NULL,
  `situacao` varchar(45) DEFAULT NULL,
  `idFornecedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `ordemServico`
--

INSERT INTO `ordemServico` (`idOrdemSrv`, `numOS`, `descricao`, `dataPedido`, `situacao`, `idFornecedor`) VALUES
(1, 1, 'Reposicao em estoque', '2019-09-25', 'Em aberto', 1),
(2, 2, 'ReposiÃ§Ã£o em estoque', '2019-09-10', 'Em Aberto', 2),
(3, 3, 'DevoluÃ§Ã£o de produto com defeito', '2019-03-20', 'Em Aberto', 5),
(4, 4, 'ReposiÃ§Ã£o em estoque', '2018-06-05', 'Recebida', 6),
(5, 5, 'Encomenda de Cliente', '2018-01-20', 'Recebida', 4),
(6, 6, 'DevoluÃ§Ã£o de produto com defeito', '2018-06-25', 'Recebida', 1),
(7, 7, 'ReposiÃ§Ã£o em estoque', '2020-02-10', 'Em Aberto', 5),
(8, 8, 'ReposiÃ§Ã£o em estoque', '2019-07-18', 'Recebida', 6);

-- --------------------------------------------------------

--
-- Estrutura para tabela `perdaDevolucao`
--

CREATE TABLE `perdaDevolucao` (
  `idPerdaDevolucao` int(11) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `idVenda` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `perdaDevolucao`
--

INSERT INTO `perdaDevolucao` (`idPerdaDevolucao`, `tipo`, `idVenda`, `idProduto`) VALUES
(1, 'Devolucao', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `codInterno` int(11) DEFAULT NULL,
  `codBarra` int(45) DEFAULT NULL,
  `unidadeMedida` varchar(45) DEFAULT NULL,
  `precoCompra` float DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `altura` float DEFAULT NULL,
  `comprimento` float DEFAULT NULL,
  `validade` varchar(45) DEFAULT NULL,
  `qtdMinima` int(11) DEFAULT NULL,
  `qtdAtual` int(11) DEFAULT NULL,
  `qtdMaxima` int(11) DEFAULT NULL,
  `largura` float DEFAULT NULL,
  `idFornecedor` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `produto`
--

INSERT INTO `produto` (`idProduto`, `nome`, `codInterno`, `codBarra`, `unidadeMedida`, `precoCompra`, `peso`, `altura`, `comprimento`, `validade`, `qtdMinima`, `qtdAtual`, `qtdMaxima`, `largura`, `idFornecedor`, `idCategoria`) VALUES
(1, 'Cimento Holcim', 1555, 2147483647, 'Kg', 30, 50, NULL, NULL, '2019-12-25', 10, 15, 20, NULL, 1, 4),
(2, 'Buchas Tam. 06', 125, 8855476, 'Unidade', 30, 5, 0, 0, '0', 6, 10, 15, 0, 1, 4),
(3, 'Buchas Tam. 07', 1212212, 1122151, '1', 1, 1, 1, 1, '1', 1, 1, 1, 1, 2, 4),
(4, '', NULL, 1299496820, NULL, 0, 12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(5, '', NULL, 1752245577, NULL, 0, 95, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2),
(6, 'Veda Calha', NULL, 1344348428, NULL, 0, 36, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2),
(7, 'Cimento', NULL, 1704188531, NULL, 0, 23, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(8, 'Furadeira', NULL, 1317462037, NULL, 0, 86, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(9, 'Veda Calha', NULL, 1895296188, NULL, 0, 37, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(10, '', NULL, 1607072796, NULL, 0, 75, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(11, 'Furadeira', NULL, 1556147720, NULL, 0, 56, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2),
(12, 'Furadeira', NULL, 1303732392, NULL, 0, 49, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(13, 'Cimento', NULL, 1919723292, NULL, 0, 35, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(14, 'Furadeira', NULL, 1283575512, NULL, 0, 37, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(15, '', NULL, 1071058476, NULL, 0, 23, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(16, 'Veda Calha', NULL, 1929954908, NULL, 0, 22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(17, 'Massa Corrida', NULL, 2031487598, NULL, 0, 38, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(18, 'Veda Calha', NULL, 1480542760, NULL, 0, 74, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(19, 'Furadeira', NULL, 1259950513, NULL, 0, 92, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(20, 'Massa Corrida', NULL, 1027498690, NULL, 0, 27, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(21, 'Veda Calha', NULL, 1038765953, NULL, 0, 37, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(22, 'Veda Calha', NULL, 1374865410, NULL, 0, 35, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(23, '', NULL, 1981829691, NULL, 0, 98, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(24, 'Veda Calha', NULL, 1875197006, NULL, 53.59, 34, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(25, 'Veda Calha', NULL, 1521204559, NULL, 7.68, 37, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(26, 'Furadeira', NULL, 2128657783, NULL, 10.31, 69, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2),
(27, '', NULL, 1658965246, NULL, 36.35, 46, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(28, 'Veda Calha', NULL, 1595401472, NULL, 94.89, 55, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(29, 'Cimento', NULL, 1204425625, NULL, 23.58, 29, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(30, 'Massa Corrida', NULL, 1513784235, NULL, 22.08, 54, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(31, 'Cimento', NULL, 1693229127, NULL, 47.03, 40, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2),
(32, 'Cimento', NULL, 2023319551, NULL, 13.76, 60, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(33, 'Cimento', NULL, 1600688039, NULL, 60.71, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(34, 'Cimento', NULL, 1510749927, NULL, 7.41, 75, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(35, 'Cimento', NULL, 1035513799, NULL, 77.52, 9, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(36, 'Furadeira', NULL, 1570384393, NULL, 82.48, 9, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(37, 'Cimento', NULL, 1646577530, NULL, 98.98, 38, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(38, 'Cimento', NULL, 1133193940, NULL, 55.85, 67, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2),
(39, 'Veda Calha', NULL, 1394106409, NULL, 10.21, 73, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(40, 'Veda Calha', NULL, 2109282403, NULL, 42.26, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(41, 'Massa Corrida', NULL, 2048124485, NULL, 37.47, 100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(42, 'Massa Corrida', NULL, 2070645623, NULL, 51.61, 43, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(43, 'Massa Corrida', NULL, 1463443605, NULL, 22.32, 42, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(44, '', NULL, 2135187800, NULL, 8.78, 24, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2),
(45, '', NULL, 1028447029, NULL, 83.27, 74, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(46, 'Cimento', NULL, 1208586347, NULL, 41.29, 55, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2),
(47, 'Veda Calha', NULL, 1627614309, NULL, 38.96, 32, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(48, 'Furadeira', NULL, 2039924875, NULL, 7, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(49, 'Massa Corrida', NULL, 1811992264, NULL, 40.74, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(50, '', NULL, 1813608753, NULL, 87.01, 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(51, 'Veda Calha', NULL, 1089333914, NULL, 33.82, 93, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(52, 'Cimento', NULL, 1301159046, NULL, 12.84, 86, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(53, 'Furadeira', NULL, 1059745676, NULL, 84.43, 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(54, 'Veda Calha', NULL, 1092384912, NULL, 14.64, 44, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(55, '', NULL, 1762357258, NULL, 53.92, 94, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(56, 'Furadeira', NULL, 1665038564, NULL, 73.54, 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(57, '', NULL, 2143675446, NULL, 89.41, 60, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(58, 'Furadeira', NULL, 1725128430, NULL, 50.65, 29, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(59, 'Massa Corrida', NULL, 1729288607, NULL, 5.66, 64, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(60, 'Cimento', NULL, 1904657223, NULL, 48.61, 59, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(61, 'Furadeira', NULL, 1748069781, NULL, 86.91, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(62, 'Cimento', NULL, 1075049482, NULL, 24.23, 45, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(63, 'Furadeira', NULL, 2057364942, NULL, 25.36, 51, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(64, 'Veda Calha', NULL, 1210382696, NULL, 38.54, 69, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(65, 'Veda Calha', NULL, 1267226079, NULL, 87.28, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(66, '', NULL, 2066713135, NULL, 46.24, 30, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(67, 'Veda Calha', NULL, 1163838327, NULL, 17.29, 51, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(68, 'Massa Corrida', NULL, 1098350982, NULL, 75.39, 48, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(69, '', NULL, 1725799094, NULL, 14.17, 36, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(70, '', NULL, 1154095011, NULL, 85.8, 81, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(71, 'Furadeira', NULL, 1198828154, NULL, 97.24, 25, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(72, 'Furadeira', NULL, 1173329963, NULL, 50.34, 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(73, 'Veda Calha', NULL, 1968092161, NULL, 49.32, 59, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(74, 'Cimento', NULL, 1082545707, NULL, 11.76, 17, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(75, '', NULL, 1225200352, NULL, 71.31, 34, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(76, 'Cimento', NULL, 2134172276, NULL, 35.96, 24, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(77, 'Veda Calha', NULL, 1125716824, NULL, 11.24, 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(78, 'Massa Corrida', NULL, 1931755334, NULL, 76.5, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(79, 'Cimento', NULL, 1371852859, NULL, 57.11, 90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(80, '', NULL, 1406104466, NULL, 44.33, 17, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(81, '', NULL, 2051195719, NULL, 44.17, 57, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(82, 'Veda Calha', NULL, 1927967096, NULL, 12.9, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(83, 'Massa Corrida', NULL, 1152493264, NULL, 0.02, 81, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(84, 'Massa Corrida', NULL, 1119718760, NULL, 17.66, 92, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(85, 'Furadeira', NULL, 1224968742, NULL, 62.49, 34, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(86, '', NULL, 1765170239, NULL, 88.79, 51, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(87, 'Cimento', NULL, 2085210636, NULL, 7.73, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2),
(88, 'Veda Calha', NULL, 1717857329, NULL, 5.4, 77, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2),
(89, '', NULL, 1068412659, NULL, 10.01, 97, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(90, 'Massa Corrida', NULL, 1691795666, NULL, 17.1, 87, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(91, '', NULL, 1122378955, NULL, 7.84, 81, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(92, 'Veda Calha', NULL, 1794693179, NULL, 87.96, 30, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(93, 'Furadeira', NULL, 1086057688, NULL, 43.09, 81, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(94, 'Massa Corrida', NULL, 1655967607, NULL, 12.92, 52, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2),
(95, 'Veda Calha', NULL, 2030338115, NULL, 75.07, 69, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(96, 'Cimento', NULL, 2003484176, NULL, 32.86, 82, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(97, 'Furadeira', NULL, 1870762831, NULL, 30.6, 56, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(98, 'Furadeira', NULL, 1271811470, NULL, 62.73, 50, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(99, 'Cimento', NULL, 1506560684, NULL, 26.02, 85, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(100, 'Veda Calha', NULL, 1225733480, NULL, 61.19, 42, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(101, 'Massa Corrida', NULL, 1915020631, NULL, 69.67, 80, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(102, 'Furadeira', NULL, 1641254522, NULL, 68.68, 41, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1),
(103, 'Furadeira', NULL, 1658944351, NULL, 10.83, 32, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(104, 'Massa Corrida', NULL, 1169522411, NULL, 10.31, 85, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(105, 'Veda Calha', NULL, 2093942626, NULL, 21.37, 61, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(106, '', NULL, 1513722463, NULL, 47.83, 33, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(107, 'Veda Calha', NULL, 1393298718, NULL, 63.24, 56, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(108, 'Massa Corrida', NULL, 2111749344, NULL, 30.18, 8, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(109, 'Cimento', NULL, 1693432760, NULL, 29.1, 34, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(110, 'Furadeira', NULL, 1184556448, NULL, 25.75, 80, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(111, 'Furadeira', NULL, 1366351991, NULL, 70.48, 77, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(112, 'Furadeira', NULL, 2051454829, NULL, 29.57, 65, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 3),
(113, 'Furadeira', NULL, 1719540128, NULL, 73.94, 23, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(114, 'Massa Corrida', NULL, 1121048581, NULL, 83.49, 19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(115, 'Furadeira', NULL, 1465839665, NULL, 13.36, 27, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(116, 'Cimento', NULL, 2054057960, NULL, 64.44, 13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(117, 'Massa Corrida', NULL, 1835658124, NULL, 43.48, 9, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(118, 'Veda Calha', NULL, 1572926690, NULL, 39.58, 9, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(119, 'Massa Corrida', NULL, 1962078524, NULL, 88.26, 90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4),
(120, 'Veda Calha', NULL, 1649412248, NULL, 2.24, 96, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2),
(121, 'Cimento', NULL, 1295695678, NULL, 82.12, 38, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 3),
(122, 'Cimento', NULL, 1606300234, NULL, 58.7, 97, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 4),
(123, 'Cimento', NULL, 2067885011, NULL, 38.98, 67, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4);

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nome`, `email`, `senha`) VALUES
(1, 'Silvio Romero', 'silvioromero.sr@gmail.com', '12345'),
(2, 'Luiz Gama', 'luiz.gama@gmail.com', '12345'),
(3, 'Juliano Hermes', 'juliano.hermes@email.com', '12345'),
(4, 'Júlio de Moraes', 'julio.moraes@email.com', '12345'),
(5, 'Maicon Ferreira', 'maicon.ferreira@email.com', '12345'),
(6, 'Fabrício Muniz', 'fabricio.muniz@email.com', '12345');

-- --------------------------------------------------------

--
-- Estrutura para tabela `venda`
--

CREATE TABLE `venda` (
  `idVenda` int(11) NOT NULL,
  `dataVenda` varchar(45) DEFAULT NULL,
  `subTotal` float DEFAULT NULL,
  `codBarra` int(45) DEFAULT NULL,
  `valorDesconto` float DEFAULT NULL,
  `situacao` varchar(45) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idFormaPgto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Despejando dados para a tabela `venda`
--

INSERT INTO `venda` (`idVenda`, `dataVenda`, `subTotal`, `codBarra`, `valorDesconto`, `situacao`, `idCliente`, `idUsuario`, `idFormaPgto`) VALUES
(1, '2019-09-26', 60, 154477, 10, 'aberta', 1, 2, 1),
(2, '2019-01-20', 100, 1121234244, 0, 'efetuada', 3, 4, 3),
(3, '2018-06-05', 90, 22313131, 0, 'aberta', 1, 4, 1),
(4, '2017-04-20', 91, 1231232431, 5, 'efetuada', 2, 5, 2),
(5, '2019-05-08', 100, 1212325667, 0, 'efetuada', 5, 6, 1),
(6, '2019-08-17', 206, 23445676, 0, 'efetuada', 6, 4, 3),
(7, '2018-06-20', 176, 12322323, 0, 'efetuada', 8, 5, 3),
(8, '2019-07-05', 149, 123235454, 0, 'efetuada', 9, 4, 1),
(9, '2019-08-09', 4, 1122351, 0, 'efetuada', 10, 3, 2),
(10, '2014-02-10', 100, 12233134, 0, 'aberta', 11, 6, 1);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAdmin`),
  ADD KEY `fk_admin_usuario1_idx` (`idUsuario`);

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD KEY `fk_cliente_enderecos1_idx` (`idEndereco`);

--
-- Índices de tabela `colaborador`
--
ALTER TABLE `colaborador`
  ADD PRIMARY KEY (`idColaborador`),
  ADD KEY `fk_colaborador_endereco1_idx` (`idEndereco`),
  ADD KEY `usuario_idUsuario` (`idUsuario`);

--
-- Índices de tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`idEndereco`);

--
-- Índices de tabela `formaPagamento`
--
ALTER TABLE `formaPagamento`
  ADD PRIMARY KEY (`idFormaPgto`);

--
-- Índices de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`idFornecedor`),
  ADD KEY `fk_fornecedor_enderecos1_idx` (`idEndereco`);

--
-- Índices de tabela `itensOrdem`
--
ALTER TABLE `itensOrdem`
  ADD PRIMARY KEY (`idItensOrdem`),
  ADD KEY `fk_itensOrdem_produto1_idx` (`idProduto`),
  ADD KEY `fk_itensOrdem_ordemServico1_idx` (`idOrdemSrv`);

--
-- Índices de tabela `itensVenda`
--
ALTER TABLE `itensVenda`
  ADD PRIMARY KEY (`idItensVenda`),
  ADD KEY `fk_itensVenda_venda1_idx` (`idVenda`),
  ADD KEY `fk_itensVenda_produto1_idx` (`idProduto`);

--
-- Índices de tabela `ordemServico`
--
ALTER TABLE `ordemServico`
  ADD PRIMARY KEY (`idOrdemSrv`),
  ADD KEY `fk_ordemServico_fornecedor1_idx` (`idFornecedor`);

--
-- Índices de tabela `perdaDevolucao`
--
ALTER TABLE `perdaDevolucao`
  ADD PRIMARY KEY (`idPerdaDevolucao`),
  ADD KEY `fk_perdaDevolucao_venda1_idx` (`idVenda`),
  ADD KEY `fk_perdaDevolucao_produto1_idx` (`idProduto`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idProduto`),
  ADD KEY `fk_produto_categoria1_idx` (`idCategoria`),
  ADD KEY `fk_produto_fornecedor1_idx` (`idFornecedor`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Índices de tabela `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`idVenda`),
  ADD KEY `fk_venda_cliente1_idx` (`idCliente`),
  ADD KEY `fk_venda_usuario1_idx` (`idUsuario`),
  ADD KEY `fk_venda_formaPagamento1_idx` (`idFormaPgto`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `admin`
--
ALTER TABLE `admin`
  MODIFY `idAdmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `colaborador`
--
ALTER TABLE `colaborador`
  MODIFY `idColaborador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `idEndereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `formaPagamento`
--
ALTER TABLE `formaPagamento`
  MODIFY `idFormaPgto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `idFornecedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `itensOrdem`
--
ALTER TABLE `itensOrdem`
  MODIFY `idItensOrdem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `itensVenda`
--
ALTER TABLE `itensVenda`
  MODIFY `idItensVenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `ordemServico`
--
ALTER TABLE `ordemServico`
  MODIFY `idOrdemSrv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `perdaDevolucao`
--
ALTER TABLE `perdaDevolucao`
  MODIFY `idPerdaDevolucao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `idProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `venda`
--
ALTER TABLE `venda`
  MODIFY `idVenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_admin_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_enderecos1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `colaborador`
--
ALTER TABLE `colaborador`
  ADD CONSTRAINT `fk_colaborador_endereco1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuario_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fk_fornecedor_enderecos1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `itensOrdem`
--
ALTER TABLE `itensOrdem`
  ADD CONSTRAINT `fk_itensOrdem_ordemServico1` FOREIGN KEY (`idOrdemSrv`) REFERENCES `ordemServico` (`idOrdemSrv`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_itensOrdem_produto1` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `itensVenda`
--
ALTER TABLE `itensVenda`
  ADD CONSTRAINT `fk_itensVenda_produto1` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_itensVenda_venda1` FOREIGN KEY (`idVenda`) REFERENCES `venda` (`idVenda`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `ordemServico`
--
ALTER TABLE `ordemServico`
  ADD CONSTRAINT `fk_ordemServico_fornecedor1` FOREIGN KEY (`idFornecedor`) REFERENCES `fornecedor` (`idFornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `perdaDevolucao`
--
ALTER TABLE `perdaDevolucao`
  ADD CONSTRAINT `fk_perdaDevolucao_produto1` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_perdaDevolucao_venda1` FOREIGN KEY (`idVenda`) REFERENCES `venda` (`idVenda`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `fk_produto_categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_produto_fornecedor1` FOREIGN KEY (`idFornecedor`) REFERENCES `fornecedor` (`idFornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `fk_venda_cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_venda_formaPagamento1` FOREIGN KEY (`idFormaPgto`) REFERENCES `formaPagamento` (`idFormaPgto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_venda_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

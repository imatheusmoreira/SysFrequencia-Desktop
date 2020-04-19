-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.24-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for sistemafrequencia
CREATE DATABASE IF NOT EXISTS `sistemafrequencia` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sistemafrequencia`;

-- Dumping structure for table sistemafrequencia.avisos
CREATE TABLE IF NOT EXISTS `avisos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(300) NOT NULL,
  `inicioaviso` datetime NOT NULL,
  `fimaviso` datetime NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sistemafrequencia.avisos: ~0 rows (approximately)
DELETE FROM `avisos`;
/*!40000 ALTER TABLE `avisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `avisos` ENABLE KEYS */;

-- Dumping structure for table sistemafrequencia.cargo
CREATE TABLE IF NOT EXISTS `cargo` (
  `codigo` int(10) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table sistemafrequencia.cargo: ~29 rows (approximately)
DELETE FROM `cargo`;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` (`codigo`, `nome`, `descricao`) VALUES
	(1, 'ADMINISTRADOR', ''),
	(2, 'Assistente em Administração', ''),
	(3, 'ASSISTENTE SOCIAL', ''),
	(4, 'Auxiliar em Administração', ''),
	(5, 'AUXILIAR EM BIBLIOTECA', ''),
	(6, 'BIBLIOTECÁRIO', ''),
	(7, 'CONTADOR', ''),
	(10, 'DIGITADOR', 'DIGITA DOCUMENTOS'),
	(11, 'ECONOMISTA', ''),
	(12, 'ENFERMEIRA', ''),
	(13, 'Estagiário', ''),
	(10, 'Intérprete de Linguas de Sinais', ''),
	(14, 'JORNALISTA', ''),
	(15, 'NUTRICIONISTA', ''),
	(16, 'PEDAGOGA', ''),
	(17, 'PROGRAMADOR', 'DESENVOLVE PROGRAMAS'),
	(18, 'PROGRAMADOR VISUAL', ''),
	(19, 'PSICÓLOGA', ''),
	(20, 'SECRETÁRIA EXECUTIVA', ''),
	(21, 'Técnica de Laboratório - Química', ''),
	(22, 'TÉCNICO EM ASSUNTOS EDUCACIONAIS', ''),
	(23, 'TÉCNICO EM ÁUDIO VISUAL', ''),
	(24, 'TÉCNICO EM CONTABILIDADE', ''),
	(25, 'TÉCNICO EM EDIFICAÇÕES', ''),
	(26, 'TÉCNICO EM ELETROELETRÔNICA', ''),
	(26, 'TÉCNICO EM ENFERMAGEM', ''),
	(27, 'TÉCNICO EM LABORATÓRIO - INFORMÁTICA', ''),
	(28, 'TÉCNICO EM TECNOLOGIA DA INFORMAÇÃO', ''),
	(29, 'TECNÓLOGO EM GESTÃO FINANCEIRA', '');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;

-- Dumping structure for table sistemafrequencia.configuracoes
CREATE TABLE IF NOT EXISTS `configuracoes` (
  `urlsaida` varchar(200) DEFAULT NULL,
  `urllogopdf` varchar(200) DEFAULT NULL,
  `urllogotela` varchar(200) DEFAULT NULL,
  `matricula` varchar(18) NOT NULL,
  KEY `FK_configuracoes_servidores` (`matricula`),
  CONSTRAINT `FK_configuracoes_servidores` FOREIGN KEY (`matricula`) REFERENCES `servidores` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table sistemafrequencia.configuracoes: ~3 rows (approximately)
DELETE FROM `configuracoes`;
/*!40000 ALTER TABLE `configuracoes` DISABLE KEYS */;
INSERT INTO `configuracoes` (`urlsaida`, `urllogopdf`, `urllogotela`, `matricula`) VALUES
	('C:/Users/Giovana/Dropbox/CGP/Frequencias', '//BL1-SALAEQUI-01/SysFrequencia/logo10anos.png', '//BL1-SALAEQUI-01/SysFrequencia/SysFrequenciaLogo.png', '1809017'),
	('C:/Users/ILHAWAY/Dropbox/CGP/Frequencias', '//BL1-SALAEQUI-01SysFrequencia/logo10anos.png', '//BL1-SALAEQUI-01/SysFrequencia/SysFrequenciaLogo.png', '081.351.523-88'),
	('C:/Users/Matheus Moreira/Desktop', '//10.50.13.3/SysFrequencia/logo10anos.png', '//10.50.13.3/SysFrequencia/SysFrequenciaLogo.png', '90');
/*!40000 ALTER TABLE `configuracoes` ENABLE KEYS */;

-- Dumping structure for table sistemafrequencia.configuracoes_email
CREATE TABLE IF NOT EXISTS `configuracoes_email` (
  `matricula` varchar(18) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `emailsenha` varchar(100) DEFAULT NULL,
  `emailassuntopdf` varchar(200) DEFAULT NULL,
  `emailtextopdf` text,
  `emailassuntoalerta` varchar(200) DEFAULT NULL,
  `emailtextoalerta` text,
  KEY `FK_configuracoes_email_servidores` (`matricula`),
  CONSTRAINT `FK_configuracoes_email_servidores` FOREIGN KEY (`matricula`) REFERENCES `servidores` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Guarda os dados de email do programa';

-- Dumping data for table sistemafrequencia.configuracoes_email: ~2 rows (approximately)
DELETE FROM `configuracoes_email`;
/*!40000 ALTER TABLE `configuracoes_email` DISABLE KEYS */;
INSERT INTO `configuracoes_email` (`matricula`, `email`, `emailsenha`, `emailassuntopdf`, `emailtextopdf`, `emailassuntoalerta`, `emailtextoalerta`) VALUES
	('1809017', 'email@gmail.com', 'senhadoemail', '', '', '', '');
/*!40000 ALTER TABLE `configuracoes_email` ENABLE KEYS */;

-- Dumping structure for table sistemafrequencia.feriados
CREATE TABLE IF NOT EXISTS `feriados` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `dia` int(2) NOT NULL,
  `mes` int(2) NOT NULL,
  `ano` int(4) DEFAULT NULL,
  UNIQUE KEY `codigo` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table sistemafrequencia.feriados: ~19 rows (approximately)
DELETE FROM `feriados`;
/*!40000 ALTER TABLE `feriados` DISABLE KEYS */;
INSERT INTO `feriados` (`codigo`, `nome`, `dia`, `mes`, `ano`) VALUES
	(1, 'Carnaval', 13, 2, 0),
	(2, 'Paixão de Cristo', 30, 3, 0),
	(3, 'Pascoa', 1, 4, 0),
	(4, 'Corpus Christi', 31, 5, 0),
	(7, 'Tiradentes', 21, 4, 0),
	(10, 'Dia do Trabalhador', 1, 5, 0),
	(11, 'Independência do Brasil', 7, 9, 0),
	(12, 'Nossa Senhora Aparecida', 12, 10, 0),
	(13, 'Finados', 2, 11, 0),
	(15, 'Proclamação da República', 15, 11, 0),
	(16, 'Natal', 25, 12, 0),
	(17, 'Ano Novo', 1, 1, 0),
	(19, 'Feriado municipal - Aniversário de Maracanaú', 6, 3, 0),
	(20, 'Cinzas', 1, 3, 0),
	(21, 'Semana Santa', 13, 4, 0),
	(22, 'Santo Antônio', 13, 6, NULL),
	(23, 'Feriado referente ao dia do estudante (Reprogramado)', 8, 9, NULL),
	(24, 'Recesso Escolar (Carnaval)', 12, 2, NULL),
	(25, 'Cinzas', 14, 2, NULL);
/*!40000 ALTER TABLE `feriados` ENABLE KEYS */;

-- Dumping structure for table sistemafrequencia.funcao
CREATE TABLE IF NOT EXISTS `funcao` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table sistemafrequencia.funcao: ~15 rows (approximately)
DELETE FROM `funcao`;
/*!40000 ALTER TABLE `funcao` DISABLE KEYS */;
INSERT INTO `funcao` (`codigo`, `nome`, `descricao`) VALUES
	(2, 'Coordenação de Gestão de Pessoas', ''),
	(3, '****', ''),
	(4, 'Coordenação Almoxarifado e Patrimônio', ''),
	(2, 'Chefe de Gabinete', ''),
	(2, 'Coordenação de Execução Orçamentária e Financeira', ''),
	(2, 'Coordenação de Aquisições e Contratações', ''),
	(2, 'Coordenação de Infraestrutura', ''),
	(2, 'Assistente da Diretoria de Ensino', ''),
	(2, 'Coordenação Técnico-Pedagógica', ''),
	(2, 'Coordenação de Biblioteca', ''),
	(2, 'Coordenação de Assuntos Estudantis', ''),
	(2, 'Coordenação de Extensão', ''),
	(5, 'Coordenação Controle Acadêmico', ''),
	(2, 'Assistente da DIRAP', ''),
	(2, 'Coordenação Tecnologia da Informação', '');
/*!40000 ALTER TABLE `funcao` ENABLE KEYS */;

-- Dumping structure for table sistemafrequencia.instituicoes
CREATE TABLE IF NOT EXISTS `instituicoes` (
  `cnpj` varchar(100) NOT NULL,
  `nomeempresarial` varchar(100) NOT NULL,
  `nomefantasia` varchar(100) NOT NULL,
  `dataabertura` date DEFAULT NULL,
  `ativecoprincipal` varchar(100) DEFAULT NULL,
  `ativecosecundaria` varchar(200) DEFAULT NULL,
  `naturezajuridica` varchar(100) DEFAULT NULL,
  `rua` varchar(100) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `municipio` varchar(50) DEFAULT NULL,
  `uf` varchar(3) DEFAULT NULL,
  `cep` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefone` varchar(40) DEFAULT NULL,
  `efr` varchar(50) DEFAULT NULL,
  `contrato` varchar(20) NOT NULL,
  `momentodecadastro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `cnpj` (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sistemafrequencia.instituicoes: ~0 rows (approximately)
DELETE FROM `instituicoes`;
/*!40000 ALTER TABLE `instituicoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `instituicoes` ENABLE KEYS */;

-- Dumping structure for table sistemafrequencia.lotacao
CREATE TABLE IF NOT EXISTS `lotacao` (
  `codigo` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `responsável` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `observacoes` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table sistemafrequencia.lotacao: ~4 rows (approximately)
DELETE FROM `lotacao`;
/*!40000 ALTER TABLE `lotacao` DISABLE KEYS */;
INSERT INTO `lotacao` (`codigo`, `nome`, `responsável`, `email`, `observacoes`) VALUES
	(1, 'DIREÇÃO GERAL', 'Costa', 'costa@gmail.com', ''),
	(2, 'DIRAP', 'Santos', 'santos@gmail.com', ''),
	(3, 'DEPPI', 'Junior', 'junior@gmail.com', ''),
	(4, 'DIREN', 'Germana', 'germanamu@gmail.com', '');
/*!40000 ALTER TABLE `lotacao` ENABLE KEYS */;

-- Dumping structure for table sistemafrequencia.servidores
CREATE TABLE IF NOT EXISTS `servidores` (
  `matricula` varchar(18) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `funcao` varchar(50) DEFAULT NULL,
  `lotacao` varchar(50) NOT NULL,
  `setor` varchar(80) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `celular` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `senha` varchar(15) DEFAULT NULL,
  `ehusuario` varchar(6) NOT NULL DEFAULT 'NAO',
  `ch` int(10) unsigned NOT NULL DEFAULT '80',
  `tipo` varchar(20) NOT NULL DEFAULT 'Servidor',
  `ativo` varchar(5) NOT NULL DEFAULT 'SIM',
  `mesferias` varchar(5) NOT NULL DEFAULT 'SIM',
  `observacoes` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabela onde serão cadastrados os funcionários';

-- Dumping data for table sistemafrequencia.servidores: ~74 rows (approximately)
DELETE FROM `servidores`;
/*!40000 ALTER TABLE `servidores` DISABLE KEYS */;
INSERT INTO `servidores` (`matricula`, `nome`, `cargo`, `funcao`, `lotacao`, `setor`, `telefone`, `celular`, `email`, `senha`, `ehusuario`, `ch`, `tipo`, `ativo`, `mesferias`, `observacoes`) VALUES
	('123', 'Maria Fonseca', 'Intérprete de Linguas de Sinais', '****', 'DIREN', 'Diren', '', '', '', NULL, 'NAO', 40, 'Servidor', 'SIM', 'SIM', ''),
	('90', 'MATHEUS MOREIRA - NDS', 'ADMINISTRADOR', '****', 'DAP', 'Acompanhamento de Estágio', '', '12345678', 'imatheusmoreira@gmail.com', '1234', 'SIM', 40, 'Servidor', 'NAO', '', 'Estagiario');
/*!40000 ALTER TABLE `servidores` ENABLE KEYS */;

-- Dumping structure for table sistemafrequencia.setor
CREATE TABLE IF NOT EXISTS `setor` (
  `codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `responsavel` varchar(50) DEFAULT NULL,
  `lotacao` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `observacoes` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_setor_lotacao` (`lotacao`),
  CONSTRAINT `FK_setor_lotacao` FOREIGN KEY (`lotacao`) REFERENCES `lotacao` (`nome`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

-- Dumping data for table sistemafrequencia.setor: ~34 rows (approximately)
DELETE FROM `setor`;
/*!40000 ALTER TABLE `setor` DISABLE KEYS */;
INSERT INTO `setor` (`codigo`, `nome`, `responsavel`, `lotacao`, `email`, `observacoes`) VALUES
	(1, 'Secretária de Gabinete', 'Costa', 'DIREÇÃO GERAL', 'costa@gmail.com', ''),
	(2, 'Coordenação de Gestão de Pessoas', 'Giovana', 'DIREÇÃO GERAL', 'giovana@ifce.edu.br', ''),
	(3, 'Comunicação Social', 'Debora', 'DIREÇÃO GERAL', 'deb@gmail.com', ''),
	(4, 'Acompanhamento de Estágio', 'Germana', 'DIREN', 'germa@ifce.edu.br', ''),
	(7, 'Diren', 'Germana Maria Marinho Silva', 'DIREN', 'germanamaracanau@gmail.com', '');
/*!40000 ALTER TABLE `setor` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

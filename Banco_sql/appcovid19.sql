-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 06-Jul-2021 às 02:40
-- Versão do servidor: 10.4.14-MariaDB
-- versão do PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `appcovid19`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `checkin`
--

CREATE TABLE `checkin` (
  `codcheckin` bigint(20) NOT NULL,
  `nenhumsintoma` tinyint(1) NOT NULL,
  `febre` tinyint(1) NOT NULL,
  `tosse` tinyint(1) NOT NULL,
  `dificuldaderespirar` tinyint(1) NOT NULL,
  `fraqueza` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `userid` bigint(20) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `datanasc` int(11) NOT NULL,
  `peso` double NOT NULL,
  `altura` double NOT NULL,
  `alergias` text DEFAULT NULL,
  `doencas` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`userid`, `nome`, `email`, `datanasc`, `peso`, `altura`, `alergias`, `doencas`) VALUES
(2, 'Pedro Antônio', 'pedro@gmail.com', 12081989, 89.9, 1.98, 'Tomate, Leite', 'Cardíaco'),
(9, 'Rogério', 'roger@gmail.com', 12031980, 85.5, 1.75, 'Rinite', 'Artrite'),
(10, 'Rogério', 'rogerio@gmail.com', 12041980, 87.6, 1.78, 'Pólen', 'Artrite');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `checkin`
--
ALTER TABLE `checkin`
  ADD PRIMARY KEY (`codcheckin`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `checkin`
--
ALTER TABLE `checkin`
  MODIFY `codcheckin` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `userid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

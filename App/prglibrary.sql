-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le :  mar. 20 juil. 2021 à 21:00
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.4.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `prglibrary`
--

-- --------------------------------------------------------

--
-- Structure de la table `admins`
--

DROP TABLE IF EXISTS `admins`;
CREATE TABLE IF NOT EXISTS `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admins`
--

INSERT INTO `admins` (`id`, `name`, `email`, `password`) VALUES
(1, 'dzeko', 'dzii@gmail.com', '$2a$12$5cXBi4JvlVSgFagM2tP.aOwMKBo7nhJUaSU/qnajNkOta2zeMmZ9a'),
(4, 'dzeko', 'qq@gmail.com', '$2a$12$1zUXQmopH2yOGD9U3bpY3OmmHoHwaDg0OZKY86/7Hz87Wf5UkzZCq'),
(5, 'dzeko', 'email@gmail.com', '$2a$12$jrY2kleby0/Oh2Q0LrYk2eQf0tz87u7SwiGU2Mjm.P7mmg7ZFFUxe'),
(6, 'dzeko', 'mortadaha@gmail.com', '$2a$12$KL93xN6i.3qbghcmLmypxOXzzWEsckdkx.94CBmfFt9msDQBtWlW.');

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

DROP TABLE IF EXISTS `auteur`;
CREATE TABLE IF NOT EXISTS `auteur` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date_naissance` date NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`num`),
  UNIQUE KEY `nom` (`nom`,`prenom`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `auteur`
--

INSERT INTO `auteur` (`num`, `nom`, `prenom`, `date_naissance`, `avatar`) VALUES
(27, 'Krug', 'Steve', '1950-01-01', NULL),
(1, 'dzeko', 'aaa', '2021-07-14', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `co_domaine`
--

DROP TABLE IF EXISTS `co_domaine`;
CREATE TABLE IF NOT EXISTS `co_domaine` (
  `co_id` int(11) NOT NULL,
  `do_id` int(11) NOT NULL,
  `sous_genre` varchar(50) NOT NULL,
  PRIMARY KEY (`co_id`,`do_id`),
  KEY `do_id` (`do_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `co_domaine`
--

INSERT INTO `co_domaine` (`co_id`, `do_id`, `sous_genre`) VALUES
(1, 1, 'Architecture'),
(2, 1, 'Enseignement de l\'art'),
(3, 1, 'Histoire de l\'art'),
(4, 1, 'Danse'),
(5, 1, 'Design'),
(6, 1, 'Mode'),
(7, 1, 'Film'),
(8, 1, 'Design graphique'),
(9, 1, 'Musique'),
(10, 1, 'Solfège'),
(11, 1, 'Peinture'),
(12, 1, 'Photographie'),
(13, 2, 'Ours'),
(14, 2, 'Chats'),
(15, 2, 'Chatons'),
(16, 2, 'Chiens'),
(17, 2, 'Chiots'),
(18, 3, 'Fantastique'),
(19, 3, 'Roman historique'),
(20, 3, 'Épouvante'),
(21, 3, 'Humour'),
(22, 3, 'Littérature'),
(23, 3, 'Magie'),
(24, 3, 'Policier'),
(25, 3, 'Pièce de théâtre'),
(26, 3, 'Poésie'),
(27, 3, 'Romance'),
(28, 3, 'Science-fiction'),
(29, 3, 'Nouvelle'),
(30, 3, 'Thriller'),
(31, 3, 'Jeune adulte'),
(32, 4, 'Biologie'),
(33, 4, 'Chimie'),
(34, 4, 'Mathématiques'),
(35, 4, 'Physique'),
(36, 4, 'Programmation'),
(37, 5, 'Management'),
(38, 5, 'Entrepreneuriat'),
(39, 5, 'Économie'),
(40, 5, 'Réussite d\'entreprise'),
(41, 5, 'Finance'),
(42, 6, 'Littérature pour enfants'),
(43, 6, 'Histoire en rimes'),
(44, 6, 'Petite enfance'),
(45, 6, 'Histoire du soir'),
(46, 6, 'Livre d\'images'),
(47, 7, 'Civilisation ancienne'),
(48, 7, 'Archéologie'),
(49, 7, 'Anthropologie'),
(50, 7, 'Seconde Guerre mondiale'),
(51, 7, 'Vie sociale et coutumes'),
(52, 8, 'Gastronomie'),
(53, 8, 'Livre de cuisine'),
(54, 8, 'Santé mentale'),
(55, 8, 'Exercice'),
(56, 8, 'Alimentation'),
(57, 8, 'Développement personnel'),
(58, 9, 'Autobiographie'),
(59, 9, 'Politique et gouvernements'),
(60, 9, 'Rois et chefs d\'État'),
(61, 9, 'Compositeurs'),
(62, 9, 'Artistes'),
(63, 10, 'Religion'),
(64, 10, 'Science politique'),
(65, 10, 'Psychologie'),
(66, 11, 'Mathématiques'),
(67, 11, 'Géographie'),
(68, 11, 'Psychologie'),
(69, 11, 'Algèbre'),
(70, 11, 'Enseignement'),
(72, 11, 'Économie'),
(73, 11, 'Science'),
(74, 11, 'Chimie'),
(75, 11, 'Langue anglaise'),
(76, 11, 'Physique'),
(77, 11, 'Informatique');

-- --------------------------------------------------------

--
-- Structure de la table `domaine`
--

DROP TABLE IF EXISTS `domaine`;
CREATE TABLE IF NOT EXISTS `domaine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `genres` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `domaine`
--

INSERT INTO `domaine` (`id`, `genres`) VALUES
(1, 'Arts'),
(2, 'Animaux'),
(3, 'Fiction'),
(4, 'Science & Mathématiques'),
(5, 'Économie & Finance'),
(6, 'Fiction jeunesse'),
(7, 'Histoire'),
(8, 'Santé & Bien-être'),
(9, 'Biographie'),
(10, 'Sciences sociales'),
(11, 'Manuel');

-- --------------------------------------------------------

--
-- Structure de la table `ecrit`
--

DROP TABLE IF EXISTS `ecrit`;
CREATE TABLE IF NOT EXISTS `ecrit` (
  `ISSN` int(8) NOT NULL,
  `Num` int(11) NOT NULL,
  PRIMARY KEY (`ISSN`,`Num`),
  KEY `Num` (`Num`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ecrit`
--

INSERT INTO `ecrit` (`ISSN`, `Num`) VALUES
(12345678, 1);

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `issn` int(8) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `resume` varchar(400) NOT NULL,
  `nb_page` int(11) NOT NULL,
  `genre` int(11) NOT NULL,
  `s_genre` int(11) NOT NULL,
  `avatar` varchar(255) NOT NULL,
  `fichier` blob NOT NULL,
  `added_by` int(11) NOT NULL,
  `created_at` date NOT NULL,
  PRIMARY KEY (`issn`),
  KEY `genre` (`genre`),
  KEY `s_genre` (`s_genre`),
  KEY `added_by` (`added_by`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`issn`, `titre`, `resume`, `nb_page`, `genre`, `s_genre`, `avatar`, `fichier`, `added_by`, `created_at`) VALUES
(12345678, 'kkk', 'kkkk', 11, 1, 1, '', '', 4, '2021-07-19');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

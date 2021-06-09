-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 09 juin 2021 à 15:32
-- Version du serveur :  10.1.31-MariaDB
-- Version de PHP :  7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `rmigimmobilier`
--

-- --------------------------------------------------------

--
-- Structure de la table `bien`
--

CREATE TABLE `bien` (
  `id` int(11) NOT NULL,
  `code` varchar(200) NOT NULL,
  `loyer` int(11) NOT NULL,
  `nombrepeice` int(11) NOT NULL,
  `photo` varchar(200) NOT NULL,
  `superficie` int(11) NOT NULL,
  `idtype` int(11) NOT NULL,
  `idproprio` int(11) NOT NULL,
  `etat` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bien`
--

INSERT INTO `bien` (`id`, `code`, `loyer`, `nombrepeice`, `photo`, `superficie`, `idtype`, `idproprio`, `etat`) VALUES
(1, 'M001', 120000, 2, '', 210, 1, 1, 'Occupé'),
(2, 'M002', 80000, 2, '', 120, 1, 5, 'Occupé'),
(3, 'M003', 400000, 5, '', 2300, 4, 2, 'Occupé'),
(4, 'M004', 100000, 2, '', 200, 3, 5, 'Occupé'),
(5, 'M005', 1500000, 6, '', 1200, 2, 10, 'Occupé'),
(6, 'M006', 500000, 3, '', 1000, 1, 10, 'Occupé'),
(7, 'M007', 1600000, 7, '', 1290, 1, 1, 'Occupé'),
(8, 'M008', 700000, 3, '', 1200, 4, 1, 'Occupé'),
(9, 'M009', 2500000, 12, '', 2350, 1, 2, 'Occupé'),
(10, 'M010', 65000, 1, '', 190, 3, 3, 'Occupé'),
(11, 'M011', 45000, 1, '', 69, 3, 3, 'Occupé'),
(12, 'M012', 100000, 2, '', 120, 3, 3, 'Occupé'),
(13, 'M013', 20800000, 10, '', 1080, 1, 4, 'Libre'),
(14, 'M014', 120000, 2, '', 293, 1, 5, 'Libre'),
(15, 'M015', 95000, 2, '', 23, 3, 6, 'Libre'),
(16, 'M016', 500000, 3, '', 120, 1, 7, 'Libre'),
(17, 'M017', 65000, 1, '', 29, 3, 8, 'Occupé'),
(18, 'M017', 50000, 1, '', 123, 3, 13, 'Occupé');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `prenom` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `tel` varchar(200) NOT NULL,
  `NCI` varchar(110) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `email`, `tel`, `NCI`) VALUES
(1, 'Bili', 'Peter', 'bilpet@yahoo.fr', '32893849', 'ZYUZ36J2'),
(2, 'Diouf', 'Joel', 'dioufj@gmail.com', '2978280', 'DSKM56DJ'),
(3, 'Francois', 'Peter', 'francois@gmail.com', '782028826', 'WXLK2379'),
(4, 'Abdoul', 'Adel', 'adel@gmail.com', '772305392', 'LDZL8Z00'),
(5, 'Diallo', 'Abas', 'diallo@gmail.com', '781209200', 'LUZE90ZO'),
(6, 'Paul', 'Steph', 'paulsteph@htmail.com', '702897389', 'EOEZ0320'),
(7, 'Bouche', 'Abi', 'boucheabi@gmail.com', '788127891', 'JKAZ0012'),
(8, 'Gyaume', 'Matt', 'matt82gy@yahoo.com', '761270023', 'KZA29097'),
(9, 'Boit', 'Robin', 'rBoit@contact.com', '702395563', 'AZIDSD45'),
(10, 'Azer', 'Tyra', 'azertyra@gmail.com', '782329090', 'UE8923J9');

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

CREATE TABLE `contrat` (
  `id` int(11) NOT NULL,
  `datecreation` varchar(200) NOT NULL,
  `daternvllmnt` varchar(200) NOT NULL,
  `montantDE` int(11) NOT NULL,
  `idclient` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `contrat`
--

INSERT INTO `contrat` (`id`, `datecreation`, `daternvllmnt`, `montantDE`, `idclient`) VALUES
(1, '01/06/2019', '31/07/2019', 100000, 1),
(2, '21/07/2019', '21/07/2020', 90000, 2),
(3, '22/07/2019', '22/07/2019', 200000, 10),
(4, '22/07/2019', '22/07/2019', 100000, 10);

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `id` int(11) NOT NULL,
  `numf` varchar(200) NOT NULL,
  `idloyer` int(11) NOT NULL,
  `avance` int(11) NOT NULL,
  `arrierees` int(11) NOT NULL,
  `restant` int(11) NOT NULL,
  `datef` varchar(200) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`id`, `numf`, `idloyer`, `avance`, `arrierees`, `restant`, `datef`, `total`) VALUES
(1, 'F001', 1, 0, 0, 0, '12/07/2019', 100000),
(2, 'F002', 1, 0, 0, 0, '06/08/2019', 100000),
(3, 'F003', 1, 0, 0, 0, '21/07/2019', 120000),
(4, 'F004', 2, 0, 0, 0, '21/07/2019', 100000),
(5, 'F005', 4, 0, 0, 0, '21/07/2019', 400000),
(6, 'F006', 6, 300000, 200000, 200000, '22/07/2019', 500000),
(7, 'F017', 13, 0, 0, 0, '22/07/2019', 50000);

-- --------------------------------------------------------

--
-- Structure de la table `loyer`
--

CREATE TABLE `loyer` (
  `id` int(11) NOT NULL,
  `code` varchar(20) NOT NULL,
  `idbien` int(11) NOT NULL,
  `idclient` int(11) NOT NULL,
  `dateentree` varchar(200) NOT NULL,
  `caution` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `loyer`
--

INSERT INTO `loyer` (`id`, `code`, `idbien`, `idclient`, `dateentree`, `caution`) VALUES
(1, 'L001', 2, 1, '01/07/2019', 160000),
(2, 'L002', 4, 3, '03/06/2019', 200000),
(3, 'L003', 1, 3, '21/07/2019', 240000),
(4, 'L004', 3, 4, '04/07/2019', 800000),
(5, 'L005', 5, 5, '11/06/2019', 3000000),
(6, 'L006', 6, 5, '29/05/2019', 1000000),
(7, 'L007', 7, 6, '01/07/2019', 3200000),
(8, 'L008', 8, 7, '21/07/2019', 1400000),
(9, 'L009', 9, 4, '15/03/2019', 5000000),
(10, 'L010', 10, 6, '21/07/2019', 130000),
(11, 'L011', 11, 2, '21/07/2019', 90000),
(12, 'M012', 12, 10, '22/07/2019', 200000),
(13, 'L017', 18, 10, '22/07/2019', 100000);

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `id` int(11) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `adresse` varchar(200) NOT NULL,
  `tel` int(11) NOT NULL,
  `email` varchar(200) NOT NULL,
  `paiement` int(11) NOT NULL,
  `moyen` varchar(200) NOT NULL,
  `type` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `proprietaire`
--

INSERT INTO `proprietaire` (`id`, `nom`, `adresse`, `tel`, `email`, `paiement`, `moyen`, `type`) VALUES
(1, 'Diouf Abasse', 'Dakar plateau Rue 12 x 34 ', 3692100, 'abasse12@gmail.com', 2420000, 'Depot', 'Particulier'),
(2, 'Ben immo', 'Sacré coeur 3 Rue 21 x 26', 783839902, 'contact@immo.org', 2900000, 'Virement', 'Entreprise'),
(3, 'Sen Home', 'Fasse Rue 39 x 48', 3392338, 'home@sn.com', 210000, 'Virement', 'Entreprise'),
(4, 'Babacar Diagn', 'Medina Rue 25 x 26', 782630927, 'diagn89b@yahoo.com', 20800000, 'Depot', 'Particulier'),
(5, 'Kodros Mv', 'Plateau Rue 37x12', 762379350, 'mvkodros@gmail.com', 300000, 'Virement', 'Particulier'),
(6, 'Beniimmobilier', 'Fasse Rue 9 x 23 ', 782320099, 'beni@gmail.com', 95000, 'Virement', 'Entreprise'),
(7, 'Coloc Home', 'Point E Rue 15 x 26', 772390035, 'homecoloc@gmail.com', 250000, 'Virement', 'Entreprise'),
(8, 'Kara Abdoule', 'Liberté 6 Rue 33 x 12', 773290383, 'karaabdoule@gmail.com', 58500, 'Virement', 'Particulier'),
(9, 'Keurgy Immobilier', 'HLM 5 Rue 22 x 26', 338720939, 'keurgyimmo@gmail.com', 0, 'Virement', 'Entreprise'),
(10, 'Cibemmo', 'Sacré coeur 3 Rue 1 x 23', 3389293, 'cibemmo@info.com', 2000000, 'Virement', 'Entreprise'),
(11, 'Babakar Ly', 'Medina Rue 22 x 29', 781290286, 'babakarly@gmail.com', 0, 'Depot', 'Particulier'),
(12, 'Diop Lo', 'Medina Rue 26 x 23', 781290288, 'dioplo@gmail.com', 0, 'Virement', 'Particulier'),
(13, 'PromesseImmo.cn', 'Plateau Rue 19 x 15', 781202563, 'prommeimmo@yahoo.com', 45000, 'Virment', 'Entreprise');

-- --------------------------------------------------------

--
-- Structure de la table `typebien`
--

CREATE TABLE `typebien` (
  `id` int(11) NOT NULL,
  `libelle` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typebien`
--

INSERT INTO `typebien` (`id`, `libelle`) VALUES
(1, 'Appartement'),
(2, 'Duplex'),
(3, 'Studio'),
(4, 'Villa'),
(5, 'Chambre');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `login` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `login`, `password`) VALUES
(1, 'Exaucé Yanga', 'passer', 'passer');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bien`
--
ALTER TABLE `bien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idtype` (`idtype`),
  ADD KEY `idproprio` (`idproprio`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idclient` (`idclient`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idloyer` (`idloyer`);

--
-- Index pour la table `loyer`
--
ALTER TABLE `loyer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idbien` (`idbien`),
  ADD KEY `idclient` (`idclient`);

--
-- Index pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `typebien`
--
ALTER TABLE `typebien`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bien`
--
ALTER TABLE `bien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `contrat`
--
ALTER TABLE `contrat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `loyer`
--
ALTER TABLE `loyer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `typebien`
--
ALTER TABLE `typebien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bien`
--
ALTER TABLE `bien`
  ADD CONSTRAINT `bien_ibfk_1` FOREIGN KEY (`idtype`) REFERENCES `typebien` (`id`),
  ADD CONSTRAINT `bien_ibfk_2` FOREIGN KEY (`idproprio`) REFERENCES `proprietaire` (`id`);

--
-- Contraintes pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD CONSTRAINT `contrat_ibfk_1` FOREIGN KEY (`idclient`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_1` FOREIGN KEY (`idloyer`) REFERENCES `loyer` (`id`);

--
-- Contraintes pour la table `loyer`
--
ALTER TABLE `loyer`
  ADD CONSTRAINT `loyer_ibfk_1` FOREIGN KEY (`idclient`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `loyer_ibfk_2` FOREIGN KEY (`idbien`) REFERENCES `bien` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;




SET NAMES 'utf8';
USE wildslack;
--
-- Delete data from the table 'workspace_users'
--
TRUNCATE TABLE workspace_users;
--
-- Delete data from the table 'workspace'
--
TRUNCATE TABLE workspace;
--
-- Delete data from the table 'message'
--
TRUNCATE TABLE message;
--
-- Delete data from the table 'channel_users'
--
TRUNCATE TABLE channel_users;
--
-- Delete data from the table 'channel_message'
--
TRUNCATE TABLE channel_message;
--
-- Delete data from the table 'channel'
--
TRUNCATE TABLE channel;
--
-- Delete data from the table 'app_user'
--
TRUNCATE TABLE app_user;

--
-- Inserting data into table app_user
--
INSERT INTO app_user(id_user, email, nickname, password, last_chan) VALUES
(1, 'AbrahamAcevedo@example.com', 'Abraham968', '8A8NZA0EpJowiIy2lsHnLPQADs51EjnrmWFRMC81BpU=', 2),
(2, 'Jude_High169@example.com', 'Markus549', 'OnLnb1PljeW2jzMkJYRjXwz4z0/gOtX8QXwdkKl+CNY=', 3),
(3, 'Bauer@example.com', 'Jason4', 'u6L4xbnpzz/ccORBRi7fD6IyyRiLRsanDMXr2UGz4SY=', 1),
(4, 'Alarcon@example.com', 'Mcnally2', 'se2GJ2NM5GbixM5Y7us0iplLEf5lyDG7UN1YfEMc+CQ=', 1),
(5, 'gndd9978@example.com', 'Adolph45', 'yBZraHMSMG4W5ucwuFAzRVgh7jO8OYtFKw6xgh7Tr6U=', 2),
(6, 'Palmer_Lofton@example.com', 'Luther2020', '7e0QmiqiDY5phsM3i9YFPu/ocu6HcQ3l5YtWOeFw33I=', 4),
(7, 'Abernathy@example.com', 'Ada2005', '0pInYY4C+xF+f3f8AQz3euVYRq/l63wwtkerwqU9S+o=', 3),
(8, 'Adaline_Abbott@example.com', 'Gerardo1992', 'V7cxJ6+dPe9Ad2l7kYQi5lJwP9cyBXqg8fBYffLR+10=', 5),
(9, 'Shayne_Britton589@example.com', 'Carmela778', 'RKUg8XtHEWNU9vF0rtZKAopYuiUflNmbWgowcfyGAbE=', 3),
(10, 'mxwygtmf_ahjpwboxdy@example.com', 'Florida343', '7DAbjw315gpOyhT+lfSraUaEK5K0QJkxcClXfIaNQXM=', 2);

--
-- Inserting data into table channel
--
INSERT INTO channel(id_channel, default_channel, description, name, workspace_id_workspace) VALUES
(1, False, 'incalculable', 'Lady Vengeance (KOR)', 1),
(2, True, 'spacieux spatieuse', 'Last Summer of the Rich (The) (AUT)', 2),
(3, False, 'large ', 'Last Summer (USA)', 3),
(4, True, 'truculent', 'Larmes du soleil (Les) (USA)', 1),
(5, False, 'vorace', 'Last Face (The) (USA)', 2);

--
-- Inserting data into table channel_message
--
INSERT INTO channel_message(message_id, channel_id_channel) VALUES
(1, 4),
(2, 1),
(3, 5),
(4, 2),
(5, 3),
(6, 1),
(7, 4),
(8, 5),
(9, 2),
(10, 3),
(11, 1),
(12, 3),
(13, 2),
(14, 5),
(15, 4),
(16, 3),
(17, 2),
(18, 5),
(19, 4),
(20, 1),
(21, 4),
(22, 5),
(23, 3),
(24, 1),
(25, 2),
(26, 4),
(27, 5),
(28, 3),
(29, 1),
(30, 2),
(31, 5),
(32, 1),
(33, 4),
(34, 2),
(35, 3),
(36, 3),
(37, 1),
(38, 5),
(39, 2),
(40, 4),
(41, 1),
(42, 4),
(43, 3),
(44, 2),
(45, 5),
(46, 1),
(47, 4),
(48, 5),
(49, 3),
(50, 2),
(51, 3),
(52, 5),
(53, 2),
(54, 1),
(55, 4),
(56, 5),
(57, 4),
(58, 3),
(59, 2),
(60, 1),
(61, 2),
(62, 3),
(63, 1),
(64, 4),
(65, 5),
(66, 4),
(67, 3),
(68, 5),
(69, 1),
(70, 2),
(71, 2),
(72, 1),
(73, 4),
(74, 5),
(75, 3),
(76, 1),
(77, 5),
(78, 2),
(79, 4),
(80, 3),
(81, 5),
(82, 2),
(83, 3),
(84, 4),
(85, 1),
(86, 1),
(87, 3),
(88, 5),
(89, 4),
(90, 2),
(91, 1),
(92, 5),
(93, 3),
(94, 2),
(95, 4),
(96, 3),
(97, 4),
(98, 5),
(99, 1),
(100, 2);

--
-- Inserting data into table channel_users
--
INSERT INTO channel_users(id_channel, id_user) VALUES
(5, 1),
(1, 2),
(4, 3),
(3, 4),
(2, 5),
(2, 6),
(4, 7),
(1, 8),
(5, 9),
(3, 10),
(3, 1),
(4, 2),
(5, 3),
(1, 4),
(2, 5),
(2, 6),
(5, 7),
(4, 8),
(1, 9),
(3, 10);

--
-- Inserting data into table message
--
INSERT INTO message(id, message, post_date, app_user_id_user, channel_id_channel) VALUES
(1, '-Vous voulez un whisky ?', '1989-04-27 18:31:31', 1, 3),
(2, '-Juste un doigt !', '1972-07-07 14:59:01', 9, 2),
(3, '-Vous voulez pas un whisky d''abord ? ', '2017-05-30 10:05:22', 6, 4),
(4, '- Il s''est fait coincer par la tapette géante ! ', '1970-01-01 00:00:03', 2, 1),
(5, '- Écoutez Kara, Monsieur n''est pas une tapette, Monsieur est commissaire de police ! ', '1999-04-25 23:03:13', 3, 5),
(6, '-Madame, je vous pisse à la raie ! ', '1996-09-30 02:56:25', 1, 4),
(7, '-Deray. Odile Deray ', '1995-05-20 19:48:40', 3, 2),
(8, 'On peut tromper mille personnes une fois mais on ne peut pas tromper mille personnes mille fois. ', '1996-06-09 17:43:52', 10, 1),
(9, 'Écoutez, laissez la police faire son travail, dès que j''aurais de plus amples informations, croyez bien que vous en serez les premiers informés. ', '1981-05-13 00:23:46', 4, 5),
(10, '- Parlez-moi de vous plutôt...', '2001-06-03 16:00:27', 10, 3),
(11, '- Odile. Moi, c''est Odile. Pluto, c''est l''ami de Mickey.', '2002-02-05 00:06:49', 8, 1),
(12, '- Ah non, Pluto c''est le chien de Mickey. L''ami de Mickey c''est Dingo.', '2000-08-31 15:18:45', 10, 2),
(13, '- Pardonnez-moi, je ne sais plus ce que je dis. C''est ce film, toute cette pression... ', '2016-12-09 21:43:46', 3, 5),
(14, 'Quand je suis content, je vomis ! ', '1976-09-25 21:26:26', 7, 3),
(15, 'Les castors lapons sont-ils hermaphrodites ? C''est la question que se pose ce chercheur... ', '1970-01-23 22:44:31', 9, 4),
(16, 'Prenez un chewing gum Emile ! ', '1989-07-15 13:51:42', 10, 3),
(17, '-Tiffani euh... j''veux pas te prendre la tête avec ça, mais est-ce-que je peux dormir chez toi ce soir, j''ai...j''ai perdu ma mère ce matin.', '1976-12-12 16:49:09', 7, 2),
(18, '-Elle est morte ?', '2014-03-14 04:45:42', 1, 5),
(19, '-Non non, je l''ai perdue, c''est à dire que je l''ai perdue quoi, elle était là et puis pou..pouf, je l''ai perdue... Mais mon chien est mort, par contre. Alors si... si je pouvais dormir chez toi, tu vois, juste pour avoir une présence, un compagnon, pour p', '1971-11-27 11:56:45', 5, 1),
(20, '-Ca fait trois fois qu''il est mort ton chien.', '1970-01-01 01:37:15', 10, 4),
(21, '-Oui, mais il a beaucoup souffert hein ! ', '2017-01-10 11:06:13', 3, 5),
(22, '- Vous savez parler le Danois Simon ?', '1978-03-02 04:53:34', 3, 4),
(23, '- Non.', '1993-11-30 21:12:57', 1, 1),
(24, '- Non ? Oh... Il va falloir apprendre... Skoul ofen sru. répétez après moi : Skoul ofen sru.', '1970-01-01 00:00:04', 2, 2),
(25, '- Skoul ofen sru.', '1970-01-01 00:05:48', 9, 3),
(26, '- Oh mais non je suis sotte c''est du suédois !', '2007-09-15 07:49:05', 9, 4),
(27, '- Oh mais non je suis sotte c''est du suédois ! ', '1981-07-04 22:06:45', 8, 5),
(28, '- Commissaire ! Je reviens du Caméo, regardez ce qu''on a trouvé coincé dans une porte : un doigt !', '1970-01-01 00:01:12', 3, 2),
(29, '- Ah !', '1971-11-06 15:08:24', 3, 1),
(30, '- Nan, je déconne. Nan, c''est ça qu''on a trouvé... ', '2014-02-05 16:01:07', 9, 3),
(31, 'Meurs, pourriture communiste ! ', '1970-01-01 00:00:11', 6, 2),
(32, 'Pour des raisons de budget, la scène suivante sera entièrement bruitée à la bouche. ', '1981-11-29 13:04:03', 3, 3),
(33, '- Tu as une brosse ?', '1987-06-18 12:33:17', 3, 5),
(34, '- Merci toi aussi !', '1991-12-10 14:51:55', 2, 4),
(35, '- Tu as été formidable.', '1970-01-01 00:10:48', 9, 1),
(36, '- Oui dans le tiroir. ', '1970-01-01 00:00:05', 6, 1),
(37, 'Il sort dixième de l''école de police de Nice avec une moyenne de /, ce qui est bien mais pas top. ', '2018-06-03 20:41:16', 3, 4),
(38, 'On peut se tutoyer ? C''est plus sympa... T''es lourd !', '1983-10-01 14:29:28', 6, 5),
(39, '- Sarah Connor ?', '1988-04-14 15:55:41', 1, 2),
(40, '- C''est à côté. ', '1970-01-01 00:00:26', 6, 3),
(41, '- Tu connais la différence entre un pull-over et une moule ?', '1995-12-23 03:13:33', 8, 2),
(42, '- Non...', '1970-01-01 00:24:42', 7, 3),
(43, '- Un pull-over ça moule, et une moule ça pue l''ovaire. ', '2016-03-25 23:19:59', 5, 4),
(44, 'Aréoport de Nice, aréoport de Nice ! Deux minutes d''arrêt ! ', '1970-01-01 00:01:28', 2, 5),
(45, 'O, D, I, maintenant L... Mais que ça peut bien vouloir dire ? LIDO ? C''est un truc de danseuses... ', '2012-05-04 07:07:36', 9, 1),
(46, 'Il ne peut plus rien nous arriver d''affreux maintenant ! ', '2004-12-26 18:06:17', 1, 1),
(47, 'Tu fais super bien le chat ! ', '1990-11-12 19:06:00', 10, 2),
(48, 'Karamazov, aucun lien je suis fils unique. ', '2008-11-27 14:29:36', 5, 5),
(49, '- Je suis envoyé par l''agence Security.', '2015-09-02 14:01:31', 5, 3),
(50, '- Et vous êtes ?', '1971-02-25 20:52:10', 1, 4),
(51, '- À l''Aréoport. ', '2006-09-28 03:58:42', 3, 4),
(52, 'Il dit qu''il a plus de genou. Il dit qu''il voit pas le rapport. ', '1970-08-13 20:44:56', 6, 2),
(53, '- Bon d''autres indices ? ', '2010-08-15 11:43:48', 1, 3),
(54, '- Oui, le tueur a laissé une deuxième lettre sur le mur. La première était un O, la deuxième est un D. On sait pas ce que ça veut dire mais les types des chiffres et des lettres sont dessus.', '1988-09-02 12:28:11', 7, 1),
(55, '- Ca n''est que des bonnes choses hein ! C''est du cacao de synthèse avec de la margarine et de la saccharose aussi. ', '1992-05-01 14:17:08', 7, 5),
(56, '- Je ne sais pas si vous avez remarqué Thérèse, mais il y a une espèce de deuxième couche à l''intérieur ! ', '1976-05-26 11:31:00', 10, 2),
(57, '- C''est fin, c''est très fin, ça se mange sans faim. ', '1977-03-08 12:52:56', 7, 5),
(58, '- C''est une fabrication artisanale.', '1970-01-01 00:00:07', 4, 4),
(59, '- Oui effectivement, on a un petit peu l''impression que c''est fait à la main quoi...', '1970-01-01 00:08:00', 3, 3),
(60, '- Oui, oui, oui, C''est fait à la main, c''est roulé à la main sous les aisselles. ', '2003-06-21 19:50:03', 1, 1),
(61, 'Bonhomme en retard, liaison dans le tiroir. ', '2007-08-24 09:53:47', 9, 3),
(62, '- Une serpillère ! C''est formidable Thérèse, je suis ravi, écoutez...', '1970-01-01 00:00:05', 7, 1),
(63, '- Non pierre, c''est un gilet. ', '1989-01-31 09:45:11', 10, 4),
(64, '- Ah oui ! Ah bah bien sûr, ah bah et alors bien sûr c''est un gilet : il y a des trous plus grands pour les bras. Alors... Je suis ravi, Thérèse. Je suis... Vraiment je suis ravi !', '1970-01-01 00:06:05', 3, 5),
(65, '- Et point de vue coloris parce que... j''avais pensé à un joli camaïeu de bleu marine comme je sais que vous aimez bien, puis je me suis dit dans ces tons là, ça changera.', '1993-11-11 03:22:39', 10, 2),
(66, '- Vous avez tout à fait raison Thérèse parce que le gris et bordeaux ça va avec tout alors, vous ne risquez pas de vous tromper.', '2004-08-12 17:50:50', 5, 3),
(67, '- Et puis c''est une chose qui n''est pas commune et que vous ne verrez pas chez tout le monde.', '1986-04-17 01:15:00', 5, 5),
(68, '- Mais j''espère bien Thérèse, J''espère bien. Ecoutez, si vous saviez ce que ça tombe bien : je me disais encore hier soir qu''il me manquait quelque chose pour descendre les poubelles. ', '2002-03-20 11:11:16', 10, 2),
(69, 'Je ne vous jette pas la pierre, Pierre, mais j''étais à deux doigts de m''agacer. ', '1983-09-29 13:11:17', 6, 4),
(70, '- Qu''est ce qu''il se passe, ma ... ma veste est pleine de Cambouis...', '1977-01-20 21:40:38', 10, 1),
(71, '- Où est-ce que vous vous êtes taché comme ça Monsieur Boisseau ?', '1970-01-01 00:05:31', 9, 3),
(72, '- Je vous présente toutes mes confuses !', '1970-01-01 00:15:28', 4, 4),
(73, '- Vos confuses... Vous n''imaginez pas que je vais réveillonner chez Castel avec ça ? Mais qu''est ce que c''est cette matière, c''est, c''est de la merde ?', '1994-02-23 02:03:48', 10, 5),
(74, '- Non, non, c''est Klug ! ', '2009-08-03 04:13:54', 10, 1),
(75, 'Tenez M. Prescovic, Nettoyez. Parce qu''imaginez qu''un chien vienne à manger ça, y pourrait être malade. Non, j''veux dire, à cause des bouts d''verre. ', '1979-03-03 11:11:22', 6, 2),
(76, '- Non, non, le village est gentil là, mais... C''est l''intervention de cette grosse femme, c''est un p''tit peu... Enfin c''est... Ça va très loin...', '1989-10-03 10:25:39', 6, 1),
(77, '- Oui, mais, c''est, c''est là que je me rends compte que malheureusement, je vous ai beaucoup moins bien réussie que le porc. ', '1970-01-01 00:00:59', 9, 2),
(78, '- Y''a un monsieur qui a appelé et ben y voulait enculer Thérèse !', '1991-04-07 08:36:54', 5, 5),
(79, '- Oui mais c''est un ami ! ', '1986-07-02 16:41:17', 5, 4),
(80, '- Éboueur, ça vous va ?', '1995-03-16 21:06:26', 6, 3),
(81, '- Hé dites donc ! Pourquoi pas ramasser les poubelles tant qu''vous y êtes ? Ça va pas non ? Non, non, on va mettre autre chose, on va mettre euh... Oh, bah vous avez qu''a mettre burelier.', '2004-12-26 18:57:14', 2, 1),
(82, '- Pardon ? ', '2011-09-20 19:07:47', 4, 4),
(83, '- Burelier, celui qui travaille dans les bureaux.', '2001-10-30 19:00:01', 5, 5),
(84, '- Ah oui, vous voulez dire buraliste ?', '1991-08-18 09:31:39', 4, 3),
(85, '- Mais non Buraliste ça bosse dans un tabac. Mais vous êtes complètement abrutie vous hein ? ', '1987-11-24 16:58:06', 10, 2),
(86, 'Donnez-moi un morceau de cette chose longue et molle... ', '1980-05-03 18:37:33', 1, 3),
(87, 'Ecoutez Thérèse, je n''aime pas dire du mal des gens, ...mais effectivement elle est gentille... ', '2015-04-03 02:11:07', 6, 2),
(88, 'Votre gueule Thérèse, votre gueule ! ', '1978-02-18 03:04:17', 2, 5),
(89, '- Non mais c''est des querelles d''amoureux ça, vous êtes marié ? Vous ne vous êtes jamais disputé avec votre femme vous ?', '1970-01-01 00:00:06', 2, 4),
(90, '- Oui, mais jamais à coup de fer à souder !', '1975-12-29 05:28:47', 10, 1),
(91, '- C''est parce que vous n''êtes pas bricoleur, c''est tout... ', '1970-01-01 00:15:55', 7, 2),
(92, 'Mais je vous en prie. Figurez-vous que Thérèse n''est pas moche. Elle n''a pas un physique facile... C''est différent. ', '1983-08-28 07:53:50', 7, 1),
(93, 'J''ai bientôt fini avec mes petits lépreux de Jakarta. C''est tout la Croix Rouge ça ! Ils me demandent de faire des gants à trois doigts. Vous croyez pas que j''aurais pas plus vite fait de faire des moufles ! ', '1980-02-16 02:42:59', 10, 4),
(94, 'Si vous pouviez faire levier, je pourrais m''introduire ! ', '1993-02-19 10:47:18', 4, 5),
(95, 'Il m''écrase la pomme des dents. ', '1970-01-01 00:01:07', 1, 3),
(96, 'Ca dépend, ça dépasse ! ', '2017-01-14 18:31:33', 5, 4),
(97, 'Oui, je vois difficilement comment j''aurais pu avoir moins de chance qu''en recevant une balle dans le pied, mais si vous connaissez pire, faites-moi signe ! ', '1970-01-01 00:08:38', 10, 3),
(98, 'C''est c''la oui ! ', '1991-08-11 06:21:03', 5, 1),
(99, '- Allô, Détresse Amitié, Joyeux Noël !', '2004-06-17 13:28:34', 8, 2),
(100, '- Allô ?', '2007-12-10 01:56:44', 4, 5);

--
-- Inserting data into table workspace
--
INSERT INTO workspace(id_workspace, description, name) VALUES
(1, 'tendu ', 'Marie-Louise Damien'),
(2, 'attifé (bien/mal)', 'Jean-Paul Belmondo'),
(3, 'parfait', 'Jean-Louis Barrault');

--
-- Inserting data into table workspace_users
--
INSERT INTO workspace_users(id_workspace, id_user) VALUES
(1, 1),
(2, 2),
(3, 3),
(1, 4),
(2, 5),
(3, 6),
(1, 7),
(2, 8),
(3, 9),
(1, 10);
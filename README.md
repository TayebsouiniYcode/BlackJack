Project context
Vous êtes médiateur numérique et on vous demande de faire des ateliers de jeux aux profils des apprenants YouCode.

​

L’équipe pédagogique décide de créer un jeu de cartes qui aident les apprenants à s’amuser.

​

Dans un jeu de cartes, une carte est caractérisée par sa hauteur (1 pour l’as, 2 à 10 pour les cartes correspondantes, 11 pour le valet, 12 pour la dame, 13 pour le roi), et par sa couleur (1 pour carreau, 2 pour cœur, 3 pour pique, et 4 pour trèfle).

​

Exemple :

​

(12 3)) -> (Dame Pique)

​

(5 1) -> (5 Carreau)

​

On souhaite créer un jeu de 52 cartes défini comme une liste de cartes. Pour cela, on va définir une méthode qui construit une liste de cartes suivant une première carte donnée, et l'on utilisera ensuite pour créer le jeu de cartes à partir de l'as de carreau. Pour cela vous devez utiliser :

​

une méthode qui construit la liste des cartes suivantes d’une carte donnée en paramètre. Cette liste doit respecter l’ordre des couleurs (carreau, cœur, pique, trèfle) ; ainsi la dernière carte correspond au roi de trèfle. (13 4) -> () (8 4) -> (9 4) (10 4) (11 4) (12 4) (13 4) (12 3) -> ((13 3) (1 4) (2 4) (3 4) (4 4) (5 4) (6 4) (7 4) (8 4) (9 4) (10 4) (11 4) (12 4) (13 4))
une méthode qui crée un jeu de 52 cartes défini comme une liste de couples de valeurs. Exemple : (creer_cartes) -> ((1 1) (2 1) … (12 4) (13 4))
​

Pour écrire une méthode qui mélange un jeu de cartes, on va procéder en plusieurs étapes. Pour mélanger, il faut pouvoir tirer une carte au hasard pour en faire la première carte du nouveau jeu mélangé. Pour cela, on choisira au hasard l'indice i de la carte à tirer, pour ensuite extraire du jeu la carte d'indice i. Voici donc trois méthodes qui permettent de programmer cette méthode.

La méthode extraire_ieme_carte qui extrait la ième carte d’une liste de cartes donnée en paramètre. Cette méthode renvoie une liste constituée de la carte extraite et de la liste des cartes restantes (extraire_ieme_carte '((1 1) (12 3) (14 4)) 2) -> ((12 3) ((1 1) (14 4)))
La méthode tirer_une_carte qui tire une carte au hasard parmi les cartes d’une liste de cartes donnée en paramètre. Cette fonction renvoie une liste constituée de la carte tirée, et de la liste des cartes restantes après le tirage. Pour écrire cette méthode, utilisez random n qui renvoie un nombre au hasard compris entre 0 (inclus) et n (exclus), ainsi que la méthode extraire_ieme_carte. (tirer_une_carte '((1 2) (13 4) (5 3) (1 1) (6 3))) -> ((6 3) ((1 2) (13 4) (5 3) (1 1)))
Écrire la méthode melanger_jeu_cartes qui permet de mélanger les cartes d’une liste de cartes donnée en paramètre. Cette méthode renvoie la liste des cartes mélangées. À noter que cette méthode utilise la fméthode tirer_une_carte. (melanger_jeu_cartes '((10 1) (4 4) (5 2)) -> ((10 1) (5 2) (4 4))
​

Piocher des cartes est différent de tirer des cartes au hasard : la pioche est un paquet de cartes. Quand on pioche des cartes, on prend les carte qui se trouvent au dessus de la pioche. Lorsque qu'on se défausse, on remet les cartes en dessous de la pioche.

La méthode piocher_n_cartes qui permet de piocher les n premières cartes d’une liste de cartes donnée en paramètre. Cette méthode renvoie une liste constituée de la liste des cartes piochées, et de la liste des cartes restantes dans la pioche. (piocher_n_cartes '((13 4) (5 3) (1 1) (6 3)) 2) -> (((13 4) (5 3)) ((1 1) (6 3)))
La méthode defausser_cartes qui prend deux listes de cartes en paramètres (une liste de cartes correspondant à la pioche et une liste des cartes à défausser) et qui retourne la liste de ces cartes de la pioche, dont les cartes à défausser ont été mises à la fin. (defausser_cartes '((1 1)(1 2)) '((3 4)(4 3))) -> ((1 1)(1 2)(3 4)(4 3)
​

Une partie de blackjack va opposer le joueur à la banque. La banque commence par tirer une carte et va ensuite en donner deux au joueur. Le but de ce jeu consiste à approcher ou faire le chiffre 21 sans le dépasser. La valeur des cartes est établie comme suit : les cartes de 2 à 10 conservent leurs valeurs, les figures valent 10 et l’as vaut 1.

​

Le joueur peut demander autant de cartes qu’il le souhaite. S’il dépasse 21, il perd. S’il s’arrête avant, la banque tire des cartes jusqu’à dépasser 17 pour ne pas prendre de risque. Si la banque fait moins que le joueur, ou qu’elle dépasse 21, le joueur gagne. S’il fait moins que la banque, le joueur perd. Sinon, il y a égalité.

​

Dans ce projet, un jeu de blackjack sera considéré comme une liste de 3 sous-listes : la liste des cartes de la banque, la liste des cartes du joueur et la liste des cartes restantes dans la pioche.

La méthode creer_blackjack prépare le jeu du blackjack en initialisant la liste correspondante au jeu. Cette méthode retourne ainsi une liste constituée de la liste des cartes du joueur (vide au départ), de la liste des cartes de la banque (vide au départ), et de la pioche (constituée au départ des 52 cartes mélangées du jeu)
Des méthodes permettent d’accéder respectivement à la liste des cartes du joueur, de la banque et de la pioche à partir d’une liste définissant le jeu du blackjack.
Des méthodes permettent d’accéder respectivement à la liste des cartes du joueur, de la banque et de la pioche à partir d’une liste définissant le jeu du blackjack
La méthode banque_pioche_n qui met à jour le jeu du blackjack après une pioche de n cartes de la part de la banque
La méthode joueur_pioche_n qui met à jour le jeu du blackjack après une pioche de n carte de la part du joueur.
Une méthode total_cartes qui retourne les points correspondant à une liste de cartes donnée en paramètre. Pour rappel, un as compte pour un point ; les figures comptent pour dix points ; les cartes de 2 à 10 conservent leurs valeurs. (total_cartes '((1 3) (13 4) (5 4))) -> 16
Une méthode faire_jouer_banque qui fait jouer la banque jusqu’à qu’elle atteigne au moins un total de 17 points. Cette méthode renvoie la liste du blackjack mise à jour
Une méthode afficher_jeu permet d’afficher l’état du jeu.
Une méthode faire_jouer_joueur qui retourne le jeu du blackjack mis à jour après le jeu du joueur (après 0, une ou plusieurs pioches). Si le joueur atteint 21 points, il est inutile de continuer à jouer. Sinon cette méthode doit donner le choix au joueur de rejouer ou non.
Une méthode tout_defausser permet de défausser toutes les cartes afin de recommencer à jouer. Cette méthode renvoie ainsi le jeu du blackjack dont les cartes de la banque et celles du joueur ont été mises dans la pioche.
La méthode tour_de_jeu simule un tour de jeu : la banque tire une carte, puis le joueur tire 2 cartes, et continue à jouer s’il le souhaite. Quand le joueur s’arrête, ses points sont comptabilisés. Si le joueur a dépassé les 21 points, la méthode affiche le fait qu’il a perdu. Sinon, la banque continue à jouer. À la fin du jeu de la banque, son nombre de points est comptabilisé. Puis la méthode affiche le jeu et un message précisant qui est le gagnant.
Une méthode permet de jouer plusieurs tours au blackjack
​

Dans la règle complète du blackjack, chaque As peut prendre au choix la valeur 1 ou 11. Dans la pratique, pour un joueur donné, un seul As peut prendre la valeur 11 (sinon on a un score d'au moins 22), et la valeur d'un As est choisie pour maximiser le score sans dépasser 21. Exemple: Si un joueur a un As et un 4, il a (au choix) 5 points ou 15 : on privilégiera la valeur 11 pour l'As pour profiter d'un meilleur score. Si le joueur décide de tirer une autre carte et qu'il obtient un 9, l'As vaut alors 1 pour atteindre un total de 14 (au lieu de 24 s'il valait 11). Proposez une méthode total_cartes2 qui prend en compte cette nouvelle règle dans le comptage des points d'un ensemble de cartes.

​

Une partie de bataille va opposer le joueur à la machine. Un jeu de 52 cartes est mélangé et partagé en deux paquets de 26 cartes : l'un pour la machine, l'autre pour le joueur. À chaque tour, le joueur et la machine piochent une carte dans leur paquet. Celui qui pioche la carte de hauteur la plus élevée remporte le pli, c'est-à-dire qu'il met les deux cartes jouées en dessous de son paquet. Pour simplifier le problème, on décide que l'As vaut 1 et qu'en cas d'égalité, chacun remet sa carte sous son paquet. Le jeu se poursuit jusqu'à ce qu'un joueur n'ait plus de cartes. L'autre joueur est alors le gagnant.
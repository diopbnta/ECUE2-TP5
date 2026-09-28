# TP5 : Réponses

Nom / Prénom :

## Partie 1 : Enquête

| Étape | Ce qui est anormal                                          | Ligne responsable                                                        | Classe qui aurait dû l'empêcher |
|-------|-------------------------------------------------------------|--------------------------------------------------------------------------|---------------------------------|
| 1     | Tous les auteurs affiches verne                             | Static dans Auteur                                                       | Auteur                          |
| 2     | Germinal a un nombre de disponibles  de -2 aprés 3 emprunts | germinal.nbDisponibles--;                                                | Livre                           |
| 3     | Date de naissance 2090                                      | Auteur inconnu = new Auteur("Dupont", "Jean", LocalDate.of(2090, 1, 1)); | Auteur                          |
| 4     | L'ISBN devient "123" et le titre devient null               | tourDuMonde.isbn = "123"; et tourDuMonde.titre = null;                   | Livre                           |
| 5     | Modifier et ensuite ajouter des livres                      | bib.nbLivres = 1; puis bib.ajouterLivre(...)                             | Bibliotéque                     |
| 6     | Nombre de livre égal 100 et ensuite il essaye d'en rajouter | bib.nbLivres = 100; puis bib.ajouterLivre(...)                           | Bibliotéque                                |

**1.1** :Parceque avec la méthode static dans la classe Auteur, à chaque fois qu'on crée un nouveau ça le remplace avec la précédente

**1.2** : Une bonne classe doit protéger ses données et garantir ses règles. Le code extérieur ne devrait pas pouvoir faire n'importe quoi directement.
        germinal.nbDisponibles--; 1 - 0 - -1 - -2

## Partie 2

**2.1** :Non, il ne faut pas écrire de setters.

Les attributs sont private et final, et les règles métier indiquent qu'un auteur ne peut pas modifier son nom, son prénom ou sa date de naissance après sa création.
Donc , il faut utiliser les getters ret pas les setters

**2.2** :Parce que le constructeur est l'endroit où l'objet est créé.

On veut garantir qu'il est valide dès sa création.
## Partie 3

**3.1** : ça limite le nombre de disponibilité pour pas avoir de livre disponible que d'exemplaire

**3.2** :  Pour éviter de répéter la même vérification, on crée une méthode privée verifierTitre(). Le constructeur et setTitre() appellent cette méthode. Cela évite la duplication du code et garantit que la même règle est appliquée partout.

## Partie 4

**4.1** :

**4.2** :

## Partie 5

**5.1** :

**5.2** :

**5.3** :

**5.4** :

**5.5** :

## Partie 6

Nombre de livres créés affiché à l'étape 10, et explication :

## Bonus B2 : code dupliqué


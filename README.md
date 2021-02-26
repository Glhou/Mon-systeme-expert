# Mon-systeme-expert

Petite interface java pour l'utilisation d'un systeme expert réalisé pendant une semaine training à Centrale Marseille.

## Base de Règles
### Modifier la base de règle
Vous trouverez à la racine du projet la base de règle sous le nom de regles.cvs (ce type de fichier peut être ouvert via un tableur). La première ligne de ce fichier représente le schéma que doit suivre toutes les règles. Les lignes suivantes sont les règles. Vous pouvez modifier à souhait ce document.

### Utiliser le Chainage arrière
Vous trouverez un champs nomé "But" dans lequel vous pourrez définir la conclusion but à vérifier. Entrez une conclusion dans ce champ puis clickez sur "Valider" et ensuite sur Chainage arrière. Un label apparaitera alors pour vous indiquer si le but est vérifié ou non.

## Base de fait
### Ajouter une BDF
Pour ajouter une base de fait il suffit d'ajouter un fichier un fait par ligne à la racine du projet. Puis il faut aller dans le main et ajouter le nom du fichier à la collection en paramètre.
Les fichiers faits et faits sont des exemples.

### Utiliser une BDF avec le Chainage avant
Une fois le projet lancé vous pouvez choisir quel base de fait utiliser puis vous pouvez clicker sur Chainage Avant pour obtenir le résultat dans la liste à coté.


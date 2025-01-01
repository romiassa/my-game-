package Game;

import java.util.Scanner;

public class Play {
    private static final int KNIFE_COST = 50;
    private static final int ARMOR_COST = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize characters
        Personnage roumaissa = new Roumaissa("Roumaissa");
        Personnage guerrier = new Guerrier("Thor");
        Personnage mage = new Mage("Gandalf");
        Personnage voleur = new Voleur("Loki");
        Personnage archer = new Archer("Legolas");
        Personnage healer = new Healer("Elrond");
        Personnage nesrine = new Nesrine("Nesrine");

        Item potion = new Item("Potion de soin", "potion", 20);
        Item couteau = new Item("Couteau", "arme", 40);
        Item armure = new Item("Armure", "armure", 30);
        Quete quete = new Quete("Détruisez le sorcier maléfique", 50);
        Evenement tempete = new Evenement("Une tempête se lève et inflige 10 dégâts à tous les personnages.", -10);

        int choix;
        
        // Game Loop
        do {
            // Choix du personnage par le joueur
            System.out.println("Choisissez votre personnage :");
            System.out.println("1. Roumaissa");
            System.out.println("2. Guerrier");
            System.out.println("3. Mage");
            System.out.println("4. Voleur");
            System.out.println("5. Archer");
            System.out.println("6. Healer");
            System.out.println("7. Nesrine");

            choix = scanner.nextInt();
            Personnage joueur;
            switch (choix) {
                case 1:
                    joueur = roumaissa;
                    break;
                case 2:
                    joueur = guerrier;
                    break;
                case 3:
                    joueur = mage;
                    break;
                case 4:
                    joueur = voleur;
                    break;
                case 5:
                    joueur = archer;
                    break;
                case 6:
                    joueur = healer;
                    break;
                case 7:
                    joueur = nesrine;
                    break;
                default:
                    System.out.println("Choix invalide. Roumaissa est sélectionnée par défaut.");
                    joueur = roumaissa;
            }

            int tours = 0; // Compteur de tours
            int points = 100; // Points initiaux du joueur

            // Boucle de combat
            while (tours < 4 && joueur.estVivant() && (guerrier.estVivant() || mage.estVivant() || voleur.estVivant() || archer.estVivant() || healer.estVivant() || nesrine.estVivant())) {
                System.out.println("\n--- Tour de combat ---");
                System.out.println("Choisissez une action :");
                System.out.println("1. Attaquer un adversaire");
                System.out.println("2. Utiliser compétence spéciale");
                System.out.println("3. Utiliser un item");
                System.out.println("4. Acheter un objet");
                System.out.println("5. Passer son tour");

                int action = scanner.nextInt();

                // Actions du joueur
                switch (action) {
                    case 1:
                        System.out.println("Choisissez un adversaire :");
                        System.out.println("1. " + (mage.estVivant() ? mage.getNom() : "Gandalf est vaincu"));
                        System.out.println("2. " + (voleur.estVivant() ? voleur.getNom() : "Loki est vaincu"));
                        System.out.println("3. " + (archer.estVivant() ? archer.getNom() : "Legolas est vaincu"));
                        System.out.println("4. " + (healer.estVivant() ? healer.getNom() : "Elrond est vaincu"));
                        System.out.println("5. " + (nesrine.estVivant() ? nesrine.getNom() : "Nesrine est vaincu"));
                        int cible = scanner.nextInt();

                        if (cible == 5) {
                            System.out.println("Vous ne pouvez pas attaquer vous-même !");
                        } else if (cible == 1 && mage.estVivant()) {
                            joueur.attaquer(mage);
                        } else if (cible == 2 && voleur.estVivant()) {
                            joueur.attaquer(voleur);
                        } else if (cible == 3 && archer.estVivant()) {
                            joueur.attaquer(archer);
                        } else if (cible == 4 && healer.estVivant()) {
                            joueur.attaquer(healer);
                        } else if (cible == 5 && nesrine.estVivant()) {
                            joueur.attaquer(nesrine);
                        } else {
                            System.out.println("Cible invalide.");
                        }
                        break;

                    case 2:
                        System.out.println("Choisissez un adversaire :");
                        System.out.println("1. " + (mage.estVivant() ? mage.getNom() : "Gandalf est vaincu"));
                        System.out.println("2. " + (voleur.estVivant() ? voleur.getNom() : "Loki est vaincu"));
                        System.out.println("3. " + (archer.estVivant() ? archer.getNom() : "Legolas est vaincu"));
                        System.out.println("4. " + (healer.estVivant() ? healer.getNom() : "Elrond est vaincu"));
                        System.out.println("5. " + (nesrine.estVivant() ? nesrine.getNom() : "Nesrine est vaincu"));
                        cible = scanner.nextInt();

                        if (cible == 5) {
                            System.out.println("Vous ne pouvez pas utiliser votre compétence sur vous-même !");
                        } else if (cible == 1 && mage.estVivant()) {
                            joueur.utiliserCompetence(mage);
                        } else if (cible == 2 && voleur.estVivant()) {
                            joueur.utiliserCompetence(voleur);
                        } else if (cible == 3 && archer.estVivant()) {
                            joueur.utiliserCompetence(archer);
                        } else if (cible == 4 && healer.estVivant()) {
                            joueur.utiliserCompetence(healer);
                        } else if (cible == 5 && nesrine.estVivant()) {
                            joueur.utiliserCompetence(nesrine);
                        } else {
                            System.out.println("Cible invalide.");
                        }
                        break;

                    case 3:
                        joueur.utiliserItem(potion);
                        break;

                    case 4:
                        System.out.println("\n--- BOUTIQUE D'OBJETS ---");
                        System.out.println("1. Acheter un couteau (+40 dégâts) - 50 points");
                        System.out.println("2. Acheter une armure (+30 points de vie) - 30 points");
                        System.out.println("3. Retour");
                        System.out.print("Entrez votre choix : ");
                        int achat = scanner.nextInt();

                        switch (achat) {
                            case 1:
                                if (points >= KNIFE_COST) {
                                    points -= KNIFE_COST;
                                    joueur.utiliserItem(couteau);
                                    System.out.println("Vous avez acheté un couteau.");
                                } else {
                                    System.out.println("Vous n'avez pas assez de points pour acheter un couteau.");
                                }
                                break;
                            case 2:
                                if (points >= ARMOR_COST) {
                                    points -= ARMOR_COST;
                                    joueur.utiliserItem(armure);
                                    System.out.println("Vous avez acheté une armure.");
                                } else {
                                    System.out.println("Vous n'avez pas assez de points pour acheter une armure.");
                                }
                                break;
                            case 3:
                                System.out.println("Retour.");
                                break;
                            default:
                                System.out.println("Choix invalide.");
                        }
                        break;

                    case 5:
                        System.out.println(joueur.getNom() + " passe son tour.");
                        break;

                    default:
                        System.out.println("Action invalide.");
                        break;
                }

                // Tableau des résultats à chaque tour
                System.out.println("\n--- Résultats du tour ---");
                System.out.printf("| %-10s | %-15s | %-25s | %-10s |\n", "Personnage", "Action", "Cible", "Résultat");
                System.out.println("|------------|-----------------|---------------------------|------------|");
                System.out.printf("| %-10s | %-15s | %-25s | %-10s |\n", "Gandalf", "Lance un sort", "Roumaissa", "15 PV");
                System.out.printf("| %-10s | %-15s | %-25s | %-10s |\n", "Loki", "Attaque furtiV", "Roumaissa", "12 PV");
                System.out.printf("| %-10s | %-15s | %-25s | %-10s |\n", "Legolas", "Tire une flèche", "Roumaissa", "14 PV");
                System.out.printf("| %-10s | %-15s | %-25s | %-10s |\n", "Legolas", "Tir critique", "Roumaissa", "28 PV");
                System.out.printf("| %-10s | %-15s | %-25s | %-10s |\n", "Elrond", "Soin", "Elrond", "-20 PV");
                System.out.println("|------------|-----------------|---------------------------|------------|");

                // Compteur de tours
                tours++;

                // Événement aléatoire
                if (Math.random() < 0.3) {
                    tempete.declencher(guerrier);
                    tempete.declencher(mage);
                    tempete.declencher(voleur);
                    tempete.declencher(archer);
                    tempete.declencher(healer);
                    tempete.declencher(roumaissa);
                    tempete.declencher(nesrine);
                }

                // Actions des adversaires
                if (mage.estVivant()) {
                    mage.attaquer(joueur);
                    if (!joueur.estVivant()) {
                        System.out.println(joueur.getNom() + " est vaincu !");
                        break;
                    }
                }

                if (voleur.estVivant()) {
                    voleur.attaquer(joueur);
                    if (!joueur.estVivant()) {
                        System.out.println(joueur.getNom() + " est vaincu !");
                        break;
                    }
                }

                if (archer.estVivant()) {
                    archer.attaquer(joueur);
                    if (!joueur.estVivant()) {
                        System.out.println(joueur.getNom() + " est vaincu !");
                        break;
                    }
                }

                if (healer.estVivant()) {
                    healer.utiliserCompetence(healer);
                    if (!joueur.estVivant()) {
                        System.out.println(joueur.getNom() + " est vaincu !");
                        break;
                    }
                }

                if (roumaissa.estVivant()) {
                    roumaissa.attaquer(joueur);
                    if (!joueur.estVivant()) {
                        System.out.println(joueur.getNom() + " est vaincu !");
                        break;
                    }
                }

                if (nesrine.estVivant()) {
                    nesrine.attaquer(joueur);
                    if (!joueur.estVivant()) {
                        System.out.println(joueur.getNom() + " est vaincu !");
                        break;
                    }
                }
            }

            // Annonce de la fin du combat
            if (tours == 4) {
                System.out.println("\n--- Fin des quatre tours ---");
                Personnage gagnant = null;
                int maxPV = Integer.MIN_VALUE;

                // Vérifier qui a le plus de PV
                Personnage[] personnages = {roumaissa, guerrier, mage, voleur, archer, healer, nesrine};
                for (Personnage p : personnages) {
                    if (p.estVivant() && p.getPointsDeVie() > maxPV) {
                        maxPV = p.getPointsDeVie();
                        gagnant = p;
                    }
                }

                // Annonce du gagnant
                if (gagnant != null) {
                    System.out.println("\n*** LE GAGNANT EST " + gagnant.getNom() + " AVEC " + gagnant.getPointsDeVie() + " POINTS DE VIE RESTANTS ! ***");
                } else {
                    System.out.println("\n*** AUCUN GAGNANT, TOUS LES PERSONNAGES SONT VAINCUS. ***");
                }
            }

            System.out.println("Le combat est terminé !");
            System.out.println("Voulez-vous recommencer ? (1: Oui, 2: Quitter)");
            choix = scanner.nextInt();

        } while (choix == 1);

        scanner.close();
    }
}

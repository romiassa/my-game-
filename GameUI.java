package Game;

import java.util.Scanner;

public class GameUI {
    private Personnage joueur;
    private Personnage[] personnages;
    private int tours;
    private final int MAX_TOURS = 3;

    public GameUI() {
        initialisePersonnages();
    }

    private void initialisePersonnages() {
        Personnage roumaissa = new Roumaissa("Roumaissa");
        Personnage guerrier = new Guerrier("Thor");
        Personnage mage = new Mage("Gandalf");
        Personnage voleur = new Voleur("Loki");
        Personnage archer = new Archer("Legolas");
        Personnage healer = new Healer("Elrond");
        Personnage nesrine = new Nesrine("Nesrine");

        personnages = new Personnage[]{roumaissa, guerrier, mage, voleur, archer, healer, nesrine};

        // Choix du personnage par le joueur
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez votre personnage :");
        for (int i = 0; i < personnages.length; i++) {
            System.out.println((i + 1) + ". " + personnages[i].getNom());
        }
        int choix = scanner.nextInt();
        joueur = personnages[choix - 1];
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (tours < MAX_TOURS && joueur.estVivant()) {
            System.out.println("\n--- TOUR " + (tours + 1) + " ---");
            System.out.println("Choisissez une action :");
            System.out.println("1. Attaquer un adversaire");
            System.out.println("2. Utiliser compétence spéciale");
            System.out.println("3. Utiliser un item");
            System.out.println("4. Passer son tour");

            int action = scanner.nextInt();
            effectuerAction(action);

            // Vérifier si un événement aléatoire se produit
            if (Math.random() < 0.3) {
                for (Personnage p : personnages) {
                    if (p.estVivant()) {
                        p.recevoirDegats(10);
                        System.out.println(p.getNom() + " a reçu 10 points de dégâts de la tempête.");
                    }
                }
            }

            tours++;
        }

        // Annonce du gagnant après trois tours
        annoncerGagnant();
        scanner.close();
    }

    private void effectuerAction(int action) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez un adversaire :");
        for (int i = 0; i < personnages.length; i++) {
            if (!personnages[i].equals(joueur) && personnages[i].estVivant()) {
                System.out.println((i + 1) + ". " + personnages[i].getNom());
            }
        }
        int cibleIndex = scanner.nextInt() - 1;
        Personnage cible = personnages[cibleIndex];

        switch (action) {
            case 1:
                joueur.attaquer(cible);
                break;
            case 2:
                joueur.utiliserCompetence(cible);
                break;
            case 3:
                joueur.utiliserItem(new Item("Potion de soin", "potion", 20));
                break;
            case 4:
                System.out.println(joueur.getNom() + " passe son tour.");
                break;
            default:
                System.out.println("Action invalide.");
        }

        afficherResultats(cible);
    }

    private void afficherResultats(Personnage cible) {
        System.out.printf("| %-10s | %-25s | %-10s |\n", "Personnage", "Action", "Résultat");
        System.out.println("|------------|---------------------------|------------|");
        System.out.printf("| %-10s | %-25s | %-10s |\n", joueur.getNom(), "Attaque", cible.getNom() + " perd 15 PV");
        System.out.println("|------------|---------------------------|------------|");
    }

    private void annoncerGagnant() {
        Personnage gagnant = null;
        int maxPV = Integer.MIN_VALUE;

        for (Personnage p : personnages) {
            if (p.estVivant() && p.getPointsDeVie() > maxPV) {
                maxPV = p.getPointsDeVie();
                gagnant = p;
            }
        }

        if (gagnant != null) {
            System.out.println("\n*** LE GAGNANT EST " + gagnant.getNom().toUpperCase() + " AVEC " + gagnant.getPointsDeVie() + " POINTS DE VIE RESTANTS ! ***");
        } else {
            System.out.println("\n*** AUCUN GAGNANT, TOUS LES PERSONNAGES SONT VAINCUS. ***");
        }
    }
}

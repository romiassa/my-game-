package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameHistory implements Serializable {
    private List<String> history;

    public GameHistory() {
        this.history = new ArrayList<>();
    }

    public void addEvent(String event) {
        history.add(event);
    }

    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("Aucun événement n'a eu lieu dans l'histoire du jeu.");
        } else {
            System.out.println("\n--- HISTORIQUE DU JEU ---");
            for (String event : history) {
                System.out.println(event);
            }
        }
    }

    public void startStory() {
        System.out.println("******************************************************************");
        System.out.println("*                                                                *");
        System.out.println("*                        HISTOIRE DU JEU                         *");
        System.out.println("*                                                                *");
        System.out.println("******************************************************************\n");

        System.out.println("******************************************************************");
        System.out.println("* Il était une fois, dans un monde où régnaient le chaos et      *");
        System.out.println("* l'obscurité, un royaume connu sous le nom de Luminaria.        *");
        System.out.println("*                                                                *");
        System.out.println("* Luminaria, autrefois un havre de paix et de prospérité, avait  *");
        System.out.println("* été envahi par des forces maléfiques. Les ténèbres avaient     *");
        System.out.println("* englouti les terres, et seuls les plus braves des guerriers    *");
        System.out.println("* osaient encore espérer un avenir meilleur.                     *");
        System.out.println("*                                                                *");
        System.out.println("* Un ancien prophète avait prédit que sept héros se lèveraient   *");
        System.out.println("* pour combattre ces forces obscures et restaurer la lumière.    *");
        System.out.println("*                                                                *");
        System.out.println("* Ces héros étaient :                                            *");
        System.out.println("* - Roumaissa, la guerrière au cœur indomptable.                 *");
        System.out.println("* - Thor, le guerrier à la force titanesque.                     *");
        System.out.println("* - Gandalf, le mage aux pouvoirs mystiques.                     *");
        System.out.println("* - Loki, le voleur rusé et insaisissable.                       *");
        System.out.println("* - Legolas, l'archer au tir précis.                             *");
        System.out.println("* - Elrond, le guérisseur bienveillant.                          *");
        System.out.println("* - Nesrine, la magicienne mystérieuse.                          *");
        System.out.println("*                                                                *");
        System.out.println("* Ces sept champions avaient chacun leur propre histoire et      *");
        System.out.println("* leurs propres motivations, mais tous étaient unis par un but   *");
        System.out.println("* commun : libérer Luminaria des griffes du mal.                 *");
        System.out.println("*                                                                *");
        System.out.println("* L'aventure commence dans une petite clairière, où les héros    *");
        System.out.println("* se sont réunis pour la première fois.                          *");
        System.out.println("* Chacun d'entre eux sait que le chemin qui les attend sera      *");
        System.out.println("* semé d'embûches, mais ils sont prêts à tout pour ramener la    *");
        System.out.println("* paix dans leur royaume.                                        *");
        System.out.println("******************************************************************");
        
        System.out.println("******************************************************************");
        System.out.println("*                                                                *");
        System.out.println("*           Bienvenue dans l'aventure de Luminaria !             *");
        System.out.println("*   Chaque choix que vous faites influence le destin de nos      *");
        System.out.println("*   héros et du royaume tout entier. Préparez-vous à combattre,  *");
        System.out.println("*      à explorer et à découvrir les secrets de Luminaria.       *");
        System.out.println("*                                                                *");
        System.out.println("******************************************************************");
    }

    public static void main(String[] args) {
        GameHistory histoire = new GameHistory();
        histoire.startStory();
    }
}

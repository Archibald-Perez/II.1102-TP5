import java.util.*;

/**
 * TD5 Exercice 1-5
 * @author Archibald Perez
 *
 */
public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(
				Arrays.asList(2, 65, 42, 53, 27, 2, 42, 27, 2, 53, 53, 53, 65, 21, 27, 53, 2, 53, 65, 27));
		afficheListe(list);
		occurence(list);
		deleteElement(list);
		afficheListe(list);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(38, "Isère");
		map.put(34, "Hérault");
		map.put(75, "Paris");
		map.put(0, null);
		afficheDico(map);
		allOcurrences(list);
	}

	public static void afficheListe(ArrayList<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

	public static void occurence(ArrayList<Integer> list) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		int number = 0;
		while (true) { // Demande à nouveau la saisie si l'utilisateur donne une valeur incorrecte.
			try {
				System.out.println("Entrez un entier pour connaître son nombre d'occurence dans la liste.");
				number = scan.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("La valeur entrée est incorrecte.");
				scan.nextLine();
			}
		}
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (iterator.next() == number) {
				count++;
			}
		}
		System.out.println("Le nombre d’occurrences de " + number + " est " + count + ".");
	}

	public static void deleteElement(ArrayList<Integer> list) {
		Scanner scan = new Scanner(System.in);
		int number = 0;
		while (true) { // Demande à nouveau la saisie si l'utilisateur donne une valeur incorrecte.
			try {
				System.out.println("Entrez un entier pour le supprimer de la liste.");
				number = scan.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("La valeur entrée est incorrecte.");
				scan.nextLine();
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == number) {
				list.remove(i);
				i--;
			}
		}
	}
	public static void afficheDico(Map map) {
		System.out.println(map.entrySet());
	}
	public static void allOcurrences(ArrayList<Integer> list) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			int number = iterator.next();
			if (map.containsKey(number)) {
				int newcount = map.get(number)+1;
				map.put(number,newcount);
			} else {
				map.put(number,1);
			}
		}
		afficheDico(map);
	}
}

import java.util.*;


/**
 * TD 5 Exercice 6
 * @author Archibald Perez
 *
 */
public class Classe {

	public static void main(String[] args) {
		Set<Integer> A1 = new HashSet<Integer>();
		Set<Integer> A2 = new HashSet<Integer>();
		Set<Integer> A3 = new HashSet<Integer>();
		Map<Integer, String> students = new HashMap<Integer, String>();
		while (true) {
			System.out.println();
			System.out.println("Bienvenue dans la gestion de classe!");
			System.out.println("Tapez 1 pour ajouter un étudiant.");
			System.out.println("Tapez 2 pour modifier un étudiant.");
			System.out.println("Tapez 3 pour supprimer un étudiant.");
			System.out.println("Tapez 4 pour afficher une classe.");
			int choice = 0;
			Scanner scan = new Scanner(System.in);
			while (true) { // Demande à nouveau la saisie si l'utilisateur donne une valeur incorrecte.
				try {
					choice = scan.nextInt();
					if (!(choice <= 4 && choice > 0)) {
						System.out.println("La valeur entrée est incorrecte.");
						scan.nextLine();
						continue;
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("La valeur entrée est incorrecte.");
					scan.nextLine();
				}
			}
			switch (choice) {
			case 1:
				addStudentAsk(A1, A2, A3, students);
				break;
			case 2:
				changeStudent(A1,A2,A3,students);
				break;
			case 3:
				deleteStudent(A1,A2,A3,students);
				break;
			case 4:
				showStudents(A1, A2, A3, students);
				break;
			}
		}

	}

	/**
	 * Interface utilisateur pour ajouter un étudiants à la base de données.
	 * @param A1 ensemble classe A1.
	 * @param A2 ensemble classe A2.
	 * @param A3 ensemble classe A3.
	 * @param students dictionnaire des étudiants.
	 */
	public static void addStudentAsk(Set<Integer> A1, Set<Integer> A2, Set<Integer> A3, Map<Integer, String> students) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez le nom de l'étudiant");
		String surname = scan.nextLine();
		System.out.println("Entrez le prénom de l'étudiant");
		String name = scan.nextLine();
		Scanner scant = new Scanner(System.in);
		int id = 0;
		while (true) { // Demande à nouveau la saisie si l'utilisateur donne une valeur incorrecte.
			try {
				System.out.println("Entrez l'identifiant de l'étudiant");
				id = scant.nextInt();
				if (students.containsKey(id)) {
					System.out.println("L'identifiant est déjà prit");
					scant.nextLine();
					continue;
				}
				if (id == 0) {
					System.out.println("L'identifiant ne peut être nul.");
					scant.nextLine();
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("La valeur entrée est incorrecte.");
				scant.nextLine();
			}
		}
		int promo = 0;
		while (true) { // Demande à nouveau la saisie si l'utilisateur donne une valeur incorrecte.
			try {
				System.out.println("Entrez le numéro de promotion de l'étudiant (1, 2 ou 3).");
				promo = scant.nextInt();
				if (!(promo <= 3 && promo > 0)) {
					System.out.println("La valeur entrée est incorrecte.");
					scant.nextLine();
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("La valeur entrée est incorrecte.");
				scant.nextLine();
			}
		}
		addStudent(A1,A2,A3,students,id,promo,name,surname);

	}

	/**
	 * Ajoute un étudiant avec les paramètres spécifiés.
	 * @param A1 ensemble classe A1.
	 * @param A2 ensemble classe A2.
	 * @param A3 ensemble classe A3.
	 * @param students dictionnaire des étudiants.
	 * @param id identifiant de l'étudiant (integer)
	 * @param promo numéro de promo (integer de 1 à 3)
	 * @param name prénom de l'étudiant (string)
	 * @param surname nom de l'étudiant (string)
	 */
	public static void addStudent(Set<Integer> A1, Set<Integer> A2, Set<Integer> A3, Map<Integer, String> students,int id,int promo,String name,String surname) {
		switch (promo) {
		case 1:
			A1.add(id);
			break;
		case 2:
			A2.add(id);
			break;
		case 3:
			A3.add(id);
			break;
		}
		students.put(id, name + " " + surname);
	}

	/**
	 * Affiche les étudiants de la classe envoyé.
	 * @param A1 ensemble classe A1.
	 * @param A2 ensemble classe A2.
	 * @param A3 ensemble classe A3.
	 * @param students dictionnaire des étudiants.
	 */
	public static void showStudents(Set<Integer> A1, Set<Integer> A2, Set<Integer> A3, Map<Integer, String> students) {
		Scanner scan = new Scanner(System.in);
		int promo = 0;
		while (true) { // Demande à nouveau la saisie si l'utilisateur donne une valeur incorrecte.
			try {
				System.out.println("Entrez le numéro de promotion a visualiser (1, 2 ou 3).");
				promo = scan.nextInt();
				if (!(promo <= 3 && promo > 0)) {
					System.out.println("La valeur entrée est incorrecte.");
					scan.nextLine();
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("La valeur entrée est incorrecte.");
				scan.nextLine();
			}
		}
		Set<Integer> show = A1;
		switch (promo) {
		case 2:
			show = A2;
			break;
		case 3:
			show = A3;
			break;
		}
		System.out.println("Les étudiants de la promotion A" + promo + " sont :");
		Iterator<Integer> iterator = show.iterator();
		while (iterator.hasNext()) {
			int id = iterator.next();
			System.out.print("Id : ");
			System.out.print(id);
			System.out.print(", Nom complet : ");
			System.out.println(students.get(id));
		}
	}

	/**
	 * Modifie les informations d'un étudiant à partir de son id.
	 * @param A1 ensemble classe A1.
	 * @param A2 ensemble classe A2.
	 * @param A3 ensemble classe A3.
	 * @param students dictionnaire des étudiants.
	 */
	public static void changeStudent(Set<Integer> A1, Set<Integer> A2, Set<Integer> A3, Map<Integer, String> students) {
		Scanner scan = new Scanner(System.in);
		int id = 0;
		while (true) { // Demande à nouveau la saisie si l'utilisateur donne une valeur incorrecte.
			try {
				System.out.println("Entrez l'identifiant de l'étudiant à modifier");
				id = scan.nextInt();
				if (!students.containsKey(id)) {
					System.out.println("Aucun étudiant ne possède cet identifiant");
					scan.nextLine();
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("La valeur entrée est incorrecte.");
				scan.nextLine();
			}
		}
		int promo = 3;
		if (A1.contains(id)) {
			promo = 1;
		}
		if (A2.contains(id)) {
			promo = 2;
		}
		String fullname = students.get(id);
		System.out.println("Vous allez modifier "+fullname+".");
		Scanner scant = new Scanner(System.in);
		System.out.println("Entrez le nouveau nom ou tapez \"0\" pour garder le même nom.");
		String surname = scant.nextLine();
		if (surname.equals("0")) {
			surname = fullname.split(" ")[0];
		}
		System.out.println("Entrez le nouveau prénom ou tapez \"0\" pour garder le même prénom.");
		String name = scant.nextLine();
		if (name.equals("0")) {
			name = fullname.split(" ")[1];
		}
		System.out.println("Entrez le numéro de la nouvelle promotion ou tapez \"0\" pour garder la même promotion.");
		int newpromo = 0;
		while (true) { // Demande à nouveau la saisie si l'utilisateur donne une valeur incorrecte.
			try {
				newpromo = scant.nextInt();
				if (!(newpromo <= 3 && newpromo >= 0)) {
					System.out.println("La valeur entrée est incorrecte.");
					scant.nextLine();
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("La valeur entrée est incorrecte.");
				scant.nextLine();
			}
		}
		if (newpromo != 0) {
			A1.remove(id);
			A2.remove(id);
			A3.remove(id);
			promo = newpromo;
		}
		System.out.println("Entrez le nouvel id ou tapez \"0\" pour garder le même id.");
		int newid = 0;
		while (true) { // Demande à nouveau la saisie si l'utilisateur donne une valeur incorrecte.
			try {
				newid = scant.nextInt();
				if (students.containsKey(newid)) {
					System.out.println("L'identifiant est déjà prit");
					scant.nextLine();
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("La valeur entrée est incorrecte.");
				scant.nextLine();
			}
		}
		if (!(newid == 0)) {
			A1.remove(id);
			A2.remove(id);
			A3.remove(id);
			students.remove(id);
			id = newid;
		}
		addStudent(A1,A2,A3,students,id,promo,name,surname);
	}
	
	/**
	 * Supprime un étudiant à partir de son id.
	 * @param A1 ensemble classe A1.
	 * @param A2 ensemble classe A2.
	 * @param A3 ensemble classe A3.
	 * @param students dictionnaire des étudiants.
	 */
	public static void deleteStudent(Set<Integer> A1, Set<Integer> A2, Set<Integer> A3, Map<Integer, String> students) {
		Scanner scan = new Scanner(System.in);
		int id = 0;
		while (true) { // Demande à nouveau la saisie si l'utilisateur donne une valeur incorrecte.
			try {
				System.out.println("Entrez l'identifiant de l'étudiant à supprimer");
				id = scan.nextInt();
				if (!students.containsKey(id)) {
					System.out.println("Aucun étudiant ne possède cet identifiant");
					scan.nextLine();
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("La valeur entrée est incorrecte.");
				scan.nextLine();
			}
		}
		A1.remove(id);
		A2.remove(id);
		A3.remove(id);
		students.remove(id);
	}
}

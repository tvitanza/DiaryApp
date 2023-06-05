package DiaryAppPackage;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DiaryUI implements IDiaryUI {
    private final Scanner input;
    private final PrintStream output;

    public DiaryUI(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String showMenu() {
        output.println("\nChoisissez dans les options suivantes:");
        output.println("(1) lister les diaries");
        output.println("(2) ajouter un diary");
        output.println("(3) modifier un diary");
        output.println("(4) supprimer un diary");
        output.println("(Q) quitter l'application");
        return input.nextLine();
    }

    @Override
    public int showDeleteForm() {
        output.println("\nFormulaire de suppression d'un diary");
        output.print("Identifiant: ");
        return Integer.parseInt(input.nextLine());
    }

    @Override
    public Diary showUpdateForm() {
        output.println("\nFormulaire de modification d'un diary");
        output.print("Identifiant: ");
        int id = Integer.parseInt(input.nextLine());
        output.print("Titre: ");
        String title = input.nextLine();
        output.print("Début: ");
        LocalDate begin = LocalDate.parse(input.nextLine());
        output.print("Publique?: ");
        boolean isPublic = input.nextBoolean();
        return new Diary(id, title, begin, isPublic);
    }

    @Override
    public Diary showAddForm() {
        output.println("\nFormulaire d'ajout de diary'");
        output.print("Titre: ");
        String title = input.nextLine();
        output.print("Début: ");
        LocalDate begin = LocalDate.parse(input.nextLine());
        output.print("Publique?: ");
        boolean isPublic = input.nextBoolean();
        input.nextLine();
        return new Diary(title, begin, isPublic);
    }

    @Override
    public void showList(List<Diary> diaryList) {
        output.println("\nListe des diaries:");
        for(Diary d : diaryList) {
            output.println(String.join(" - ", String.valueOf(d.getId()), d.getTitle(),
                    String.valueOf(d.getBegin()), String.valueOf(d.isPublic())));
        }
    }
}


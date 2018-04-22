package by.epam.library.main;

import java.util.List;

import by.epam.library.entity.Book;
import by.epam.library.entity.Library;
import by.epam.library.entity.Magazine;
import by.epam.library.entity.PrintedEdition;
import by.epam.library.service.LibraryService;
import by.epam.library.service.find.FindByPrice;
import by.epam.library.service.find.Findable;
import by.epam.library.view.PrintAsList;
import by.epam.library.view.PrintAsTable;
import by.epam.library.view.Printable;
import by.epam.library.view.ViewAction;

public class Main {

    public static void main(String[] args) {

        Library myLibrary = new Library();
        myLibrary.add(new Book("Java", 300, 1997, "soft", "Shildt"));
        myLibrary.add(new Book("C++", 250, 2008, "semi-rigid", "Kite"));
        myLibrary.add(new Magazine(100, "Erudit", 2018, "scientific"));

        Findable matcher = new FindByPrice(300);

        LibraryService libService = new LibraryService();
        List<PrintedEdition> lists = libService.find(myLibrary, matcher);

        System.out.println(lists.size());

        ViewAction.print(new PrintAsList(), lists);
        ViewAction.print(new PrintAsTable(), lists);
    }

}

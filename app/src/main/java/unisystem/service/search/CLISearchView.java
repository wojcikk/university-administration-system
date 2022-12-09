package unisystem.service.search;

import org.springframework.stereotype.Service;
import unisystem.domain.Domain;

import java.util.List;

@Service
public class CLISearchView implements SearchView {

    @Override
    public void printSearchedList(List<Domain> searchedList) {
        if(!searchedList.isEmpty()) {
            System.out.println("\nSearching completed:");
            searchedList.stream().forEach(System.out::println);
        } else {
            System.out.println("\nSearching completed:\n record was not found");
        }
    }
}

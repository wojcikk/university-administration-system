package unisystem.service.search;

import unisystem.domain.Domain;

import java.util.List;

public interface SearchView {
    void printSearchedList(List<Domain> searchedList);
}

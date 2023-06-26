package HW_5.repository;

import HW_5.model.Team;

import java.util.List;

public interface TeamRepository<T extends Team> {

    List<T> getAll();
    void add(T t);
    void remove(String teamName);
    Long getMaxId();

}
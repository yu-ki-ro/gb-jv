package HW_4.view;

import HW_4.model.User;

public interface UserView<T extends User> {

    void sendOnConsole(String sortType);  // GET request
    void create(String fullName, Integer age, String phoneNumber);  // POST request
    void remove(String fullName);  // DELETE request
    void edit(String fullName, Integer age, String phoneNumber);  // PUT request
}
package backend.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class testDAO {

    String a = "asdf";

    @Autowired
    public testDAO(String pass) {
        this.a = pass;
    }

    public void printA() {
        System.out.println(a);
    }

}

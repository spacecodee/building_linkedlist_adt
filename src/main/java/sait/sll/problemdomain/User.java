package sait.sll.problemdomain;

import java.util.Objects;

public class User {

    public User() {
    }

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private int id;
    private String name;
    private String email;
    private String password;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User other)) return false;

        return this.id == other.id && this.name.equals(other.name) && this.email.equals(other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

    public boolean isCorrectPassword(String password) {
        if (this.password == null && password == null) return true;
        else if (this.password == null || password == null) return false;
        else return this.password.equals(password);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'' + '}';
    }
}

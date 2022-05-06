package edu.corvinus.hazi20;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @GeneratedValue
    @Id
    private Long id;
    @NotNull
    @Size(min=6, message = "A felhasználónévnek legalább 6 karakter hosszúságúnak kell lennie!")
    @Column(unique = true)
    private String username;
    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)[a-zA-Z\\d\\w\\W]{8,}$",
            message = "A jelszónak legalább 8 karakterből kell állnia, illetve tartalmazni kell betűt és számot is!")
    private String password;
    @NotNull(message = "Kérlek add meg a neved!")
    private String fullname;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public User(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }
}

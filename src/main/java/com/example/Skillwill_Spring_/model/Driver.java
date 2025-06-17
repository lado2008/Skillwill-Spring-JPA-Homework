package com.example.Skillwill_Spring_.model;

import jakarta.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String name;

    @Column(name = "nationality", nullable = false, length = 50)
    private String nationality;

    @Column(name = "race_number", nullable = false, unique = true)
    private int number;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "team_name", nullable = false, length = 50)
    private String team;

    public void setNationality(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNationality'");
    }

    public void setName(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

    public void setNumber(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNumber'");
    }

    public void setTeam(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTeam'");
    }

    public void setName(int string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }


}
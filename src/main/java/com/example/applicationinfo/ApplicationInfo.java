package com.example.applicationinfo;

import jakarta.persistence.*;

@Entity
@Table(name = "APPLICATION_INFO")
public class ApplicationInfo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attraction_seq")
    @SequenceGenerator(name = "attraction_seq", sequenceName = "attraction_seq", allocationSize = 1)
    private int id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "ADMIN_EMAIL")
    private String adminEmail;
    @Column(name = "VERSION")
    private int version;

    public ApplicationInfo() {

    }
    public ApplicationInfo(int id, String title, String adminEmail, int version) {
        this.id = id;
        this.title = title;
        this.adminEmail = adminEmail;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public int getVersion() {
        return version;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}

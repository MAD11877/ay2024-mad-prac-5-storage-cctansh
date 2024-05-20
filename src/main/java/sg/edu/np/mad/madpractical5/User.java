package sg.edu.np.mad.madpractical5;

import java.io.Serializable;

public class User {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int newId) {
        this.id = newId;
    }
    private boolean followed;
    public boolean getFollowed() {
        return followed;
    }
    public void setFollowed(boolean newFollowed) {
        this.followed = newFollowed;
    }
    public User(String name, String description, int id, boolean followed) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }
}
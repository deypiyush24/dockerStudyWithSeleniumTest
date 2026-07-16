package Pages.PojoClass;

import java.util.List;

public class UserClass {
    private int id;
    private String name;
    private boolean isActive; // Jackson handles "isActive" -> "active" or matches exactly
    private ProfileDetails profileDetails;
    private List<ContactLogistic> contactLogistics; // Array becomes a List of our child POJO

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean getIsActive() { return isActive; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }

    public ProfileDetails getProfileDetails() { return profileDetails; }
    public void setProfileDetails(ProfileDetails profileDetails) { this.profileDetails = profileDetails; }

    public List<ContactLogistic> getContactLogistics() { return contactLogistics; }
    public void setContactLogistics(List<ContactLogistic> contactLogistics) { this.contactLogistics = contactLogistics; }


}

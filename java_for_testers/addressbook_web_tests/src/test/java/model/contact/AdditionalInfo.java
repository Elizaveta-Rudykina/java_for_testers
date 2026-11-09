package model.contact;

public record AdditionalInfo(
        String company,
        String group,
        String photoUrl
) {
    public AdditionalInfo() {
        this("", "", "");
    }

    public AdditionalInfo withCompany(String company) {
        return new AdditionalInfo(company, this.group, this.photoUrl);
    }

    public AdditionalInfo withGroup(String group) {
        return new AdditionalInfo(this.company, group, this.photoUrl);
    }

    public AdditionalInfo withPhoto(String photoUrl) {
        return new AdditionalInfo(this.company, this.group, photoUrl);
    }
}

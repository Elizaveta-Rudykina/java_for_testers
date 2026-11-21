package model;

public record ContactData(
        String id,
        String firstName,
        String middleName,
        String lastName,
        String photo,
        String address,
        String mobilePhone,
        String email,
        String homepage,
        String birthDay,
        String birthMonth,
        String birthYear,
        String group) {

    public ContactData() {
        this("", "", "", "", "", "",
                "", "", "",
                "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.middleName, this.lastName, this.photo,
                this.address, this.mobilePhone, this.email, this.homepage, this.birthDay,
                this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, photo, this.address,
                this.mobilePhone, this.email, this.homepage, this.birthDay,
                this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withFullName(String firstName, String middleName, String lastName) {
        return new ContactData(this.id, firstName, middleName, lastName, this.photo, this.address,
                this.mobilePhone, this.email, this.homepage, this.birthDay, this.birthMonth,
                this.birthYear, this.group);
    }

    public ContactData withFirstAndLastNames(String firstName, String lastName) {
        return new ContactData(this.id, firstName, middleName, lastName, this.photo,
                this.address, this.mobilePhone, this.email, this.homepage, this.birthDay,
                this.birthMonth, this.birthYear, this.group);
    }
}

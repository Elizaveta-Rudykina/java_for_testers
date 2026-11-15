package model;

public record ContactData(
        String firstName,
        String middleName,
        String lastName,
        String nickName,
        String photo,
        String title,
        String company,
        String address,
        String homePhone,
        String mobilePhone,
        String workPhone,
        String email,
        String email2,
        String email3,
        String homepage,
        String birthDay,
        String birthMonth,
        String birthYear,
        String anniversaryDay,
        String anniversaryMonth,
        String anniversaryYear,
        String group
) {
    public ContactData() {
        this("", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "",
                "", "", "", "", "", "", "");
    }

    public ContactData withFullNameOnly(String firstName, String middleName, String lastName) {
        return new ContactData(firstName, middleName, lastName, this.nickName, this.photo, this.title, this.company,
                this.address, this.homePhone, this.mobilePhone, this.workPhone, this.email, this.email2, this.email3,
                this.homepage, this.birthDay, this.birthMonth, this.birthYear, this.anniversaryDay, this.anniversaryMonth, this.anniversaryYear, this.group);
    }

    public ContactData withBaseDataOnly(String firstName, String middleName, String lastName, String address,
                                        String mobilePhone, String email, String birthDay, String birthMonth, String birthYear, String group) {
        return new ContactData(firstName, middleName, lastName, this.nickName, this.photo, this.title, this.company,
                address, this.homePhone, mobilePhone, this.workPhone, email, this.email2, this.email3,
                this.homepage, birthDay, birthMonth, birthYear, this.anniversaryDay, this.anniversaryMonth, this.anniversaryYear, group);
    }

    public ContactData withNameAndPhoneOnly(String firstName, String mobilePhone) {
        return new ContactData(firstName, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company,
                this.address, this.homePhone, mobilePhone, this.workPhone, this.email, this.email2, this.email3,
                this.homepage, this.birthDay, this.birthMonth, this.birthYear, this.anniversaryDay, this.anniversaryMonth, this.anniversaryYear, this.group);
    }

}

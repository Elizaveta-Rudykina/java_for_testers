package model;

public record ContactData(

        String id, String firstName,
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
        this("", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "",
                "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.middleName, this.lastName, this.nickName,
                this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone,
                this.workPhone, this.email, this.email2, this.email3, this.homepage, this.birthDay, this.birthMonth,
                this.birthYear, this.anniversaryDay, this.anniversaryMonth, this.anniversaryYear, this.group);
    }

    public ContactData withFullName(String firstName, String middleName, String lastName) {
        return new ContactData(this.id, firstName, middleName, lastName, this.nickName,
                this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone,
                this.workPhone, this.email, this.email2, this.email3, this.homepage, this.birthDay, this.birthMonth,
                this.birthYear, this.anniversaryDay, this.anniversaryMonth, this.anniversaryYear, this.group);
    }

    public ContactData withBaseData(String firstName, String middleName, String lastName, String address,
                                    String mobilePhone, String email, String birthDay, String birthMonth,
                                    String birthYear, String group) {
        return new ContactData(this.id, firstName, middleName, lastName, this.nickName,
                this.photo, this.title, this.company, address, this.homePhone, mobilePhone,
                this.workPhone, email, this.email2, this.email3, this.homepage, birthDay, birthMonth,
                birthYear, this.anniversaryDay, this.anniversaryMonth, this.anniversaryYear, group);
    }

    public ContactData withFirstAndLastNames(String firstName, String lastName) {
        return new ContactData(this.id, firstName, middleName, lastName, this.nickName,
                this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone,
                this.workPhone, this.email, this.email2, this.email3, this.homepage, this.birthDay, this.birthMonth,
                this.birthYear, this.anniversaryDay, this.anniversaryMonth, this.anniversaryYear, this.group);
    }

    public ContactData withAllExcIdFirstLastNames(String middleName, String nickName, String photo, String title,
                                                  String company, String address, String homePhone, String mobilePhone,
                                                  String workPhone, String email, String email2, String email3,
                                                  String homepage, String birthDay, String birthMonth, String birthYear,
                                                  String anniversaryDay, String anniversaryMonth, String anniversaryYear,
                                                  String group) {
        return new ContactData(this.id, this.firstName, middleName, this.lastName, nickName,
                photo, title, company, address, homePhone, mobilePhone,
                workPhone, email, email2, email3, homepage, birthDay, birthMonth,
                birthYear, anniversaryDay, anniversaryMonth, anniversaryYear, group);
    }
}

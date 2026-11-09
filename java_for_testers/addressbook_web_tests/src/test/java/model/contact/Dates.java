package model.contact;

public record Dates(
        String birthDay,
        String birthMonth,
        String birthYear,
        String anniversaryDay,
        String anniversaryMonth,
        String anniversaryYear
) {
    public Dates withBirthDay(String birthDay) {
        return new Dates(birthDay, this.birthMonth, this.birthYear, this.anniversaryDay, this.anniversaryMonth, this.anniversaryYear);
    }

    public Dates withBirthMonth(String birthMonth) {
        return new Dates(this.birthDay, birthMonth, this.birthYear, this.anniversaryDay, this.anniversaryMonth, this.anniversaryYear);
    }

    public Dates withBirthYear(String birthYear) {
        return new Dates(this.birthDay, this.birthMonth, birthYear, this.anniversaryDay, this.anniversaryMonth, this.anniversaryYear);
    }

    public Dates withAnniversaryDay(String anniversaryDay) {
        return new Dates(this.birthDay, this.birthMonth, this.birthYear, anniversaryDay, this.anniversaryMonth, this.anniversaryYear);
    }

    public Dates withAnniversaryMonth(String anniversaryMonth) {
        return new Dates(this.birthDay, this.birthMonth, this.birthYear, this.anniversaryDay, anniversaryMonth, this.anniversaryYear);
    }

    public Dates withAnniversaryYear(String anniversaryYear) {
        return new Dates(this.birthDay, this.birthMonth, this.birthYear, this.anniversaryDay, this.anniversaryMonth, anniversaryYear);
    }
}

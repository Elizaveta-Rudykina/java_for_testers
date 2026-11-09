package model.contact;

/**
 * Личные данные и идентификаторы
 */

public record Identity(
        String firstName,
        String middleName,
        String lastName,
        String nickName,
        String title
) {
    public Identity withFirstName(String firstName) {
        return new Identity(firstName, this.middleName, this.lastName, this.nickName, this.title);
    }

    public Identity withMiddleName(String middleName) {
        return new Identity(this.firstName, middleName, this.lastName, this.nickName, this.title);
    }

    public Identity withLastName(String lastName) {
        return new Identity(this.firstName, this.middleName, lastName, this.nickName, this.title);
    }

    public Identity withNickName(String nickName) {
        return new Identity(this.firstName, this.middleName, this.lastName, nickName, this.title);
    }

    public Identity withTitle(String title) {
        return new Identity(this.firstName, this.middleName, this.lastName, this.nickName, title);
    }
}

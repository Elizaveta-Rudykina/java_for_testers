package model.contact;

/**
 * Контактная информация для связи
 */

public record Communication(
        String address,
        String homePhone,
        String mobilePhone,
        String workPhone,
        String email1,
        String email2,
        String email3,
        String homepage
) {
    public Communication withAddress (String address) {
        return new Communication(address, this.homePhone, this.mobilePhone, this.workPhone, this.email1, this.email2, this.email3, this.homepage);
    }

    public Communication withHomePhone (String homePhone) {
        return new Communication(this.address, homePhone, this.mobilePhone, this.workPhone, this.email1, this.email2, this.email3, this.homepage);
    }

    public Communication withMobilePhone (String mobilePhone) {
        return new Communication(this.address, this.homePhone, mobilePhone, this.workPhone, this.email1, this.email2, this.email3, this.homepage);
    }

    public Communication withWorkPhone (String workPhone) {
        return new Communication(this.address, this.homePhone, this.mobilePhone, workPhone, this.email1, this.email2, this.email3, this.homepage);
    }

    public Communication withEmail1 (String email1) {
        return new Communication(this.address, this.homePhone, this.mobilePhone, this.workPhone, email1, this.email2, this.email3, this.homepage);
    }

    public Communication withHEmail2 (String email2) {
        return new Communication(this.address, this.homePhone, this.mobilePhone, this.workPhone, this.email1, email2, this.email3, this.homepage);
    }

    public Communication withEmail3 (String email3) {
        return new Communication(this.address, this.homePhone, this.mobilePhone, this.workPhone, this.email1, this.email2, email3, this.homepage);
    }

    public Communication withHomepage (String homepage) {
        return new Communication(this.address, this.homePhone, this.mobilePhone, this.workPhone, this.email1, this.email2, this.email3, homepage);
    }
}

package model.contact;

public record ContactData(
        Identity identity,
        Communication communication,
        Dates dates,
        AdditionalInfo additionalInfo
) {
    public ContactData withIdentity(Identity identity) {
        return new ContactData(identity, this.communication, this.dates, this.additionalInfo);
    }

    public ContactData withCommunication(Communication communication) {
        return new ContactData(this.identity, communication, this.dates, this.additionalInfo);
    }

    public ContactData withDates(Dates dates) {
        return new ContactData(this.identity, this.communication, dates, this.additionalInfo);
    }

    public ContactData withAdditionalInfo(AdditionalInfo additionalInfo) {
        return new ContactData(this.identity, this.communication, this.dates, additionalInfo);
    }
}

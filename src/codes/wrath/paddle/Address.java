package codes.wrath.paddle;

import java.util.Objects;

public class Address {
    private Integer number;
    private String street;
    private String district;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String complement;

    public Address(Integer number, String street, String district, String city, String state, String zip,
            String country, String complement) {
        this.number = number;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.complement = complement;
    }

    public Address(Integer number, String street, String district, String city, String state, String zip,
            String country) {
        this(number, street, district, city, state, zip, country, "");
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, street, district, city, state, zip, country, complement);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        return Objects.equals(number, other.number) && Objects.equals(street, other.street)
                && Objects.equals(district, other.district) && Objects.equals(city, other.city)
                && Objects.equals(state, other.state) && Objects.equals(zip, other.zip)
                && Objects.equals(country, other.country) && Objects.equals(complement, other.complement);
    }

    @Override
    public String toString() {
        return "Address(number=" + number + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country="
                + country + ")";
    }

}

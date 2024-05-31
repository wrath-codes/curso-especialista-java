package codes.wrath.paddle;

public class Club {
    private String name;
    private String phone;
    private String email;
    private String cnpj;
    private String stateRegistration;
    private Address address;

    public Club(String name, String phone, String email, String cnpj, String stateRegistration, Address address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.cnpj = cnpj;
        this.stateRegistration = stateRegistration;
        this.address = address;
    }

    public Club(String name, String phone, String email, String cnpj, String stateRegistration, Integer number,
            String street, String district, String city, String state, String zip, String country, String complement) {
        this(name, phone, email, cnpj, stateRegistration,
                new Address(number, street, district, city, state, zip, country, complement));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}

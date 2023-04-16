import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String numberPhone;
    private Type type;

    public Contact() {
    }
    public Contact(String name, String numberPhone) {
        this.name = name;
        this.numberPhone = numberPhone;
    }

    public Contact(String name, String numberPhone, Type type) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Type getType(){
        return type;
    }


    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", type=" + type +
                '}';
    }
}
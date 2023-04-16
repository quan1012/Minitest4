import java.io.Serializable;

public class Type implements Serializable {
    private String idType;
    private String nameType;
    public Type(String idType, String nameType) {
        this.idType = idType;
        this.nameType = nameType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }


    @Override
    public String toString() {
        return "Type{" +
                "idType='" + idType + '\'' +
                ", nameType='" + nameType + '\'' +
                '}';
    }
}
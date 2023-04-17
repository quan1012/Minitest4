import java.io.IOException;
import java.util.*;

public class Manager extends Phone implements IPhone {
    private ArrayList<Contact> contactArrayList;
    private ArrayList<Type> typeArrayList;

    public Manager(List<Contact> contacts) {
        contactArrayList = new ArrayList<>();
        typeArrayList = new ArrayList<>();
    }

    public void saveToFile(String filename) throws IOException {
        ReadWriteFile<Contact> writeFile = new ReadWriteFile<>();
        writeFile.writeToFile(filename, contactArrayList);
        System.out.println("Đã lưu vào danh bạ " + filename);
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        ReadWriteFile<Contact> readFile = new ReadWriteFile<>();
        contactArrayList = readFile.readFromFile(filename);
        System.out.println("Đọc từ file " + filename);
    }

    public void addType(Type type) {
        typeArrayList.add(type);
    }

    @Override
    public void searchPhone(String name) {
        boolean isFound = false;
        for (Contact c : contactArrayList) {
            if (c.getName().equals(name)) {
                System.out.println(c);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Không tìm thấy liên hệ có tên " + name + " trong danh sách.");
        }
    }

    @Override
    public void sort() {
        Collections.sort(contactArrayList, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        for (Contact c : contactArrayList) {
            System.out.println(c);
        }
    }

    @Override
    public void display(Type type) {
        if (type == null) {
            System.out.println("Hiển thị tất cả các liên hệ:");
            for (Contact c : contactArrayList) {
                System.out.println(c);
            }
        } else {
            System.out.println("Hiển thị danh bạ với loại " + type.getNameType() + ":");
            for (Contact c : contactArrayList) {
                if (c.getType().getIdType().equals(type.getIdType())) {
                    System.out.println(c);
                }
            }
        }
    }

    @Override
    void insertPhone(Contact contact) {
        Type type = chooseType();
        if (type == null) {
            System.out.println("Không thể thêm liên hệ mà không có loại liên hệ.");
            return;
        }
        for (Contact c : contactArrayList) {
            if (c.getName().equalsIgnoreCase(contact.getName()) && c.getType().getIdType().equals(type.getIdType())) {
                System.out.println("Số điện thoại này đã tồn tại, bạn có muốn cập nhật lại số điện thoại? (Y/N)");
                String choice = new Scanner(System.in).nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    c.setNumberPhone(contact.getNumberPhone());
                    System.out.println("Cập nhật số điện thoại thành công.");
                }
                return;
            }
        }
        contact.setType(type);
        contactArrayList.add(contact);
        System.out.println("Thêm liên hệ thành công.");
    }

    public Type chooseType() {
        System.out.println("Chọn loại liên hệ:");
        for (Type t : typeArrayList) {
            System.out.println(t.getIdType() + ". " + t.getNameType());
        }
        System.out.println("0. Tạo loại mới");
        int choice = new Scanner(System.in).nextInt();
        if (choice == 0) {
            System.out.println("Nhập ID Type:");
            String ID = new Scanner(System.in).nextLine();
            System.out.println("Nhập tên Type:");
            String typeName = new Scanner(System.in).nextLine();
            Type type = new Type(ID, typeName);
            addType(type);
            return type;
        } else {
            for (Type t : typeArrayList) {
                if (t.getIdType().equals(String.valueOf(choice))) {
                    return t;
                }
            }
        }
        return null;
    }

    @Override
    public void removePhone(String name) {
        boolean isRemoved = false;
        for (int i = 0; i < contactArrayList.size(); i++) {
            if (contactArrayList.get(i).getName().equals(name)) {
                contactArrayList.remove(i);
                isRemoved = true;
                break;
            }
        }
        if (isRemoved) {
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Không tìm thấy liên hệ có tên " + name + " trong danh sách.");
        }
    }

    @Override
    public void updatePhone(String name, String newPhone) {
        boolean isUpdated = false;
        for (Contact c : contactArrayList) {
            if (c.getName().equals(name)) {
                c.setNumberPhone(newPhone);
                isUpdated = true;
                break;
            }
        }
        if (isUpdated) {
            System.out.println("Cập nhật số điện thoại mới thành công cho liên hệ " + name);
        } else {
            System.out.println("Không tìm thấy liên hệ có tên " + name + " trong danh sách.");
        }
    }
}
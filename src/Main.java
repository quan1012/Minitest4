
import java.util.*;
public class Main {
     public static List<Contact> contacts = new ArrayList<>();
    public static Manager phoneBookManage = new Manager(contacts);


    public static void  search(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên cần tìm kiếm:");
        String name = sc.nextLine();
        phoneBookManage. searchPhone(name);

    }

    public static void sort(){
        phoneBookManage.sort();
    }

    public static void display(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID:");
        String id=sc.nextLine();
        System.out.println("Nhập tên công ty:");
        String name=sc.nextLine();
        Type type=new Type(id,name);
        phoneBookManage.display(type);
    }

    public static void delete(){
        System.out.println("Nhập tên cần xóa:");
        Scanner sc=new Scanner(System.in);
        String name = sc.nextLine();
        phoneBookManage.removePhone(name);
    }

    public static void editPhone(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhập tên:");
        String name = sc.nextLine();
        System.out.println("Nhập số điện thoại:");
        String newPhone=sc.nextLine();
        phoneBookManage.updatePhone(name,newPhone);
    }

    public static void insert(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập tên:");
        String name = sc.nextLine();
        System.out.println("Nhập số điện thoại:");
        String phoneNumber= sc.nextLine();
        System.out.println("Nhập type:");
        System.out.println("Nhập ID:");
        String id=sc.nextLine();
        System.out.println("Nhập tên công ty:");
        String n_ame=sc.nextLine();
        Type type=new Type(id,n_ame);

        Contact contact=new Contact(name,phoneNumber,type);

        phoneBookManage.insertPhone(contact);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {

            System.out.println(
                    "1.Tìm kiếm số theo tên.\n"
                            + "2.Sắp xếp danh bạ. \n"
                            + "3.Hiển thị theo type.\n"
                            + "4.Xóa số.\n"
                            + "5.Sửa số điện thoại theo tên.\n"
                            + "6.Thêm số điện thoại.\n"
                            + "0.Exit");
            System.out.println();
            System.out.println("Vui lòng chọn chức năng:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    search();
                    break;
                case 2:
                    sort();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    editPhone();
                    break;
                case 6:
                    insert();
                    break;
                default:
                    System.out.println("Mời chọn lại chức năng!!!");
            }
        }while (choice !=0);
    }
}
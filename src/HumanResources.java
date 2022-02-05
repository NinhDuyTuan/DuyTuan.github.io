import java.nio.file.FileSystemLoopException;
import java.sql.Array;
//khai báo thư viện
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
// khai báo lớp HumanResources
public class HumanResources {
    static Scanner sc = new Scanner(System.in);

    // Hiển thị thông tin nhân viên
    public static void display(ArrayList<Staff> staffList) {
        // chạy vòng lặp duyệt từng đối tượng Staff trong mảng staffList
        for (Staff i : staffList) {
            i.displayInformation(); // in ra lần lượt từng đối tượng trong phương thức displayInformation()
        }
    }
    // Hiển thị phòng ban
    public static void displayDepartment(ArrayList<Department> departmentsList) {
        //chạy vòng lặp duyệt từng đối tượng Department trong mảng dempartmentList
        for (Department j : departmentsList) {
            System.out.println(j.toString());//in ra lần lượt từng đối tượng trong phương thức toString()
        }
    }
    // Hiển thị nhân viên theo bộ phận
    public static void displayEmployeeDepartment(ArrayList<Staff> staffList, String department){
        //chạy vòng lặp duyệt từng đối tượng Staff trong mảng staffList
        for(Staff i : staffList){
            //nếu tên department trùng với tên department trong arraylist thì in ra phương thức displayInformation()
            if(department.equalsIgnoreCase(i.getNameDepartment()) ){
                i.displayInformation();
            }
        }
    }
    //Thêm nhân viên mới
    public static void addNewEmployee(ArrayList<Staff> staffList, int newCode, String newName, double newCoSalary, String inDate, String newDepartment ,int newVacationDay, int overTime, String newTitle){
        Staff newInfo;// khai báo biến newInfo có kiểu dữ liệu Staff
        //nếu độ dài chức vụ lớn hơn không thì khai báo object newInfo theo lớp Manager
        if(newTitle.length() > 0){
            newInfo = new Manager(newCode, newName, newCoSalary, inDate, newDepartment, newVacationDay, newTitle);
            // ngược lại , khai báo object newInfo theo lớp Employee
        }else {
           newInfo = new Employee(newCode, newName, newCoSalary , inDate, newDepartment, newVacationDay, overTime);
        }
        // thêm nhân viên mới vào mảng staffList
        staffList.add(newInfo);
    }
    //Search thông tin nhân viên
    public static void searchInfo(ArrayList<Staff> staffList, String keySearch){
        boolean isHas = false;
        //duyệt vòng lặp duyệt từng đối tượng Staff trong mảng staffList
        for(Staff i : staffList){
            //nếu keySearch trùng với tên nhân viên hoặc mã số nhân viên thì gọi phương thức displayInformation
            if(keySearch.equalsIgnoreCase(i.getNameEmployee()) || keySearch.equalsIgnoreCase(String.valueOf(i.getCodeEmployee()))){
                i.displayInformation();
                isHas = true; // isHas = true thì phương thức displayInformation sẽ tiếp tục in cho đến khi ko tìm được

            }
        }
        // khi ko tìm được thì isHas = false và in ra ko tìm thấy
        if (!isHas){
            System.out.println("Ko tìm thấy tên bạn muốn tìm !");
        }
    }
    //Hiển thị lương nhân viên
    public static void displaySalary(ArrayList<Staff> stafflist ){
        // dùng vòng lặp duyệt từng phần tử Staff trong mảng staffList
        for(Staff st : stafflist){
            // kiểm tra nếu st là kiểu Employee thì ép kiểu staff qua Employee
            if(st instanceof Employee){
                Employee e = (Employee) st;
                System.out.println(e.displaySalary());
            }
            // kiểm tra nếu st là kiểu Manager thì ép kiểu staff qua Manager
            if(st instanceof  Manager){
                Manager m = (Manager) st;
                System.out.println(m.displaySalary());
            }
        }
    }

    //Sắp xếp lương tăng dần

    public static void ascendingSalary(ArrayList<Staff> staffList){
        //sử dụng method comparator để dùng hàm sort
        //để xếp tăng dần lấy o1 - o2
        Comparator<Staff> ascending = new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.calculateSalary() - o2.calculateSalary() ;
            }
        };
        staffList.sort(ascending);
        for(Staff staff : staffList){
            //lúc này staffList đã được sắp xếp lương theo thứ tự tăng dần
            // duyệt từng đối tượng trong mảng staffList và in ra phương thức displaySalary
            System.out.println(staff.displaySalary());
        }
    }
    //Sắp xếp lương giảm dần
    public static void decreasingSalary(ArrayList<Staff> staffList){
        //sử dụng method comparator để dùng hàm sort
        //để xếp giảm dần lấy o2 - o1
        Comparator<Staff> desceasing = new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o2.calculateSalary() - o1.calculateSalary() ;
            }
        };
        staffList.sort(desceasing);
        for(Staff staff : staffList){
            //lúc này staffList đã được sắp xếp lương theo thứ tự giảm dần
            // duyệt từng đối tượng trong mảng staffList và in ra phương thức displaySalary
            System.out.println(staff.displaySalary());
        }
    }


    public static void main(String[] args) {
        //tạo 1 arraylist có tên staffList có kiểu dữ liệu Staff
        ArrayList<Staff> staffList = new ArrayList<>();
        //tạo các đối tượng Employee với các field khai báo trong hàm tạo Employee
        Staff Tuan = new Employee(1, "Tuấn", 1.2, "10/04/2020", "Engineer", 3, 20);
        Staff Tu = new Employee(2, "Tú", 1.2, "10/04/2020", "Accountant", 3, 8);
        Staff Nam = new Employee(3, "Nam", 1.2, "10/04/2020", "Engineer", 3, 25);
        Staff Hoa = new Employee(4, "Hòa", 1.2, "10/04/2020", "HR", 3, 10);
        Staff Hoang = new Employee(5, "Hoàng", 1.2, "10/04/2020", "HR", 3, 12);
        //tạo các đối tượng Manager vs các field khai báo trong hàm tạo Employee
        Staff Thien = new Manager(10, "Thiện", 2.0, "10/05/2014", "HR", 5, "Project Leader");
        Staff Trung = new Manager(11, "Nam", 2.5, "10/05/2014", "Engineer", 5, "Technical Leader");
        Staff TuanAnh = new Manager(12, "Tuấn Anh", 3.0, "10/05/2014", "Accountant", 5, "Project Leader");
        Staff Tung = new Manager(13, "Tùng", 3.5, "10/05/2014", "Engineer", 5, "Technical Leader");
        //thêm các đối tượng Employee vào mảng staffList
        staffList.add(Tuan);
        staffList.add(Tu);
        staffList.add(Nam);
        staffList.add(Hoa);
        staffList.add(Hoang);
        //thêm các đối tượng Manager vào mảng staffList
        staffList.add(Thien);
        staffList.add(Trung);
        staffList.add(TuanAnh);
        staffList.add(Tung);
        // Tạo 1 ArrayList có tên là departmetnList có kiểu dữ liệu là Department
        ArrayList<Department> departmentsList = new ArrayList<>();
        //khơi tạo các đối tượng Department với các field được khai báo trong hàm tạo Department
        Department HR = new Department("HR", "HR", 3);
        Department Accountant = new Department("AC", "Accountant", 2);
        Department Engineer = new Department("EN", "Engineer", 5);
        //thêm các đối tượng Department vào mảng departmentList
        departmentsList.add(HR);
        departmentsList.add(Accountant);
        departmentsList.add(Engineer);
        // Cho user nhập lựa chọn
        boolean check = true;
        //vòng lắp do while cho người dùng nhập liên tục cho đến khi check = false
        do {
            System.out.println("-------------------Menu-------------------");
            System.out.println("Mời bạn chọn 1 trong các chức năng sau: ");
            System.out.println("Nhấn phím 1 - Hiển thị danh sách nhân viên ");
            System.out.println("Nhấn phím 2 - Hiển thị các bộ phận trong công ty ");
            System.out.println("Nhấn phím 3 - Hiển thị danh sách nhân viên theo từng bộ phận ");
            System.out.println("Nhấn phím 4 - Thêm nhân viên mới");
            System.out.println("Nhấn phím 5 - Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên ");
            System.out.println("Nhấn phím 6 - Hiển thị bảng lương của nhân viên toàn công ty ");
            System.out.println("Nhấn phím 7 - Hiển thị bảng lương của nhân viên theo thứ tự tăng dần ");
            System.out.println("Nhấn phím 8 - Hiển thị bảng lương của nhân viên theo thứ tự giảm dần ");
            System.out.println("Nhấn phím 0 - Thoát khỏi chương trình");
            System.out.println("-------------------*************************************-------------------");
            System.out.print("Nhập số ở đây ");
            int num = sc.nextInt(); // khai báo num để xét các case trong switch

            switch (num) {
                case 1 -> {
                    System.out.println("Bạn đang chọn hiển thị danh sách nhân viên trong công ty");
                    display(staffList);//gọi phương thức display có đối số là staffList
                }
                case 2 -> {
                    System.out.println("Bạn đang chọn hiển thị danh sách các phòng ban");
                    displayDepartment(departmentsList);// gọi phương thức displayDepartment có đối số là departmentList
                }
                case 3 -> {
                    System.out.println("Bạn đang chọn hiển thị danh sách nhân viên theo từng bộ phận");
                    System.out.print("Nhập phòng ban:  ");
                    String department = sc.next();//khai báo biến department cho user nhập phòng muốn tìm kiếm
                    displayEmployeeDepartment(staffList, department);//gọi phương thức  displayEmployeeDepartment có
                    // 2 đối số là staffList và department
                }
                case 4 -> {
                    System.out.println("Bạn đang chọn thêm nhân viên mới");
                    System.out.println("Bạn muốn thêm nhân viên hay quản lý");
                    System.out.println("Nhân viên - Nhập a ");
                    System.out.println("Quản lý - Nhập b ");
                    String choose = sc.next();//cho người dùng nhập lựa chọn a hoặc b để chọn thêm nhân viên hay quản lý
                   //nếu chọn a cho user nhập các thuộc tính của nhân viên
                    if (choose.equalsIgnoreCase("a")) {
                        System.out.print("Nhập mã nhân viên : ");
                        int newCode = sc.nextInt();
                        System.out.print("Nhập họ tên : ");
                        String newName = sc.next();
                        System.out.print("Nhập Hệ số lương : ");
                        double newCoSalary = sc.nextDouble();
                        System.out.print("Nhập ngày vào công ty : ");
                        String inDate = sc.next();
                        System.out.print("Nhập phòng ban : ");
                        String newDepartment = sc.next();
                        System.out.print("Số ngày nghỉ phép : ");
                        int newVacationDay = sc.nextInt();
                        System.out.print("Số giờ làm thêm : ");
                        int newOverTime = sc.nextInt();
                        String newTitle = "";
                        //gọi phương thức  addNewEmployee() có các đối số
                        addNewEmployee(staffList, newCode, newName, newCoSalary, inDate, newDepartment, newVacationDay, newOverTime, newTitle);
                        System.out.println("Bạn có thể xem danh sách mới bằng cách chọn phím 1");

                    // ngược lại cho user nhập các thuộc tính của quản lý
                    } else if (choose.equalsIgnoreCase("b")) {
                        System.out.print("Nhập mã quản lý : ");
                        int newCode = sc.nextInt();
                        System.out.print("Nhập họ tên : ");
                        String newName = sc.next();
                        System.out.print("Nhập Hệ số lương : ");
                        double newCoSalary = sc.nextDouble();
                        System.out.print("Nhập ngày vào công ty : ");
                        String inDate = sc.next();
                        System.out.print("Nhập phòng ban : ");
                        String newDepartment = sc.next();
                        System.out.print("Số ngày nghỉ phép : ");
                        int newVacationDay = sc.nextInt();
                        int newOverTime = 0;
                        System.out.print("Chức vụ : ");
                        sc.nextLine();
                        String newTitle = sc.nextLine();
                        // gọi phương thức addNewEmployee() có các đối số
                        addNewEmployee(staffList, newCode, newName, newCoSalary, inDate, newDepartment, newVacationDay, newOverTime, newTitle);
                        System.out.println("Bạn có thể xem danh sách mới bằng cách chọn phím 1");
                    }
                }
                case 5 -> {
                    System.out.println("Bạn muốn tìm kiếm thông tin nhân viên ");
                    System.out.print("Bạn có thể tìm kiếm thông tin bằng cách nhập mã nhân viên hoặc tên vào đây : ");
                    String keySearch = sc.next(); // cho user nhập tên hoặc mã nhân viên
                    searchInfo(staffList, keySearch); //gọi phương thức searchInfo() có các đối số staffList và keySearch
                }
                case 6 -> {
                    System.out.println("Bạn đang chọn hiển thị lương toàn bộ nhân viên trong công ty");
                    displaySalary(staffList);// gọi phương thức displaySalary có đối số staffList
                }
                case 7 -> {
                    System.out.println("Bạn đang chọn hiển thị lương của nhân viên theo thứ tự tăng dần:");
                    ascendingSalary(staffList); // gọi phương thức ascendingSalary() có đối số là staffList
                }
                case 8 -> {
                    System.out.println("Bạn đang chọn hiển thị lương của nhân viên theo thứ tự giảm dần:");
                    decreasingSalary(staffList);// gọi phương thức decreasingSalary() có đối số là staffList
                }
                case 0 -> {
                    System.out.println("Bạn đã kết thúc chương trình. Hẹn gặp lại !!!");
                    check = false;//khi check = false vòng lặp do while sẽ dừng lại
                }
            }
        } while (check);

    }
}
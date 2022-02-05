public class Department {
    private String codeDepartment;// khai báo biến mã bộ phận
    private String nameDepartment;// khai báo biến tên bộ phận
    private int numberEmployeeDepartment; // khai báo biến số lượng nhân viên
    // khởi tạo hàm tạo có tham số
    public Department(String codeDepartment, String nameDepartment, int numberEmployeeDepartment){
        this.codeDepartment = codeDepartment;
        this.nameDepartment = nameDepartment;
        this.numberEmployeeDepartment = numberEmployeeDepartment;
    }
    //tạo các phương thức getCodeDepartment(), getNameDepartment() và getNumberEmployeeDepartment() để trả về
    // mã bộ phân, tên bộ phận, só lượng nhân viên
    public String getCodeDepartment(){
        return codeDepartment;
    }
    public String getNameDepartment(){
        return  nameDepartment;
    }
    public int getNumberEmployeeDepartment(){
        return numberEmployeeDepartment;
    }
    // tạo phương thức toString trả về 1 chuỗi nêu thông tin về bộ phận
    public String toString(){
        return "Mã bộ phận: "+getCodeDepartment() +" | Tên bộ phận: "+ getNameDepartment() + " | số lượng nhân viên trong phòng: "+ getNumberEmployeeDepartment();
    }
}

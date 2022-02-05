public abstract class Staff {
    private int codeEmployee; // khai báo mã nhân viên
    private String nameEmployee; // khai báo tên nhân viên
    private double coSalary; // khai báo hệ số lương
    private String inDate; // khai báo ngày vào làm
    private String nameDepartment; // khai báo bộ phận làm việc
    private int vacationDay; // khai báo số ngày nghỉ phép
    //tạo hàm tạo Staff
    public Staff(int codeEmployee, String nameEmployee, double coSalary, String inDate, String nameDepartment, int vacationDay){
        this.codeEmployee = codeEmployee;
        this.nameEmployee = nameEmployee;
        this.coSalary = coSalary;
        this.inDate = inDate;
        this.nameDepartment = nameDepartment;
        this.vacationDay = vacationDay;
    }
    // khai báo phương thức getCodeEmployee để trả về giá trị mã nhân viên
    public int getCodeEmployee(){
        return codeEmployee;
    }
    // khai báo phương thức getNameEmployee để trả về giá trị tên nhân viên
    public String getNameEmployee(){
        return nameEmployee;
    }
    // khai báo phương thức getCoSalary để trả về giá trị tên nhân viên
    public double getCoSalary(){
        return coSalary;
    }
    // khai báo phương thức getInDate để trả về giá trị ngày vào làm
    public String getInDate(){
        return inDate;
    }
    // khai báo phương thức getNameDepartment để trả về giá trị tên phòng ban
    public String getNameDepartment(){
        return nameDepartment;
    }
    // khai báo phương thức getVacationDay để trả về giá trị số ngày nghỉ
    public int getVacationDay(){
        return vacationDay;
    }

    //khai báo phương thức trừu tượng displayInformation()
    public abstract void displayInformation();
    //khai báo phương thức trừu tượng calculateSalary()
    protected abstract int calculateSalary();
    //khai báo phương thức trừu tượng displaySalary()
    protected  abstract  String displaySalary();
}

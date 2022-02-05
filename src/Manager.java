//tạo lớp Manager kế thừa lớp Staff và ICalculator
public class Manager extends Staff implements ICalculator{
    private String title;// tạo biến chức vụ

    public Manager(int codeEmployee, String nameEmployee, double coSalary, String inDate, String nameDepartment, int vacationDay, String title) {
        super(codeEmployee, nameEmployee, coSalary, inDate, nameDepartment, vacationDay);// super kế thừa các thuộc tính từ class Staff
        this.title = title;
    }
    // khai báo phương thức getTitle() để trả về giá trị chức vụ (title)
    public String getTitle(){
        return title;
    }
    //khai báo phương thức titleSalary và trả về 1 giá trị
    //nếu chức vụ là Business Leader thì trả về 8000000
    //nếu chức vụ là Project Leader thì trả về 5000000
    //còn lại là 6000000
    public double titleSalary(){
        if(title.equals("Business Leader")){
            return 8000000;
        }else if(title.equals("Project Leader")){
            return 5000000;
        }else{
            return 6000000;
        }
    }
    //ghi đè phương thức calculateSalary() từ class Staff
    @Override
    public int calculateSalary(){
        return (int)(getCoSalary() * 5000000 + titleSalary());
    }
    //khai báo phương thức displaySalary() trả về 1 chuỗi
    public String displaySalary(){
        return "Mã nhân viên: " + getCodeEmployee() + " | Tên nhân viên: " + getNameEmployee() + " | Hệ số lương: " + getCoSalary() + " | Lương đạt được : "+ calculateSalary();
    }
    //ghi đè phương thức displayInformation() từ class Staff
    @Override
    public void displayInformation(){
        System.out.print("Mã nhân viên : " + getCodeEmployee() +" | Tên nhân viên: " + getNameEmployee() + " | Hệ số lương: "+ getCoSalary() );
        System.out.print(" | Ngày vào làm: " + getInDate() + " | Bộ phận: " + getNameDepartment() + " | Số ngày nghỉ phép: " + getVacationDay() +" | Chức vụ: " + getTitle());
        System.out.println();
    }
}

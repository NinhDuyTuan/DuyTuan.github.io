// khai báo lớp Employee kế thừa lớp Staff và mở rộng ICalculator
public class Employee extends Staff implements ICalculator{
    private int overTime; // khai báo số giờ làm thêm
    //khai báo lớp Employee và truyền các tham số
    public Employee(int codeEmployee, String nameEmployee, double coSalary, String inDate, String nameDepartment, int vacationDay, int overTime){
        super(codeEmployee,nameEmployee, coSalary, inDate,nameDepartment,vacationDay );// super kế thừa các thuộc tính từ class Staff
        this.overTime = overTime;
    }
    // khai báo phương thức getOverTime() để trả về giá trị làm thêm (overTime)
    public int getOverTime(){
        return overTime;
    }

    @Override
    public int calculateSalary(){
        return (int)(getCoSalary() * 3000000 + overTime * 200000);
    }
    public String displaySalary(){
        return "Mã nhân viên: " + getCodeEmployee() + " | Tên nhân viên: " + getNameEmployee() + " | Hệ số lương: " + getCoSalary() + " | Lương đạt được : "+ calculateSalary();
    }
    @Override
    public void displayInformation(){
        System.out.print("Mã nhân viên : " + getCodeEmployee() +" | Tên nhân viên: " + getNameEmployee() + " | Hệ số lương: "+ getCoSalary() );
        System.out.print(" | Ngày vào làm: " + getInDate() + " | Bộ phận: " + getNameDepartment() + " | Số ngày nghỉ phép: " + getVacationDay() +" | Số giờ làm thêm: " + getOverTime() );
        System.out.println();
    }


}

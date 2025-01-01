package zitsolution.com.JavaWithJasper.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBonusDTO {
    private Integer bonusId;
    private String employeeName;
    private String jobTitle;
    private Double bonusAmount;
    private String bonusDate;
    private String remarks;
}

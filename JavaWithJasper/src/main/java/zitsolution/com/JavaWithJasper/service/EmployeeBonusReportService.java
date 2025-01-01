package zitsolution.com.JavaWithJasper.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zitsolution.com.JavaWithJasper.dto.EmployeeBonusDTO;
import zitsolution.com.JavaWithJasper.dto.Publication;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeBonusReportService {
    public List<EmployeeBonusDTO> fetchEmployeeBonusReport() {
        String apiUrl = "http://localhost:8010/api/employee-bonuses/list";
        RestTemplate restTemplate = new RestTemplate();
        EmployeeBonusDTO[] employeeBonusDTOS = restTemplate.getForObject(apiUrl, EmployeeBonusDTO[].class);
        return Arrays.asList(employeeBonusDTOS);
    }
}

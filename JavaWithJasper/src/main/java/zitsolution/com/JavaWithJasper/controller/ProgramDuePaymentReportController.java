package zitsolution.com.JavaWithJasper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zitsolution.com.JavaWithJasper.model.ProgramDuePayment;
import zitsolution.com.JavaWithJasper.service.ProgramDuePaymentReportService;

import java.util.Arrays;

@RestController
@RequestMapping("/api/reports")
public class ProgramDuePaymentReportController {
    @Autowired
    private ProgramDuePaymentReportService reportService;

    @GetMapping("/program-due-payment-list-all-time-pdf")
    public ResponseEntity<byte[]> downloadReport() {
        try {
            // Sample Data
            ProgramDuePayment item1 = new ProgramDuePayment(1, "IBN Sina-Seminar", "IBN Sina-Rangpur", "01713-041428",
                    "1-Aug-2023", "Evening(7PM-12PM)", 400, 700000.00, 400000.00, 300000.00);
            ProgramDuePayment item2 = new ProgramDuePayment(2, "Popular Pharma", "Popular Meeting", "01713-041428",
                    "7-Aug-2023", "Evening(7PM-12PM)", 350, 550000.00, 225000.00, 125000.00);
            ProgramDuePayment item3 = new ProgramDuePayment(3, "Marriage- Dr. Javed", "Dr. Javed", "01713-041428",
                    "13-Aug-2023", "Full Day (10AM-12AM)", 450, 880000.00, 479000.00, 321000.00);
            ProgramDuePayment item4 = new ProgramDuePayment(4, "Birthday- ZIT MD", "Syed Mostafa Jamal", "01713-041428",
                    "20-Aug-2023", "Full Day (10AM-12AM)", 150, 200000.00, 76300.00, 123700.00);

            byte[] pdf = reportService.generateReport(Arrays.asList(item1, item2, item3, item4));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=ProgramDuePaymentReport.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                    .body(pdf);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
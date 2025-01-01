package zitsolution.com.JavaWithJasper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zitsolution.com.JavaWithJasper.model.IndentItem;
import zitsolution.com.JavaWithJasper.service.IndentItemReportService;

import java.util.Arrays;
@RestController
@RequestMapping("/api/reports")
public class IndentItemReportController {
    @Autowired
    private IndentItemReportService indentItemReportService;

    @GetMapping("/download-report/9C_B_01A Indent Report - From Interface.pdf")
    public ResponseEntity<byte[]> downloadReport() {
        try {
            IndentItem item1 = new IndentItem(1, "Basmati Rice", "Basmoti cal", "Kg", 50, 290, 14500, "Good");
            IndentItem item2 = new IndentItem(2, "Buter Daal", "Buter Dal", "Kg", 20, 120, 2400, "Good");

            byte[] pdf = indentItemReportService.generateReport(Arrays.asList(item1, item2));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=IndentReport.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                    .body(pdf);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
package zitsolution.com.JavaWithJasper.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zitsolution.com.JavaWithJasper.dto.Publication;
import zitsolution.com.JavaWithJasper.service.PublicationService;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class PublicationReportController {

    @Autowired
    private PublicationService publicationService;

    @GetMapping("/publications")
    public ResponseEntity<byte[]> generatePublicationReport() {
        try {
            // Fetch the data
            List<Publication> publicationList = publicationService.fetchPublications();
            if (publicationList.isEmpty()) {
                throw new RuntimeException("Data source is empty!");
            }

            // Load JasperReport template
            InputStream reportStream = new ClassPathResource("reports/publicationReport.jrxml").getInputStream();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);


            // Fill the report with data
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(publicationList);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ReportTitle", "Publication List Report");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Export the report to PDF
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            // Return the PDF as a response
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=PublicationReport.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500)
                    .body(("Error generating report: " + e.getMessage()).getBytes());
        }
    }
}
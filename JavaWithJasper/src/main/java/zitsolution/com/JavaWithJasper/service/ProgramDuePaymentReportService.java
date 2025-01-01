package zitsolution.com.JavaWithJasper.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import zitsolution.com.JavaWithJasper.model.ProgramDuePayment;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProgramDuePaymentReportService {
    public byte[] generateReport(List<ProgramDuePayment> paymentList) throws JRException {
        InputStream reportStream = getClass().getResourceAsStream("/reports/ProgramDuePaymentReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        // Parameters for the report
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ReportTitle", "Program Due Payment List-All Time");
        parameters.put("WaterParkName", "Chiklee Water Park");
        parameters.put("Location", "Honumantola, Rangpur");
        parameters.put("ReportNumber", "C_D_02D");
        parameters.put("PrintDate", "7/8/2023");
        parameters.put("PrintTime", "11:03 AM");

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(paymentList);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
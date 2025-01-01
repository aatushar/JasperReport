package zitsolution.com.JavaWithJasper.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import zitsolution.com.JavaWithJasper.model.IndentItem;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndentItemReportService {
    public byte[] generateReport(List<IndentItem> items) throws JRException {
        InputStream reportStream = getClass().getResourceAsStream("/reports/IndentReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("IndentNo", "000050");
        parameters.put("IndentTo", "Sub Store-Kitchen");
        parameters.put("IndentDate", "15-08-2023");
        parameters.put("PrintDate", "15-08-2023 04:45:59 PM");

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(items);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

}
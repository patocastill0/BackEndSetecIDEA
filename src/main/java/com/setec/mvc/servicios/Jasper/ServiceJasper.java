package com.setec.mvc.servicios.Jasper;

import com.setec.mvc.dtos.reportesJasper.TrabajadorJasperDTO;
import com.setec.mvc.servicios.TrabajadorServicioImpl;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceJasper {
    @Autowired
    private TrabajadorServicioImpl trabajadorser;

    public String exportReport(String reportFormat, String folio) throws FileNotFoundException, JRException {
        String path =  "C:\\Users\\LENOVO\\Documents\\ReportesJasper";
        List<TrabajadorJasperDTO> trabajadordto = new ArrayList<>();
        TrabajadorJasperDTO trabajador = trabajadorser.findByFolioTrabajador(folio);
        trabajadordto.add(trabajador);
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:ReporteSetec.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(trabajadordto );

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\trabajador.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\trabajador.pdf");
        }

        return "report generated in path : " + path;
    }
}

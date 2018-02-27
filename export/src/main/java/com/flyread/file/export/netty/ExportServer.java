package com.flyread.file.export.netty;

import com.flyread.file.export.base.ExportFactory;
import com.flyread.file.export.base.ExportHandlerPipeline;
import com.flyread.file.export.base.ExportService;
import com.flyread.file.export.base.ExportType;
import com.flyread.file.export.excel.*;
import com.flyread.file.export.excel.util.ExcelUtil;
import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;

import java.io.File;
import java.util.*;

/**
 * Created by DELL on 2018/2/11.
 */
public class ExportServer {
    public static void main(String[] args) {
        String[] rowName = new String[]{"员工编号", "姓名", "性别", "特长", "学历",
                "入职时间", "简历", "照片", "部门"};
        String[] filter = new String[]{"员工编号", "姓名", "性别", "特长", "学历",
                "入职时间", "简历"};
        ExportRequest request = new ExportRequest();
        ExcelData meta = new ExcelData();
        meta.setHeaders(Arrays.asList(rowName));
        meta.setTitle("标题");
        meta.getStyleFuncList().add(e -> {
            HSSFCell cell = ExcelUtil.getCellByCoordinate(e,0,0,0);
            HSSFCellStyle cellStyle = e.createCellStyle();
            //cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(cellStyle);
        });
        meta.getMap().put("list",new ArrayList<Person>(){{add(new Person("1","1","1",new Date(),19));}});
        request.setFileName("123");
        request.setFileType(".xls");
        request.setExportTemplate("template");
        request.setExportData(meta);

        ExportHandlerPipeline pipeline = new ExportHandlerPipeline();
        pipeline.addLast(new ExcelHeaderFilterHandler(Arrays.asList(filter)));
        pipeline.addLast(new DefaultExcelExportHandler(new File("C:\\Users\\DELL\\Desktop\\新建文件夹\\template.xls")));

        ExportService service = ExportFactory.create(ExportType.EXCEL,pipeline,new File("C:\\Users\\DELL\\Desktop\\新建文件夹"),"/download/");
        System.out.println(service.export(request,new ExportResponse()).getPath());
    }
}

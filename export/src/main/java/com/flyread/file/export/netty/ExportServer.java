package com.flyread.file.export.netty;

import com.flyread.file.export.ExportBootstrap;
import com.flyread.file.export.base.ExportType;
import com.flyread.file.export.excel.*;
import com.flyread.file.export.excel.util.ExcelUtil;
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
        ExcelExportData meta = new ExcelExportData();
        meta.setHeaders(Arrays.asList(rowName));
        meta.setTitle("标题");
        meta.getStyleFuncList().add(e -> {
            HSSFCell cell = ExcelUtil.getCellByCoordinate(e,0,0,0);
            HSSFCellStyle cellStyle = e.createCellStyle();
            //cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(cellStyle);
        });
        meta.getMap().put("list",new ArrayList<Person>(){{add(new Person("1","1","1",new Date(),19));}});
        System.out.println(new ExportBootstrap()
                                .initRequest("1234",".xls","C:\\Users\\DELL\\Desktop\\新建文件夹","/download/",new File("C:\\Users\\DELL\\Desktop\\新建文件夹\\template.xls"),meta)
                                .initPipeline()
                                .build(ExportType.EXCEL)
                                .export()
                                .getPath());
    }
}

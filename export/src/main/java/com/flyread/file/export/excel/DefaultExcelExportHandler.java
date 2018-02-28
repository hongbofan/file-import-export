package com.flyread.file.export.excel;

import com.flyread.file.export.base.BaseExportContext;
import com.flyread.file.export.base.ExportHandler;
import com.flyread.file.export.excel.util.JxlsUtil;
import com.flyread.file.export.model.ExportRequest;
import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by hongbf on 2018/2/26.
 */
public class DefaultExcelExportHandler implements ExportHandler {

    @Override
    public void handleRequest(BaseExportContext context) throws Exception {
        ExcelExportContext c = (ExcelExportContext) context;
        ExportRequest request = c.getRequest();

        File template = c.getConfig(request.getTemplateFile().getName());
        if (template == null) {
            this.export(request, c.getOutputStream());
        } else {
            this.exportByJxls(request, c.getOutputStream(),template,c.getJxlsHelper());
        }
    }
    private void exportByJxls(ExportRequest request,OutputStream out,File input,JxlsHelper helper) throws Exception{
        if (input == null) {
            throw new NullPointerException("错误的配置类型:" + request.getOutputFileName());
        }

        InputStream fis = new FileInputStream(input);

        Context context = new Context();
        ExcelExportData data = (ExcelExportData) request.getExportData();
        Map<String,Object> model = data.getMap();
        if (model != null) {
            for (String key : model.keySet()) {
                context.putVar(key, model.get(key));
            }
        }
        Transformer transformer  = helper.createTransformer(fis,out);
        JexlExpressionEvaluator evaluator = (JexlExpressionEvaluator)transformer.getTransformationConfig().getExpressionEvaluator();
        Map<String, Object> funcs = new HashMap<>();
        funcs.put("jx", new JxlsUtil());
        evaluator.getJexlEngine().setFunctions(funcs);
        helper.processTemplate(context,transformer);
    }
    private void export(ExportRequest request, OutputStream out) throws Exception {

        /*ExcelData meta = (ExcelData) request.getExportData();
        List<String> headers = meta.getHeaders();
        List<Object> list = meta.getList();
        String title = meta.getTitle();
        // 创建工作簿对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建工作表
        HSSFSheet sheet = workbook.createSheet(meta.getSheetName());
        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);

        // 合并单元格 起始行, 终止行, 起始列, 终止列
        if (headers.size() > 1) {
            CellRangeAddress cra =new CellRangeAddress(0, 0, 0, headers.size() - 1);
            sheet.addMergedRegion(cra);
        }
        HSSFCell cellTitle = row.createCell(0);
        cellTitle.setCellValue(title);

        row = sheet.createRow(1);
        for (int i = 0; i < headers.size(); i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers.get(i));
            cell.setCellValue(text);
        }

        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 2);
            Object bean = list.get(i);
            Map<String,Object> map = ExcelUtil.objectToMap(bean);
            //拿到第一个数据
            for (int j = 0;j<headers.size();j++) {
                HSSFCell cell = row.createCell(j);
                //遍历字段进行顺序赋值
                Object value = map.get(headers.get(j));
                translate.translate(value,cell);
            }
        }
        // 让列宽随着导出的列长自动适应
        for (int colNum = 0; colNum < headers.size(); colNum++) {
            int columnWidth = sheet.getColumnWidth(colNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                HSSFRow currentRow;
                // 当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(colNum) != null) {
                    HSSFCell currentCell = currentRow.getCell(colNum);
                    if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        int length = currentCell.getStringCellValue()
                                .getBytes().length;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }
            }
            if (colNum == 0) {
                sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
            } else {
                sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
            }
        }
        meta.getStyleFuncList().forEach(c -> c.accept(workbook));
        workbook.write(out);*/
    }
}

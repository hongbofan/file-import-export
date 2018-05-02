//package com.flyread.file.imp0rt.base;
//
//import com.flyread.file.imp0rt.base.impl.DefaultImportPipeline;
//import com.flyread.file.imp0rt.excel.ExcelImportServiceImpl;
//import com.flyread.file.imp0rt.model.ImportRequest;
//import com.flyread.file.imp0rt.txt.TxtImportServiceImpl;
//
///**
// * @author by hongbf on 2018/3/14.
// */
//public class ImportFactory {
//    public static ImportService create(ImportType type, ImportRequest request) {
//        switch (type) {
//            case EXCEL:
//                return new ExcelImportServiceImpl(
//                        new DefaultImportPipeline(request)
//                                .addFirst(new ExcelToJavaBeanHandler())
//                                .addFirst(new ExcelDecoderHandler())
//                );
//            case TXT:
//                return new TxtImportServiceImpl(
//                        new DefaultImportPipeline(request)
//                                .addFirst(new TxtToJavaBeanHandler())
//                                .addFirst(new TxtDecoderHandler())
//                );
//            default:
//                throw new RuntimeException("type is invalid!");
//        }
//    }
//}

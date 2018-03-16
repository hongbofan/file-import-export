package com.flyread.file.imp0rt.model;

import com.flyread.file.imp0rt.base.ImportTranslate;

import java.io.File;

/**
 * @author by hongbf on 2018/2/28.
 */
public class ImportRequest {

    private File importFile;

    private int selectSheet;

    private int startRowNum;

    private ImportTranslate translate;

    public ImportRequest(File importFile) {
        this.importFile = importFile;
    }

    public File getImportFile() {
        return importFile;
    }

    public void setImportFile(File importFile) {
        this.importFile = importFile;
    }


    public int getSelectSheet() {
        return selectSheet;
    }

    public void setSelectSheet(int selectSheet) {
        this.selectSheet = selectSheet;
    }

    public int getStartRowNum() {
        return startRowNum;
    }

    public void setStartRowNum(int startRowNum) {
        this.startRowNum = startRowNum;
    }

    public ImportTranslate getTranslate() {
        return translate;
    }

    public void setTranslate(ImportTranslate translate) {
        this.translate = translate;
    }
}

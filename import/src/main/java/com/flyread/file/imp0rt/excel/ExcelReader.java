package com.flyread.file.imp0rt.excel;

import com.flyread.file.imp0rt.base.ImportReader;
import com.flyread.file.imp0rt.base.ImportWriter;
import com.flyread.file.imp0rt.model.ImportRecord;

import java.io.*;
import java.util.Iterator;


/**
 * @author by hongbf on 2018/2/25.
 */
public class ExcelReader<E> implements ImportReader<E> {

    private Iterator<E> it;
    public ExcelReader(Iterator<E> it) {
        this.it = it;
    }
    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public E next() {
        return it.next();

    }

    public static void main(String[] args) {
        ImportReader<ImportRecord> reader = new ExcelReader<>(new ExcelIterator(new File("C:\\Users\\DELL\\Desktop\\Book.xls")));
        ImportWriter writer = new ExcelWriter();
        while (reader.hasNext()) {
            ImportRecord record = reader.next();
            writer.write(record);
            System.out.println(record.toString());
        }
    }
}

package com.flyread.file.export.excel.util;

import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.command.AbstractCommand;
import org.jxls.command.Command;

/**
 * @author by hongbf on 2018/2/27.
 */
public class JxlsUtil {
    static {
        XlsCommentAreaBuilder.addCommandMapping("each",EachCommandExtend.class);
    }
}

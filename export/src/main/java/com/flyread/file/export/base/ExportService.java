package com.flyread.file.export.base;

import com.flyread.file.export.model.ExportRequest;
import com.flyread.file.export.model.ExportResponse;

/**
 * @author  hongbf on 2018/2/11.
 */
public interface ExportService {
    ExportResponse export();
}

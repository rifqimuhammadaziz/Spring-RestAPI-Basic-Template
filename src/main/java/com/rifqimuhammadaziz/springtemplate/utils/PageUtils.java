package com.rifqimuhammadaziz.springtemplate.utils;

import com.rifqimuhammadaziz.springtemplate.model.response.PageDTO;

public class PageUtils {
    public static PageDTO calculatePage(int page, int size, long totalElement) {
        PageDTO pageDTO = new PageDTO();
        boolean isFirst = false;
        boolean isLast = false;
        long totalPage = 0;

        if (totalElement % size == 0) {
            totalPage = totalElement / size;
        } else {
            totalPage = totalElement / size + 1;
        }

        if (page == totalPage) {
            isLast = true;
        }

        if (page == 1) {
            isFirst = true;
        }

        pageDTO.setFirst(isFirst);
        pageDTO.setLast(isLast);
        pageDTO.setSize(size);
        pageDTO.setPage(page);
        pageDTO.setTotalPage(totalPage);
        pageDTO.setTotalElement(totalElement);

        return pageDTO;
    }
}

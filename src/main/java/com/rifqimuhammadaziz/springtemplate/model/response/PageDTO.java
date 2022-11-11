package com.rifqimuhammadaziz.springtemplate.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageDTO<T> {
    private int page;
    private int size;
    private long totalElement;
    private boolean isFirst;
    private boolean isLast;
    private long totalPage;
    private List<T> data;
}

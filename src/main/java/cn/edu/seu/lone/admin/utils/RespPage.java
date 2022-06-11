package cn.edu.seu.lone.admin.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

public class RespPage<T> extends Page<T> {

    @Override
    public Page<T> setRecords(List<T> records) {
        if (!CollectionUtils.isEmpty(records)) {
            for (T item : records) {

            }
        }
        this.records = records;
        return this;
    }

}

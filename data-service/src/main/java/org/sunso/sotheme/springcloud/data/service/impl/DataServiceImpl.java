package org.sunso.sotheme.springcloud.data.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.sunso.sotheme.springcloud.common.data.DataDTO;
import org.sunso.sotheme.springcloud.data.service.DataService;

@Slf4j
@Service
public class DataServiceImpl implements DataService {
    @Override
    public int saveData(DataDTO dto) {
        log.info("saveData request data[{}]", dto);
        return 1;
    }
}

package org.sunso.sotheme.springcloud.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sunso.sotheme.springcloud.common.data.DataDTO;
import org.sunso.sotheme.springcloud.data.service.DataService;

@RestController
@RequestMapping("/data")
public class DataServiceController {
    @Autowired
    private DataService dataService;

    @PostMapping("/save")
    public int saveData(@RequestBody DataDTO dto) {
        return dataService.saveData(dto);
    }
}

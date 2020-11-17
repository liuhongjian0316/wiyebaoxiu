package com.zy.controller;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.zy.common.config.FileConfig;
import com.zy.common.utils.LayuiImgJson;
import com.zy.common.utils.MultipartFileToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {


    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @PostMapping("/upload")
    public LayuiImgJson upload(MultipartFile file) throws Exception {
        File file1 = MultipartFileToFile.multipartFileToFile(file);
        StorePath storePath = fastFileStorageClient.uploadFile(null, new FileInputStream(file1), file1.length(), MultipartFileToFile.getType(file));
        MultipartFileToFile.delteTempFile(file1);

        Map<String,Object> data = new HashMap<>();
        data.put("src",FileConfig.service +storePath.getFullPath());
        data.put("title",FileConfig.service +storePath.getFullPath());
        return  new LayuiImgJson(data);
    }
}


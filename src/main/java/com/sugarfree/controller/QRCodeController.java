package com.sugarfree.controller;

import com.sugarfree.outvo.BaseMapOutVo;
import com.sugarfree.outvo.FileUrl;
import com.sugarfree.service.FileService;
import com.sugarfree.service.QRCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/21
 */
@Slf4j
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/qrcode",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class QRCodeController {

    @Autowired
    private FileService fileService;
    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping(value = "file")
    public ResponseEntity<Object> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.status(400).body("file is null!!");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        log.info("file name:{}",fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("file suffixName:{}",suffixName);
        // 文件上传后的路径
        InputStream inputStream = file.getInputStream();
        String url = this.fileService.upload(inputStream,suffixName);
        log.info("upload file success!!");
        FileUrl fileUrl = new FileUrl();
        fileUrl.setUrl(url);
        return ResponseEntity.status(200).body(fileUrl);
    }

    @PostMapping(value = "basemap")
    public ResponseEntity addBaseMap(String url) throws IOException {
        String fileUrl = qrCodeService.addBaseMap(url);
        BaseMapOutVo outVo = new BaseMapOutVo();
        outVo.setUrl(fileUrl);
        return ResponseEntity.status(200).body(outVo);
    }

    @PutMapping(value = "basemap")
    public ResponseEntity modifyBaseMap(String url) throws IOException {
        String fileUrl = qrCodeService.modifyBaseMap(url);
        BaseMapOutVo outVo = new BaseMapOutVo();
        outVo.setUrl(fileUrl);
        return ResponseEntity.status(200).body(outVo);
    }

    @GetMapping(value = "basemap")
    public ResponseEntity getBaseMap() throws IOException {
        String fileUrl = qrCodeService.getBaseMap();
        BaseMapOutVo outVo = new BaseMapOutVo();
        outVo.setUrl(fileUrl);
        return ResponseEntity.status(200).body(outVo);
    }

    @DeleteMapping(value = "basemap")
    public ResponseEntity deleteBaseMap() throws IOException {
        this.qrCodeService.deleteBaseMap();
        return ResponseEntity.ok().build();
    }
}

package com.blogs.web;



import com.blogs.service.DownLoadService;
import com.blogs.service.UploadFileService;
import com.blogs.service.UploadImagesService;
import com.blogs.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



/**
 * ClassName:UploadController
 * Package:com.aliyun.web
 * Description:
 *
 * @date:2019/8/17 17:06
 * @author: 574986060@qq.com
 */
@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private UploadImagesService UploadImageService;

    @Autowired
    private UploadFileService uploadFileService;

    @Autowired
    private UploadService service;



    @Autowired
    private DownLoadService downLoadService;


    @PostMapping("avatar")
    public ResponseEntity<String> uploadAvatar(@RequestParam("avatar") MultipartFile avatar) {

        String path = service.uploadAvatar(avatar);

        return ResponseEntity.ok().body(path);

    }
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile image) {

        String path = UploadImageService.uploadImage(image);

        return ResponseEntity.ok().body(path);

    }

    @PostMapping("file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        String path = uploadFileService.uploadFile(file);

        return ResponseEntity.ok().body(path);

    }


 /*   @RequestMapping("get/{id}")
    public ResponseEntity<HashMap<String, Object>> readProject(@PathVariable("id") String id) {

        return ResponseEntity.ok(downLoadService.getProject(id));
    }*/
}

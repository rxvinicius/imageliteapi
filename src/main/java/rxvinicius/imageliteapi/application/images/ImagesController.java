package rxvinicius.imageliteapi.application.images;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import rxvinicius.imageliteapi.domain.entity.Image;
import rxvinicius.imageliteapi.domain.enums.ImageExtension;
import rxvinicius.imageliteapi.domain.service.ImageService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/images")
@Slf4j
@RequiredArgsConstructor
public class ImagesController {

    private final ImageService imageService;

    @PostMapping()
    public ResponseEntity save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam(value = "tags", required = false) List<String> tags
    ) throws IOException {
        log.info("Imagem recebida: name {}, size: {}", file.getOriginalFilename(), file.getSize());

        Image image = Image.builder()
                .name(name)
                .tags(String.join(",", tags))
                .size(file.getSize())
                .extension(ImageExtension.valueOf(MediaType.valueOf(file.getContentType())))
                .file(file.getBytes())
                .build();
        imageService.save(image);
        return ResponseEntity.ok().build();
    }

}

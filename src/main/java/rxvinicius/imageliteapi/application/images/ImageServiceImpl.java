package rxvinicius.imageliteapi.application.images;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rxvinicius.imageliteapi.domain.entity.Image;
import rxvinicius.imageliteapi.domain.service.ImageService;
import rxvinicius.imageliteapi.infra.repository.ImageRepository;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    @Transactional
    public Image save(Image image) {
        return imageRepository.save(image);
    }

}

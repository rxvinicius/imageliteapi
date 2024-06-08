package rxvinicius.imageliteapi.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rxvinicius.imageliteapi.domain.entity.Image;

public interface ImageRepository extends JpaRepository<Image, String> {

}

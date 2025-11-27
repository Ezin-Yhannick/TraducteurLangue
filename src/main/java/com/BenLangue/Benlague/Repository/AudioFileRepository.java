package com.BenLangue.Benlague.Repository;

import com.BenLangue.Benlague.Entity.AudioFile;
import com.BenLangue.Benlague.Entity.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AudioFileRepository extends JpaRepository<AudioFile, Long> {

    Optional<AudioFile> findByTranslation(Translation translation);
}

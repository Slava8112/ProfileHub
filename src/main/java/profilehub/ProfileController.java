package profilehub;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile newProfile) {
        if (newProfile.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Profile savedProfile = profileRepository.save(newProfile);
        return ResponseEntity.status(201).body(savedProfile);
    }

    @GetMapping
    public ResponseEntity<Profile> getProfile(@RequestParam Long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile updatedProfile) {
        if (updatedProfile.getId() == null || !profileRepository.existsById(updatedProfile.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Profile savedProfile = profileRepository.save(updatedProfile);
        return ResponseEntity.ok(savedProfile);
    }
}

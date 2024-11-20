package profilehub;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters")
    private String surname;

    @Size(max = 100, message = "Job title must not exceed 100 characters")
    private String jobTitle;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+\\d{10,15}$", message = "Phone number must match the format +79999999999")
    private String phone;

    @Size(max = 200, message = "Address must not exceed 200 characters")
    private String address;

    @ElementCollection
    @Size(max = 10, message = "You can specify up to 10 interests")
    private List<@Size(max = 30, message = "Each interest must not exceed 30 characters") String> interests;

    private boolean isPublic = false;

    private String avatarUrl;
}

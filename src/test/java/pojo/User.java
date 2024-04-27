package pojo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.cucumber.java.mk_latn.No;
import io.cucumber.java.sl.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data //
@AllArgsConstructor
@NoArgsConstructor
@Builder  // Allows object creation using builder pattern
@JsonInclude(Include.NON_NULL) // allows null fields to be ignored when object is serialized to json
public class User {

    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String signUpDate;
    private String createdAt;
    private String profilePic;


}

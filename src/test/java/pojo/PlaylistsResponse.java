package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.cucumber.java.sl.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaylistsResponse {

    private Integer success;


    private Integer status;

    private List<Playlist> playlists;


}

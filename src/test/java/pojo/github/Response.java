
package pojo.github;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Response {

    @JsonProperty("success")
    private Integer success;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("playlists")
    private List<Playlist> playlists;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Response() {
    }

    /**
     * 
     * @param success
     * @param playlists
     * @param status
     */
    public Response(Integer success, Integer status, List<Playlist> playlists) {
        super();
        this.success = success;
        this.status = status;
        this.playlists = playlists;
    }

    @JsonProperty("success")
    public Integer getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Integer success) {
        this.success = success;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("playlists")
    public List<Playlist> getPlaylists() {
        return playlists;
    }

    @JsonProperty("playlists")
    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Response.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("success");
        sb.append('=');
        sb.append(((this.success == null)?"<null>":this.success));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("playlists");
        sb.append('=');
        sb.append(((this.playlists == null)?"<null>":this.playlists));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.playlists == null)? 0 :this.playlists.hashCode()));
        result = ((result* 31)+((this.success == null)? 0 :this.success.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Response) == false) {
            return false;
        }
        Response rhs = ((Response) other);
        return ((((this.playlists == rhs.playlists)||((this.playlists!= null)&&this.playlists.equals(rhs.playlists)))&&((this.success == rhs.success)||((this.success!= null)&&this.success.equals(rhs.success))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}

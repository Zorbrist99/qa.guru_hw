package eighteenthlesson.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ModelResUsersShopBook {

    String userId, username, password, isbn, token, expires, isActive;

    @JsonProperty("created_date")
    String createdDate;
}

package sixteenthlesson.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ModelResSingleUsers {
    private Data data;
    private Support support;


    @lombok.Data
    public static class Data {
        @JsonProperty("first_name")
        String firstName;

        @JsonProperty("last_name")
        String lastName;

        String email, avatar;
        int id;
    }

    @lombok.Data
    public static class Support {
        String url, text;
    }
}


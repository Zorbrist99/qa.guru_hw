package sixteenthlesson.model;

import lombok.Data;

@Data
public class ModelResSingleUsers {
    private Data data;
    private Support support;

    @lombok.Data
    public static class Data {
        String email, first_name, last_name, avatar;
        int id;
    }

    @lombok.Data
    public static class Support {
        String url, text;
    }
}


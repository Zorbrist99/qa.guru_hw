package eighteenthlesson.models;

import lombok.Data;

import java.util.List;

@Data
public class ModelReqAddBooksInBasket {
    private String userId;
    private List<CollectionOfIsbns> collectionOfIsbns;


    @Data
    public static class CollectionOfIsbns {
        private String isbn;
    }

}

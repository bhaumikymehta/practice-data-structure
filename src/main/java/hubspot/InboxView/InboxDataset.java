package hubspot.InboxView;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record InboxDataset(
    @JsonProperty("userId") long userId,
    @JsonProperty("users") List<User> users,
    @JsonProperty("messages") List<Message> messages
) {
    public record User(
        @JsonProperty("id") long id,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("avatar") String avatar
    ) {}
    
    public record Message(
        @JsonProperty("content") String content,
        @JsonProperty("fromUserId") long fromUserId,
        @JsonProperty("toUserId") long toUserId,
        @JsonProperty("timestamp") long timestamp
    ) {}
}
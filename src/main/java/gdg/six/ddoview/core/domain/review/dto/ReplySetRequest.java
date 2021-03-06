package gdg.six.ddoview.core.domain.review.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
public class ReplySetRequest {
    @NotNull
    private Long reviewId;

    private Long parentReplyId;

    @NotNull
    private Long memberId;

    @NotBlank
    private String content;

    public boolean checkChildReply() {
        return !Objects.isNull(parentReplyId);
    }
}

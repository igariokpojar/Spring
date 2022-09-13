package proxy;

import com.cydeo.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class PushNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for comment: "+comment.getText());
    }
}

package graphdb.extractors.parsers.stackoverflow.entity;

import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import graphdb.extractors.parsers.stackoverflow.StackOverflowExtractor;

public class AnswerInfo {

    Node node = null;
    int answerId = 0;
    int parentQuestionId = 0;
    int ownerUserId = -1;

    public AnswerInfo(Node node, int id, int parentId, String creationDate, int score, String body, int ownerUserId) {
        this.node = node;
        this.answerId = id;
        this.parentQuestionId = parentId;
        this.ownerUserId = ownerUserId;

        node.addLabel(Label.label(StackOverflowExtractor.ANSWER));

        node.setProperty(StackOverflowExtractor.ANSWER_ID, id);
        node.setProperty(StackOverflowExtractor.ANSWER_PARENT_QUESTION_ID, parentId);
        node.setProperty(StackOverflowExtractor.ANSWER_CREATION_DATE, creationDate);
        node.setProperty(StackOverflowExtractor.ANSWER_SCORE, score);
        node.setProperty(StackOverflowExtractor.ANSWER_BODY, body);
        node.setProperty(StackOverflowExtractor.ANSWER_OWNER_USER_ID, ownerUserId);
        node.setProperty(StackOverflowExtractor.ANSWER_ACCEPTED, false);

    }

    public int getAnswerId() {
        return answerId;
    }

    public int getParentQuestionId() {
        return parentQuestionId;
    }

    public void setAccepted(boolean accepted) {
        node.setProperty(StackOverflowExtractor.ANSWER_ACCEPTED, accepted);
    }

    public int getOwnerUserId() {
        return ownerUserId;
    }

    public Node getNode() {
        return node;
    }

}

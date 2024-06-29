package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    public String getBody() {
        return body;
    }

    public List<Tag> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        String childrenHtml = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());
        String attributesString = getAttributesAsString();
        if (attributesString.isEmpty()) {
            return "<" + getName() + ">" + body + childrenHtml + "</" + getName() + ">";
        } else {
            return "<" + getName() + " " + attributesString + ">" + body + childrenHtml + "</" + getName() + ">";
        }
    }
}
// END

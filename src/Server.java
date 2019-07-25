import Base.ContentGenerator;

public class Server  extends ContentGenerator {
    public int number;


    public Server(int id){
        initContent();
        number = id;
    }

    @Override
    protected Node Unit(int id) {
        return new Node(id);
    }

    public void selectStartDefectNode() {
        int nodeNumber = randomRange(0,content.size()-1);
        setFailedState(nodeNumber);
    }

    private void setFailedState(int nodeNumber){
        for(int i=nodeNumber; i < content.size(); i++){
            Node node = (Node) content.get(i);
            node.failed = true;
        }
    }

    public void setFailedState(){
        for (Object o : content) {
            Node node = (Node) o;
            node.failed = true;
        }
    }

    public boolean getNodeStatus(int nodeNumber){
        Node node = (Node)content.get(nodeNumber);
        return node.failed;
    }
}

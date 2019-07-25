import Base.ContentGenerator;

public class Cluster extends ContentGenerator {

    public Cluster(){
        initContent();
    }

    @Override
    protected Server Unit(int id) {
        return new Server(id);
    }

    public void sendMessage(){
        int serverNumber = randomRange(0,content.size()-1);
        Server server = (Server) content.get(serverNumber);
        server.selectStartDefectNode();
        for(int i=serverNumber+1; i < content.size(); i++){
            server = (Server) content.get(i);
            server.setFailedState();
        }
    }

    public boolean isFailed(int serverNumber, int nodeNumber){
        Server server = (Server) content.get(serverNumber);
        return server.getNodeStatus(nodeNumber);
    }
}

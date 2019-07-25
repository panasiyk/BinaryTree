import java.util.Map;

public class FailSearchEngine {

    private Cluster cluster;

    public FailSearchEngine() {
        this.cluster = new Cluster();
        cluster.sendMessage();
        search();
    }

    private void search() {
        if(cluster.isFailed(0, 0)){
            System.out.println("Server number - 1  node number - 1");
            return;
        }
        int serverI = Helper.mid(0, cluster.content.size()-1);
        Server server = (Server)cluster.content.get(serverI);
        int nodeI = Helper.mid(0, server.content.size()-1);
        findGap(serverI, nodeI);
    }

    private void findGap(int serverNumber, int nodeNumber){
        Map content = Helper.getLeftNodeNeighbor(serverNumber, nodeNumber, this.cluster);
        boolean leftNodeNeighborStatus = cluster.isFailed((int)content.get("serverNumber"), (int)content.get("nodeNumber"));
        if (cluster.isFailed(serverNumber, nodeNumber) && !leftNodeNeighborStatus) {
            Server gapServer = (Server)cluster.content.get(serverNumber);
            Node gapNode = (Node)gapServer.content.get(nodeNumber);
            System.out.println("Server number - " + gapServer.number + " node number - " + gapNode.number);
        }else if (leftNodeNeighborStatus){
            content = Helper.getLeftMiddleContent(serverNumber, nodeNumber, this.cluster);
            findGap((int)content.get("serverNumber"), (int)content.get("nodeNumber"));
        }else {
            content = Helper.getRightMiddleContent(serverNumber, nodeNumber, this.cluster);
            findGap((int)content.get("serverNumber"), (int)content.get("nodeNumber"));
        }
    }

}

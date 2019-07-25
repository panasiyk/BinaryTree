import java.util.HashMap;
import java.util.Map;

public class Helper {

    public static int mid(int start, int finish) {
        return (int)Math.ceil((double)(start + finish)/2);
    }

    public static Map getLeftNodeNeighbor(int serverNumber, int nodeNumber, Cluster cluster) {
        Map<String, Integer> content = new HashMap<String, Integer>();
        if(nodeNumber>0)
            nodeNumber =  nodeNumber - 1;
        else {
            Server server = (Server)cluster.content.get(serverNumber-1);
            serverNumber -= 1;
            nodeNumber =  server.content.size()-1;
        }
        content.put("serverNumber", serverNumber);
        content.put("nodeNumber", nodeNumber);
        return content;
    }

    public static Map getLeftMiddleContent(int serverNumber, int nodeNumber, Cluster cluster) {
        Map<String, Integer> content = new HashMap<String, Integer>();
        if(nodeNumber>0)
            nodeNumber = nodeNumber ==1 ? 0 : mid(0, nodeNumber);
        else {
            Server server = (Server)cluster.content.get(serverNumber - 1);
            serverNumber -= 1;
            nodeNumber = mid(0, server.content.size() - 1);
        }
        content.put("serverNumber", serverNumber);
        content.put("nodeNumber", nodeNumber);
        return content;
    }



    public static Map getRightMiddleContent(int serverNumber, int nodeNumber, Cluster cluster) {
        Map<String, Integer> content = new HashMap<String, Integer>();
        Server server = (Server)cluster.content.get(serverNumber);
        if(nodeNumber != server.content.size()-1)
            nodeNumber =  mid(nodeNumber, server.content.size() - 1);
        else {
            Server newServer = (Server)cluster.content.get(serverNumber+1);
            serverNumber += 1;
            nodeNumber = mid(0, newServer.content.size()-1);
        }
        content.put("serverNumber", serverNumber);
        content.put("nodeNumber", nodeNumber);
        return content;
    }

}

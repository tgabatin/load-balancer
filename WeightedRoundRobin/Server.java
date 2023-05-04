package WeightedRoundRobin;

public class Server {
    private int id;
    private int weight;

    /**
     * 
     * @param id
     * @param weight
     */
    public Server(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    /**
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return weight
     */
    public int getWeight() {
        return weight;
    }
}
